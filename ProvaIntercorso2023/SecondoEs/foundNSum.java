package ProvaIntercorso2023.SecondoEs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class foundNSum {


    private static int sum =0; //varibile per checkare la somma del numero di addendi 

    public static ArrayList<Integer> numeriPrimi(int p, int s){ //funzione per i numeri primi

        ArrayList<Integer> primi = new ArrayList<Integer>(); //creo il vettore


        for(int i=p+1; i<=s; i++){ //scorro da p+1 a somma
            if(i==2){  //2, unico numero primo pari!
                primi.add(p); //se c'+è lo devo aggiungere
            }

            boolean divisibile = false;
            if(i%2!=0){ //se è dispari il numero 
                for(int j=2; j<=Math.sqrt(i); j++){ //da 2 fino a 10, controllo se sia divisibile
                    if(i%j==0){ //se ha anche un solo divisore da 2 in poi, lo aggiungo e taglio il ciclo. 
                       divisibile=true;
                       break;
                    }
                }

                if(!divisibile){
                    primi.add(i);
                }

               
            }


        }

        System.out.println("Primi:" + primi.toString());
        return primi;
    }


    //--------------------------FUNZIONE BACKTRACK---------------------------------\\
    public static List<List<Integer>> findSum(ArrayList<Integer> primi, int s, int max_n){ //torno una list list di interi, che sono tutte le permutazioni che mi permettono di avere una certa somma, 
        //in ingresso do: il vettore di numeri primi, la somma e il numero massimo di addendi 

        List<List<Integer>> result = new ArrayList<>();  //creo il list list di risultati
        backtrack(new ArrayList<>(), result, primi, s, max_n); //funzione di backtrack, prende in ingresso, il current che creo al momento, il result da modificare, somma e numero addensi max
        return result; //torno result 
    }



    public static void backtrack(List<Integer> current, List<List<Integer>> result,  ArrayList<Integer> primi, int s, int max_n ){ //il current è una lista di Integer, result, somma e massimo numero di addendi

        //CONDIZIONE DI TERMINAZIONE 

        if(current.size()==max_n){ //se i candidati sono uguali al numero di addendi, mi fermo
            sum =0;
            
            for(int i=0; i<current.size(); i++){ //sommo i candidati 

                if(i<current.size()-1 && current.get(i)<current.get(i+1)){
                    sum+=current.get(i);
                } else if(i<current.size()-1 && current.get(i)>current.get(i+1)){
                    return;
                } else if(i==current.size()-1){
                    sum+=current.get(i);
                }
                
            }

            

            if(sum==s){ //uguale alla somma richiesta? Se sì è soluzione! Aggiungo il vettore formato da current in result 
                result.add(new ArrayList<>(current));
            }

            return; //torno dalla ricorsione 
        }



        for(int i=0; i<primi.size(); i++){ //faccio un for da 0 per tutti i numeri primi!
            if(!current.contains(primi.get(i))){ //se l'elemento i-esimo non è contenuto nella soluzione candidata allora 
                current.add(primi.get(i)); //lo aggiungo
                backtrack(current, result, primi, s, max_n); //faccio backtrack
                current.remove(current.size()-1); //quando termino, torno sui miei passi e eploro tutte le possibili soluzioni
            }
        }


    }

//--------------------------FUNZIONE BACKTRACK---------------------------------\\


//--------------------------MAIN---------------------------------\\
    public static void main(String[] args) {
    
        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\ProvaIntercorso2023\\SecondoEs\\test.txt");

        Scanner scan; //dal file prendo le triple di numeri


        try {
                scan = new Scanner(f);
                Random rand = new Random();
                


                while(scan.hasNextLine()){

                    int somma = scan.nextInt(); //la somma che devo trovare
                    int numero_addendi = scan.nextInt(); //da quanti numeri deve essere fatta
                    int start = scan.nextInt(); //da quale numero devo partire 


                    System.out.println("CASO TEST TRIPLA: " + "("+ somma+", "+ numero_addendi +", "+ start+")"); //stampa della tripla acquisita

                    ArrayList<Integer> numeriPrimi =  numeriPrimi(start, somma); //FORMO IL VETTORE DI NUMERI PRIMI, cioè costruisco il vettore di tutti i numeri primi da start+1 a somma

                    List<List<Integer>> result = findSum(numeriPrimi, somma, numero_addendi); //risultato trovato grazie al backtracking

                    for(int i=0; i<result.size(); i++){
                        System.out.println("Somma " + somma + ":" + result.get(i).toString()); //ne stampo 3 della lista di liste di interi
                    }


                }

        scan.close();

        } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
        }


    }





    
}
