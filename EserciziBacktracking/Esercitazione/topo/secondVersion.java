package EserciziBacktracking.Esercitazione.topo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class secondVersion {

    int [] xMoves = {1, 0};  //SET DI POSSIBILI MOSSE, SONO I CANDIDATI!
    int [] yMoves = {0, 1};

   


    
    public boolean isSoution(int x, int y, int n, int [][] sol){ //come controllo che sia soluzione?
       return (x==n-1 && y==n-1); //vedo se sono arrivato all'ultima posizione del labirinto!
    }



    public boolean isSafe(int [][] maze, int x, int y, int n){ //controllo se la mossa la posso fare
        if(x>=0 && y>=0 && x<n && y<n && maze[x][y]==1){ //se sono nella matrice e il valore delle nuove posizioni nel maze è 1, allora posso attuare
            return true; //torno vero
        }

        return false; 
    }


    
    public boolean solveMazeUtil(int [][] maze, int x, int y, int[][] sol, int n){  //funzione di backtrack

        if(isSoution(x, y, n, sol)){ // se è soluzione, allora pongo il primo a 1 e l'ulyimo a 1
            sol[0][0]=1;
            sol[x][y]=1;
            return true; //torna vero
        }

        //sennò controllo le possibili mosse
        for(int i=0; i<2; i++){ 

                int nextX= x+xMoves[i]; //creo la nuova combinazione di mosse, scorrendo le coppie
                int nextY= y+yMoves[i];

                if(isSafe(maze, nextX, nextY, n)){ //se è safe, allora vado avanti

                    sol[nextX][nextY]=1; //metto 1 nel path da seguire

                    if(solveMazeUtil(maze, nextX, nextY, sol, n)){ //backtrack!, se mi tornqa true ho trovato la soluzione, torno trues
                        return true;
                    }

                    sol[nextX][nextY]=0; //se invece torno false, non è safe, lo metto a zero e provo altro!
                }


        }

        return false;
        
    }




    public boolean solve(int [][] maze, int [][] sol, int n){

        if(solveMazeUtil(maze, 0, 0, sol, n)){ //chiamo solveMazeutil, funzione di backtrack!
            return true; // se torna true, torno true
        }

        return false; //se no false
    }





    public static void main(String[] args) {
        //LETTURA DA FILE//
        File  f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\EserciziBacktracking\\Esercitazione\\topo\\matrice.txt");
        
        try {
            Scanner scan = new Scanner(f);

            while(scan.hasNextLine()){


                int row = scan.nextInt();
                int col = scan.nextInt();

        

                if(row==0 || col==0){
                    return;
                } 

                
                if(row != col){
                    System.out.println("la matrice deve essere quadrata!");
                    return;
                }

                int [][] mat = new int[row][col];

                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        mat[i][j] = scan.nextInt();
                    }
                }


                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        System.out.printf("%d\t", mat[i][j]);
                    }
                    System.out.printf("\n");
                }  

                
                //SOLUZIONE


                secondVersion s = new secondVersion(); //oggetto seconda sezione

                

                int [][] sol = new int[row][col]; //creo la matrice di soluzione 

                if(s.solve(mat, sol, row)){ //chiamo la solve, che mi restituisce vero se ho trovato la soluzione

                    System.out.println("Soluzione!");  //stampo

                    for(int i=0; i<row; i++){
                            for(int j=0; j<col; j++){  
                                System.out.printf("%d\t", sol[i][j]);
                            }
                        System.out.printf("\n");
                    }

                    
                }

                
            }


            scan.close();



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
