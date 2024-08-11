package hotel_reservation;

import java.util.Scanner;

public class HotelReservationSystem {
    private Hotel hotel;

    public HotelReservationSystem() {
        this.hotel = new Hotel("Grand Hotel", 6);
        initializeHotel();
    }

    private void initializeHotel() {
        hotel.addRoom(1, "Single", 100.0);
        hotel.addRoom(2, "Double", 200.0);
        hotel.addRoom(3, "Suite", 300.0);
        hotel.addRoom(4, "Single", 100.0);
        hotel.addRoom(5, "Double", 200.0);
        hotel.addRoom(6, "Suite", 300.0);
    }

    public void startSystem() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Booking");
            System.out.println("3. View Bookings");
            System.out.println("4. Process Payment");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchRooms(scanner);
                    break;
                case 2:
                    makeBooking(scanner);
                    break;
                case 3:
                    hotel.viewBookings();
                    break;
                case 4:
                    processPayment(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void searchRooms(Scanner scanner) {
        System.out.println("Enter room category:");
        String category = scanner.nextLine();
        hotel.searchRooms(category);
    }

    private void makeBooking(Scanner scanner) {
        System.out.println("Enter room number:");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter guest name:");
        String guestName = scanner.nextLine();
        System.out.println("Enter check-in date:");
        String checkInDate = scanner.nextLine();
        System.out.println("Enter check-out date:");
        String checkOutDate = scanner.nextLine();

        if (hotel.bookRoom(roomNumber, guestName, checkInDate, checkOutDate)) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Room not available.");
        }
    }

    private void processPayment(Scanner scanner) {
        System.out.println("Enter booking ID:");
        int bookingId = scanner.nextInt();
        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();

        hotel.processPayment(bookingId, amount);
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.startSystem();
    }
}
