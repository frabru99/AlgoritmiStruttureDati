package Homework2.SommaSottovettori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class somma {

    public static int max=0; //variabili di supporto
    public static int maxs=0;
    public static int maxd=0;

    public static int sum1=0;
    public static int sum2=0;
    
    

    public static int maxSum(int[] vet, int l, int r){

        
    
        if(l<r){

            int m= (l+r)/2; //se l<r

            maxSum(vet, l, m);
            maxSum(vet, m+1, r);
            max=impera(vet, l, r, m);            
        } else if (l==r){
            return Math.max(vet[0], vet[vet.length-1]);
        }


        return max;

    }

    //COMPLEXITY NLOGN
    public static int impera(int [] vet, int l , int r, int m){

        sum1=0;  //inizializzo a 0 ad ogni chiamata della funzione impera
        sum2=0;
        maxs=0;
        maxd=0;
        
        
        for(int k = m; k>=l; k--){ //sommo tutto qurllo che c'è dal punto medio in giù, e mi prendo il massimo valore, fino a l, quindi decremento
            sum1+=vet[k]; 

            if(sum1>maxs){ //massimo della somma dei sotto vettori di sinistra
                maxs=sum1;
            }

        }


        for(int g =m+1; g<r; g++){ //invece qui lo faccio da m+1 fino a r, e trovo la massima somma 
            sum2+=vet[g];
            
            if(sum2>maxd){ 
                maxd=sum2;
            }
        }


    
        if(maxs+maxd>=max){ //ma se la somma dei due è il massimo, pongo il massimo alla loro somma
            max = maxs+maxd;
        } else if (maxs>=maxd+maxs && maxs>=max){
            max = maxs;
        } else if(maxd>=maxd+maxs && maxd>=max){
            max=maxd;
        }       
                   
        return max; //torno max

    }



    public static void main(String[] args) {


        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\Homework2\\SommaSottovettori\\testcases.txt");

        int dim =0;
        

        Scanner scan;

        try {
            scan = new Scanner(f);
            

            while(scan.hasNextLine()){

                dim = scan.nextInt();

                if(dim == 0) {
                    System.out.println("Terminazione");
                    scan.close();
                    return;
                }

                int [] vet = new int[dim]; //vettore di prova 

                for(int i=0; i<dim; i++){
                    vet[i]=scan.nextInt();
                    System.out.printf("%d\t", vet[i]);
                }

                System.out.println(" ");

                sum1=0;  //inizializzo a 0 ad ogni chiamata della funzione impera
                sum2=0;
                maxs=0;
                maxd=0;
                max=-1;

                int val = maxSum(vet, 0, vet.length); //avvio la funzione sul vettore 

                System.out.println("Massima somma= " + val); //stampo

                

            } 


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }


    
    
}
