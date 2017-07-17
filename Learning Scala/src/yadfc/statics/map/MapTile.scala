package yadfc.statics.map

import yadfc.statics.Thing
import yadfc.language.Name

class MapTile(terrain:String, height:Float, gbi:Int, activity:Int, climate:Int, name:String) extends Thing {
  override val baseIconIdx:Int = terrain.head.toInt
  override val iconIdxOffest:Int = 1 + gbi
  
  val level = Math.round(height)
}