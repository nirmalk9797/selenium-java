package dependencyTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
	static String trackingNum = null;

	@Ignore
	@Test()
	public void CreateShipment() {
		System.out.println("CreateShipment");
		trackingNum = "ABC123Track";
	}

	@Test(dependsOnMethods = {"CreateShipment"},ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception {

		if (trackingNum != null) {
			System.out.println("TrackShipment");

		}
		else 
			throw new Exception("invalid tracking number");
	}

	@Test(dependsOnMethods = {"CreateShipment","TrackShipment"})
	public void CancelShipment() throws Exception {
		if (trackingNum != null) {
			System.out.println("CancelShipment");
		}
		else 
			throw new Exception("invalid tracking number");
	}

}



