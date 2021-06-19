package unitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before all test in the class");
	}

	@Before
	public void before() {
		System.out.println("Before each test method");
	}

	@Test
	public void testOne() {
		System.out.println("Test1");
	}

	@Test
	public void testTwo() {
		System.out.println("Test2");
	}

	@Test
	public void testThree() {
		System.out.println("Test3");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After all tests in class");
	}

	@After
	public void after() {
		System.out.println("After each test method");
	}

}
