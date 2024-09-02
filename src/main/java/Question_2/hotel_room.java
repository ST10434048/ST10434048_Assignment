package Question_2;

public abstract class hotel_room extends bed {
   protected int room_ID;
   protected int sleepers;
   protected boolean available;
   protected boolean breakfast;
   protected boolean miniBar;

    protected void setRoom_ID(int room_ID) {
        this.room_ID = room_ID;
    }

   protected int getRoom_ID() {
        return room_ID;
    }

   protected void setSleepers(int sleepers) {
        this.sleepers = sleepers;
    }

   protected int getSleepers() {
        return sleepers;
    }

   protected void setAvailable(boolean available) {
        this.available = available;
    }

   protected boolean getAvailable() {
        return available;
    }

   protected void setBreakfast(String choice) {
        this.breakfast = choice.equals("yes");
    }

   protected boolean getBreakfast() {
        return breakfast;
    }

   protected void setMiniBar(String choice) {
        this.miniBar = choice.equals("yes");
    }

   protected boolean getMiniBar() {
        return miniBar;
    }

    protected abstract int price(int sleepers, booking booking);
}
