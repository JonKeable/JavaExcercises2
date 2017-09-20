
public class GrayCode {

	public static void main(String[] args) {
		int n = 4;
		GrayCode gc = new GrayCode();
		String[] arr;
		arr = gc.genCode(n);
		//prints out the gray code from the returned array
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private String[] genCode(int n) {
		String[] ans;
		if(n <= 0) return null;
		//If the length of binary string required is 1, return the base case {0,1}
		if(n == 1) {
			ans = new String[2];
			ans[0] = "0";
			ans[1] = "1";
			return ans;
		}
		//Otherwise generate gray code based on the gray code for a binary string of length n-1
		else {
			String[] prevAns = genCode(n-1);
			int prevLength = prevAns.length;
			ans = new String[prevLength*2]; 
			for(int i = 0; i < prevLength; i++) {
				//the first half of the gray code is just the gray code for n-1, with a 0 added to the start
				ans[i] = "0" + prevAns[i];
				//the second half is the gray code in reverse sequence for n-1, with a 1 added to the start
				ans[ans.length - i - 1] = "1" + prevAns[i];
			}
			return ans;
		}
	}
}
