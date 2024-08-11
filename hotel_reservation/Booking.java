package hotel_reservation;

class Booking {
    private int bookingId;
    private Room room;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    private double totalCost;

    public Booking(int bookingId, Room room, String guestName, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost() {
        
        return room.getPrice();
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalCost() {
        return totalCost;
    }
}

