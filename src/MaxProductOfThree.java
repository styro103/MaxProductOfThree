/*
 * Shaun Mbateng
 * This program has the user input an array, and the maximum possible product
 * 	of any three of the elements in the array.
 * It has a time complexity of O(N*log(N))
 * 	(complexity is O(N+M) if regular sorting method isn't used).
 */

import java.util.Scanner;

public class MaxProductOfThree 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in); //For Inputs
		ProductOfThreeCounters Set1 = new ProductOfThreeCounters(); //Class That Gets Product
		ProductOfThreeSort Set2 = new ProductOfThreeSort(); //Class That Gets Product
		int [] arr; //Array to Sort
		int len; //Length of Array
		int prod1;
		int prod2;
		
		//Enter and Set Array Length
		System.out.print("Enter the Array Length: ");
		len = cin.nextInt();
		arr = new int [len];
		
		//Fill Array
		for (int i=0; i<len; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			arr[i] = cin.nextInt();
		}
		
		cin.close(); //No More Inputs Needed
		
		//Get Products
		prod1 = Set1.getMax(arr);
		prod2 = Set2.getMax(arr);
		
		//Print Arrays
		System.out.println();
		
		if (prod1==prod2) //If Equal, and Always Should be, Display
			System.out.println("Max Product: "+prod1);
		else //Should Not Happen, but for Code Checking
		{
			System.out.println("Max Product 1: "+prod1);
			System.out.println("Max Product 2: "+prod2);
		}
	}
}
