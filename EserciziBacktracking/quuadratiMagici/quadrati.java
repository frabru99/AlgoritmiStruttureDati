package EserciziBacktracking.quuadratiMagici;

import java.util.ArrayList;
import java.util.Random;

public class quadrati {

    public static int sum=0;
    public static int sumrow=0;
    public static boolean isNumb=false;
    public static int sumcolumn=0;
    public static Random rand = new Random();



    public static int [][] findMagic(ArrayList<Integer> elems, int n){

        int [][] result = new int[n][n]; //risultato 
        backtrack(0, elems, result, n);
        return result; //lo ritorno ma tanto lo stampo
    }




    public static void backtrack(int g, ArrayList<Integer> elems, int [][] current, int n){



        
        if(g==n*n){ //se ho raggiunto questo numero di iterazioni

        sum=0;
        sumrow=0;
        sumcolumn=0;  //inizializzo le somme

            for(int i=0; i<n; i++){ //controllo somma totale, di ogni riga e di ogni colonna
                sumrow=0;
                sumcolumn=0;
                for(int j=0; j<n; j++){
                    sumcolumn+=current[j][i];
                    sumrow+=current[i][j];
                    sum+=current[i][j];
                }

                if(sumrow!= (n*((n*n)+1)/2) || sumcolumn != (n*((n*n)+1)/2)){ //appena una non è uguale al valore definito, allora ritorno
                    return;
                }
            
            }

            int diag1 = 0, diag2 = 0; //controllo le somme sulle diagonali
            for (int i = 0; i < n; i++) {
                diag1 += current[i][i];
                diag2 += current[i][n - 1 - i];  //controllo le somme sulle diagonali
            }

            if(diag1!= (n*((n*n)+1)/2) || diag2 != (n*((n*n)+1)/2)){
                    return; //se una delle due non rispetta, allora torno
            }
            

            if((sum==(n*n*((n*n)+1)/2))){ //se anche la somma è giusta, Stampo
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        System.out.printf("%d\t", current[i][j]);
                    }
                System.out.printf("\n");
                }
                System.out.println("-----------");
                //System.exit(0);
                return;
                
            }


        
            return;
        }


        int row = g / n; //prendo row e col in base alle iterazioni fatte
        int col = g % n;

        for(int i=0; i<elems.size(); i++){ //per tutti gli elementi

            isNumb=true;

            for(int k=0; k<n; k++){  //isSafe?
                    if(current[row][k]==elems.get(i) || current[k][col]==elems.get(i) || current[k][k]==elems.get(i) || current[k][n-k-1]==elems.get(i)){ //controllo se sia presente
                        //su riga, colonna e diagonali
                            isNumb= false;
                    }

            }

          
            if(isNumb){ //se non lo ho 
                current[row][col]=elems.get(i); //lo aggiungo

                
                backtrack(g+1, elems, current, n); //richiamo la funzione
                

                current[row][col]=0; //sennò torno indietro e metto 0
            }
            


        }


    }



    //COMPLEXITY: 2^n
    public static void main(String[] args) {

        int n = 3;

        ArrayList<Integer> elems = new ArrayList<>();  //cadidati per ogni posizione 

        for(int i=0; i<(n*n); i++){  //costruisco i candidati totali
            elems.add(i+1);
        }


        findMagic(elems, n); //chiamo la funzione
        
    }
    
}
