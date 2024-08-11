package hotel_reservation;

public class HotelTest {
    public static void main(String[] args) {
        // Create a new hotel with 5 rooms
        Hotel hotel = new Hotel("Grand Hotel", 5);

        // Add rooms to the hotel
        hotel.addRoom(101, "Single", 100.0);
        hotel.addRoom(102, "Double", 150.0);
        hotel.addRoom(103, "Suite", 250.0);
        hotel.addRoom(104, "Single", 100.0);
        hotel.addRoom(105, "Double", 150.0);

        // Test booking rooms
        System.out.println("Booking Room 101 for John Doe:");
        if (hotel.bookRoom(101, "John Doe", "2024-08-11", "2024-08-15")) {
            System.out.println("Room 101 booked successfully.");
        } else {
            System.out.println("Failed to book Room 101.");
        }

        System.out.println("Booking Room 103 for Jane Doe:");
        if (hotel.bookRoom(103, "Jane Doe", "2024-08-12", "2024-08-16")) {
            System.out.println("Room 103 booked successfully.");
        } else {
            System.out.println("Failed to book Room 103.");
        }

        // Try to book an already booked room
        System.out.println("Attempting to book Room 101 again:");
        if (hotel.bookRoom(101, "Alice Smith", "2024-08-13", "2024-08-17")) {
            System.out.println("Room 101 booked successfully.");
        } else {
            System.out.println("Room 101 is already booked.");
        }

        // Test checking out
        System.out.println("Checking out Room 101:");
        hotel.checkOut(101);

        System.out.println("Attempting to book Room 101 after checkout:");
        if (hotel.bookRoom(101, "Alice Smith", "2024-08-13", "2024-08-17")) {
            System.out.println("Room 101 booked successfully.");
        } else {
            System.out.println("Failed to book Room 101.");
        }

        // Test room availability
        System.out.println("Available rooms: " + hotel.getAvailableRoomsCount());
        System.out.println("Booked rooms: " + hotel.getBookedRoomsCount());

        // View all bookings
        System.out.println("\nCurrent Bookings:");
        hotel.viewBookings();

        // Test processing payment
        System.out.println("\nProcessing payment for Booking ID 1:");
        hotel.processPayment(1, 400.0); // Test with sufficient payment
        hotel.processPayment(1, 90.0);  // Test with insufficient payment
    }
}

