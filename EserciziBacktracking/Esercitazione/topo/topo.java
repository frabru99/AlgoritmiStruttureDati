package EserciziBacktracking.Esercitazione.topo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class topo {



    public int[][] foundSolution(int [][] plane, int row){

        int[][] result = new int [row][row];
        backtrack(0, plane, result, row, 0, 0);
        return result;

    }



    private void backtrack(int k, int [][] plane, int [][] result, int row, int i, int j){

        //System.out.println(row);
        if(result[row-1][row-1]==1){

            System.out.println("-Solution-");
            for(int s=0; s<row; s++){
                    for(int l=0; l<row; l++){
                        System.out.printf("%d\t", result[s][l]);
                    }
                    System.out.printf("\n");
                }

                System.exit(0);


        }


        if(plane[i][j]==1 && i<row && j<row){  //rivedi soluzione, fallo con il pattern sulle slide!!!!!
                    result[i][j]=1;
                    backtrack(k+1, plane, result, row, i, j+1);
                    result[i][j]=0;
        }


                
        if (plane[i][j]==1  && i<row && j<row){
            result[i][j]=1;
            backtrack(k+1, plane, result, row, i+1, j);
            result[i][j]=0;
        }
        
    }


    public static void main(String[] args) {

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


                topo t = new topo();

                t.foundSolution(mat, row);


                
            }


            scan.close();








        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        






    }
    
}
