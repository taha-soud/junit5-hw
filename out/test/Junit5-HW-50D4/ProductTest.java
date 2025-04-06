package main.najah.test;

import main.najah.code.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Tests")
public class ProductTest {

	Product product;

	@BeforeEach
	void setUp() {
		product = new Product("Coffee", 100.0);
	}

	@Test
	@DisplayName("Test valid discount application")
	void testValidDiscount() {
		product.applyDiscount(20);
		assertEquals(80.0, product.getFinalPrice(), 0.001);
	}

	@Test
	@DisplayName("Test invalid negative price throws exception")
	void testNegativePrice() {
		assertThrows(IllegalArgumentException.class, () -> new Product("Item", -10));
	}

	@Test
	@DisplayName("Test invalid discount over 50% throws exception")
	void testInvalidDiscountAboveLimit() {
		assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(60));
	}

	@ParameterizedTest
	@ValueSource(doubles = {0, 10, 50})
	@DisplayName("Test valid discount range with parameterized test")
	void testDiscountRange(double discount) {
		product.applyDiscount(discount);
		double expected = 100.0 * (1 - discount / 100);
		assertEquals(expected, product.getFinalPrice(), 0.001);
	}

	@Test
	@DisplayName("Test multiple assertions on product properties")
	void testProductProperties() {
		assertAll(
				() -> assertEquals("Coffee", product.getName()),
				() -> assertEquals(100.0, product.getPrice(), 0.001),
				() -> assertEquals(0.0, product.getDiscount(), 0.001)
		);
	}

	@Test
	@DisplayName("Test discount application performance")
	@Timeout(1)
	void testApplyDiscountTimeout() {
		product.applyDiscount(10);
		assertEquals(90.0, product.getFinalPrice(), 0.001);
	}
}
