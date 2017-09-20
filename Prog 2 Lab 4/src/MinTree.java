public class MinTree {

    Tree tree = new Tree( 24, 
                 new Tree( 45, 
                     null , 
                     new Tree(8, null , null) ) , 
                 new Tree ( 17, 
                     new Tree (74 , null , null ) , 
                     null ) );

    public static void main(String[] args){
	MinTree mt = new MinTree();
	System.out.println("Minimum is :" + mt.findMin());
    }

    public int findMin(){
        return findMinAux(tree);
    }

    public int findMinAux(Tree tree) {
    	//if the tree has no children, return the value of the tree
    	if(tree.left() == null && tree.right() == null) { 
    		return tree.getVal();
    	}
    	else {
    		//if the tree has a left child but no right child, compare the value to the minimum of the left tree
    		if(tree.left() != null && tree.right() == null) {
    			int tmp = findMinAux(tree.left());
    			int val = tree.getVal();
    			if (val <= tmp) return val;
    			else return tmp;
    		}
    		else{
    			//if the tree has a right child but no left child, compare the value to the minimum of the right child
    			if(tree.left() == null && tree.right() != null) {
        			int tmp = findMinAux(tree.right());
        			int val = tree.getVal();
        			if (val <= tmp) return val;
        			else return tmp;
        		}
    			else {
    				// if the tree has both left and right children, compare the value to both, and if it is more than either of them, compare them with each other
    				if (tree.left() != null && tree.right() != null) {
    					int L = findMinAux(tree.left());
                		int R = findMinAux(tree.right());
                		int val = tree.getVal();
                		if (val <= L && val <= R) return val;
                		else {
                			if(L <= R) return L;
                			else return R;
                		}
                	}
    				else return 0;
    			}
            		
    		}		
    	}
    }


}
class Tree {

   private int val;
   private Tree left, right;

   public Tree(int val, Tree left, Tree right){
     this.val = val;
     this.left = left;
     this.right = right;
   }

   public int getVal(){
      return val;
   }

   public Tree left(){
      return left;
   }

   public Tree right(){
      return right;
   }
}