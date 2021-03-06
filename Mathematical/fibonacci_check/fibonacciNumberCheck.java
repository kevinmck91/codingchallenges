package fibonacci_check;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author kmk
 * 
 *         You are given an integer, . Write a program to determine if is an
 *         element of the Fibonacci sequence.
 * 
 *         The first few elements of the Fibonacci sequence are 0 1 1 2 3 5 8 13
 *         21.. A Fibonacci sequence is one where every element is a sum of the
 *         previous two elements in the sequence. The first two elements are and
 *         0 and 1
 * 
 *         https://www.hackerrank.com/challenges/is-fibo
 * 
 *
 */

public class fibonacciNumberCheck {

	public static void main(String[] args) {

		// User inputs number of integers to be tested
		Scanner myScan = new Scanner(System.in);
		long N = myScan.nextInt();

		// Test each number individually
		for (long x = 0L; x < N; x++) {

			BigInteger number = myScan.nextBigInteger();

			if (nthNumber(number) == true) {
				System.out.println("IsFibo");
			}

			else {
				System.out.println("IsNotFibo");
			}
		}
	}

	public static boolean nthNumber(BigInteger number) {

		// calculate the expression 5(N)^2+4 and 5(N)^2-4 using BigIntegers
		BigInteger four = new BigInteger("4");
		BigInteger five = new BigInteger("5");

		BigInteger numberSquared = number.multiply(number);
		BigInteger fiveTimesSquare = five.multiply(numberSquared);

		BigInteger fiveTimesSquarePlusFour = fiveTimesSquare.add(four);
		BigInteger fiveTimesSquareMinusFour = fiveTimesSquare.subtract(four);

		// If 5(N)^2+4 or 5(N)^2-4 is a perfect square, then its a Fibonacci
		// number

		if (isPerfertSquare(fiveTimesSquarePlusFour)
				|| isPerfertSquare(fiveTimesSquareMinusFour)) {
			return true;
		}

		return false;
	}

	public static boolean isPerfertSquare(BigInteger L) {

		// Convert the BigInteger to double in order to get square root
		double doubleValue = L.doubleValue();
		double sqrtOfDouble = Math.sqrt(doubleValue);

		// Round the square root to nearest whole number and square it again for
		// proof
		double roundedSqrtOfDouble = Math.round(sqrtOfDouble);
		double roundedSquare = roundedSqrtOfDouble * roundedSqrtOfDouble;

		if (roundedSqrtOfDouble * roundedSqrtOfDouble == doubleValue) {
			return true;
		}
		return false;
	}

}
