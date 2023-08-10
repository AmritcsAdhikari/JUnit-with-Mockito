package com.app.amrit.basics01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * In JUnit 5, we can use @TestMethodOrder to control the execution order of tests.
 * 
 * We can use the @Order annotation to enforce tests to run in a specific order.
 * 
 * @BeforeEach is used to signal that the annotated method should be executed before each @Test method in the current test class.
 * 
 * @AfterEach is used to signal that the annotated method should be executed before after @Test method in the current test class.
 * 
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
	
	Calculator c;
	int a, b, actual, expectedMul, expectedAdd;
	
	
	@BeforeEach
	public void setUp() {
		c = new Calculator();
		a = 10;
		b = 20;
		expectedMul = 200;
		expectedAdd = 30;
	}
	
	
	@Test
	@Order(10)
	@DisplayName("TESTING NULL CHECK")
	public void testIsObjectCreated() {
		assertNotNull(c);
	}
	
	
	@Order(20)
	@Test
	@DisplayName("TESTING MULTIPLY OPERATION")
	public void testMultiply() {
		actual = c.multiply(a, b);
		assertEquals(expectedMul, actual);
	}
	
	@Test
	@Disabled
	@DisplayName("TESTING DISABLE A TEST METHOD")
	public void testdummy() {
		System.out.println("Dummy Test");
	}

	@Order(30)
	@Test
	@DisplayName("TESTING MULTIPLY OPERATION")
	public void testAddition() {
		actual = c.addition(a, b);
		assertEquals(expectedAdd, actual);
	}

	
	@AfterEach
	public void clean() {
		c = null;
	}
}
