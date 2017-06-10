package ScalaLearn.Utils

import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j

/**
  * Array Utils
  */
object INDArrayUtils {

  def addBias(data: INDArray, nCols: Int): INDArray = {
    Nd4j.hstack(Nd4j.ones(nCols, 1), data)
  }

}
