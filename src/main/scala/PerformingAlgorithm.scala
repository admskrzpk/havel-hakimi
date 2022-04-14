object PerformingAlgorithm extends App {

  import scala.annotation.tailrec

  val si = Seq(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3)

  def removingZeros(si: Seq[Int]): Seq[Int] = {
    si.filterNot(_ == 0)
  }

  def sorting(si: Seq[Int]): Seq[Int] = {
    si.sortWith(_ > _)
  }

  def lengthCheck(si: Seq[Int], n: Int): Boolean = {
    if (n > si.length) true
    else false
  }

  def frontElimination(n: Int, si: Seq[Int]): Seq[Int] = {
    si.take(n).map(_ - 1) ++
      si.takeRight(si.length - n)
  }

  @tailrec
  def performingAlgorithm(si: Seq[Int]): Boolean = {
    val withoutZeroes = removingZeros(si)
    if (withoutZeroes.isEmpty) true
    else {
      val sortedList = sorting(withoutZeroes)
      val n = sortedList.head
      val headlessList = sortedList.tail
      if (n > headlessList.length) false
      else {
        performingAlgorithm(frontElimination(n, headlessList))
      }
    }
  }
  val result = performingAlgorithm(si)
  println(result)
}
