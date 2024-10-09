package devguideocp.Part2_C11to15.A11_3_Generics3;

/**
 * @author hatzp
 **/

final class RecBiNode<E> extends RecNode<E, RecBiNode<E>> {          // (4)

    private RecBiNode<E>  previous;    // Reference to previous node   // (5)

    RecBiNode(E data, RecBiNode<E> next, RecBiNode<E> previous) {
        super(data, next);
        this.previous = previous;
    }
    public void setPrevious(RecBiNode<E> previous) { this.previous = previous; }
    public RecBiNode<E> getPrevious()              { return this.previous; }
    @Override public String toString() {
        return (this.previous == null? "" : this.previous + ", ") +
                this.getData() + (this.getNext() == null? "" : ", " + this.getNext());
    }

    public static <E> void traverseBinTree(RecBiNode<E> root) {     // (2)
        if (root.getPrevious() != null)
            traverseBinTree(root.getPrevious());
        System.out.print(root.getData() + ", ");
        if (root.getNext() != null)
            traverseBinTree(root.getNext());             // No cast necessary!
    }
}
