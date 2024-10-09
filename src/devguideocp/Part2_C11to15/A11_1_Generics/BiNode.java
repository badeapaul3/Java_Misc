package devguideocp.Part2_C11to15.A11_1_Generics;

/**
 * @author hatzp
 **/

interface IBiLink<T> extends IMonoLink<T> {
    void       setPrevious(IBiLink<T> previous);
    IBiLink<T> getPrevious();
}

class BiNode<E> extends MonoNode<E> implements IBiLink<E> {
    private IBiLink<E>  previous;    // Reference to previous node

    BiNode(E data, IBiLink<E> next, IBiLink<E> previous) {
        super(data, next);
        this.previous = previous;
    }
    @Override public void setPrevious(IBiLink<E> previous) {
        this.previous = previous;
    }
    @Override public IBiLink<E> getPrevious() { return this.previous; }
    @Override public String toString() {
        return (this.previous == null? "" : this.previous + ", ") +
                this.getData() +
                (this.getNext() == null? "" : ", " + this.getNext());
    }

    public static void main(String[] args) {
        BiNode<Integer> intBiNode = new BiNode<>(2020, null, null);
        System.out.println(intBiNode.toString());
        MonoNode<Integer> intMonoNode = intBiNode;        // (1)
        Integer iRef = intMonoNode.getData();             // Integer with int value 2020
        System.out.println(intMonoNode.toString());
        //MonoNode<Number> numMonoNode = intBiNode;         // (2) Compile-time error!
    }
}
