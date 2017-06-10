package ScalaLearn.Examples

import ScalaLearn.Metrics.Metrics.mse
import ScalaLearn.Regression.RidgePolynomial
import ScalaLearn.Utils.IOUtils.readData
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4s.Implicits._

/**
  * Example: Ridge Polynomial Regression
  */
object RidgePolynomialRegression extends App {

  // Load the Data
  val data: List[Array[Double]] = readData(
    "/Users/dan.dixey/Desktop/ScalaLearn/src/main/resources/SLRDataset.csv")

  // Get the Features and Target
  val X: List[Array[Double]] = data.map(a => Array(a(0), a(1)))
  val y: List[Array[Double]] = data.map(a => Array(a.last))

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

  // Instantiate the Model: Ridge Polynomial Regression
  val model4 = new RidgePolynomial(polynomialFactor,
    iterations,
    learningRate,
    regParam,
    bias)
  val w4: INDArray = model4.train(trainX, trainY)
  val prediction4: INDArray = model4.predict(trainX, w4)
  println("Ridge Polynomial Regression")
  println(s"Weights: $w4")
  println(s"Mean Squared Error: ${mse(prediction4, trainY)}\n")

}
