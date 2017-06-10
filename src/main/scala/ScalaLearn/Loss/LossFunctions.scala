package ScalaLearn.Loss

import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4s.Implicits._

/**
  * Contains all the Loss functions
  */
object LossFunctions {

  def findGradient(x: INDArray, y: INDArray, theta: INDArray): INDArray = {
    -(y - x.dot(theta)).T.dot(x)
  }
}
