
public class MinInt {

    int[] arr = {24,52,74,9,34,23,64,34};

    public static void main(String[] args){
	MinInt m = new MinInt();
	System.out.println("Minimum is :" + m.findMin());
    }

    public int findMin(){
           return findMinAux(0);
    }

    public int findMinAux(int index) {
    	//if index is the last element in the array, just return this
    	if(index+1 == arr.length) {
    		return arr[index];
    	}
    	//otherwise compare the value at the specified index with the minimun for the rest of the array
    	else {
    		int tmp = findMinAux(index+1);
    		if(arr[index] <= tmp) return arr[index];
    		else return tmp;
    	}

    }
    
}
