package RecuperoProvaIntercorso.backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class findWord {

    int [] xMoves ={1, -1, 0, 0, 1, -1, 1, -1};
    int [] yMoves = {0, 0, 1, -1, 1, -1, -1, 1};


    public void backtrack(char [][] map, int[][] result, int k, char[] vet, int row, int col, int x, int y, ArrayList<String> positions){
       
        if(isSolution(k, vet)){

            System.out.println("\n----Soluzioni---");


            for(int i=0; i<positions.size(); i++){
                System.out.println(positions.get(i));
            }
        
            
            return;
        }


        //prendo il possibile candidato

        char value = vet[k-1];

        for(int i=0; i<xMoves.length; i++){

            int newX = x+xMoves[i];
            int newY = y+ yMoves[i];

            if(isSafe(map, result, newX, newY, value, row, col)){
                result[newX][newY]=k;
                positions.add("("+Integer.toString(newX+1)+","+Integer.toString(newY+1)+")");
                backtrack(map, result, k+1, vet, row, col, newX, newY, positions);
                result[newX][newY]=0;
                positions.remove(positions.size()-1);
            }

        }

        return;
    }




    private boolean isSafe(char[][] map, int[][] result, int newX, int newY, char value, int row, int col) {
        return (newX>=0 && newY>=0 && newX<row && newY<col && map[newX][newY]==value && result[newX][newY]==0);
    }




    private boolean isSolution(int k, char[] vet) {
        return k==vet.length+1;
    }




    public static void main(String[] args) {



        char [] vet = {'h', 'e', 'l', 'l', 'o'};

        int row = 5;
        int col = 5;

        char [][] mat = {
        {'t', 'z', 'x', 'c', 'd'}, 
        {'a', 'h', 'n', 'o', 'x'}, 
        {'h', 'w', 'e', 'l', 'o'}, 
        {'o', 'r', 'n', 'l', 'n'},
        {'a', 'b', 'r', 'i', 'n'}};

        ArrayList<String> positions = new ArrayList<String>();


        findWord find = new findWord();

        find.backtrack(mat, new int[row][col], 1, vet, row, col, 0, 0, positions);

        

        




    
    }
    
}
