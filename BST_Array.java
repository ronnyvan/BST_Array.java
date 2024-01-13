public class BST_Array {
   public Integer[] tree;

   public BST_Array() {
      tree = new Integer[20];
   }

   public void add(Integer val) {
      addHelp(0, val);
   }

   public void addHelp(int rootIndex, Integer val) {
      if (tree[rootIndex] == null) {
         tree[rootIndex] = val;
         return;
      }

      if ((rootIndex * 2) >= tree.length) {
         Integer[] newArray = new Integer[tree.length * 2];
         for (int i = 0; i < tree.length; i++) {
            newArray[i] = tree[i];
         }
         tree = newArray;
      }
      if (val < tree[rootIndex])
         addHelp(rootIndex * 2 + 1, val);
      else
         addHelp(rootIndex * 2 + 2, val);

   }

   public boolean find(Integer val) {
      return findHelp(0, val);
   }

   private boolean findHelp(int rootIndex, Integer val) {
      if (tree[rootIndex] == val) {
         return true;
      }
      if (tree[rootIndex] == null || rootIndex >= tree.length) {
         return false;
      }
      if (val < tree[rootIndex])
         return findHelp(rootIndex * 2 + 1, val);
      else
         return findHelp(rootIndex * 2 + 2, val);
   }

   public String toString() {
      if (tree[0] == null) {
         return "Empty";
      }

      int power = 2;
      String result = "Level 0: ";
      for (int i = 0, level = 1; i < tree.length; i++) {
         if (i == power - 1) {
            boolean emptyRow = true;
            for (int j = i; j < i + power - 1 && j < tree.length; j++) {
               if (tree[j] != null){
                  emptyRow = false;
               }
            }

            if (emptyRow) break;
            result += "\nLevel " + level++ +": ";
            power *= 2;
         }
         if (tree[i] != null) {
            result += tree[i] + " ";
         } else {
            result += "(null) ";
         }

      }
      return result;
   }

   public void remove(Integer val) {
      int valIndex = findIndex(0, val);
      if (valIndex == -1) {
         return;
      }
     
      if (valIndex * 2 >= tree.length || (tree[valIndex * 2 + 1] == null && tree[valIndex * 2 + 2] == null)) { //0 
         tree[valIndex] = null;
      } 
      else if (valIndex * 2 < tree.length && (tree[valIndex * 2 + 1] == null ^ tree[valIndex * 2 + 2] == null)) { //1 
         int childIndex;
         if (tree[valIndex * 2 + 1] == null) {
            childIndex = valIndex * 2 + 2;
         } else {
            childIndex = valIndex * 2 + 1;
         }
         tree[valIndex] = tree[childIndex];
         oneChild(valIndex, childIndex);
      } else { // 2
         int rightMinIndex = findLeftmost(valIndex * 2 + 2);
         tree[valIndex] = tree[rightMinIndex];
         tree[rightMinIndex] = null;
      }

   }

   private void oneChild(int rootIndex, int childIndex) {
      if (childIndex * 2 >= tree.length || (tree[childIndex * 2 + 1] == null && tree[childIndex * 2 + 2] == null)) {
         tree[childIndex] = null;
         return;
      }
      tree[rootIndex * 2 + 1] = tree[childIndex * 2 + 1];
      tree[rootIndex * 2 + 2] = tree[childIndex * 2 + 2];
      oneChild(childIndex, childIndex * 2 + 1);
      oneChild(childIndex, childIndex * 2 + 2);
   }

   private Integer findLeftmost(int rootIndex) {
      if (rootIndex >= tree.length || tree[rootIndex] == null) {
         return null;
      }

      Integer leftmost = findLeftmost(rootIndex * 2 + 1);
      if (leftmost != null) {
         return leftmost;
     } else {
         return rootIndex;
     }
   }

   private int findIndex(int rootIndex, Integer val) {
      if (rootIndex >= tree.length || tree[rootIndex] == null) {
         return -1;
      }
      if (tree[rootIndex] == val) {
         return rootIndex;
      }
      if (val < tree[rootIndex]) {
         return findIndex(rootIndex * 2 + 1, val);
      } else
         return findIndex(rootIndex * 2 + 2, val);
   }
}
