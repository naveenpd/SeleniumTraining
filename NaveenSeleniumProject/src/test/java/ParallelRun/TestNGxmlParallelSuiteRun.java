package ParallelRun;

import java.util.Arrays;

import org.testng.TestNG;

public class TestNGxmlParallelSuiteRun {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		testng.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//testng1.xml"}));
		testng.setSuiteThreadPoolSize(2);
		testng.run();
	}
	
}
