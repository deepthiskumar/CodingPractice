package test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import code.ProjectEuler;

public class ProjectEulerTest {

	ProjectEuler pObj = new ProjectEuler();
	
	@Test
	public void testSOfm() {
		assertNotNull(pObj.sOfm(0));
	}
	
	@Test
	public void testSOfmVal()
	{
		int val = pObj.sOfm(10);
		assertTrue( val == 23);	
	}
	
	@Test
	public void testSOfm1000()
	{
		Integer val = pObj.sOfm(1000);
		assertNotNull("sOfm = "+ val , val);
		System.out.println("sOfm = "+val);
	}
	
	@Test
	public void testEvenFibSumNull()
	{
		assertNotNull(pObj.evenFibSum(10));
	}
	
	@Test
	public void testEvenFibSum10()
	{
		assertTrue(pObj.evenFibSum(10) == 10);
	}
	
	@Test
	public void testEvenFibSum4Mil()
	{
		int val = pObj.evenFibSum(4000000);
		System.out.println("sumEvenFib: "+val);
	}
	
	@Test
	public void testEvenDiv()
	{
		int val = pObj.evenDiv(20);
		System.out.println("EvenDiv: "+val);
		
	}
	
	@Test
	public void testSumSquareDiff()
	{
		int val = pObj.sumSquareDiff(10);
		assertTrue(val == 2640);
		val = pObj.sumSquareDiff(100);
		System.out.println("SumSquareDiff: " + val);
	}
	
	@Test
	public void testNthPrime()
	{
		int val = pObj.nthPrime(6);
		assertTrue(val == 13);
		System.out.println("10001th prime: "+ pObj.nthPrime(10001)); //faster than haskell
	}
	
    @Test
    public void testAdjProd()
    {
    	BigInteger val = new BigInteger("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
    	BigInteger prod = pObj.adjProd(val, 4);
    	assertTrue(prod.equals(BigInteger.valueOf(5832)));
    	prod = pObj.adjProd(val, 13);
    	System.out.println("AdjProd 13 digits: "+ prod);
    	
    }
    
    @Test
    public void testPyProd()
    {
    	assertTrue(pObj.pyProd() == 31875000);
    }
    
    @Test
    public void testSumOfPrimes()
    {
    	assertTrue(pObj.sumOfPrimes(10) == 17);
    	System.out.println("Sum of primes < 2 million: "+pObj.sumOfPrimes(2000000));
    }

}
