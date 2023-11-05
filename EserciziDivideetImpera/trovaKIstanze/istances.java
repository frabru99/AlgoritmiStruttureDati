package EserciziDivideetImpera.trovaKIstanze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class istances {


    public int count=0;

    public int findIstances(int [] vet, int l, int r, int k){


        if(l<r){

            int m = (l+r)/2;

            findIstances(vet, l, m, k);
            findIstances(vet, m+1, r, k);



        } else if (l==r && vet[l]==k){
            count++;
        }



        return count;
    }

    //complessità, senza considerare file e letture, circa O(n)



    public static void main(String[] args) {



        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\EserciziDivideetImpera\\trovaKIstanze\\test.txt");

        try (Scanner scan = new Scanner(f)) {


            while(scan.hasNextLine()){

                


            int testcases = scan.nextInt();

            if(testcases==0){
                return;
            }


                for(int i=0; i<testcases; i++){

                int founElem = scan.nextInt();

                int dim = scan.nextInt();

                

                int [] vet = new int[dim];

                for(int j=0;j<dim;j++){
                        vet[j]=scan.nextInt();
                }

                istances s = new istances();

                System.out.println("Istanze di "+ founElem +": " + s.findIstances(vet, 0, vet.length-1, founElem));

                }

            }




        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("File non trovato!");
           
        }
        
    }
    
}
