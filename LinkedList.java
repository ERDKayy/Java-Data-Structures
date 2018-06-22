public class LinkedList {
 
   // This is a Node class to be used in the data structure
   protected static class Node {
      public Object data;
      public Node next;
   }

   protected Node head;
   protected Node tail;
   protected Node next;
   
   public LinkedList() {
      
      head = null;
      tail = null;
      next = null;
      
   }
   
   public void first() {
      next = head;
   }
   
   public Object next() {
      // Return the data item pointed at by the "next" pointer, and then
      // advance the pointer.

      if (next != null) {
         Object data = next.data;
         next = next.next;
         return data;
      } else {
         return null;
      }
   }
   
   public Object getAt(int index) {
      
      // Find the Node at the requested index (zero-based)
      // and return the data contained within that Node.

      if (index < 0) return null;
      
      int i = 0;
      Node current = head;
      while (current != null && i < index) {
         current = current.next;
         i = i + 1;
      }
      if (current != null) return current.data;
      else return null;
   }

   // Additional method from last week:
   public Node createNode(Object data) {
      Node newNode = new Node();
      newNode.data = data;
      newNode.next = null;
      return newNode;
   }
   
   public void add(Object data) {
      Node newNode = createNode(data);
      
      if (tail != null) {
         tail.next = newNode;

      }
      tail = newNode;
      if (head == null) head = newNode;
   }
   
   public boolean isEmpty() {
       return(head == null);
   }
   
   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.add("one");
      list.add("two");
      list.add("three");
      
      list.first();
      System.out.println(list.next());
      System.out.println(list.next());
      System.out.println(list.next());
   }
}
