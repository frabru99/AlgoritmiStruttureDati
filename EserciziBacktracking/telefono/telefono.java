package EserciziBacktracking.telefono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class telefono {



    HashMap<Integer, Character []> map = new HashMap<Integer, Character []>();

    Character [] two = {'a', 'b', 'c'}; // mappa di numero/telefono
    Character [] tree = {'d', 'e', 'f'};
    Character [] four = {'g', 'h', 'i'};
    Character [] five = {'j', 'k', 'l'};
    Character [] six = {'m', 'n', 'o'};
    Character [] seven = {'p', 'q', 'r', 's'};
    Character [] eight = {'t', 'u', 'v'};
    Character [] nine = {'w', 'x', 'y', 'z'};


    
    public telefono(){ // inserisco nella hashmap
        map.put(2, two);
        map.put(3, tree);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);
        map.put(7, seven);
        map.put(8, eight);
        map.put(9, nine);
    }


    public boolean isSolution(int k, int dim, ArrayList<Character> current){ //è soluzione se k == a dim
        if(k==dim){
                return true;
        }

        return false;

    }




    public void backtracking(int [] digits, int k, int dim, ArrayList<Character> current){

        if(isSolution(k, dim, current)){ //stampo se lo è 
            for(int i=0; i<current.size(); i++){
                System.out.printf("%c\t", current.get(i));
            }

            System.out.println(" ");

    
            return;
        }



        int digit = digits[k]; // mi genero i candidati, prendo il digit i-esimo del valore nella k esima iterazione
        Character[] elems= map.get(digit); //mi prendo gli elementi corrispondenti

        

        for(int i=0; i<elems.length; i++){ //itero su quelli

                current.add(elems[i]); //inserisco
                backtracking(digits, k+1, dim, current); //backtracking e aumento
                current.remove(current.size()-1); // rimuovo!
        }

        

    }


    public static void main(String[] args) {

        //costruisco la hashmap

        telefono t = new telefono();

        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\EserciziBacktracking\\telefono\\numbers.txt");

        try (Scanner scan = new Scanner(f)) {
            while(scan.hasNextLine()){

            
            int dim = scan.nextInt();

            if(dim==0){
                System.out.println("Terminazione!");
                return;
            }

            int [] digits = new int[dim];

            for(int i=0; i<dim; i++){
                digits[i]=scan.nextInt();
            }

            
            t.backtracking(digits, 0, dim, new ArrayList<Character>());



   }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        
    }
    
}
