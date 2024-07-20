package HYR.Tutorial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class P17DataProvider {

	@Test(dataProvider = "dp1")
	public void P17dataProviderTest1(String v1) throws Exception {
		System.out.println(v1);
	}

	@Test(dataProvider = "dp2")
	public void P17dataProviderTest2(String[] value) throws Exception {
		System.out.println(value[0] + " - " + value[1]); // Two dimensional
	}

	@Test(dataProvider = "dp3")
	public void P17dataProviderTest3(Object[] value) throws Exception {
		System.out.println("*********");

		for (int i = 0; i < value.length; i++) {
			System.out.println(value[i]);
		}
	}

	@Test(dataProvider = "dp4")
	public void P17dataProviderTest4(String s) throws Exception {
		System.out.println(s);
	}

	
	@Test(dataProvider = "dp5")
	public void P17dataProviderTest5(String[] s) throws Exception {
		System.out.println("*********");
//		System.out.println(s[0]+"-"+s[1]);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]); 
		}
	}
	
	
	@DataProvider()
	public Object[] dp1() {
//		Integer[] i1 = new Integer[] {456,89};
//		return i1;

		String[] s1 = new String[] { "4567", "dfghjhg", "7894" };
		return s1;
	}

	@DataProvider()
	public String[][] dp2() {
		String[][] obj2 = new String[][] { // Two dimensional
				{ "tyui", "tyui" }, { "gyhui", "7890" }, { "456", "7890" } };
		return obj2;
	}

	@DataProvider()
	public Object[] dp3() {
		Object[][] obj3 = new Object[][] { // Combination of data types
				{ "abc", "etc", 67890, "8987" }, { "gyhui", 7890, "78e8" }, { 456, 7890 }, { 898 } };
		return obj3;
	}

	@DataProvider()
	public Iterator<String> dp4() {
		List<String> data = new ArrayList<>();
		data.add("Nirmal");
		data.add("Krishnakumar");
		return data.iterator();
	}
	
	@DataProvider()
	public Iterator<String[]> dp5(){
		Set<String[]> data = new HashSet<>();
		data.add(new String[] {"Nirmal","K"});
		data.add(new String[] {"Arjun","KS"});
		return data.iterator();
	}
}
