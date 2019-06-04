/**
 * Created by CFD2 on 12/7/17.
 */
public class ListReferenceBased <E> implements ListInterface <E> {
    private Node <E> head = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {    //Adding to beginning
            head = (size == 0) ? new Node <>(item) : new Node <>(item, head);   //ternary if adding to the empty list or adding to the beginning
            ++size;
        } else {    //Adding elsewhere
            Node <E> curr = find(index - 1);
            curr.setNext(new Node <>(item, curr.getNext()));
            ++size;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > (size - 1) || isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {    //if removing from beginning
            head = head.getNext();
            --size;
        } else {
            Node <E> curr = find(index - 1);    //removing from elsewhere
            curr.setNext(curr.getNext().getNext());
            --size;
        }

    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Cannot get what is out of bounds.");
        return find(index).getItem();
    }

    @Override
    public void removeAll() {
        head = null;
        size = 0;

    }

    private Node <E> find(int index) {
        Node <E> curr = head;
        for (; index != 0; index-- ) {
            curr = curr.getNext();
        }
        return curr;

    }
}
