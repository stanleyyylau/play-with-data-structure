public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList();

        for (int i = 0; i <= 5; i++ ) {
            llist.addFirst(i);
            System.out.println(llist.toString());
        }

        llist.add(2, 666);
        System.out.println(llist);

        System.out.println(llist.remove(2));
        System.out.println(llist.toString());

        System.out.println(llist.removeFirst());
        System.out.println(llist.toString());

        System.out.println(llist.removeLast());
        System.out.println(llist.toString());

    }
}
