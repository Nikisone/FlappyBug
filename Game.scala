package o1

import constants._

class Game {

  val bug = new Bug(new Pos(100, 40))
  val obstacle = new Obstacle(70)


  def timePasses() = {
    bug.fall()
    obstacle.approach()
  }

  def activateBug() = {
    bug.flap(15)
  }

  def isLost = obstacle.touches(bug) || !bug.isInBounds

}
