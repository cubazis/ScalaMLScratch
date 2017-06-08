package ScalaLearn.Testing

import org.nd4s.Implicits._

/**
  * Simple Array Manipulation Testing Script
  */
object SimpleArray extends App {

  // Creating a simple array
  val arr = (1 to 9).asNDArray(3, 3)
  println(arr)

  // Creating a simple array # 2
  val sub = arr(0 -> 2, 1 -> 3)
  println(sub)

  // Create two large matrices
  val arr2 = (1 to 9000).asNDArray(300, 300)
  val arr3 = (1 to 9000).asNDArray(300, 300)
  val arr4 = arr2.transpose().mul(arr3)

  // Show part of the result
  println(arr4(8, 0 -> 100).meanNumber())

}
