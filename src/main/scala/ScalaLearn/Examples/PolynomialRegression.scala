package ScalaLearn.Examples

import ScalaLearn.Metrics.Metrics.mse
import ScalaLearn.Regression.Polynomial
import ScalaLearn.Utils.IOUtils.readData
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4s.Implicits._

/**
  * Polynomial Regression
  */
object PolynomialRegression extends App {

  // Load the Data
  val data = readData(
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

  // Instantiate the Model: Polynomial Regression
  val model3 =
    new Polynomial(polynomialFactor, iterations, learningRate * 0.001, bias)
  val w3 = model3.train(trainX, trainY)
  val prediction3: INDArray = model3.predict(trainX, w3)
  println("Polynomial Regression")
  println(s"Weights: $w3")
  println(s"Mean Squared Error: ${mse(prediction3, trainY)}\n")

}
