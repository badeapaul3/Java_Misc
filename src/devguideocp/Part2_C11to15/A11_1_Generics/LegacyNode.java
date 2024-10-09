package devguideocp.Part2_C11to15.A11_1_Generics;

/**
 * @author hatzp
 **/

class LegacyNode {
    private Object    data;    // The value in the node
    private LegacyNode next;   // The reference to the next node.
    LegacyNode(Object data, LegacyNode next) {
        this.data = data;
        this.next = next;
    }
    public void       setData(Object obj)      { this.data = obj; }
    public Object     getData()                { return this.data; }
    public void       setNext(LegacyNode next) { this.next = next; }
    public LegacyNode getNext()                { return this.next; }
    @Override public String toString() {
        return this.data + (this.next == null? "" : ", " + this.next);
    }

    public static void main(String[] args) {
        LegacyNode node1 = new LegacyNode(4, null);       // 4 --> null
        LegacyNode node2 = new LegacyNode("July", node1); // "July" --> 4 --> null

        Object obj = node2.getData();

        if (obj instanceof String str) {
            System.out.println(str.toUpperCase()); // Method specified in the String class.
        }
    }


}
