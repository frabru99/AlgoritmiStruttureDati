package Esercizio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class entry{
     
    public static void main(String[] args) {


        
        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\Homework1\\Esercizio2\\test.txt");

        Scanner scan; 

    try {
            scan = new Scanner(f); //apro lo scanner sul file 
            


            while(scan.hasNextLine()){
            ArrayList<String> st = new ArrayList<String>();
            int dim = scan.nextInt(); //il primo valore preso è sempre la dimensione del vettore di stringhe 

            if(dim==0){
                scan.close(); //se è zero,  termino il programma 
                return;
            }

            scan.nextLine(); //vado avanti nel test case

            for(int i=0; i<dim; i++){ //itero fino a quanto mi è stato indicato da dim
                st.add(scan.nextLine());
            }
            
            Prefisso prefisso = new Prefisso(dim, st); //creo istanza della classe dedicata 
            String pr = prefisso.divide(0, dim-1); // avvio la funzione di trova prefisso
            System.out.println("\nLa stringa in comune è: "+pr);
            

        }

    } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }

}



}
