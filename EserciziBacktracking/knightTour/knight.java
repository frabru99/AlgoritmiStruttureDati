package EserciziBacktracking.knightTour;

public class knight {

    
    int [] xMoves = {-2, 2, -2, 2, 1, 1, -1, -1};
    int [] yMoves = {1, 1, -1, -1, 2, -2, 2, -2}; //i set di mosse 


    private boolean isSafe(int [][] result, int x, int y, int n){
        if(x<n && y<n && x>=0 && y>=0 && result[x][y]==-1){ //è safe la posizione se e soo se sono nella matrice e se la posizione è uguale a -1
            return true;
        }

        return false;
    }


    private boolean isSolution(int k, int n){ //se è soluzione che faccio? torno se k ha fatto tutte le mosse! 
        return (k==n*n);

    }


    public void backtrack(int k, int [][] result, int n, int x, int y){
        
        if(isSolution(k, n)){ //se soluzione, stampo!
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.printf("%d\t", result[i][j]);
                }

                System.out.println(" ");
            }

           System.exit(0);
            
        }




        for(int i=0; i<8; i++){

            int newX = x + xMoves[i];
            int newY = y + yMoves[i]; //valuto le coppie di mosse

            if(isSafe(result, newX, newY, n)){ //se è safe, allora 
                result[newX][newY]=k; //pongo i nuovi valori con k, (ceh faccio partire da 1!)
                backtrack(k+1, result, n, newX, newY); //e vado avanti 
                result[newX][newY]=-1; //sennò tonro indietro 
                
            }

            
        }

        return;  
    }





    public static void main(String[] args) { //rpblema del cavallo 


        int [][] result = new int[5][5]; //data una maatrce quadrata 


        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){ //inizializzo a -1
                result[i][j]=-1;
            }
        }

        result[0][0]=0; //pongo primo elemento a 0

        knight k = new knight(); 


        k.backtrack(1, result, 5, 0, 0); //avvio funzione
        


    }
    
}
