package org.example;

public class Main {
    public static void main(String[] args) {
        BookMyFlight bookMyFlight = new BookMyFlight();

        bookMyFlight.myLocation("Trabzon");
        bookMyFlight.bookTicket();
        bookMyFlight.chooseSourceLocation();
        bookMyFlight.verifyDestinationLocation("Ankara");
        bookMyFlight.chooseDestinationLocation();
        bookMyFlight.confirmDestinationLocation();
    }
}