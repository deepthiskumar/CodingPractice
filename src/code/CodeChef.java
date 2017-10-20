package code;

import java.math.BigInteger;

public class CodeChef {
	
	public BigInteger nextPalindrome(BigInteger k)
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
	
	boolean isPalindrome(BigInteger val)
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
