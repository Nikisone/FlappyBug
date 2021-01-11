package o1

import constants._

// This class is introduced in Chapter 2.7.

object FlappyBugApp extends App {

  val sky        = rectangle(ViewWidth, ViewHeight,  LightBlue)
  val ground     = rectangle(ViewWidth, GroundDepth, SandyBrown)
  val trunk      = rectangle(30, 250, SaddleBrown)
  val foliage    = circle(200, ForestGreen)
  val tree       = trunk.onto(foliage, TopCenter, Center)
  val rootedTree = tree.onto(ground, BottomCenter, new Pos(ViewWidth / 2, 30))
  val scenery    = sky.place(rootedTree, BottomLeft, BottomLeft)


  val bugPic = Pic("ladybug.png")


  def rockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)


  // INSERT YOUR OWN CODE BELOW.

  val game = new Game()

  val gui = new View(game, "FlappyBug") {
    var background = scenery

    def makePic = {
      val obstaclePic = rockPic(game.obstacle)
      background.place(obstaclePic, game.obstacle.pos).place(bugPic, game.bug.pos)
    }

    override def onKeyDown(key: Key) = {
      if (key == Key.Space) {
        game.activateBug()
      }
    }

    override def onTick() = {
      background = background.shiftLeft(BackgroundShift)
      game.timePasses()
    }

    override def isDone = game.isLost
  }

  gui.start()

}

