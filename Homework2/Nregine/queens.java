package Homework2.Nregine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class queens {

    public int count =0; //conteggio delle matrici soluzione trovate




    public void backtrack(int [][] table, int k, int n){ //funzione di backtracking

        if(isSolution(k, n)){ //se è soluzione
            /* Stampa delle soluzioni, lascio per debug

            System.out.println("------------"); //stampo la matrice
            for(int i=0;i<n; i++){
                    for(int j=0;j<n;j++){
                        System.out.printf("%d  ", table[i][j]);
                    }

                    System.out.println(" ");
            }

            */ 

            count++;//aumento il conteggio
            return;
        }

        
        //Backtracking//

        for(int i=k; i<n; i++){ //scorro tutti gli elementi della matrice 
            for(int j=0; j<n;j++){ //invece per le righe seguo , per non ricominciare da 0.

                if(isSafe(table, i, j, n)){ //se è safe la nuova posizione
                    table[i][j]=1; //impongo uguale a 1 
                    backtrack(table, k+1, n); //backtrack e ricomincio
                    table[i][j]=0;  //backtrack
                } 
            }
            
        }


        return;


    }

    private boolean isSafe(int[][] table, int row, int col, int n) { //per la verifica della posizione

        int j=1;

        //devo controllare se ci sono uno nella stessa riga e stessa colonna 
        for(int i=0; i<n; i++){
            if(table[row][i]==1 || table[i][col]==1){ //prendo la riga o la colonna, le blocco e controllo su tutti gli elementi rimanenti
                return false;
            }
        }

        while(row-j>=0 && col-j>=0){ //controllo diagonale superiore sinistra
            if(table[row-j][col-j]==1){
                return false;
            }
            j++;
        }

        j=1;

        while(row+j<n && col+j<n){ //controllo diagonale inferiore destra 
            if(table[row+j][col+j]==1){
                return false;
            }
            j++;
        }


        j =1;
        while(row+j<n && col-j>=0){ //controllo diagonale inferiore sinistra 
            if(table[row+j][col-j]==1){
                return false;
            }
            j++;
        }

        j=1;
        while(row-j>=0 && col+j<n){ //controllo diagonale superiore destra
            if(table[row-j][col+j]==1){
                return false;
            }
            j++;
        }

    
        return true;
    }

    private boolean isSolution(int k, int n){ //è soluzione quando k è uguale al numero di righe/colonne (n regine)
        return k==(n);
    }



    //COMPLESSITA' NEL CASO PEGGIORE O(2^n)


    public static void main(String[] args) { 



        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\Homework2\\Nregine\\test.txt");

        try{

        Scanner s = new Scanner(f);

        while(s.hasNextLine()){


            int n=s.nextInt();

            if(n==0){
                System.out.println("Termino il programma");
                return;
            }

            System.out.println("Per una scacchiera :" + n + " x "+n);


            int [][] table = new int[n][n];


            queens q = new queens();


            q.backtrack(table, 0, n);

            System.out.println(q.count);

        }

        } catch (FileNotFoundException e){
            System.out.println("File non trovato!");

        }

        
    }
    
}
