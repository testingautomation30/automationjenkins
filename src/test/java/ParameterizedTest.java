import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
	
	/* @Parameters({"username","password"})
	@BeforeSuite
	public void ddd(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		
		
		System.out.println("Test one Methos");
	}*/
	
    @Parameters({"username","password"})
	@Test
	public void testOne(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		Assert.assertTrue(username.equals("username@gmail.com"), " user name is not displayed");
		System.out.println("Test one Methos");
	}

}
