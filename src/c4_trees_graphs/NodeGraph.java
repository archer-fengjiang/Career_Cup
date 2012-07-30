package c4_trees_graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * This class defines nodes in a graphs
 *
 * @author Fengjiang.
 *         Created Jul 29, 2012.
 */
public class NodeGraph {
	private List<NodeGraph> neighbourNodes;
	public String content;
	public NodeGraph(){
		neighbourNodes = new LinkedList<NodeGraph>();
	}
	
	public List<NodeGraph> getNeighbours(){
		return this.neighbourNodes;
	}
	
	public void addNeighbour(NodeGraph node){
		this.neighbourNodes.add(node);
	}
}
