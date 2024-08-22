package tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.redBusBookingPage;

public class redBusBookingTest {

    redBusBookingPage redBus = new redBusBookingPage();

    @BeforeSuite
    public void launchUrl() throws IOException {
        System.out.println("Before Suite method");
        Reporter.log("Chrome Browser Initiated");
        redBus.openChromeBrowser();
    }

    @Test
    public void redBusBookingTestCases() throws InterruptedException {
        //TC-01 : Provide Location and Date
        Reporter.log("TestCase-01 Initiated, Description : Provide Location and Date");
        redBus.provideLocationAndDate();

        //TC-02 : Click on Search and navigates to Bus Selection Page
        Reporter.log("TestCase-02 Initiated, Description : Select Bus as per preference");
        redBus.selectBus();

        //TC-03 : Select On-board and Drop locations
        Reporter.log("TestCase-03 Initiated, Description : Select locations and click on view seats");
        redBus.selectDetailsToViewSeats();

        //TC-04 : Choose seat and proceed to booking
        Reporter.log("TestCase-04 Initiated, Description : Select seat to proceed booking");
        redBus.selectSeatAndProceed();

        //TC-05 : Provide Passenger Details and Proceed to Pay
        Reporter.log("TestCase-05 Initiated, Description : Provide Passenger details and proceed to pay");
        redBus.PassengerDetailsAndProceedToPay();

        redBus.endBrowser();
    }
}