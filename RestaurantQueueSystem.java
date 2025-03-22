/**
 * Sistem Antrian Restoran menggunakan Single Linked List
 * 
 * Program ini mengimplementasikan sistem antrian pelanggan di restoran
 * menggunakan struktur data Single Linked List dengan operasi push dan pop.
 */

 import java.util.Scanner;

 // Kelas untuk merepresentasikan data pelanggan
 class Customer {
     private String name;
     private int tableNumber;
     private int numberOfPeople;
     
     public Customer(String name, int tableNumber, int numberOfPeople) {
         this.name = name;
         this.tableNumber = tableNumber;
         this.numberOfPeople = numberOfPeople;
     }
     
     public String getName() {
         return name;
     }
     
     public int getTableNumber() {
         return tableNumber;
     }
     
     public int getNumberOfPeople() {
         return numberOfPeople;
     }
     
     @Override
     public String toString() {
         return "Pelanggan: " + name + 
                ", Meja: " + tableNumber + 
                ", Jumlah Orang: " + numberOfPeople;
     }
 }
 
 // Kelas Node untuk Single Linked List
 class Node {
     Customer data;
     Node next;
     
     public Node(Customer data) {
         this.data = data;
         this.next = null;
     }
 }
 
 // Kelas untuk implementasi Single Linked List
 class CustomerQueue {
     private Node head; // Kepala antrian (pelanggan pertama)
     private Node tail; // Ekor antrian (pelanggan terakhir)
     private int size;  // Ukuran antrian
     
     public CustomerQueue() {
         this.head = null;
         this.tail = null;
         this.size = 0;
     }
     
     // Operasi push: menambahkan pelanggan baru ke akhir antrian
     public void push(Customer customer) {
         Node newNode = new Node(customer);
         
         // Jika antrian kosong
         if (head == null) {
             head = newNode;
             tail = newNode;
         } else {
             // Jika antrian tidak kosong, tambahkan di belakang
             tail.next = newNode;
             tail = newNode;
         }
         
         size++;
         System.out.println("Pelanggan " + customer.getName() + " ditambahkan ke antrian.");
     }
     
     // Operasi pop: menghapus dan mengembalikan pelanggan dari awal antrian
     public Customer pop() {
         if (isEmpty()) {
             System.out.println("Antrian kosong!");
             return null;
         }
         
         Customer customer = head.data;
         head = head.next;
         
         // Jika antrian sekarang kosong, tail juga harus null
         if (head == null) {
             tail = null;
         }
         
         size--;
         System.out.println("Pelanggan " + customer.getName() + " dilayani dan dihapus dari antrian.");
         return customer;
     }
     
     // Memeriksa apakah antrian kosong
     public boolean isEmpty() {
         return head == null;
     }
     
     // Mendapatkan ukuran antrian
     public int size() {
         return size;
     }
     
     // Menampilkan semua pelanggan dalam antrian
     public void display() {
         if (isEmpty()) {
             System.out.println("Antrian kosong!");
             return;
         }
         
         System.out.println("\n=== DAFTAR ANTRIAN PELANGGAN ===");
         System.out.println("Jumlah pelanggan dalam antrian: " + size);
         
         Node current = head;
         int position = 1;
         
         while (current != null) {
             System.out.println(position + ". " + current.data);
             current = current.next;
             position++;
         }
         
         System.out.println("===============================\n");
     }
 }
 
 public class RestaurantQueueSystem {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         CustomerQueue queue = new CustomerQueue();
         int choice;
         
         System.out.println("=== SISTEM ANTRIAN RESTORAN ===");
         
         do {
             System.out.println("\nMenu:");
             System.out.println("1. Tambah Pelanggan (Push)");
             System.out.println("2. Layani Pelanggan (Pop)");
             System.out.println("3. Tampilkan Antrian");
             System.out.println("4. Keluar");
             System.out.print("Pilihan Anda: ");
             
             choice = scanner.nextInt();
             scanner.nextLine(); // Membersihkan buffer
             
             switch (choice) {
                 case 1:
                     System.out.print("Nama Pelanggan: ");
                     String name = scanner.nextLine();
                     System.out.print("Nomor Meja: ");
                     int tableNumber = scanner.nextInt();
                     System.out.print("Jumlah Orang: ");
                     int numberOfPeople = scanner.nextInt();
                     
                     Customer newCustomer = new Customer(name, tableNumber, numberOfPeople);
                     queue.push(newCustomer);
                     queue.display();
                     break;
                     
                 case 2:
                     Customer servedCustomer = queue.pop();
                     if (servedCustomer != null) {
                         System.out.println("Pelanggan yang dilayani: " + servedCustomer);
                     }
                     queue.display();
                     break;
                     
                 case 3:
                     queue.display();
                     break;
                     
                 case 4:
                     System.out.println("Terima kasih telah menggunakan Sistem Antrian Restoran!");
                     break;
                     
                 default:
                     System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
             }
             
         } while (choice != 4);
         
         scanner.close();
     }
 }