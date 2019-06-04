/**
 * Created by CFD2 on 12/7/17.
 */
public interface ListInterface <E> {
    public boolean isEmpty();
    public int size();
    public void add(E item, int index);
    public void remove(int index);
    public Object get(int index);
    public void removeAll();
}
