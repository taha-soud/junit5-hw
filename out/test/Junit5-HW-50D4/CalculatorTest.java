package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
public class CalculatorTest {

	Calculator calc;

	@BeforeEach
	void setUp() {
		calc = new Calculator();
	}

	@Test
	@DisplayName("Test addition of positive numbers")
	void testAddValid() {
		int result = calc.add(2, 3, 5);
		assertEquals(10, result);
	}

	@Test
	@DisplayName("Test addition with no arguments")
	void testAddEmpty() {
		assertEquals(0, calc.add());
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 5})
	@DisplayName("Test factorial of valid numbers")
	void testFactorialValid(int n) {
		assertTrue(calc.factorial(n) >= 1);
	}

	@Test
	@DisplayName("Test factorial with negative input throws exception")
	void testFactorialNegative() {
		assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3));
	}

	@Test
	@DisplayName("Test division with valid inputs")
	void testDivideValid() {
		assertEquals(5, calc.divide(10, 2));
	}

	@Test
	@DisplayName("Test division by zero throws exception")
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
	}

	@Test
	@DisplayName("Test addition with timeout")
	@Timeout(1)
	void testAddWithTimeout() {
		assertEquals(15, calc.add(5, 5, 5));
	}

	@Test
	@DisplayName("Test factorial with multiple assertions")
	void testFactorialMultipleAssertions() {
		int result = calc.factorial(4);
		assertAll(
				() -> assertEquals(24, result),
				() -> assertTrue(result > 0),
				() -> assertNotNull(result)
		);
	}
}
