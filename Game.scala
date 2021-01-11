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

  // Your code goes here. Please add only what is requested by the ebook. To avoid
  // confusing our automatic assessment system, please don't invent additions of your own
  // here (at least not until you're done with the ebook’s official FlappyBug assignments).
}
