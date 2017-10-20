package test;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import code.CodeChef;

public class CodeChefTest {

	CodeChef c = new CodeChef();
	@Test
	public void testNextPalindrome() {
		System.out.println(c.nextPalindrome(BigInteger.valueOf(100)));
	}

}
