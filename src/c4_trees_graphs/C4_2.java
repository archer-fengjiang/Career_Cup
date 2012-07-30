package c4_trees_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes
 *
 * @author Fengjiang.
 *         Created Jul 29, 2012.
 */
public class C4_2 {
	public boolean isRoutable(Graph g, NodeGraph start, NodeGraph end){
		List<NodeGraph> nodes = g.getNodes();
		if(!nodes.contains(start) || !nodes.contains(end)){
			return false;
		}
		if(start == end)
			return true;
		
		Set<NodeGraph> visitedNodes = new HashSet<NodeGraph>();
		visitedNodes.add(start);
		
		List<NodeGraph> stack = new LinkedList<NodeGraph>();
		stack.add(start);
		
		while(!stack.isEmpty()){
			NodeGraph node = stack.remove(0);
			List<NodeGraph> neighbours = node.getNeighbours();
			for(NodeGraph n : neighbours){
				if(n == end){
					return true;
				} 
				else if(!visitedNodes.contains(n)){
					visitedNodes.add(n);
					stack.add(0, n);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		NodeGraph[] nodes = new NodeGraph[10];
		Graph graph = new Graph();
		for(int i = 0; i < 10; i++){
			nodes[i] = new NodeGraph();
			nodes[i].content = Integer.toString(i);
			graph.addNodes(nodes[i]);
		}
		
		nodes[0].addNeighbour(nodes[1]);
		nodes[0].addNeighbour(nodes[2]);
		nodes[1].addNeighbour(nodes[3]);
		nodes[2].addNeighbour(nodes[1]);
		nodes[3].addNeighbour(nodes[1]);
		nodes[3].addNeighbour(nodes[4]);
		nodes[3].addNeighbour(nodes[5]);
		nodes[4].addNeighbour(nodes[3]);
		nodes[4].addNeighbour(nodes[7]);
		nodes[5].addNeighbour(nodes[3]);
		nodes[5].addNeighbour(nodes[7]);
		nodes[6].addNeighbour(nodes[9]);
		nodes[7].addNeighbour(nodes[5]);
		nodes[7].addNeighbour(nodes[8]);
		nodes[8].addNeighbour(nodes[6]);
		nodes[8].addNeighbour(nodes[9]);
		nodes[9].addNeighbour(nodes[2]);
		
		C4_2 direct = new C4_2();
		if(!direct.isRoutable(graph, nodes[9], nodes[0])){
			System.out.println("9->0 false");
		}
		if(direct.isRoutable(graph, nodes[6], nodes[8])){
			System.out.println("6->8 true");
		}
		if(direct.isRoutable(graph, nodes[1], nodes[2])){
			System.out.println("1->2 true");
		}
	}
}
