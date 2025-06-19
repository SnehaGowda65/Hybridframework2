package com.listeners.demoblazeweb;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.genericlib.demoblazeweb.Base;

public class EventList implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ss =(TakesScreenshot)Base.driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File dest = new File("Screenshots/"+time+".png");
		String path = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Base.test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	public void onTestStart(ITestResult result) {
		Base.test=Base.extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		Base.test.pass("Test Passed");
	}

	public void onTestSkipped(ITestResult result) {
		Base.test.fail("Test failed");
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		Base.extent.flush();
	}

	
}
