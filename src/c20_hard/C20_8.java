package c20_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and an array of smaller strings T
 * design a method to search s for each small string in T
 *
 * @author Fengjiang.
 *         Created Aug 23, 2012.
 */
public class C20_8 {
    public SuffixTree tree;
    
    public C20_8(String str){
        this.tree = new SuffixTree(str);
    }
	
    private class Node{
        Map<Character, Node> childMap = new HashMap<Character, Node>();
        List<Integer> indexes = new ArrayList<Integer>();

        public void insertString(String str, int index){
            indexes.add(index);
            if(str == null || str.length() == 0){
                return;
            }
            char firstChar = str.charAt(0);
            Node childNode = childMap.get(firstChar);
            if(childNode == null){
                childNode = new Node();
            }
            childMap.put(firstChar, childNode);
            String reminderStr = str.substring(1);
            childNode.insertString(reminderStr, index);
        }

        public List<Integer> getIndexes(String string){
            if(string == null || string.length() == 0){
                return indexes;
            }
            char firstChar = string.charAt(0);
            String reminderString = string.substring(1);
            return childMap.get(firstChar).getIndexes(reminderString);
        }
    }

    public class SuffixTree{
        Node root;

        public SuffixTree(String string){
            root = new Node();
            for(int i = 0; i < string.length(); i++){
                root.insertString(string.substring(i), i);
            }
        }

        public List<Integer> getIndexes(String string){
            return root.getIndexes(string);
        }
    }

    public static void main(String[] args){
        String str = "bibsxarcherb";
        String[] subStrings = {"bi", "ib", "ibs", "x", "rc", "b"};
        C20_8 tester = new C20_8(str);
        for(int i = 0; i < subStrings.length; i++){
            System.out.println(subStrings[i] + ": " + tester.tree.getIndexes(subStrings[i]).toString());
        }
    }
}
