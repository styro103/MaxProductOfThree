/*
 * The class that gets the maximum product of any Three Array Elements Using Sorting
 * This has a time complexity of O(N*log(N))
 */
 
import java.util.Arrays; //For Sorting Element

class ProductOfThreeSort
{
	public int getMax(int [] A) //Function That Gets Max Product of Three Elements
	{
		//Edge Cases
		if (A.length==3) //If Only Three Element
			return (A[0]*A[1]*A[2]); //Return Product of Array Elements
		
		int prod; //Product of Elements
		int N = A.length; //Length of Array
		
		//Sort Array, Post Sort, First Two Elements May be Negative, 
			//but Then Their Product May be Greater Than The Second to Last Two's
		Arrays.sort(A); //Sort Array	
		prod = A[N-1]; //Start Product at Value of Last Element
		
		if (prod==0) //If Max Element is Zero
			return 0; //Return Zero Because All Other Options Are Negative
		if (A[1]>0 || prod<0) //General Case, Last Two Elements Aren't Negative, or Max is Negative
			prod *=  A[N-2]*A[N-3]; //Max Product is Product of Last Three Elements
		else //Special Case, If Second Element is Negative and Max Isn't 
			prod *= Math.max(A[0]*A[1], A[N-2]*A[N-3]); //Multiply by Bigger Value, Product of First Two or Second to Last Two Elements
		
		return prod; //Return Product
	}
}