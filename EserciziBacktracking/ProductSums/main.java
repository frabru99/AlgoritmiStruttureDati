package EserciziBacktracking.ProductSums;

import java.util.ArrayList;

public class main {
    


    public static void main(String[] args) {
        

        int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //ingresso di 10 interi

        int [] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int n = 300; //per trovare il prodotto che fa 300

        products p = new products(); //nuovo elemento


        boolean val = p.backtrack(vet, numbers, 0, n, new ArrayList<Integer>()); //funzione di backtrack

        
        if(!val){
            System.out.println("Non ci sono soluzioni!");
        }

    }
}
