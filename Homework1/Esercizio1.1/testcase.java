
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testcase {
    

    
    public static void main(String[] args) {
        File f = new File("C:\\Users\\brune\\OneDrive\\Desktop\\Magistrale\\Algoritmi e Strutture Dati\\Homework1\\Esercizio1.1\\test.txt");

       Scanner scan;
    try {
        scan = new Scanner(f);
    

        while (scan.hasNextLine()){


        int dim = scan.nextInt();
        
        if(dim == 0  || dim > 500000){
            if(dim>500000){
                System.out.println("Dimensione troppo grande!");
            }
            scan.close();
            return;
        } //controllo sulla dimensione ottenuta, se 0 o maggiore di quella consentita torno e chiudo il programma 


        int [] values = new int[dim]; //genero il vettore 

        for(int i=0; i<dim; i++){
            values[i]= scan.nextInt(); //leggo 
        }

        VectorSorting vet =new VectorSorting(dim, values); //instanzio oggetto dedicato

        System.out.println("\nIl vettore letto e': ");
        vet.stampaVet(); //stampo 
        

        int num_scambi = vet.sortDivide(0, dim-1); //invoco la funzione di sort, con ritorno degli scambi
        
        System.out.println("\nIl vettore ordinato e': ");
        vet.stampaVet();
        System.out.printf("\nNumero di scambi effettuati: %d", num_scambi); //stampo

    }

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
    

}
