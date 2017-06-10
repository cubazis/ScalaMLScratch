package ScalaLearn.Metrics

import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j

/**
  * Created by dan.dixey on 10/06/2017.
  */
object Metrics {

  def mse(x1: INDArray, x2: INDArray) = Nd4j.mean((x1 mul x1) sub (x2 mul x2))

  def mae(x1: INDArray, x2: INDArray) = ???

  def rsquared(x1: INDArray, x2: INDArray) = ???

}
