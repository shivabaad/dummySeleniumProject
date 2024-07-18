package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	private Integer count = 0;
	static Integer maxRetry = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & (count++ < maxRetry)) {
			return true;
		}
		return false;
	}

}