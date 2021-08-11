import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Buyer b1; // mahirah - buyer
	private Buyer b2; // mahirah - buyer

	private ArrayList<Buyer> buyerList; // mahirah - buyer

	@Before
	public void setUp() throws Exception {
		// buyer
		b1 = new Buyer("Mahirah", "90105231", "mahirahS@gmail.com", "64521, #02-1078");
		b2 = new Buyer("Melissa", "80015002", "MelissaT@hotmail.com", "760030, #09-103");
		
		buyerList= new ArrayList<Buyer>();
	}

	@After
	public void tearDown() throws Exception {
		b1 = null; // mahirah - buyer
		b2 = null; // mahirah - buyer
		buyerList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	// mahirah - buyer
	@Test
	public void testretrieveBuyer() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Buyer arraylist to add to", buyerList);
		
		
		// test if the list item retrieved from the SourceCentre is empty - boundary
		String allBuyer= C206_CaseStudy.retrieveAllBuyer(buyerList);
		String testOutput = "";
		assertEquals("Check that ViewBuyerAcctList", testOutput, allBuyer);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addBuyer(buyerList, b1);
		C206_CaseStudy.addBuyer(buyerList, b2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, buyerList.size());
	
		//test if the expected output string same as the list of buyer retrieved from the SourceCentre
		allBuyer = C206_CaseStudy.retrieveAllBuyer(buyerList);
		
		testOutput = String.format("%-20s %-10s %-10s %-30s\n","Mahirah", "90105231", "mahirahS@gmail.com", "64521, #02-1078" );
		testOutput += String.format("%-20s %-10s %-10s %-30s\n","Melissa", "80015002", "MelissaT@hotmail.com", "760030, #09-103" );

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allBuyer);
	}
	
	// mahirah - buyer
	@Test
	public void testAddBuyer() {
		assertNotNull("Test if there is valid buyer arraylist to add to", buyerList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBuyer(buyerList, b1);
		assertEquals("Test if that Buyer arraylist size is 1?", 1, buyerList.size());
			
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addBuyer(buyerList, b2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, buyerList.size());

	}
	//jun jie 
	@Test
	public void testDeleteBuyer() {
		//boundary
		assertNotNull("Test if there is valid buyer arraylist to delete to", buyerList);
		
		// Given a list with 2 items, after deleting 2 items, test if the list is empty
		buyerList.clear();
		C206_CaseStudy.addBuyer(buyerList, b1);
		C206_CaseStudy.addBuyer(buyerList, b2);
		buyerList.clear();
		assertEquals("Test that Buyer arrayList is empty", 0, buyerList.size());
		
		//test that list Buyer can't be cleared if it's empty
		assertEquals("Test that Buyer arraylist can't be cleared if it is empty", 0 , buyerList.size());
		buyerList.clear();
	}
    /*
    Add new appointment - OK
 */
	//jun jie
@Test
public void testAddNewAppointment() {
    // initialize test data
    ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    buyerList.add(new Buyer("junjie", "90105231", "junjie@gmail.com", "64521, #02-1078"));
    buyerList.add(new Buyer("george", "80015002", "george@hotmail.com", "760030, #09-103"));

    Assert.assertEquals(0, appointmentList.size());

    C206_CaseStudy.addAppointment(appointmentList, buyerList, "90105231", "2021-08-10", "10:30");
    C206_CaseStudy.addAppointment(appointmentList, buyerList, "80015002", "2021-10-10", "10:30");

    Assert.assertEquals(2, appointmentList.size());
}

/*
    Add new appointment when buyer not exists- OK
 */
//jun jie
@Test
public void testFailToAddAppointment() {
    // initialize test data
    ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    Assert.assertTrue(appointmentList.size() == 0);
    C206_CaseStudy.addAppointment(appointmentList, buyerList, "90105231", "2021-08-10", "10:30");
    C206_CaseStudy.addAppointment(appointmentList, buyerList, "80015002", "2021-10-10", "10:30");
    Assert.assertEquals(0, appointmentList.size());
}

/*
    Delete existing appointment - OK
 */
//jun jie
@Test
public void testDeleteExistingAppointment() {
    // initialize test data
    Buyer buyer1 = new Buyer("jun jie", "90105231", "junjie@gmail.com", "64521, #02-1078");
    Buyer buyer2 = new Buyer("george", "80015002", "george@hotmail.com", "760030, #09-103");
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    appointmentList.add(new Appointment(buyer1, "2021-07-31", "11:15"));
    appointmentList.add(new Appointment(buyer2, "2021-07-29", "09:15"));
    Assert.assertEquals(2, appointmentList.size());
    C206_CaseStudy.cancelAppointment(appointmentList, "80015002", "2021-07-29", "09:15");
    Assert.assertEquals(1, appointmentList.size());
}

/*
    Delete non-existing appointment - OK
 */
// jun jie 
@Test
public void testDeleteNonExistingAppointment() {
    // initialize test data
    Buyer buyer1 = new Buyer("jun jie", "90105231", "junjie@gmail.com", "64521, #02-1078");
    Buyer buyer2 = new Buyer("george", "80015002", "george@hotmail.com", "760030, #09-103");
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    appointmentList.add(new Appointment(buyer1, "2021-07-31", "11:15"));
    appointmentList.add(new Appointment(buyer2, "2021-07-29", "09:15"));
    Assert.assertEquals(2, appointmentList.size());
    C206_CaseStudy.cancelAppointment(appointmentList, "80015002", "2021-07-30", "09:15");
    Assert.assertEquals(2, appointmentList.size());
    C206_CaseStudy.cancelAppointment(appointmentList, "80015002", "2021-07-28", "09:15");
    Assert.assertEquals(2, appointmentList.size());
}

}
