package RecuperoProvaIntercorso.divideimpera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class foundMissingElement {

    int sumLess=0;



    public int findElement(int [] vet, int l, int r){



        if(l<r){
            int m = (l+r)/2;

            sumLess= findElement(vet, l, m);
            sumLess+= findElement(vet, m+1, r);


        } else if(l==r) {
            return vet[l];
        }


        return sumLess;
        

    }



    public static void main(String[] args) {


        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\RecuperoProvaIntercorso\\divideimpera\\test.txt");


        try (Scanner s = new Scanner(f)) {

            while(s.hasNextLine()){



                int dim = s.nextInt(); //dimesnione del vettore!

                if(dim==0){
                    System.out.println("Termino il programma");
                    return;
                }

                int [] vet = new int[dim];

                for(int i=0; i<dim; i++){
                    vet[i]=s.nextInt();
                }

                int sum = ((vet[0]+vet[vet.length-1])*(dim+1))/2;


                System.out.println("La sequenza letta è: ");
                
                for (int i = 0; i < args.length; i++) {
                    System.out.printf("%d  ", vet[i]);
                }
            
                System.out.println("La somma totale per essere una progressione aritmetica è: "+sum);

                foundMissingElement found = new foundMissingElement();

                found.sumLess=0;
                int sommaOra = found.findElement(vet, 0, vet.length-1);

                int elem = sum-sommaOra;
                System.out.println("L'elemento che manca è: "+ elem);





            }





        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
}
