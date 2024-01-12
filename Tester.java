public class Tester {
      
      
   public static void main(String[] args) {
      part1test();
    //   part2test();
   }
   public static void part1test(){
      BST_Array bst3 = new BST_Array();
      bst3.add(10);
      bst3.add(5);
      bst3.add(15);
      bst3.add(3);
      bst3.add(7);
      bst3.add(12);
      bst3.add(20);
      System.out.println("------------------------------------------part1 (add & find) testing------------------------------------------");
      
      System.out.println("\n\n------------------------------------------Case 1------------------------------------------");
      System.out.println(bst3);
      System.out.println("\nVERSUS WHAT IT SHOULD LOOK LIKE");
      System.out.println("      10\r\n" +
              "    /    \\\r\n" +
              "   5      15\r\n" +
              "  / \\    /  \\\r\n" +
              " 3   7  12  20");
      System.out.println("Find 8: " + bst3.find(8)); // Should print false
      System.out.println("Find 12: " + bst3.find(12)); // Should print true
      System.out.println("Find 3: " + bst3.find(3)); // Should print true
      System.out.println("Find 18: " + bst3.find(18)); // Should print false
      
      BST_Array bst4 = new BST_Array();
      bst4.add(25);
      bst4.add(15);
      bst4.add(35);
      bst4.add(10);
      bst4.add(20);
      bst4.add(30);
      
      System.out.println("\n\n------------------------------------------Case 2 (Incomplete)------------------------------------------");
      System.out.println(bst4);
      System.out.println("\nVERSUS WHAT IT SHOULD LOOK LIKE");
      System.out.println("      25\r\n" +
              "    /    \\\r\n" +
              "   15      35\r\n" +
              "  / \\    /\r\n" +
              "10  20  30");
      bst4.remove(35);
      System.out.println("\n" + bst4);

      
      System.out.println(bst4);
      System.out.println("Find 22: " + bst4.find(22)); // Should print false
      System.out.println("Find 30: " + bst4.find(30)); // Should print true
      System.out.println("Find 10: " + bst4.find(10)); // Should print true
      }

   public static void part2test() {
            BST_Array bst5 = new BST_Array();
            bst5.add(50);
            bst5.add(25);
            bst5.add(75);
            bst5.add(15);
            bst5.add(35);
            bst5.add(85);
            bst5.add(10);
            bst5.add(20);
            bst5.add(30);
            bst5.add(40);
            bst5.add(80);
            bst5.add(90);
            System.out.println("------------------------------------------part2 (remove) testing------------------------------------------");

        
            System.out.println("------------------------------------------Original Tree------------------------------------------");
            System.out.println(bst5);
        
            System.out.println("\n------------------------------------------Removing Node 25 (2 Children)------------------------------------------");
            bst5.remove(25);
            System.out.println(bst5);
        
            System.out.println("\n------------------------------------------Removing Node 75 (1 Child)------------------------------------------");
            bst5.remove(75);
            System.out.println(bst5);
        
            System.out.println("\n------------------------------------------Removing Node 50 (Root)------------------------------------------");
            bst5.remove(50);
            System.out.println(bst5);

            System.out.println("\n------------------------------------------Removing Node 40 (Leaf -> No Children)------------------------------------------");
            bst5.remove(40);
            System.out.println(bst5);
        
            System.out.println("\n------------------------------------------Removing Non-Existent Node 55------------------------------------------");
            bst5.remove(55);
            System.out.println(bst5);
      }
}
