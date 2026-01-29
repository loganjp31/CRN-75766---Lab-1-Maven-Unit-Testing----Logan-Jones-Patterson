package com.ontariotechu.sofe3980u;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

    /**
     * Tests the bitwise OR operation with two binary values of equal length.
     * Expected result is 1111.
     */
    @Test
    public void testOr1() {
        Binary a = new Binary("1010");
        Binary b = new Binary("0101");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.or(a, b);

        assertTrue(out.toString().contains("1111"));
    }
    /**
        * Tests the bitwise OR operation when one operand is zero.
        * Expected result is the non-zero operand.
     */
    @Test
    public void testOrWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1010");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.or(a, b);

        assertTrue(out.toString().contains("1010"));
    }

    /**
     * Tests the bitwise OR operation with binary values of different lengths.
     * Expected result is 101.
     */
    @Test
    public void testOrDifferentLengths() {
        Binary a = new Binary("101");
        Binary b = new Binary("1");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.or(a, b);

        assertTrue(out.toString().contains("101"));
    }

    /**
     * Tests the bitwise AND operation with two binary values of equal length.
     * Expected result is 1000.
     */
    @Test
    public void testAnd1() {
        Binary a = new Binary("1100");
        Binary b = new Binary("1010");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.and(a, b);

        assertTrue(out.toString().contains("1000"));
    }
    /**
        * Tests the bitwise AND operation when one operand is zero.
        * Expected result is 0000.
     */
    @Test
    public void testAndWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1111");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.and(a, b);

        assertTrue(out.toString().contains("0000"));
    }
    /**
     * Tests the bitwise AND operation with binary values of different lengths.
     * Expected result is 001.
     */
    @Test
    public void testAndDifferentLengths() {
        Binary a = new Binary("101");
        Binary b = new Binary("1");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.and(a, b);

        assertTrue(out.toString().contains("001"));
    }

    /**
     * Tests the multiplication of two binary numbers.
     * Expected result is 110 (2 * 3 = 6).
     */
    @Test
    public void testMultiply1() {
        Binary a = new Binary("10"); // 2
        Binary b = new Binary("11"); // 3

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.multiply(a, b);

        assertTrue(out.toString().contains("110")); // 6
    }
    /**
     * Tests the multiplication of two binary numbers of different lengths.
     * Expected result is 100111 (7 * 5 = 35).
     */
    @Test
    public void testMultiplyByZero() {
        Binary a = new Binary("1011");
        Binary b = new Binary("0");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.multiply(a, b);

        assertTrue(out.toString().contains("0"));
    }
    /**
     * Tests the multiplication of two binary numbers of different lengths.
     * Expected result is 100111 (7 * 5 = 35).
     */
    @Test
    public void testMultiplyByOne() {
        Binary a = new Binary("1011");
        Binary b = new Binary("1");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Binary.multiply(a, b);

        assertTrue(out.toString().contains("1011"));
    }
}
