package BST;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);


        bst2 t = new bst2();

        t.inserisci(5);

        t.inserisci(3);

        t.inserisci(4);

        t.inserisci(4);        

        t.inserisci(6);

        t.inserisci(7);

        t.stampa(t.getRoot());


        System.out.println("\nScegli un valore di cui trovare il successore: ");
        int val = scan.nextInt();

       System.out.println("Il successore è: " + t.successore(val).getKey());
        

       t.delete(10);
       t.stampa(t.getRoot());

       System.out.println("Il minimo è: "+t.min(t.getRoot()).getKey());
       System.out.println("Il massimo è: "+t.max(t.getRoot()).getKey());
    }
    
}
