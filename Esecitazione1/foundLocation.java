

import java.util.ArrayList;
import java.util.Scanner;

public class foundLocation {

    private ArrayList<Integer> parents;
    private int dim;
    private Scanner scan;


    public foundLocation(){
        parents= new ArrayList<Integer>();
        dim = 0;
        scan = new Scanner(System.in);

        inizializzaLocantion();
    }


    public void inizializzaLocantion(){

        System.out.println("Quanti parenti hai?");
        dim= scan.nextInt();

        for(int i=0; i<dim; i++){
            System.out.println("inserisici civico: ");
            parents.add(scan.nextInt());
        }

        parents.sort(null);

        stampaCivici();


    }


    public void stampaCivici(){
        for(int i=0; i<dim; i++){
            System.out.printf("%d\t", parents.get(i));
        }
    }



    public int minDist(){


        int m = (parents.size())/2;
        int somma =0;
        for(int i=0; i<dim; i++){
            somma+=Math.abs(parents.get(m)-parents.get(i));
        }

        System.out.println("Il civico è: " + parents.get(m));
        
        return somma;

    }
    

    



    



}
