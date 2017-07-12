package yadfc.actors

import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

object DwarfTest {
  
  def main(args:Array[String]):Unit = {
    val fnames = Array("Urist","Afgris","Yemenette","Olgive")
    val lnames = Array("Digstone","Standstall","Glorybeard","Hammerspike")
    val sex = Array(true, true, false, true)
    val skills = Array(Map("miner"->42,"blacksmith"->30,"engraver"->38),
                       Map("miner"->21,"armorer"->15,"axedwarf"->55),
                       Map("hunter"->44,"orator"->112,"hairdresser"->34),
                       Map("miner"->55,"weaponsmith"->71,"butcher"->22))
    val professions:Array[String] = Array("miner", "axedwarf", "orator", "weaponsmith") 
                       
    var dwarves:Buffer[Dwarf] = Buffer.empty[Dwarf]
    
    var i = 0
    for (i <- 0 to 3) {
      dwarves.append(new Dwarf(fnames(i), lnames(i), sex(i), skills(i)))
    }
    
    val calcProfs:Array[String] = dwarves.map((d:Dwarf) => d.getProfession()).toArray
    if (professions sameElements calcProfs) println("Professions match!") else println("Professions do not match");
    println("Assigned professions: "+professions.mkString(", "))
    println("Returned professions: "+calcProfs.mkString(", "))
  }
}