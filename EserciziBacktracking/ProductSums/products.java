package EserciziBacktracking.ProductSums;

import java.util.ArrayList;

public class products {




    public boolean backtrack(int [] vet, int [] numbers, int k, int n, ArrayList<Integer> current){
        
        
        if(isSolution(current, vet, n)){ //se soluzione, cioè quando ho raggiunto la permutazione giusta
            
            System.out.printf("Soluzione:");
                for(int i=0; i<current.size(); i++){ //stampo e esco 
                    System.out.printf("%d  ", current.get(i));
                }
            
            
            //return true;
           System.exit(0);;//termino il programma
            

        }



        for(int i=0; i<numbers.length; i++){
            if(!current.contains(numbers[i])){
                current.add(numbers[i]);
                backtrack(vet, numbers, k+1, n, current);
                current.remove(current.size()-1);
            }
        }

        return false;
    }



    
    private boolean isSolution(ArrayList<Integer> current, int[] vet, int n) {

        int sum =0;
        if(current.size()==vet.length){

            for(int i=0; i<current.size(); i++){
                sum+=current.get(i)*vet[i];
            }

            if(sum==n){
                return true;
            }


        }

        return false;
    }




    
}
