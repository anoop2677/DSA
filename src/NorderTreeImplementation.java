import java.util.Vector;

/*
            1
       /    |     \
      2     3      4
     /|\   /|\    / | \
    5 6 7 8 9 10 11 12 13
*/
public class NorderTreeImplementation {
    public static class Node<T>{
        T val;
        boolean locked = false;
        Node parent;
        Vector<Node> child;
        int lockedDescendent = 0;
    }

    static <T> Node newNode(T key, Node parent){
        Node temp = new Node();
        temp.val = key;
        temp.child = new Vector<Node>();
        temp.parent = parent;
        return temp;
    }

    public static boolean isLocked(Node node){
        return node.locked;
    }

    protected static boolean lock(Node node){
        if(isLocked(node)){
            return false;
        }
        if(!canLockOrUnlock(node)){
            return false;
        }
        node.locked = true;
        Node parentNode = node.parent;
        while(parentNode != null){
            parentNode.lockedDescendent +=  1;
            parentNode = parentNode.parent;
        }
        return true;
    }

    public boolean unLock(Node node){
        //in unlock we are only writing not reading
        if(!isLocked(node)){
            return false;
        }
        node.locked = false;
        Node parentNode = new Node();


        while(parentNode != null){
            parentNode.lockedDescendent -= 1;
            parentNode = parentNode.parent;
        }
        return true;
    }

    public static boolean canLockOrUnlock(Node node){
        if(node.lockedDescendent >0){
            return false;
        }
        Node parentNode = new Node();
        while(parentNode != null){
            if(isLocked(parentNode)){
                return false;
            }
            parentNode = parentNode.parent;
        }
        return true;
    }

    static void inorder(Node node){
        if (node == null)
            return;

        // Total children count
        int total = node.child.size();
//        System.out.println(total);
        // All the children except the last
        for (int i = 0; i < total - 1; i++)
            inorder((Node) node.child.get(i));

        // Print the current node's data
        System.out.print("" + node.val + " ");

        // Last child
        if(total>0)
        inorder((Node) node.child.get(total - 1));
    }

    public static void main(String[] args) {
        Node root = newNode(1, null);
        root.child.add(newNode(2, root));
        root.child.add(newNode(3, root));
        root.child.add(newNode(4, root));
        Node node = (Node) root.child.get(0);
        node.child.add(newNode(5, node));
        node.child.add(newNode(6, node));
        node.child.add(newNode(7, node));
        node = (Node) root.child.get(1);
        node.child.add(newNode(8, node));
        node.child.add(newNode(9, node));
        node.child.add(newNode(10, node));
        node = (Node) root.child.get(2);
        node.child.add(newNode(11, node));
        node.child.add(newNode(12, node));
        node.child.add(newNode(13, node));

        inorder(root);
    }
}

