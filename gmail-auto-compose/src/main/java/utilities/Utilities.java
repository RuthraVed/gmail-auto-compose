package utilities;

import java.io.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {


	public static void takeScreenShot(WebDriver driver,String fileName) {
		String outputPath = System.getProperty("user.dir");
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(scrFile, new File(outputPath+"\\test-output\\screen-shots\\"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
