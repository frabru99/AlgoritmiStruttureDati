package EserciziBacktracking.topo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mouse {

    int [] xMoves = {1, -1, 0, 0}; //seet di mosse possibili!
    int [] yMoves = {0, 0, 1, -1};




    public void backtrack(int [][] map, int [][] result, int k, int n, int x, int y){ //funzione di backtrack


        if(isSolution(x, y, n, k, result)){ //se è soluzione
            System.out.println("-------------"); //stampo!
            for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        System.out.printf("%d  ", result[i][j]);
                    }

                    System.out.println(" ");
                }

            return;

        }


        for(int i=0; i<xMoves.length; i++){ //per ogni mossa, controllo se sia Safe e la provo
            int newX = x+xMoves[i];
            int newY = y+yMoves[i];


            if(isSafe(n, newX, newY, map, result)){ //se è safe
                result[newX][newY]=1; //marco il result 
                backtrack(map, result, k+1, n, newX, newY); //e faccio backtracking
                result[newX][newY]=0; //sennò torno e pongo a 0
            }


        }

        return;

    }

    public boolean isSafe(int n, int x, int y, int [][] map, int [][] result){ //safe se sono nella matrice e se map==1, e result è nullo!
        return (x>=0 && y>=0 && x<n && y<n && map[x][y]==1 && result[x][y]!=1);
    }


    public boolean isSolution(int x, int y, int n, int k, int[][] result){ //soluzione solo se l'ultimo posto della matrice è a 1!
        return (result[n-1][n-1]==1);
    }


    //prendo una matrice in ingresso, a seconda delle direzioni, posso rovare una strada per uscire!  

    public static void main(String[] args) {



        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\EserciziBacktracking\\topo\\test.txt");


        try{

            Scanner s = new Scanner(f);


            while(s.hasNextLine()){

                int row = s.nextInt(); //le consideriamo sempre quadrate!
                int col = s.nextInt();

                if(row==0 || col ==0){
                    System.out.println("terminate le matrici!");
                    return;
                }

                //leggo la matrice mappa

                int [][] map = new int[row][col];

                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        map[i][j]=s.nextInt();
                    }
                }

                System.out.println("--------MAPPA--------");

                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        System.out.printf("%d  ", map[i][j]);
                    }

                    System.out.println(" ");
                }



                mouse  m = new mouse();


                System.out.println("SOLUZIONI");
                int [][] result = new int[row][col];

                result[0][0]=1;
                m.backtrack(map, result, 0, col, 0, 0);



            }

        } catch (FileNotFoundException e){


        }
        
    }
    
}
