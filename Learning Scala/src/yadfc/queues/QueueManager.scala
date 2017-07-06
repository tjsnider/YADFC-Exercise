package yadfc.queues

import scala.collection.mutable.ListBuffer

import yadfc.statics.Item

class QueueManager {
  // Tracks non-job queues
  //  non-job queues do not have listeners
  var queues = scala.collection.mutable.HashMap.empty[String, ListBuffer[Item]]
  
  // Applies per-turn functions to queues
 
}