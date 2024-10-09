package devguideocp.Part2_C11to15.A11_2_Generics2;

/**
 * @author hatzp
 **/

import devguideocp.Part2_C11to15.A11_1_Generics.Node;

import java.util.Iterator;

/** Iterator for nodes */
public class NodeIterator<E> implements Iterator<E> {
    private Node<E> thisNode;

    public NodeIterator(Node<E> first) { thisNode = first;  }

    @Override public boolean hasNext() { return thisNode != null; }

    @Override public E next() {
        E data = thisNode.getData();
        thisNode = thisNode.getNext();
        return data;
    }

    @Override public void remove() { throw new UnsupportedOperationException(); }
}
