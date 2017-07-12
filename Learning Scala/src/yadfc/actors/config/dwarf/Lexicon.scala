package yadfc.actors.config.dwarf

import scala.util.Sorting

import yadfc.language.{Word,Adjective,Adverb,Conjunction,Determiner,Interjection,Noun,Preposition,Pronoun,Verb}

object Lexicon {
  def adjectives:Array[Adjective] = Array(
        Adjective("azan", None, None, "dim"),
        Adjective("baraz", None, None, "red"),
        Adjective("dush", None, None, "dark"),
        Adjective("gabil", None, None, "great"),
        Adjective("gamil", None, None, "old"),
        Adjective("narag", None, None, "black"),
        Adjective("mazarab", None, None, "inscribed"),
        Adjective("mazarub", None, None, "written"),
        Adjective("sharb", None, None, "bald"),
        Adjective("sigin", None, None, "long"),
        Adjective("ul", None, None, "son of"),
        Adjective("zahar", None, None, "hollow"),
        Adjective("zigil", None, None, "silver")
      )
  
  def adverbs:Array[Adverb] = Array(
        Adverb("taburud", None, None, "be heavy"),
        Adverb("tatkut", None, None, "be silent"),
        Adverb("gagin", None, None, "again")
      )
  
  def conjunctions:Array[Conjunction] = Array(
        Conjunction("ra", "and")
      )
  
  def determiners:Array[Determiner] = Array(
        Determiner("ala", "this"),
        Determiner("tada", "that")
      )
  
  def interjections:Array[Interjection] = Array(
        Interjection("lai", "behold")
      )
      
  def nouns:Array[Noun] = Array(
        Noun("aglab", None, None, "speech"),
        Noun("bark", None, None, "axe"),
        Noun("baruz", None, None, "red"),
        Noun("bizar", None, None, "dale"),
        Noun("bund", None, None, "head"),
        Noun("buz", None, None, "root"),
        Noun("duban", None, None, "valley"),
        Noun("dum", None, None, "delving"),
        Noun("gathol", None, None, "fortress"),
        Noun("gund", None, None, "subterranean hall"),
        Noun("hund", None, None, "hill"),
        Noun("inbar", None, None, "horn"),
        Noun("kheled", None, None, "mirror"),
        Noun("kibil", None, None, "silver"),
        Noun("mahal", None, None, "maker"),
        Noun("mazarb", None, None, "record"),
        Noun("nala", None, None, "river"),
        Noun("narg", None, None, "black"),
        Noun("shathur", None, None, "cloud"),
        Noun("thark", None, None, "staff"),
        Noun("turg", None, None, "beard"),
        Noun("uzbad", None, None, "lord"),
        Noun("uzn", None, None, "shadow"),
        Noun("zahr", None, None, "hollow"),
        Noun("zaram", None, None, "pool"),
        Noun("zirak", None, None, "spike")
      )
  
  def prepositions:Array[Preposition] = Array(
        Preposition("ana", "to"),
        Preposition("aya", "upon"),
        Preposition("ni", "in"),
        Preposition("tur", "through"),
        Preposition("u", "of"),
        Preposition("udu", "from"),
        Preposition("undu", "beneath")
      )
      
  def pronouns:Array[Pronoun] = Array(
        Pronoun("men", "you"),
        Pronoun("who", "who"),
        Pronoun("un", "one")
      )
      
  def verbs:Array[Verb] = Array(
        Verb("atam", None, None, "breathe"),
        Verb("bakin", None, None, "wake"),
        Verb("biruk", None, None, "break"),
        Verb("bulag", None, None, "swallow"),
        Verb("daraf", None, None, "kill"),
        Verb("felak", None, None, "chisel"),
        Verb("faluk", None, None, "craft"),
        Verb("felek", None, None, "hew (rock)"),
        Verb("gin", None, None, "begin"),
        Verb("ganag", None, None, "walk"),
        Verb("garaf", None, None, "take, grasp"),
        Verb("gunud", None, None, "excavate"),
        Verb("gurod", None, None, "fear"),
        Verb("karak", None, None, "break"),
        Verb("karok", None, None, "split"),
        Verb("khelad", None, None, "mirror"),
        Verb("kulit", None, None, "hear"),
        Verb("labab", None, None, "lick"),
        Verb("mahul", None, None, "create"),
        Verb("nakh", None, None, "come"),
        Verb("nasas", None, None, "save"),
        Verb("nazaf", None, None, "snap"),
        Verb("risis", None, None, "rise"),
        Verb("sakhu", None, None, "look"),
        Verb("salon", None, None, "descend"),
        Verb("sataf", None, None, "step"),
        Verb("shafut", None, None, "move"),
        Verb("shinak", None, None, "rip"),
        Verb("shiruk", None, None, "surround"),
        Verb("shithur", None, None, "occlude"),
        Verb("shumuk", None, None, "gesture"),
        Verb("sulun", None, None, "fall"),
        Verb("tharak", None, None, "hold up"),
        Verb("zahor", None, None, "build"),
        Verb("zelaf", None, None, "sleep"),
        Verb("zarub", None, None, "write"),
        Verb("zerab", None, None, "inscribe")
      )
      
  def vocabulary:Array[Word] = {
     val words:Array[Word] = this.adjectives ++ this.adverbs ++ this.conjunctions ++ 
                             this.determiners ++ this.interjections ++ this.nouns ++ 
                             this.prepositions ++ this.pronouns ++ this.verbs
                             
    words.sorted
  }
}