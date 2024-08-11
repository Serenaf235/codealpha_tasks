package hotel_reservation;

import java.util.ArrayList;
import java.util.List;

class Hotel {
    private String name;
    private Room[] rooms;
    private List<Booking> bookings;

    public Hotel(String name, int totalRooms) {
        this.name = name;
        this.rooms = new Room[totalRooms];
        this.bookings = new ArrayList<>();
    }

    public void addRoom(int roomNumber, String category, double price) {
        Room room = new Room(roomNumber, category, price);
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = room;
                return;
            }
        }
    }

    public boolean bookRoom(int roomNumber, String guestName, String checkInDate, String checkOutDate) {
        for (Room room : rooms) {
            if (room != null && room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                room.setGuestName(guestName);
                Booking booking = new Booking(bookings.size() + 1, room, guestName, checkInDate, checkOutDate);
                bookings.add(booking);
                return true;
            }
        }
        return false;
    }

    public void checkOut(int roomNumber) {
        for (Room room : rooms) {
            if (room != null && room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                room.setAvailable(true);
                room.setGuestName(null);
                break;
            }
        }
    }

    public int getAvailableRoomsCount() {
        int count = 0;
        for (Room room : rooms) {
            if (room != null && room.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public int getBookedRoomsCount() {
        return bookings.size();
    }

    public void viewBookings() {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId() +
                    ", Room Number: " + booking.getRoom().getRoomNumber() +
                    ", Guest Name: " + booking.getGuestName() +
                    ", Check-in Date: " + booking.getCheckInDate() +
                    ", Check-out Date: " + booking.getCheckOutDate() +
                    ", Total Cost: $" + booking.getTotalCost());
        }
    }

    public void processPayment(int bookingId, double amount) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                if (amount >= booking.getTotalCost()) {
                    System.out.println("Payment processed successfully for Booking ID: " + bookingId);
                } else {
                    System.out.println("Insufficient payment. Amount due: $" + (booking.getTotalCost() - amount));
                }
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

    public void searchRooms(String category) {
        boolean found = false;
        for (Room room : rooms) {
            if (room != null && room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println("Available Room: " + room.getRoomNumber() + ", Price: $" + room.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms found for category: " + category);
        }
    }

    public String getName() {
        return name;
    }
}

