package main;

import java.math.BigInteger;
import java.util.Scanner;

//This class is only for the submissions online. The actual code is in the "code" package

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] inp = new BigInteger[n];
		for(int i = 0; i< n; i++)
		{
			inp[i] = sc.nextBigInteger();
		}
		
		//output
		for(int i = 0; i< n; i++)
		{
			System.out.println(nextPalindrome(inp[i]));
		}
		
	}
	
	public static BigInteger nextPalindrome(BigInteger k)
	{
		BigInteger palindrome = k.add(BigInteger.ONE);
		while(true)
		{
			if(isPalindrome(palindrome))
				break;
			palindrome = palindrome.add(BigInteger.ONE);
		}
		return palindrome;
	}
	
	static boolean isPalindrome(BigInteger val)
	{
		BigInteger ten = BigInteger.valueOf(10);
		BigInteger lsb = val.mod(ten);
		BigInteger quo = val.divide(ten);
		BigInteger sum = lsb;
		while(quo.compareTo(BigInteger.ZERO) == 1)
		{
			lsb = quo.mod(ten);
			quo = quo.divide(ten);
			sum = sum.multiply(ten).add(lsb);
		}
		return (sum.compareTo(val) == 0);	
	}

}
