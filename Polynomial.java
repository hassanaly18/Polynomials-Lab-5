
public class Polynomial {

    private Node head;

    public Polynomial() {
        this.head = null;
    }

    public void insert(int coefficient, int power) {

        Node newNode = new Node(coefficient, power);

        if (head == null || head.power < power) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.power > power) {
            temp = temp.next;
        }

        if(temp.next !=null && temp.next.power == power){
            temp.next.coefficient = temp.next.coefficient + coefficient;
        }
        else{
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
}
