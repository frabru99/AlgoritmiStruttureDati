import java.util.ArrayList;

public class test {


    public static ArrayList<Integer> maxSum(int[] vet){ //funzione di chiamata

        ArrayList<Integer> solution = new ArrayList<>(); //vettore delle soluzioni 
        backtrack(vet, 0, new ArrayList<>(), solution); //backtracking funzione 
        System.out.println(solution.toString()); //faccio vedere il vettore di somme
        return solution; //ristorno

    }



    public static void backtrack (int [] vet, int k, ArrayList<Integer> current, ArrayList<Integer> result){
            
            

            System.out.println(current.toString()); //stampo ogni volta i current

            if(current.size()==vet.length){ //se ho raggiunto il massimo 
                current.clear(); //pulisco 
                return; //torno
            }
           
            

            for(int i=k; i<vet.length; i++){ // da k a lenght 
                
                if(!current.contains(vet[i])){ //se non contiene l'elemento lo aggiungo
                    current.add(vet[i]); //aggiungo l'elemento al current
                    int sum=0;
                    for(int elem: current){ //calcolo la somma degli adiacenti 
                        sum+=elem;
                    }
                    result.add(sum); //aggiungo
                    backtrack(vet, i+1, current, result); //ripeto
                }

        }


    }


    public static void main(String[] args) {
        

        int [] vet = {-5, 100, -5, 6};

        ArrayList<Integer> sums = maxSum(vet);

        sums.sort(null);

        System.out.println("Max: " + sums.get(sums.size()-1));
    }
    
}
