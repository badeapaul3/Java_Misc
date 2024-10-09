package devguideocp.Part2_C11to15.A11_1_Generics;

/**
 * @author hatzp
 **/

interface IMonoLink<E> {
    void         setData(E data);
    E            getData();
    void         setNext(IMonoLink<E> next);
    IMonoLink<E> getNext();
}

class MonoNode<E> implements IMonoLink<E> {
    private E            data;    // Data
    private IMonoLink<E> next;    // Reference to next node                   (1)

    MonoNode(E data, IMonoLink<E> next) {                                  // (2)
        this.data = data;
        this.next = next;
    }

    @Override public void setData(E data) { this.data = data; }
    @Override public E    getData()       { return this.data; }
    @Override public void setNext(IMonoLink<E> next) { this.next = next; } // (3)
    @Override public IMonoLink<E> getNext()          { return this.next; } // (4)
    @Override public String toString() {
        return this.data.toString() + (this.next == null? "" : ", " + this.next);
    }


    public static void main(String[] args) {

        IMonoLink<String> strNode2 = new MonoNode<>("Bye", null);
        System.out.println(strNode2.getData());                    // Prints: Bye

        //IMonoLink<String> strNode3 = new IMonoLink<>("Bye", null); // Compile-time error! can't instantiate an interface
    }
}
