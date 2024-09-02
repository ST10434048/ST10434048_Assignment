package Question_2;

import java.util.ArrayList;
import java.util.Random;

public class booking extends hotel_room{
    ArrayList<booking> bookings = new ArrayList<>();
    private int price;
    private String ref;

protected void setPrice(int price){
    this.price = price;
}

protected int getPrice(){
    return price;
}

    // generates a random reference number for the reservation
    // can be used for secure searching later implementation
    protected String refGenerate() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder ref = new StringBuilder();
        // using java random utility to generate a random selection of numbers and letters from CHARS
        Random rnd = new Random();

        while (ref.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            ref.append(CHARS.charAt(index));
        }
        return ref.toString();
    }

    protected void setRef(String ref){
    this.ref = ref;
    }

   protected String getRef(){
    return ref;
    }
    @Override
    protected int price(int sleepers, booking booking) {
        int price=0;
        switch (booking.getBedType()) {
            case 1 -> {
                price = (5000 * sleepers);
                return price;
            }
            case 2 -> {
                price = 800 * sleepers;
                return price;
            }
            case 3 -> {
                price = 400*sleepers;
                return price;
            }
            case 4 -> {
                price = 200 * sleepers;
                return price;
            }

        }

        return price;
    }
}
