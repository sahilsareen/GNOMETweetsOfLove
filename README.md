# GNOMETweetsOfLove
Visualize love for GNOME from twitter.

## Motivation
See my blog post: [GNOME Blogs | Lets get functional around GTK+](https://blogs.gnome.org/ssareen/2017/04/19/lets-get-functional-around-gtk/)

## Setup and HowTo
1. Install java 1.8, scala 2.11+
2. Install [sbt](http://www.scala-sbt.org/download.html) *// Simple build tool for scala, Read more [on the official docs](http://www.scala-sbt.org/documentation.html)*
3. Clone GNOMETweetsOfLove locally
`git clone https://github.com/sahilsareen/GNOMETweetsOfLove`
4. Run using 
`cd LoveIsInTheAir && sbt package run <consumer key> <consumer secret> <access token> <access token secret> [<twitter gnome love filters>]`

## Example run
1. Start app to stream tweets with filter for `guadec`
2. Tweet: [Twitter | SahilSareen1](https://twitter.com/SahilSareen1/status/854653858013904896)
![Twitter tweet](https://blogs.gnome.org/ssareen/files/2017/04/Screen-Shot-2017-04-19-at-12.11.48-PM.png)
3. See the tweet in a GTK dialog box locally
![GTK dialog box with tweet](https://blogs.gnome.org/ssareen/files/2017/04/Screen-Shot-2017-04-19-at-12.12.17-PM.png)

## Contributing
1. Generate a pull request
2. Generate patches locally using: `git format-patch -k HEAD~1 --stdout > SomeFix.patch` and email patches to ssareen [AT] gnome [DOT] org

* Stick to the [scala style guide](http://docs.scala-lang.org/style/)

## License
See [License](https://github.com/sahilsareen/GNOMETweetsOfLove/blob/master/LICENSE)

# Author
- Sahil Sareen (ssareen [AT] gnome [DOT] org)

