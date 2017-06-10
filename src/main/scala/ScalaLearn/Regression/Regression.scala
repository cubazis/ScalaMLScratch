package ScalaLearn.Regression

import ScalaLearn.Loss.LossFunctions._
import ScalaLearn.Utils.INDArrayUtils._
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j
import org.nd4s.Implicits._

/** Base Regression Class
  *
  * @param nIter            Number of Iterations to run for
  * @param learnRate        Learning Rate
  * @param regularisation   Regularisation factor
  * @param identityCol      Boolean flag to add or not add bias
  */
sealed class Regression(nIter: Int,
                        learnRate: Double,
                        regularisation: Double,
                        identityCol: Boolean) {

  /** Generate the Weights
    *
    * @param shape  Array of the number of Rows and Columns
    * @return       INDArray of the Weights (Row vector)
    */
  def getWeights(shape: Array[Int]): INDArray = {
    if (identityCol) { Nd4j.randn(shape(1) + 1, 1) } else
      Nd4j.randn(shape(1), 1)
  }

  /** Train method
    *
    * @param x  Training features nd-array
    * @param y  Target column
    * @return   Model weights
    */
  def train(x: INDArray, y: INDArray) = {
    fit(x: INDArray, y: INDArray)
  }

  /** Fit Method
    *
    * @param x  Training features nd-array
    * @param y  Target column
    * @return   Model weights
    */
  def fit(x: INDArray, y: INDArray): INDArray = {
    val (shape, trainX) = appendBias(x)
    gradientDescent(trainX, y, getWeights(shape), nIter)
  }

  /** Appending Bias
    *
    * @param x  Training features nd-array
    * @return   Training features nd-array w or w/o a bias column vector
    */
  private def appendBias(x: INDArray): (Array[Int], INDArray) = {
    val shape = x.shape()
    val trainX = if (identityCol) addBias(x, shape(0)) else x
    (shape, trainX)
  }

  /** Gradient Decent
    *
    * @param x  Training features nd-array
    * @param y  Target column
    * @param w  Model weights
    * @return   Updated weights
    */
  @scala.annotation.tailrec
  private def gradientDescent(x: INDArray,
                              y: INDArray,
                              w: INDArray,
                              nIter: Int): INDArray = {
    nIter match {
      case 0 => w
      case _ => {
        val gradient = findGradient(x, y, w) add (w mul regularisation).T
        val newWeights = w - (gradient mul learnRate).T
        gradientDescent(x, y, newWeights, nIter - 1)
      }
    }
  }

  /** Predict method
    *
    * @param x        Training features nd-array
    * @param weights  Model Weights
    * @return         Prediction
    */
  def predict(x: INDArray, weights: INDArray) = {
    val shape = x.shape()
    val testX = if (identityCol) addBias(x, shape(0)) else x
    testX.dot(weights)
  }

}

/** Linear Regression Class
  *
  * @param nIter            Number of Iterations to run for
  * @param learnRate        Learning Rate
  * @param identityCol      Boolean flag to add or not add bias
  */
class LinearRegression(nIter: Int, learnRate: Double, identityCol: Boolean)
    extends Regression(nIter, learnRate, regularisation = 0, identityCol)

/** Ridge Regression Class
  *
  * @param nIter            Number of Iterations to run for
  * @param learnRate        Learning Rate
  * @param regularisation   Regularisation factor
  * @param identityCol      Boolean flag to add or not add bias
  */
class RidgeRegression(nIter: Int,
                      learnRate: Double,
                      regularisation: Double,
                      identityCol: Boolean)
    extends Regression(nIter, learnRate, regularisation, identityCol)

/** Polynomial Regression Class
  *
  * @param factor           Polynomial transformation factor
  * @param nIter            Number of Iterations to run for
  * @param learnRate        Learning Rate
  * @param identityCol      Boolean flag to add or not add bias
  */
class Polynomial(factor: Double,
                 nIter: Int,
                 learnRate: Double,
                 identityCol: Boolean)
    extends Regression(nIter, learnRate, regularisation = 0, identityCol) {

  override def train(x: INDArray, y: INDArray): INDArray = {
    fit(x mul factor, y)
  }

}

/** Ridge Polynomial Regression Class
  *
  * @param factor           Polynomial transformation factor
  * @param nIter            Number of Iterations to run for
  * @param learnRate        Learning Rate
  * @param regularisation   Regularisation factor
  * @param identityCol      Boolean flag to add or not add bias
  */
class RidgePolynomial(factor: Double,
                      nIter: Int,
                      learnRate: Double,
                      regularisation: Double,
                      identityCol: Boolean)
    extends RidgeRegression(nIter, learnRate, regularisation, identityCol) {

  override def train(x: INDArray, y: INDArray): INDArray = {
    fit(x mul factor, y)
  }

}
