package Question_2;

import java.util.Scanner;

public class booking_manager extends booking{
    Scanner sc = new Scanner(System.in);
    protected void menu(){
        System.out.println("Welcome to the Reservation System");
        System.out.println("---------------------------------");
        System.out.println("Please enter your choice");
        System.out.println("----------------------------------");

        menuOptions();

        int choice = sc.nextInt() ;
        switch(choice){
            case 1:
                addBooking();
                menu();
            case 2:
                System.out.println("Enter an id to search");
                searchBooking(sc.nextInt());
                menu();
            case 3:
                viewBookings();
                menu();
            case 4:
                System.exit(12);
        }
        sc.close();

    }

    private void viewBookings() {
        if (bookings.isEmpty()){
            System.out.println("No bookings found in the system, please add a booking first");
        }
        for(booking booking : bookings){
            if(!bookings.isEmpty()){
                display(booking);
            }else{
                System.out.println("No bookings found");
            }
        }

    }


    private boolean available(int id){
        for(booking booking : bookings){
            if (id == booking.room_ID){
                return false;
            }
        }
        return true;
    }

    //display function created for convenience
    private void display(booking booking){
        boolean available = booking.getAvailable();
     if(!available){
         System.out.println("\nRoom is occupied");
     }else {
         System.out.println("Room is not occupied");
     }
        System.out.println("Reference number: "+ booking.getRef());
        System.out.println("Room Number: "+booking.getRoom_ID());
     switch(booking.getBedType()){
         case 1:
             System.out.println("Room type: King bedroom");
             break;
         case 2:
             System.out.println("Room type: Queen bedroom");
             break;
         case 3:
             System.out.println("Room type: Twin bedroom");
             break;
         case 4:
             System.out.println("Room type: Single bedroom");
             break;
     }
        System.out.println("Number of Guests: "+booking.getSleepers());
        System.out.println("Breakfast included: "+booking.getBreakfast());
        System.out.println("Mini Bar included: "+booking.getMiniBar());
        System.out.println("Price per night: "+booking.getPrice());

        System.out.println();

    }
    // searches for bookings using the room number as a perimeter
    private void searchBooking(int id) {
        if(bookings.isEmpty()){
            System.out.println("No bookings found in the system, please add a booking first");
        }
        for(booking booking : bookings){
            if(booking.getRoom_ID()==id){
                System.out.println("\nSearch results for "+id+": ");
                System.out.println("----------------------------");
                display(booking);
                System.out.println("Please enter 1 to continue, or press any number to exit");
                if(sc.nextInt()!=1){
                    System.exit(13);
                }
        }else if(booking.getRoom_ID()!=id){
                System.out.println("No bookings found for "+ id);
                System.out.println("Add a booking for "+id+", or try searching again");
            }
        }
    }

    //function for adding bookings into the system, contains checks for availability and updates pricing.
    private void addBooking() {
        System.out.println("Enter the booking ID");
        int id = sc.nextInt();
        if(available(id)){
            booking obj = new booking();
            bookings.add(obj);
            obj.setRoom_ID(id);

            System.out.println("Enter the amount of guests ");
            int sleepers = sc.nextInt();
            obj.setSleepers(sleepers);

            System.out.println("Is breakfast included? Enter 'yes' or 'no' ");
            obj.setBreakfast(sc.next().toLowerCase());

            System.out.println("Is the mini bar included? Enter 'yes' or 'no' ");
            obj.setMiniBar(sc.next().toLowerCase());

            System.out.println("Enter the bed type required ");
            System.out.println("1. King\n2. Queen\n3. Twin\n4. Single");
            switch(sc.nextInt()){
                case 1:
                    obj.setBedType(1);
                    break;
                case 2:
                    obj.setBedType(2);
                    break;
                case 3:
                    obj.setBedType(3);
                    break;
                case 4:
                    obj.setBedType(4);
                    break;
                default:
                    System.out.println("That is not a valid option");
                    System.out.println("please start over");
                    addBooking();
                    break;
            }

            obj.setAvailable(false);

            obj.setPrice(price(sleepers, obj));

            obj.setRef(refGenerate());

        }else{
            System.out.println("That room is not available");
        }
    }

    private void menuOptions() {
        System.out.println("Menu Options:\n");
        System.out.println("(1) Add a new Booking");
        System.out.println("(2) Search for a booking");
        System.out.println("(3) View all Bookings");
        System.out.println("(4) Exit");
    }

}
