
| Project                  | Created    | Updated    | Version |
|--------------------------|------------|------------|---------|
| Scala - ML from Scratch  | 08/06/2016 | 10/06/2017 | 0.1     |

# Scala - ML from Scratch

Scala - ML from Scratch is a personal project to implement and the common 'data science' algorithms in much the same way scikit-learn for Python has done. 

# Status

| Algorithm        | Class      | Update Date | Demo Script          |
|------------------|------------|-------------|----------------------|
| LinearRegression | Regression | 10/6/17     | DemoRegression.scala |
| RidgeRegression  | Regression | 10/6/17     | DemoRegression.scala |
| Polynomial       | Regression | 10/6/17     | DemoRegression.scala |
| RidgePolynomial  | Regression | 10/6/17     | DemoRegression.scala |

Next Up:

1.   Naive Bayes
2.   Decision Tree
3.   k-means
4.   Cross Validation / Hyperparameter Tuning

# Motivation

1.  Learn functional programming and apply it specifically for Machine Learning
2.  Apply and write ML algorithms in Scala from Scratch...

# Installation

This is subject to change, at the moment this is powered by [ND4S](https://github.com/deeplearning4j/nd4s) for the matrix manipulation and numerical computing.

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
