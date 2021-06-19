package testSuites;

import org.junit.Assert;
import org.junit.Test;

import compute.Calculator;

/**
 * @author alexgabor
 *
 */
public class CalculatorTest {

	Calculator calculator = new Calculator();
	Calculator calculator1 = new Calculator();

	@Test
	public void testMultiplyPositiveNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(4, 56, "*");
		Assert.assertEquals(224, actualResult, 0);

		double actualResult2 = calculator.compute(0, 0, "*");
		Assert.assertEquals(0, actualResult2, 0);

		double actualResult3 = calculator.compute(100, 99779, "*");
		Assert.assertEquals(9977900, actualResult3, 0);
	}

	@Test
	public void testMultiplyNegativeNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(-3, -56, "*");
		Assert.assertEquals(168, actualResult, 0);
		Assert.assertEquals("Multiplication of 2 negative numbers is incorrect", 168, actualResult, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOperator() {

		// Calculator calculator = new Calculator();
		calculator.compute(3, 0, "h");
	}

	@Test
	public void testSumPositiveNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(3, 2, "+");
		Assert.assertEquals(5, actualResult, 0);
		Assert.assertFalse(actualResult != 5);
		Assert.assertTrue(actualResult == 5);
	}

	@Test
	public void testSumNegativeNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(-2, -5, "+");
		Assert.assertEquals(-7, actualResult, 0);
		Assert.assertNotEquals(null, actualResult, 0);
		Assert.assertNotEquals("Sum of 2 negative numbers is incorrect ", -8, actualResult, 0);
	}

	@Test
	public void testDifferencePositiveNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(5, 3, "-");
		Assert.assertEquals(2, actualResult, 0);
	}

	@Test
	public void testDifferenceNegativeNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(-8, -5, "-");
		Assert.assertEquals(-3, actualResult, 0);
	}

	@Test
	public void testSqrt() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(16, 0, Calculator.SQRT);
		Assert.assertEquals(4, actualResult, 0);
	}

	@Test
	public void testDivisionWithPositiveNumbers() {
		// Calculator calculator = new Calculator();

		double actualResult = calculator.compute(10, 5, "/");
		Assert.assertEquals(2, actualResult, 0);
		Assert.assertNotEquals(3, actualResult, 0);
		Assert.assertFalse(actualResult == 3);
	}

	@Test
	public void testDivisionWithNegativeNumbers() {
		// Calculator calculator = new Calculator();
		// Calculator calculator1 = new Calculator();

		double actualResult = calculator.compute(-10, 5, "/");
		double actualResult2 = calculator.compute(-10, -5, "/");
		Assert.assertEquals(-2, actualResult, 0);
		Assert.assertEquals(2, actualResult2, 0);
		Assert.assertEquals("Division of 2 negative numbers is incorrect", -2, actualResult, 0);
		Assert.assertNotEquals(3, actualResult, 0);
		Assert.assertNotEquals(4, actualResult2, 0);
		Assert.assertFalse(actualResult == 2);
		Assert.assertTrue(actualResult2 == 2);
		Assert.assertNotNull(calculator);
		Assert.assertNotSame(calculator, calculator1);
	}
}
