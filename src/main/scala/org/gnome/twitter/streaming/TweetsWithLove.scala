/**
  * Copyright (C) 2017 Sahil Sareen (sahil [DOT] sareen [AT] hotmail [DOT] com)
  *
  * This program is free software: you can redistribute it and/or modify it under
  * the terms of the GNU General Public License as published by the Free Software
  * Foundation, either version 3 of the License, or (at your option) any later
  * version. See http://www.gnu.org/copyleft/gpl.html the full text of the
  * license.
  */

package org.gnome.twitter.streaming.TweetsWithLove

import org.apache.log4j.{Level, Logger}

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.twitter._
import org.apache.spark.SparkConf

/**
  * Streams tweets from a Twitter stream using Apache Spark.
  * The stream is instantiated with credentials and optionally filters supplied
  * by the command line arguments.
  */
object TweetsWithLove {
  def main(args: Array[String]) {
    if (args.length < 4) {
      System.err.println("Usage: TweetsWithLove <consumer key> <consumer secret> " +
        "<access token> <access token secret> [<filters>]")
      System.exit(1)
    }

    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length - 4)

    // Set the system properties so that Twitter4j library used by twitter stream
    // can use them to generate OAuth credentials
    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val sparkConf = new SparkConf()
      .setAppName("TwitterPopularTags")

    // Check Spark configuration for master URL, set it to local if not configured
    if (!sparkConf.contains("spark.master")) {
      sparkConf.setMaster("local[2]")
    }

    val ssc = new StreamingContext(sparkConf, Seconds(10))
    val stream = TwitterUtils.createStream(ssc, None, filters)

    stream.foreachRDD { rdd =>
      rdd.foreach(tweet => println(tweet.getText))
    }

    ssc.start()
    ssc.awaitTermination()
  }
}
