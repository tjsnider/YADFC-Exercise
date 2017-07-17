package yadfc.statics.map.gen

import scala.util.Random

import yadfc.statics.map.MapGenerator

object PerlinNoiseGenerator extends MapGenerator {
  val tileSize:Int = 256
  var size:Int = 0
  var layers:Int = 0
  var lacunarity:Double = 0.0
  var gain:Double = 0.0
  var initialized:Boolean = false
  
  var mesh:Array[Tuple2[Double,Double]] = List.tabulate(tileSize)(x=>{ 
      var th = 2 * Random.nextDouble() * Math.PI
      var a:Double = Math.sin(th)
      var b:Double = Math.cos(th)
      
      new Tuple2(a,b) 
    }).toArray
    
  val permutations:Array[Int] = { Random.shuffle(List.range(0,tileSize)).toArray }
  
  /**
   * Accepts creation parameters for noise map, sets initialized flag
   * 
   * parameters:
   * 	size:Int -  multiplier for ratio of output map to noise mask
   * 	layers:Int -  number of noise layers to aggregate into fractal noise map (recommended 2 to 5)
   * 	lacunarity:Double - increase in frequency between layers (layer x = lacunarity * layer x-1 tiles)
   * 	gian:Double - ratio of amplitude between layers (layer x amplitude = layer x-1 amplitude / gain)
   *  
   */
  def intialize(size:Int, layers:Int, lacunarity:Double, gain:Double) = {
    this.size = size
    this.layers = layers
    this.lacunarity = lacunarity
    this.gain = gain
    
    this.initialized = true
  }
  
  /**
   *  calculate liner interpolation of midpoint on a line
   *  
   *  parameters:
   *  	a:Double - low endpoint
   *  	b:Double - high endpoint
   *  	t:Double - midpoint as decimal progress from a to b
   */
  
  private def interpolate(a:Double, b:Double, t:Double):Double = {
    return a * (1 - t) + b * t
  }
  
  // calculate the scalar (dot) product of two vectors
  private def scalarProduct(v1:Tuple2[Double,Double], v2:Tuple2[Double,Double]):Double = {
    return v1._1 * v2._1 + v1._2 * v2._2
  }
  
  private def quintcSmooth(d:Double):Double = {
    return 6 * Math.pow(d, 5) - 15 * Math.pow(d, 4) + 10 * Math.pow(d, 3)  
  }
  
  private def calcPerlinNoiseValue(cell:Tuple2[Int,Int]):Double = {
    // translate integer coordinates into fractional coordinates
    // or expand mesh across map surface
    val fractional:Tuple2[Double,Double] = (cell._1/size,cell._2/size)
    
    // calculate vertex points
    val vsw:Tuple2[Int,Int] = (Math.floor(fractional._1).toInt,Math.floor(fractional._2).toInt)
    val vse:Tuple2[Int,Int] = (vsw._1,vsw._2 + 1)
    val vne:Tuple2[Int,Int] = (vsw._1 + 1,vsw._2 + 1)
    val vnw:Tuple2[Int,Int] = (vsw._1 + 1,vsw._2)
    
    // calculate cell as delta from VSW to VNE
    val delta:Tuple2[Double,Double] = (fractional._1 - vsw._1,fractional._2 - vsw._2)
    val smoother:Tuple2[Double,Double] = (quintcSmooth(delta._1),quintcSmooth(delta._2))
    
    // grab gradient at vertecese
    val gsw:Tuple2[Double,Double] = mesh(permutations(permutations(vsw._1) + vsw._2 % size))
    val gse:Tuple2[Double,Double] = mesh(permutations(permutations(vse._1) + vse._2 % size))
    val gne:Tuple2[Double,Double] = mesh(permutations(permutations(vne._1) + vne._2 % size))
    val gnw:Tuple2[Double,Double] = mesh(permutations(permutations(vnw._1) + vnw._2 % size))
    
    // create gradients going from vertecese to the delta cell point
    val gsw_dcp:Tuple2[Double,Double] = (delta._1,delta._2)
    val gse_dcp:Tuple2[Double,Double] = (1 - delta._1,delta._2)
    val gne_dcp:Tuple2[Double,Double] = (1 - delta._1,1 - delta._2)
    val gnw_dcp:Tuple2[Double,Double] = (delta._1,1 - delta._2)
    
    // use bilinear interpolation to create the final value
    return interpolate(interpolate(scalarProduct(gsw, gsw_dcp), scalarProduct(gse, gse_dcp), smoother._1), 
                       interpolate(scalarProduct(gnw, gnw_dcp), scalarProduct(gne, gne_dcp), smoother._1), 
                       smoother._2)
  }
  
  def calculateBaseNoiseLayer():Array[Array[Double]] = {
    // calculate the prime layer
    var baseNoiseLayer:Array[Array[Double]] = Array.fill(size*tileSize)(Array.fill(size)(0.0))
    baseNoiseLayer.zipWithIndex.map {case (subarray, index) => {
      subarray.zipWithIndex.map { case (subelem, subindex) => { calcPerlinNoiseValue((index,subindex)) } }
    }}
    
    // create and combine multiple layers from the prime layer
  }
}
