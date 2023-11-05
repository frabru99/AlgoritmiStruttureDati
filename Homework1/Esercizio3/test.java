package Esercizio3;

import java.util.Scanner;

public class test {
    

    public static void main(String[] args) {
        System.out.println("Quanti elementi vuoi inserire?");

        Scanner scan = new Scanner(System.in);


        int dim = scan.nextInt();
        Treap t = new Treap(dim);
        node root = null;

        for(int i=0; i<dim; i++){
            System.out.println("inserisci un valore di chiave: ");
            root = t.treapInsert(scan.nextInt(), root);
        }

        t.stampaTreap(root);
        scan.close();
    }
}
