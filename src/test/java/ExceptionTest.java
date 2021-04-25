import org.testng.annotations.Test;

public class ExceptionTest {

	
	@Test(expectedExceptions = ArithmeticException.class)
	public void testOne() {
		int i=1/0;
		System.out.println("Test one Methos");
	}
	
	@Test()
	public void testTwo() {
		int i=1/0;
		System.out.println("Test one Methos");
	}
}
