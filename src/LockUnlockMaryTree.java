import java.util.ArrayList;
import java.util.List;

class MAryTree{
    // Structure of the tree
    class ListNode<T>{
        // stores the value
        T val;
        // checks whether tree is locked or not
        boolean locked = false;
        // store parent node
        ListNode parent;
        // store list of children
        List<ListNode> children;
        // count of locked children
        int lockedChildrenCount = 0;
        // initializing the node
        ListNode(T val, ListNode parent){
            this.val = val;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    // A < B    kolkata < India
    boolean lock(ListNode node){
        // if node is already locked
        synchronized(this){
            if(!node.locked){
                node.locked = true;
            }
            else return false;
        }

        //check whether any child is locked or not
        if(node.lockedChildrenCount > 0){
            node.locked = false;
            return false;
        }

        // increment count of all ancestors by 1 that they have one more locked child
        ListNode parentNode = node.parent;
        while(parentNode != null){
            if(!parentNode.locked){
                parentNode.lockedChildrenCount++;
                parentNode = parentNode.parent;
            }
            else {
                node.locked = false;
                ListNode temp = node.parent;
                while(temp != parentNode){
                    parentNode.lockedChildrenCount--;
                    parentNode = parentNode.parent;
                }
                return false;
            }
        }
        return true;
    }

    boolean unLock(ListNode node){
        // if node is already unlocked
        if(!node.locked){
            return false;
        }
        synchronized(this){
            node.locked = false;
            ListNode parentNode = node.parent;
            // decrement count of all ancestors by 1 that they have one less locked child
            while(parentNode != null){
                parentNode.lockedChildrenCount--;
                parentNode = parentNode.parent;
            }
            return true;
        }
    }

}