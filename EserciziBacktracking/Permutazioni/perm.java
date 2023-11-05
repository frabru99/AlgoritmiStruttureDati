package EserciziBacktracking.Permutazioni;

import java.util.ArrayList;

/**
 * perm
 */
public class perm {


    private boolean isSolution(int [] vet, int k, int lenght){
        return k==lenght; //se è soluzione, allora posso stampare!

    }



    public void backtrack(int [] vet, int k, int lenght, ArrayList<Integer> current){

        if(isSolution(vet, k, lenght)){  

            //stampo!
            for(int i=0; i<current.size(); i++){
                System.out.printf("%d  ", current.get(i));
            }

            System.out.println("");

            return;
        }

        
        for(int i=0; i<vet.length; i++){ //su tutti i candidati
            if(!current.contains(vet[i])){ //se non è all'interno del vettore 
                current.add(vet[i]); //aggiungo
                backtrack(vet, k+1, lenght, current); //backtrack
                current.remove(current.size()-1); //alla fine rimuovo e eploro altro!
            }
        }

        return;
    }







    public static void main(String[] args) {


        int vet [] = {1, 2, 3, 4};

        perm p = new perm();

        p.backtrack(vet, 0, vet.length, new ArrayList<Integer>());


        
    }
    
}