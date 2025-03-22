class Node {
    String customerName;
    Node next;

    public Node(String customerName) {
        this.customerName = customerName;
        this.next = null;
    }
}

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Push (enqueue) pelanggan ke antrian
    public void push(String customerName) {
        Node newNode = new Node(customerName);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(customerName + " masuk ke antrian.");
    }

    // Pop (dequeue) pelanggan dari antrian
    public void pop() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println(front.customerName + " telah dilayani dan keluar dari antrian.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Menampilkan antrian saat ini
    public void displayQueue() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.print("Antrian pelanggan: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.customerName + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class RestaurantQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push("Andi");
        queue.push("Budi");
        queue.push("Citra");
        queue.displayQueue();

        queue.pop();
        queue.displayQueue();

        queue.pop();
        queue.displayQueue();
    }
}
