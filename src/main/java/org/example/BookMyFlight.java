package org.example;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import java.util.Scanner;

public class BookMyFlight extends Steps {

    private String sourceLocation;
    private String destinationLocation;

    private Scanner scanner;

    public BookMyFlight() {
        this.scanner = new Scanner(System.in);
    }

    @Given("I am in $location")
    public void myLocation(String location) {
        System.out.println("I am in " + location);
    }

    @Given("I want to Book a Flight Ticket")
    public void bookTicket() {
        System.out.println("Flight Ticket");
    }

    @When("When I choose my Source Location")
    public void chooseSourceLocation() {
        System.out.print("Enter your Source Location: ");
        this.sourceLocation = scanner.nextLine().trim();
        System.out.println("Source Location : " + sourceLocation);
    }

    @Then("My destination Location should not contain $location as an option")
    public void verifyDestinationLocation(String location) {
        if (location.equals("Istanbul")) {
            throw new AssertionError("Error: Destination cannot be the same as Source Location");
        } else {
            System.out.println("Destination Location verified");
        }
    }

    // New Scenario
    @When("When I choose my Destination Location")
    public void chooseDestinationLocation() {
        System.out.print("Enter your Destination Location: ");
        this.destinationLocation = scanner.nextLine().trim();
        System.out.println("Destination Location : " + destinationLocation);
    }

    @Then("I choose my Destination Location")
    public void confirmDestinationLocation() {
        if (destinationLocation.equals(sourceLocation)) {
            throw new AssertionError("Error: Destination cannot be the same as Source Location");
        } else {
            System.out.println("Destination Location confirmed as " + destinationLocation);
        }
    }
}
