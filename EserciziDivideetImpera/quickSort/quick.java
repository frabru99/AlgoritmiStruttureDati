package EserciziDivideetImpera.quickSort;


public class quick {



    public void quickSort(int [] vet, int l, int r){ //quicksort

        if(l<r){


            //partition
            int m = partition( vet, l, r);
            quickSort(vet, l, m-1);
            quickSort(vet, m+1, r);

        }

    }

    private int partition(int[] vet, int l, int r) { //tempo di esecuzione nlogn nel caso medio

        //scelgo un pivot
        int x = vet[r]; 

        int i = l-1; //primo indice minore dle primo elemento preso in considerazione

        for(int j=l; j<=r; j++){ //j parte da l e arriva a r
            if(vet[j]<x){ //se j è minore del pivot
                //swap!
                i=i+1; //faccio spazio e scambio
                int temp = vet[j]; 
                vet[j]=vet[i];
                vet[i]=temp;
            }
        }

        int temp = vet[r]; //scambio pivot con elemento centrale
        vet[r]=vet[i+1];
        vet[i+1]=temp;
    

        return i+1; //ritorno elemento centrale!
    }





    public static void main(String[] args) {
        

        //implementiamo il merge sort 
        int [] vet = {10, 1, 20, -10, -30};

        quick m = new quick();

        m.quickSort(vet, 0, vet.length-1);

        System.out.println("Vettore ordinato: ");

        for (int i = 0; i < vet.length; i++) {
            System.out.printf("%d\t", vet[i]);
            
        }
    }
    
}
