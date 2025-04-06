package main.najah.test;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Tests")
public class UserServiceTest {

	UserService service;

	@BeforeEach
	void setUp() {
		service = new UserService();
	}

	@Test
	@DisplayName("Valid email should pass")
	void testValidEmail() {
		assertTrue(service.isValidEmail("user@example.com"));
	}

	@Test
	@DisplayName("Invalid email (missing @) should fail")
	void testInvalidEmailMissingAt() {
		assertFalse(service.isValidEmail("userexample.com"));
	}

	@Test
	@DisplayName("Invalid email (null) should fail")
	void testInvalidEmailNull() {
		assertFalse(service.isValidEmail(null));
	}

	@ParameterizedTest
	@ValueSource(strings = {"user@mail.com", "hello@world.org", "test123@site.net"})
	@DisplayName("Multiple valid emails (parameterized)")
	void testMultipleValidEmails(String email) {
		assertTrue(service.isValidEmail(email));
	}

	@Test
	@DisplayName("Successful authentication")
	void testValidAuthentication() {
		assertTrue(service.authenticate("admin", "1234"));
	}

	@Test
	@DisplayName("Failed authentication with wrong password")
	void testInvalidAuthentication() {
		assertFalse(service.authenticate("admin", "wrongpass"));
	}

	@Test
	@DisplayName("Authentication with timeout")
	@Timeout(1)
	void testAuthenticationTimeout() {
		assertTrue(service.authenticate("admin", "1234"));
	}

	@Test
	@DisplayName("Multiple assertions for isValidEmail")
	void testEmailMultipleAssertions() {
		assertAll(
				() -> assertFalse(service.isValidEmail("plainaddress")),
				() -> assertFalse(service.isValidEmail("user.com")),
				() -> assertTrue(service.isValidEmail("name@domain.com"))
		);
	}
}
