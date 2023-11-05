package Problem3n;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);
        

        System.out.println("Dimmi due interi e io calcolerò la massima catena:");
        System.out.println("intero 1:");
        int n1 = scan.nextInt();
        System.out.println("intero 2:");
        int n2 = scan.nextInt();

        problem p = new problem();

        System.out.println("Il massimo è: " + p.function(n1, n2));
        scan.close();
        
    }
    
}
