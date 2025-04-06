package main.najah.test;

import main.najah.code.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Tests")
public class ProductTest {

	Product product;

	@BeforeAll
	static void initAll() {
		System.out.println("🔧 [ProductTest] Global setup started...");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("✅ [ProductTest] Global teardown completed.");
	}

	@BeforeEach
	void setUp() {
		System.out.println("🔁 [ProductTest] Setting up before each test...");
		product = new Product("Coffee", 100.0);
	}

	@AfterEach
	void tearDown() {
		System.out.println("🧹 [ProductTest] Cleaning up after each test...");
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
	@Test
	@Disabled("❌ Fails because it expects the wrong final price. Fix by changing expected value from 70.0 to 80.0.")
	@DisplayName("Intentionally failing test - disabled")
	void testIncorrectDiscountExpectation() {
		product.applyDiscount(20);
		// Intentionally wrong: expecting 70.0 instead of 80.0
		assertEquals(70.0, product.getFinalPrice(), 0.001);
	}

}
