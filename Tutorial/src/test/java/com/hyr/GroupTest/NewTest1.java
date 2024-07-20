package com.hyr.GroupTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class NewTest1 {

	@Test(groups = {"sanity","windows.functional"})
	public void test1() {
		System.out.println("Inside test1");
	}
	
	@Test(groups = {"sanity","functional","ios.functional"})
	public void test2() {
		System.out.println("Inside test2");
	}
	
	@Test(groups = {"functional","regression"})
	public void test3() {
		System.out.println("Inside test3");
	}
}
