/**
 * Created by CFD2 on 12/7/17.
 */
public class TestListReferenceBased {
    public static void main(String[] args) {
        TestListReferenceBased test = new TestListReferenceBased();
        ListReferenceBased <Integer> list = new ListReferenceBased<>();
        //12, 3, 25, 18
        list.add(12, 0);
        list.add(3, 1);
        list.add(25, 2);
        list.add(18, 3);
        test.printList(list);

        list.add(13, 0);
        test.printList(list);

        list.add(17, 2);
        test.printList(list);

        list.remove(4);
        test.printList(list);




    }

    public void printList(ListReferenceBased list) {
        System.out.print("\n" + list.size() + " Items in the linked list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(" ");
    }

}
