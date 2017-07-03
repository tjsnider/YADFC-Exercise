package yadfc.queues

class QueueManager {
  // Tracks non-job queues
  //  non-job queues do not have listeners
  val queues = HashMap.empty[String, ListBuffer]
  
  // Applies per-turn functions to queues
 
}