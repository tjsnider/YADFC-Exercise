package yadfc.actors

import scala.collection.mutable.Map

class Dwarf (fName:String, lName:String, isMale:Boolean, skills:Map[String, Int]) {
  
  def getProfession():String = {
    return skills.foldLeft("")((acc,entry) => if (skills.get(acc).getOrElse(0) > entry._2) acc else entry._1)
  }
  override def toString():String = {
    return fName+" "+lName+", the "+getProfession()+", "+(if (isMale) "male" else "female")+" dwarf"
  }
}