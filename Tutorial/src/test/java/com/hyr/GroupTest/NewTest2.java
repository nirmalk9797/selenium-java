package com.hyr.GroupTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
public class NewTest2 {

	@Test(groups = {"windows.smoke"})
	public void test4() {
		System.out.println("Inside test4");
	}

	@Test(groups = {"sanity"})
	public void test5() {
		System.out.println("Inside test5");
	}

	@Test(groups = {"functional","sanity"})
	public void test6() {
		System.out.println("Inside test6");
	}
	
	@Test(groups = {"regression","ios.functional"})
	public void test7() {
		System.out.println("Inside test7");
	}
}
