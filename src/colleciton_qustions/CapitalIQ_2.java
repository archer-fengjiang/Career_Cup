package colleciton_qustions;

/**
 * Find the common ancestor of two nodes in a binary tree.
 *
 * @author Fengjiang.
 *         Created Aug 29, 2012.
 */
public class CapitalIQ_2 {

    public Node findCommonAncestor(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }
        Node left = findCommonAncestor(root.left, n1, n2);
        Node right = findCommonAncestor(root.right, n1, n2);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args){
        Node[] arr = new Node[10];
        for(int i = 0; i < 10; i++){
            arr[i] = new Node(i); 
        }

        arr[0].left = arr[1];
        arr[0].right = arr[2];

        arr[1].left = arr[3];
        arr[1].right = arr[4];
        
        arr[2].left = arr[5];
        arr[2].right = arr[6];
        
        arr[3].left = arr[7];
        arr[5].right = arr[8];
        arr[6].right = arr[9];

        CapitalIQ_2 tester = new CapitalIQ_2();
        System.out.println(tester.findCommonAncestor(arr[0], arr[7], arr[3]).value);
    }

}

class Node{
    public int value;
    Node left;
    Node right;
    
    public Node(int i){
        this.value = i;
    }
}
