package code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProjectEuler {

	// Problem 1: sum of multiples of 3 and 5
	public int sOfm(int x)
	{
		Set<Integer> multiples = multiple(3,x);
		multiples.addAll(multiple(5,x));
		return (sum(multiples));
	}

	private Set<Integer> multiple(int i, int x) 
	{
		int count = 1;
		Set<Integer> multiples = new HashSet<Integer>();
		while(i*count < x)
		{
			multiples.add(i*count);
			count++;
		}
		return multiples;
	}
	
	int sum(Collection<Integer> col)
	{
		Iterator<Integer> it = col.iterator();
		int val = 0;
		while(it.hasNext())
		{
			val += it.next();
		}
		return val;
		
	}
	//Problem 2: sum of even fibonacci terms
	public int evenFibSum(int limit)
	{
		ArrayList<Integer> fib = getFibTerms(1,2,limit);
		getEven(fib);
		return (sum(fib));
	}
	
	ArrayList<Integer> getFibTerms(int first, int second, int limit)
	{
		ArrayList<Integer> terms = new ArrayList<Integer>();
		if(first <= limit) 
			terms.add(first);
		else return terms;
		terms.addAll(getFibTerms(second, first+second, limit));
		return terms;
	}
	
	void getEven(ArrayList<Integer> items) // ArrayList gets updated because the value(object reference) is passed
	{
		Iterator<Integer> it = items.iterator();
		while(it.hasNext())
		{
			Integer val = it.next();
			if(val % 2 != 0)
				it.remove(); //Using list.remove() causes concurrent modification exception
		}
	}
	
	//Problem 5: smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	
    public int evenDiv(int divisor)
	{
    	int val = divisor;
    	while(!divBy(val, divisor))
    	{
    		val++;
    	}
    	return  val;
	}
	
    boolean divBy(int val, int divisor)
    {
    	if(divisor == 1)
    		return true;
    	if(val % divisor == 0)
    		return divBy(val, divisor-1);
    	else
    		return false;
    }
    
    //Problem 6: difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    
    public int sumSquareDiff(int n)
    {
    	int a  = n*(n+1)/2;
    	int b  = sumOfSquares(n);
    	return (Math.abs(a*a-b));
    }
    
    int sumOfSquares(int n)
    {
    	int sum = 0;
    	for(int i = 1 ; i<= n ; i++ )
    		sum = sum + i*i;
    	return sum;
    }
    
    //Problem 7: nth Prime
    
    public int nthPrime(int n)
    {
    	int count = 0;
    	int val = 0;
    	while(count < n)
    	{
    		val++;
    		if(isPrime(val))
    			count++;
    	}
    	return val;
    }
    
    boolean isPrime(int n)
    {
    	if(n == 1) return false;
    	int divisor = n-1;
    	while(divisor != 1)
    	{
    		if(n % divisor == 0)
    			return false;
    		divisor--;
    	}
    	return true;
    }
    
    //Problem 8: thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
    
    public BigInteger adjProd(BigInteger val, int digits)
    {
    	String str = val.toString();
    	int[] valArray = new int[str.length()];
    	for(int i = 0; i< str.length(); i ++)
    		valArray[i] = Integer.parseInt(""+str.charAt(i));
    	return maxProduct(valArray, digits);
    }
    
    BigInteger maxProduct(int[] valArray, int digits)
    {
    	BigInteger max = BigInteger.ONE;
    	int len = valArray.length;
    	if(len < digits)
    		return max;
    	
    	for(int i = 0; i< digits; i++)
    		max = max.multiply(BigInteger.valueOf(valArray[i]));
    	
    	BigInteger newMax = maxProduct(Arrays.copyOfRange(valArray, 1, len), digits );
    	if(max.compareTo(newMax) == -1)
    		max = newMax;
    	return max;
    }
    
    //Problem 9: There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc
    
    public int pyProd()
    {
    	int b = 1;
    	int a = 0,c = 0;
    	while(true)
    	{
    		int m = 1000-b;
    		int n = 1000*(500-b);
    		if(n%m != 0)
    		{
    			b++;
    			continue;
    		}
    		a = n/m;
    		c = 1000-a-b;
    		break;
    	}
    	return (a*b*c);
    }
    
    //Problem 10: sum of all the primes below two million
    public int sumOfPrimes(int n)
    {
    	int sum = 0;
    	int val = 2;
    	while(val < n)
    	{
    		if(isPrime(val))
    			sum += val;
			val++;
    	}
    	return sum;
    }
    
    
    
 }
