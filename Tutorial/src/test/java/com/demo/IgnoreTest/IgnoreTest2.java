package com.demo.IgnoreTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest2 {

	@Test
	public void test4() {
		System.out.println("Inside test4");
	}
	
	@Test
	public void test5() {
		System.out.println("Inside test5");

	}
	
	@Test
	@Ignore
	public void test6() {
		System.out.println("Inside test6");

	}
}
