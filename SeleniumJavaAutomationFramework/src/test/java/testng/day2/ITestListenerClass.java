package testng.day2;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestName());
		captureScreenshots(result.getMethod().getMethodName() + ".jpeg");
		}

}
