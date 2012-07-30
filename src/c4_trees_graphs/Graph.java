package c4_trees_graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * This class defines a graph
 *
 * @author Fengjiang.
 *         Created Jul 29, 2012.
 */
public class Graph {
	List<NodeGraph> nodes;
	
	public Graph(){
		nodes = new LinkedList<NodeGraph>();
	}
	
	public void addNodes(NodeGraph node){
		this.nodes.add(node);
	}
	
	public List<NodeGraph> getNodes(){
		return this.nodes;
	}
}
