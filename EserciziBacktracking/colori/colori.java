package EserciziBacktracking.colori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*consideriamo un grafo non diretto di quiesto tipo 

        1
    2       3
    4       5
        6
troviamo tutte le colorazioni per cui nbon siano aiacenti in un insieme ROSSO,  GIALLO, BLU

*/
public class colori {

    public static Random rand = new Random(); 


    public static List<List<Integer>> findColors(ArrayList<Integer> colori, int dim){ //funzione di entry per il backtracking 

        List<List<Integer>> result = new ArrayList<>(); //torno una lista di liste di interi

        backtrack(dim, new ArrayList<Integer>(), colori, result); //dimensione, current, il set di colori, result 

        return result; //torno il result 


    }



    public static void backtrack(int dim, List<Integer> current, ArrayList<Integer> colori,  List<List<Integer>> result){ //funzione di backtrack

       

        if(current.size()==dim){ //se arrivo alla dimensione desiderata 

            for(int i= 0; i<current.size(); i++){ //scorro il current 
                

                if(i==0){ //se sono nella posizione zero devo controllare se e uguale alla posizione 1 o 2 
                    if(current.get(i)==current.get(i+1) || current.get(i)==current.get(i+2)){
                        return;
                    }
                } else if (i > 0 && i<current.size()-2){ //se sono tra i e dim-2, controllo 
                    if(i%2!=0){ //se dispari di posizione, devo controllare quello accanto e quello avanti 
                        if(current.get(i)==current.get(i+1) || current.get(i)==current.get(i+2)){
                            
                            return;
                        }
                    } else if(i%2==0) { //se pari, controllo solo quello di fronte 
                        if(current.get(i)==current.get(i+2)){
                            return;
                        }
                    }
                } else {
                    if(i==current.size()-2){ //se sono nella penultima posizione devo controllare solo quello dopo
                        if(current.get(current.size()-2)==current.get(current.size()-1)){
                            return;
                        }
                    }
                }

            }

            if(result.contains(current)){ //se result contiene gia' la soluzione, allora return 
                return;
            }

            result.add(new ArrayList<>(current)); //senno aggiungo e ritorno!
            return;

        }

        for(int i=0; i<dim; i++){  //per la dimensione desiderata
                current.add(colori.get(rand.nextInt(colori.size()))); //aggiungo casualmente nel set corrente, un colore casuale nella posizione i
                backtrack(dim, current, colori, result); //richiamo backtrack 
                current.remove(current.size()-1); //rimuovo l'elemento quando torno 
        }

    }






    public static void main(String[] args) {
        
        ArrayList<Integer> colori = new ArrayList<>();



        colori.add(1); //ROSSO
        colori.add(2); //GIALLO
        colori.add(3); //VERDE


        List<List<Integer>> soluzioni = findColors(colori, 6);

        for(int i=0; i<soluzioni.size(); i++){
            System.out.println("Schema : " +soluzioni.get(i).toString());
        }

    }
    
}
