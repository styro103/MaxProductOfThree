/*
 * The class that gets the maximum product of any Three Array Elements After Sorting Using Counters
 * This has a time complexity of O(N+M)
 */
 
class ProductOfThreeCounters
{
	public int getMax(int [] A) //Function That Gets Max Product of Three Elements
	{
		//Edge Case
		if (A.length==3) //If Only Three Element
			return (A[0]*A[1]*A[2]); //Return Product of Array Elements
		
		int prod; //Product of Elements
		int N = A.length; //Length of Array
		int min = A[0]; //Minimum Value in Array
        int max = A[0]; //Maximum Value in Array
		int t = 0; //For Traversing Array of Counters
        int [] count; //Array of Counters
		
		for (int i=1; i<N; i++) //Loop Through Array, Get Minimum and Max
        {
            if (A[i]<min)
                min = A[i];
            else if (A[i]>max)
                max = A[i];
        }
		
		if (max==0) //If Max Element is Zero
			return 0; //Return Zero Because All Other Options Are Negative
        
        count = new int[max-min+1]; //Set Size of Counters Array to Range of Elements
		
		for (int i=0; i<N; i++) //Loop through Array A
            count[A[i]-min]++; //Increment Count of Number in Respective Position in Counters Array
		for (int i=0; i<N;) //Sort Array Using Counters
		{
			while (count[t]==0)
				t++;
			for (int j=0; j<count[t]; j++)
				A[i++] = t+min;
			
			t++;
		}
		
		prod = A[N-1]; //Start Product at Value of Last Element
		
		if (A[1]>0 || prod<0) //General Case, Last Two Elements Aren't Negative, or Max is Negative
			prod *=  A[N-2]*A[N-3]; //Max Product is Product of Last Three Elements
		else //Special Case, If Second Element is Negative and Max Isn't 
			prod *= Math.max(A[0]*A[1], A[N-2]*A[N-3]); //Multiply by Bigger Value, Product of First Two or Second to Last Two Elements
		
		return prod; //Return Product
	}
}