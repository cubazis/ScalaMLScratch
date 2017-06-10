package ScalaLearn.Examples

import ScalaLearn.Metrics.Metrics.mse
import ScalaLearn.Regression.RidgeRegression
import ScalaLearn.Utils.IOUtils.readData
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4s.Implicits._

/**
  * Example: Ridge Regression
  */
object RidgeRegression extends App {

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

  // Instantiate the Model: Ridge Regression
  val model2 = new RidgeRegression(iterations, learningRate, regParam, bias)
  val w2 = model2.train(trainX, trainY)
  val prediction2: INDArray = model2.predict(trainX, w2)
  println("Ridge Regression")
  println(s"Weights: $w2")
  println(s"Mean Squared Error: ${mse(prediction2, trainY)}\n")

}
