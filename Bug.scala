package o1

import scala.math._
import constants._

class Bug(paikka: Pos) {

  private var currentPos = paikka
  def pos = currentPos
  val radius = BugRadius
  private var yVelocity = 0.0

  def flap(flap: Double) = {
    yVelocity = -flap
  }

  def fall() = {
    if (pos.y < 350) {
      yVelocity = yVelocity + 2
      move(yVelocity)
    }
  }

  def move(addition: Double) = {
    currentPos = currentPos.addY(addition).clampY(0, 350)
    currentPos
  }

  def isInBounds = currentPos.y < 350 && currentPos.y > 0

  override def toString() = {
    s"center at $pos, radius $radius"
  }
}
// Define class Bug here.

