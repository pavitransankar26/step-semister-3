final class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(
            String bookingId,
            String[] seatNumbers) {

        this.bookingId = bookingId;

        this.seatNumbers =
            new String[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            this.seatNumbers[i] = seatNumbers[i];
        }
    }

    public String[] getSeatNumbers() {

        String[] copy =
            new String[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            copy[i] = seatNumbers[i];
        }

        return copy;
    }

    public BookingReceipt withUpdatedSeat(
            int index,
            String newSeat) {

        String[] updatedSeats =
            getSeatNumbers();

        if (index >= 0 &&
            index < updatedSeats.length) {

            updatedSeats[index] = newSeat;
        }

        return new BookingReceipt(
            bookingId,
            updatedSeats
        );
    }
}
