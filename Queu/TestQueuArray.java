package Queu;

import java.util.Scanner;

public class TestQueuArray {
    public static void main(String[] args) {
        int item;
        char selection;

        QueuArray queu;
        queu = new QueuArray();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println();
            System.out.println("Please enter E for Enqueu, " +
            "D for Dequeu, or S for Stop: ");

            selection = scanner.next().charAt(0);
            while(selection !='S' && selection != 's') {
                if(selection == 'E' || selection == 'e') {
                    System.out.print("Please enter an integer to be enqued");
                    item = scanner.nextInt();
                    queu.enqueu(item);
                }
                else {
                    if (selection == 'D' || selection == 'd') {
                        item = queu.dequeu();
                        System.out.println("The item dequed is: "+ item);
                    }
                    else {
                        System.out.println("The selection entered is not E, D or S, please try again");
                    }
                }
                System.out.println();
                System.out.println("Please enter E for Enqueu, " +
                "D for Dequeu, or S for Stop: ");

                selection = scanner.next().charAt(0);
            }
        }

        System.out.println();
        System.out.println("End of Program");
        System.out.println();
    }
}
