package com.web.app;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseClass;



public class listeners implements ITestListener  {
	
      BaseClass b=new BaseClass();

	public void onFinish(ITestResult result) {
		
		
		try {
			b.getScreenshot(result.getName());
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	
		
	}

	public void onStart(ITestResult result) {
		
		
		try {
			
			b.getScreenshot(result.getName());
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}



	public void onTestFailure(ITestResult result) {


		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestStart(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
