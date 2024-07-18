package base;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	protected static final Logger logger = LogManager.getLogger(Utils.class);
	
	public static String getScreenshot(String methodName, WebDriver driver) {
		
		File from = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + getDateTime() + "-" + methodName + ".png";
		System.out.println(path);
		File to = new File(path);
		
		try {
			FileUtils.copyFile(from, to);
			logger.error("Failed screenshot stored at: " + to);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	private static String getDateTime() {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return date.format(timestamp);
	}

}
