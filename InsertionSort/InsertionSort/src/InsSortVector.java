
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InsSortVector {

    private Integer [] vector;
    private Scanner scan;
    private int dim;

    public InsSortVector(){
        dim=0;
        scan = new Scanner(System.in);
        initializeVect();
        
        
    }

    public void initializeVect(){
        System.out.println("Introduci la dimensione del vettore:");
        try{
        dim = scan.nextInt();
        vector = new Integer[dim];
        System.out.println("Dimensione impostata!");
        } catch(InputMismatchException e){
            System.err.println("Errore, inserisci un intero.");
        }
    }


    public void randomElements(){
        assert dim !=0 : "La dimensione non puo' essere nulla, inizializza il vettore!";
        Random rand = new Random();

        for(int i =0; i<dim; i++){
            vector[i] = rand.nextInt(10);
        }

        System.out.println("Il vettore inizializzato e': ");

        
        for(int k =0; k<dim; k++){

            System.out.printf(vector[k] + " ");
        }
    }

    public void InsertionSort(){
        assert dim !=0 : "La dimensione non puo' essere nulla, inizializza il vettore!";
        int i =0; //variabile i posta a 0 per sicurezza
        
        for(int j=1; j<dim; j++){ //dal primo valore fino alla dimensione
            int valore = vector[j]; //prendo il primo valore

            i = j-1; //do a i la posizione precedente

            while (i>=0 && vector[i]>valore){ //se i = 0 in poi, se il valore in i, quello prima, e piu grande di quello dopo
                vector[i+1] = vector[i]; //si scambiano 
                i=i-1;
            }

            vector[i+1] = valore;
        }

        System.out.println("");
        for(int k =0; k<dim; k++){
            
            System.out.printf(vector[k] + " ");
        }

    }

    
}
