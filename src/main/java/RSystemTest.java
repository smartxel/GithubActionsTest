import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		zeroOperationTest();
	}

	public static void zeroOperationTest() {

		int[] intArray = { 1, 2, 3, 0, 5, 6, 0 };
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < intArray.length; i++) {
			if(intArray[i]==0) {
				list.add(intArray[i]);
			//	System.out.println("if: "+list);
			}else {
				list.add(intArray[i]);
			//	System.out.println("else: "+list);
			}
		}
	//	System.out.println(""+list);
		
		int[] arr = { 1, 2, 3, 0, 5, 6, 0 };
        System.out.println("The original array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        for(int i= arr.length-1;i>=0;i--) {
        	 System.out.print(arr[i] + " ");
        }

	}

}
