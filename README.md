
| Project          | Created    | Updated    | Version |
|------------------|------------|------------|---------|
| Scala - sklearn  | 08/06/2016 | 08/06/2017 | 0.1     |

# Scala - scikit-learn (TO BE RENAMED)

Scala scikit-learn is a personal project to implement and the common 'data science' algorithms in much the same way scikit-learn has done. 

# Motivation

1.  Learn functional programming and apply it specifically for Machine Learning
2.  Apply and write ML algorithms in Scala from Scratch...

# Installation

Backed by [ND4S](https://github.com/deeplearning4j/nd4s) for the matrix manipulation and numerical computing.

Current build:

```
    lazy val root = (project in file(".")).settings(
      name := "ScalaLearn",
      version := "0.1.0",
      scalaVersion := "2.11.8"
    )
    
    val nd4jVersion = "0.7.2"
    
    libraryDependencies ++= Seq(
      "org.nd4j" % "nd4s_2.11" % nd4jVersion,
      "org.nd4j" % "nd4j-native-platform" % nd4jVersion,
      "org.slf4j" % "slf4j-simple" % "1.7.21"
    )
```

# Documentation

TODO

# Tests

TODO

# Contribute

TODO - please do!

# Who to contact?

[Dan Dixey](mailto:dan.dixey@gmail.com)
