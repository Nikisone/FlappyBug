package o1

import constants._
import scala.util.Random


class Obstacle(val radius: Int) {

  private var currentPos = randomLaunchPosition()
  def pos = currentPos

  def approach() = {
    if (isActive) {
      currentPos = currentPos.addX(-ObstacleSpeed)
    }
    else {
      currentPos = randomLaunchPosition()
    }
  }

  private def randomLaunchPosition() = {
    val launchX = ViewWidth + radius + Random.nextInt(499)
    val launchY = Random.nextInt(ViewHeight)
    new Pos(launchX, launchY)
  }

  def touches(bug: Bug) = {
    val criticalDistance = bug.radius + this.radius
    this.pos.distance(bug.pos) < criticalDistance
  }

  def isActive() = {
    pos.x >= -radius
  }

  override def toString = "center at " + this.pos + ", radius " + this.radius

}
