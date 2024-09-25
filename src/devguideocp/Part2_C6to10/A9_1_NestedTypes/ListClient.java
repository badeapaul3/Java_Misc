package devguideocp.Part2_C6to10.A9_1_NestedTypes;

/**
 * @author hatzp
 **/
// File: ListClient.java
class MyLinkedList {                                // (1)
    private String message = "Shine the light";       // (2)

    public Node makeNode(String info, Node next) {    // (3)
        return new Node(info, next);                    // (4) - implicit this.new
    }
    public static Node makeNodeStat(String info, Node next) {       // (3') Static method
        return new MyLinkedList().new Node(info, next);   // (4') Explicit outer object
    }

    public class Node {                               // (5) Non-static member class
        // Static field:
        static int maxNumOfNodes = 100;                 // (6)

        // Instance fields:
        private String nodeInfo;                        // (7)
        private Node next;

        // Non-zero argument constructor:
        public Node(String nodeInfo, Node next) {       // (8)
            this.nodeInfo = nodeInfo;
            this.next = next;
        }

        // Instance methods:
        public Node getNext() { return next; }
        @Override
        public String toString() {
            return message + " in " + nodeInfo + " (" + maxNumOfNodes + ")"; // (9)
        }
//
//        return MyLinkedList.this.message + " in " + this.nodeInfo +
//                " (" + this.maxNumOfNodes + ")"; // (9b)
    }
}
//_____________________________________________________________________________
public class ListClient {                                   // (10)
    public static void main(String[] args) {                  // (11)
        MyLinkedList list = new MyLinkedList();                 // (12)
        MyLinkedList.Node node1 = list.makeNode("node1", null); // (13)
        MyLinkedList.Node node2 = list.new Node("node2", node1);// (14)
        MyLinkedList.Node node3 = MyLinkedList.makeNodeStat("node3", node2);// (14)
        for (MyLinkedList.Node node = node3;
             node!=null;
             node = node.getNext()) {                           // (15)
            System.out.println(node);
        }

//  MyLinkedList.Node nodeX
//               = new MyLinkedList.Node("nodeX", node1);   // (16) Not OK.

    }
}