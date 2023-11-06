package EserciziDivideetImpera.jolly;


import java.util.ArrayList;

public class jolly {

    ArrayList<Integer> diffs = new ArrayList<>(); //vettore delle differenze
    boolean ok = true;

    public ArrayList<Integer> foundJolly(int [] vet, int l, int r){

        if(l<r){

            int m = (l+r)/2; //suddivisione semplice

            foundJolly(vet, l, m);
            foundJolly(vet, m+1, r);

        } else if(l==r && l!=vet.length-1){ //ora se sono a l e non è l'ultima posizione 

            int diff = vet[l]-vet[l+1]; //faccio la differenza col succesivo

            if(Math.abs(diff)<1 || Math.abs(diff)>vet.length-1){ //se questa differenza è minore di 1 o maggiore di n-1, non è jolly
                System.out.println("Non è una sequenza jolly"); //esco dal programma
                ok=false;
                return null;
            }

            if(!diffs.contains(Math.abs(diff))){ //se non lo ho già inserito, inserisco la differenza
                diffs.add(Math.abs(diff));
            }
            
        }


        return diffs;

    }

    public static void main(String[] args) {
        
        int [] vet = {1, 4, 2, 3};


        jolly j = new jolly();

        j.ok=true;

        j.foundJolly(vet, 0, vet.length-1);

              
        if(j.ok){
            for(int i=1; i<vet.length; i++){
                if(!j.diffs.contains(i)){
                    System.out.println("Non è una sequenza jolly!");
                    return;
                }
            }

            System.out.println("E' una sequenza jolly"); //sennò lo è
        }






        
    }
    
}
