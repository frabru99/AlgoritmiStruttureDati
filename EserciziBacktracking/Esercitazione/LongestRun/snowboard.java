
package EserciziBacktracking.Esercitazione.LongestRun;

/**
 * snowboard
 */
public class snowboard {

    public int [] xMoves = {-1, 1, 0, 0}; //mosse possibii
    public int [] yMoves = {0, 0, -1, 1};
    public int nrow=0; 
    public int ncol=0;
    public int lenght;


    
    public void findSolution(int [][] plane){

        int [][] solution = new int [nrow][ncol];

         for(int i=0; i<nrow; i++){
                for(int j=0; j<ncol; j++){
                    solution[i][j]=-1;
                }
        }


        for(int i=0; i<nrow; i++){
                for(int j=0; j<ncol; j++){
                    lenght=0;
                    int l = backtrack(plane, solution, i, j);
                    solution[i][j]= ++l;
                    
                }
            }

            System.out.println("--Soluzione--");
        for(int i=0; i<nrow; i++){
            for(int j=0; j<ncol; j++){
                System.out.printf("%d\t", solution[i][j]);
            }
            System.out.println("");
        }

    }


    public boolean isSolution(int[][] mappa, int x, int y){

        for(int i=0; i<4; i++){
           int nextX =  x + xMoves[i]; 
           int nextY = y + yMoves[i];
            
           if(isSafe(x, y, nextX, nextY, mappa)){
                return false;
            }

        }

        //soluzione quando non posso più andare da nessuna parte!
        return true;
    }








    public int backtrack(int [][] mappa, int[][]result, int x, int y){


        if(isSolution(mappa, x, y)){
            return lenght;
        }

        
            int nextX;
            int nextY;
            int minX=Integer.MAX_VALUE;
            int minY=Integer.MAX_VALUE;
            int minDistance=Integer.MIN_VALUE;

            for(int i=0; i<4; i++){ //numero mosse

                nextX = x + xMoves[i];
                nextY = y + yMoves[i];



                if(isSafe(x, y, nextX, nextY, mappa)){
                    if(mappa[nextX][nextY]>minDistance){
                        minDistance=mappa[nextX][nextY];
                        minX=nextX;
                        minY=nextY;
                    }

                    
                    
                    
                }

                

            }

            lenght++;
            backtrack(mappa, result, minX, minY);

            

            //Questo prende il valore più vicino attorno a se e 
            

            
            return lenght;
            
    }

   



    

    public boolean isSafe(int x, int y, int newx, int newy, int [][] mappa){

        try{
            if(x<nrow && y<ncol && newx>=0 && newy>=0 && newx<nrow && newy<ncol && mappa[newx][newy]<mappa[x][y]){
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getCause());
            System.out.println(x);
            System.out.println(y);
            System.out.println(newx);
            System.out.println(newy);
            System.exit(0);
        }

        return false;

    }







    public static void main(String[] args) {


        int [][] plane = {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};

        int [][] plane2 = {{56, 14, 51, 58, 88},
            {26, 94, 24, 39, 41},
            {24, 16, 8, 51, 51},
            {76, 72, 77, 43, 10},
            {38, 50, 59, 84, 81},
            {5, 23, 37, 71, 77},
            {96, 10, 93, 53, 82},
            {94, 15, 96, 69, 9},
            {74, 0, 62, 38, 96},
            {37, 54, 55, 82, 38}};

        
        
        snowboard s = new snowboard();

        s.nrow=5;
        s.ncol=5;

        for(int i=0; i<s.nrow; i++){
            for(int j=0; j<s.ncol; j++){
                System.out.printf("%d\t", plane[i][j]);
            }
            System.out.println("");
        }



        

        s.findSolution(plane);


        
    }

    
}