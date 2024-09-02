package Question_2;

import java.util.Scanner;

public class reservation_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        booking_manager bm = new booking_manager();
        bm.menu();
    }
}
