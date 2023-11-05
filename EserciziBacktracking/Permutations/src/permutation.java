import java.util.ArrayList;
import java.util.List;

public class permutation {


    public static List<List<Integer>> generatePermute(int [] nums){ //funzione iniziale

        List<List<Integer>> result = new ArrayList<>(); //result come nuovo arrayList 
        backtrack(nums, new ArrayList<>(), result); //do alla funzione di backtracking il vettore, il vettore di current, che è nuovo e il result
        return result; //quando termina, torno result

    }


    public static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result){

        if(current.size()==nums.length){ //se  la dimensione dell'insieme corrente è uguale
        //alla lunghezza del valore dei numeri allora ho trovato
        result.add(new ArrayList<>(current)); //aggiungo al risultato la lista degli elementi correnti, che è la permutazione 

        return; //torno 
        } //sennò itero sui numeri

        for(int i=0; i<nums.length; i++){ // per ogni valore dei numeri

            if(!current.contains(nums[i])){ //se il current non contiene il numero 

                current.add(nums[i]); //lo aggiungo
                backtrack(nums, current, result); //vedo se la soluzione va bene 
                current.remove(current.size()-1);
            }
            
        }


    }





    public static void main(String[] args) {

        int [] nums = {1, 2, 3, 4}; //input da dare

        List<List<Integer>> permutations = generatePermute(nums); //avvio la funzione con input 

        for (List<Integer> permutation : permutations) { //stampo ogni permutazione (questo è una sorta di for each)
            System.out.println(permutation);
        }
        
    }
    
}
