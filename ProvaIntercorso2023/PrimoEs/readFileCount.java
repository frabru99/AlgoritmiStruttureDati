package ProvaIntercorso2023.PrimoEs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class readFileCount {

    private Scanner scan;
    private ArrayList<Integer> array;
    private int count;
    private int searchelem;



    public readFileCount(){ 
        array = new ArrayList<Integer>();
        scan = new Scanner(System.in);
    }


    public void foundAllValues(){
        Random rand = new Random();

        System.out.println("Quanit casi di test vuoi eseguire?"); //faccio scegliere i casi di test da eseguire 
        int casi = scan.nextInt();


        for(int i = 0; i<casi; i++){  //per tutti i casi di test
            array.clear();  //pulisco il vettore 
            count=0; //pulisco count

            array.add(rand.nextInt(10)); //elemento da cercare 
            array.add(rand.nextInt(10)+1); //dimensione 

            for(int j = 0; j<array.get(1); j++){ //aggiungo gli elementi al vettore
                array.add(rand.nextInt(10));
            }

            System.out.println("\nElementi inseriti:"); //stampo il vettore
            System.out.println(  array.toString());

            System.out.println("\nElemento da cercare: " + array.get(0)); //stampo elemento da cercare
            
            System.out.println("\nLa dimensione e': " + array.get(1)); //stampo dimensione

            //chiamare ricerca
            searchelem= array.get(0); //elemento da cercare 
            int conteggio = foundElement(2, array.size()-1); //foundElem da 2 in poi 
            System.out.println("il conteggio e': " + conteggio); //conteggio finale 
        }
        
    }




    private int foundElement(int l, int r){ //funziopne ricorsiva

        count =0;

        if(l<r){ //se l<r allora
            int m = (l+r)/2; //punto medio per dividere 

            count += foundElement(l, m); //divido i due 
            count += foundElement(m+1, r);
        } else if (array.get(l)==searchelem){
            return 1; //sennò torno zero al caso base!
        } else {
            return 0;
        }

        return count; //ritorno conteggio alla fine
    }


    
}
