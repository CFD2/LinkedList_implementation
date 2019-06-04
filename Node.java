/**
 * Created by CFD2 on 12/7/17.
 */
public class Node <E> {
    private E item;
    private Node <E> next;

//    public Node(){
//        item = null;
//        next = null;
//    }
    public Node(E e) {
        item = e;
        this.next = null;
    }

    public Node(E e, Node <E> next) {
        item = e;
        this.next = next;
    }

    public void setItem(E e) {
        item = e;
    }

    public void setNext(Node <E> next) {
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public Node <E> getNext() {
        return next;
    }
}
