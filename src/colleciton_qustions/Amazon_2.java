package colleciton_qustions;

import java.util.Set;

/**
 * A semi-connected graph is a graph that for each pair of vertices u,v, 
 * there is either a path from u to v or a path from v to u. 
 * Give an algorithm to test if a graph is semi-connected.
 * Solution:
 * Please refer to below documents:
 * http://hi.baidu.com/shcup/blog/item/8e4fd64f191e13c3d1c86a35.html
 * http://wenku.baidu.com/view/ceb92fe2524de518964b7d66.html
 * http://hi.baidu.com/19930705cxjff/blog/item/3a390f73e691ae0f8601b049.html
 *
 * @author Fengjiang.
 *         Created Aug 27, 2012.
 */
public class Amazon_2 {
	
	private class Graph{
		public Set<Node> nodeSet;
		public Graph(Set<Node> nodeSet){
			this.nodeSet = nodeSet;
		}
	}
	
	private class Node{
		int id;
		Node pointer;
	}
}