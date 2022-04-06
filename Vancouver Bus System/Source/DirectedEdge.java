public class DirectedEdge
{
	private final int v; // edge source
	private final int w; // edge target
	private final double weight; // edge weight
	
	 public DirectedEdge(int v, int w, double weight)
	 {
		 this.v = v;
		 this.w = w;
		 this.weight = weight;
	 }
	 
	 public double weight()
	 { 
		 return weight; 
	 }
	 
	 public int from()
	 { 
		 return v; 
	 }
	 
	 public int to()
	 {
		 return w; 
	 }
	 
	    /**
	     * Returns a string representation of the directed edge.
	     * @return a string representation of the directed edge
	     */
	    public String toString() {
	        return v + "->" + w + " " + String.format("%5.2f", weight);
	    }
 
}

