package EserciziBacktracking.sumFirst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class sumFirst {




    public ArrayList<Integer> makeFirst(int sum, int start){

        ArrayList<Integer> candidates = new ArrayList<>(); //costruisco i candidati!

        boolean divisibile;

        for(int i=start+1; i<=sum; i++){ //tutti i valori dallo start alla somma, prendo solo i numeri primi!
            divisibile=false;
            if(i==2){ //è un numero primo!
                candidates.add(i);
            }

            if(i%2!=0){

                //controllo ora se ha altri divisori!
                for(int j=2; j<=Math.sqrt(i); j++){
                    if(i%j==0){
                        divisibile=true;
                    }
                }

                if(!divisibile){
                    candidates.add(i);
                }
            }

            


        }


        return candidates;

    }


    public boolean isSolution(ArrayList<Integer> curr, int nums, int sum, int k){

        if(curr.size()==nums){ //se abbiamo tutti gli operandi
            int sumTot =0; //somma totale nulla
            
                for(int i=0; i<nums; i++){
                    sumTot+=curr.get(i); //sommo
                }

                if(nums==1 && sumTot==sum){ //e elmento uguale a 1 e soddisfa ok
                    return true;
                }


                if(curr.size() >=2 && sumTot==sum){ //se soddisfa
                    if(curr.get(0)>curr.get(1) || curr.get(1) > curr.get(2)){ //se ho permutazioni doppie torno false 
                        return false;
                    }
                
                    return true; //sennò è true
                }

            
        }

        return false;
    }



    public void backtrack(ArrayList<Integer> cand, int k, int sum, ArrayList<Integer> current, int nums){

        if(isSolution(current, nums, sum, k)){ //se è soluzione stampo 
            System.out.println("Somma " + sum);
            for(int i=0; i<current.size(); i++){
                System.out.printf("%d\t", current.get(i));
            }

            System.out.println("");

            return; //torno
        }

       

            for(int i=k; i<cand.size(); i++){ //sennò prendo il for su tutti i candidati

                if(!current.contains(cand.get(i))){ //se non lo contengo
                    current.add(cand.get(i));//lo aggiungo
                    backtrack(cand, k+1, sum, current, nums); //controllo se va bene...
                    current.remove(current.size()-1); //se torno, o va bene o no, e cerco ancora!
                }
            }

            return; //torno
    }





    public static void main(String[] args) {


        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\EserciziBacktracking\\sumFirst\\test.txt");
        
        try (Scanner scan = new Scanner(f)) {

            int i=0;

            while(scan.hasNextLine()){

                int sum = scan.nextInt();
                int numComb = scan.nextInt();
                int initial = scan.nextInt();

                i++;
                System.out.println("Caso di test " + i);


                sumFirst s = new sumFirst();


               ArrayList<Integer> vetFirst = s.makeFirst(sum, initial);

               System.out.println(vetFirst.toString());

               s.backtrack(vetFirst, 0, sum, new ArrayList<Integer>(), numComb);



            }







        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        



    }
    
}
