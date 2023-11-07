package EserciziBacktracking.PermutazioniPart;

import java.util.ArrayList;

public class part {





    public void backtrack(int [] vet, int n, ArrayList<Integer> current, int k){


        
        if(isSolution(current, n, k)){ //soluzione solo se k ==n
            System.out.println("\nSoluzione");
            for(int i=0; i<current.size(); i++){
                System.out.printf("%d ", current.get(i)); //stampo la soluzione
            }

            return;
        } 


        
            for (int i = 0; i < vet.length; i++) { //sui candidati...

                    if(isSafe(vet[i], current, k)){ //se è safe il canidato
                        current.add(vet[i]); //lo aggiungo 
                        backtrack(vet, n, current, k+1); //backtrack
                        current.remove(current.size()-1); //tolgo

                    }

            }

        return;

        
    }




    private boolean isSafe(int elem, ArrayList<Integer> current, int k) {
        
        if(k==0){  //se è il primo, va bene
            return true;
        } else if (k==1){ //se k==1, va bene se l'elemento è diverso da quello di prima
            return elem!=current.get(0);
        } else { //sennò controllo se vale un a delle due diseguaglianze grazie a k!
            return ( current.get(k-2)>current.get(k-1) && elem>current.get(k-1)) || (current.get(k-2)<current.get(k-1) && elem<current.get(k-1));
        }


    }




    private boolean isSolution(ArrayList<Integer> current, int n, int k) {
        return k==n;
    }





    public static void main(String[] args) {
        


        int [] vet = {0, 1, 2}; //vettor ein ingresso

        int n =3;

        part p = new part();

        p.backtrack(vet, n, new ArrayList<Integer>(), 0); //backtrack


    }
    
}
