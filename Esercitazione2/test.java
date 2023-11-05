import java.util.Scanner;

public class test {
    

    public static void main(String[] args) {
        


        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci altezza: ");
        int h = scan.nextInt();

        Tree albero = new Tree(h);

        System.out.println("\nDammi un numero di palline e ti darò la posizione: ");
        int n = scan.nextInt();

        System.out.println("Il nodo foglia di terminazione è il numero: " + albero.findPositionSphere(n) );
    }
}
