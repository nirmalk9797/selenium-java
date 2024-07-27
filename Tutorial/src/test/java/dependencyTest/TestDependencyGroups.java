package dependencyTest;

import org.testng.annotations.Test;

public class TestDependencyGroups {

	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("sanity");
	}
	
	@Test(groups = {"sanity"})
	public void test2() {
		System.out.println("sanity");
	}
	
	@Test(groups = {"smoke"})
	public void test3() {
		System.out.println("smoke");
	}
	
	@Test(groups = {"smoke"})
	public void test4() {
		System.out.println("smoke");
	}
		
	@Test(groups = {"regression"})
	public void test5() {
		System.out.println("regression");
	}
	
		@Test(groups = {"regression"})
	public void test6() {
		System.out.println("regression");
	}
	
	@Test(dependsOnGroups = {"smoke","sanity"})
	public void main() {
		System.out.println("main test");
	}
}
