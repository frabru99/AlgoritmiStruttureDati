package EserciziBacktracking.Subset;

import java.util.ArrayList;



public class sub {




    public void backtrack(int [] vet, int k, ArrayList<Integer> current){


        //qui una soluzione non ne ho bisogno, stampo stempre!
        for(int i=0; i<current.size(); i++){ 
            System.out.printf("%d  ", current.get(i));
        }
        System.out.println(" ");


        for(int i=k; i<vet.length; i++){ //comincio da k
            current.add(vet[i]); //lo aggiungo ogni volta
            backtrack(vet, i+1, current); //mando avanti iterazione, nota bene gli passo i+1!
            current.remove(current.size()-1); //quando ho raggiunto la fine di vet, tonro indietro e ricomincio da un nuovo valore!
        }
    }



    public static void main(String[] args) {

        int vet [] = {1, 2, 3, 4}; //problema dei subset


        sub p = new sub();

        p.backtrack(vet, 0, new ArrayList<Integer>());
        
    }
    
}
