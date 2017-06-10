package ScalaLearn.Testing

import ScalaLearn.Metrics.Metrics._
import ScalaLearn.Regression._
import ScalaLearn.Utils.IOUtils._
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4s.Implicits._

/**
  * Demo Script of Using Linear, Ridge and Polynomial
  */
object DemoRegression extends App {

  // Load the Data
  val data = readData(
    "/Users/dan.dixey/Desktop/ScalaLearn/src/main/resources/SLRDataset.csv")

  // Get the Features and Target
  val X: List[Array[Double]] = data.map(a => Array(a(0), a(1)))
  val y: List[Array[Double]] = data.map(a => Array(a(2)))

  // Get some meta-data about each array
  val nRows: Int = X.size
  val nFeatures: Int = X.head.length

  // Create the nd-arrays
  val trainX: INDArray = X.flatten.toArray.asNDArray(nRows, nFeatures)
  val trainY: INDArray = y.flatten.toArray.asNDArray(nRows, 1)

  // Model params
  val iterations = 10000
  val polynomialFactor = 2
  val learningRate = 0.00001
  val regParam = 0.7
  val bias = false

  // Instantiate the Model: Simple Linear Regression
  val model = new LinearRegression(iterations, learningRate, bias)
  val w = model.train(trainX, trainY)
  val prediction: INDArray = model.predict(trainX, w)
  println("Simple Linear Regression")
  println(s"Weights: $w")
  println(s"Mean Squared Error: ${mse(prediction, trainY)}\n")

  // Instantiate the Model: Ridge Regression
  val model2 = new RidgeRegression(iterations, learningRate, regParam, bias)
  val w2 = model2.train(trainX, trainY)
  val prediction2: INDArray = model2.predict(trainX, w2)
  println("Ridge Regression")
  println(s"Weights: $w2")
  println(s"Mean Squared Error: ${mse(prediction2, trainY)}\n")

  // Instantiate the Model: Polynomial Regression
  val model3 =
    new Polynomial(polynomialFactor, iterations, learningRate * 0.001, bias)
  val w3 = model3.train(trainX, trainY)
  val prediction3: INDArray = model3.predict(trainX, w3)
  println("Polynomial Regression")
  println(s"Weights: $w3")
  println(s"Mean Squared Error: ${mse(prediction3, trainY)}\n")

  // Instantiate the Model: Ridge Polynomial Regression
  val model4 = new RidgePolynomial(polynomialFactor,
                                   iterations,
                                   learningRate,
                                   regParam,
                                   bias)
  val w4 = model4.train(trainX, trainY)
  val prediction4: INDArray = model4.predict(trainX, w4)
  println("Ridge Polynomial Regression")
  println(s"Weights: $w4")
  println(s"Mean Squared Error: ${mse(prediction4, trainY)}\n")

}
