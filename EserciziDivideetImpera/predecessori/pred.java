package EserciziDivideetImpera.predecessori;

import java.util.ArrayList;

/**
 * pred
 */
public class pred {

    /**
     * Specificato una posizione i, dove il vettore dato, da 0 a i-1 risulta ordinato, inserisce
     * l'elemento di posizione i in quella di sua competenza 
     * @param vet
     * @param l
     * @param r
     * @param i
     */

    public void insertElem(ArrayList<Integer> vet, int l , int r, int i){ //prendo in ingresso il vettore, l, r e i


        if(l<r){ //divido se l<r

            int m= (l+r)/2;


            insertElem(vet, l, m, i); //solita suddivisione divide et impera 
            insertElem(vet, m+1, r, i);
            
        } else if(l==i){ //se invece l e' uguale proprio alla posizione di inserimento

            if(l==0){ //se e' zero, nonn posso swapparee con nessun altro elemento dietrto di me, return
                return;
            }

            if(vet.get(l-1)>vet.get(i)){ //se l'elemento dietro di me e' maggiore

                //faccio un semplice swap
                int temp = vet.get(l-1);
                vet.set(l-1, vet.get(i));
                vet.set(i, temp);
                //decremento la posizione 
                i--; 
                //richiamo il tutto con la nuova posizione!
                insertElem(vet, 0, vet.size()-1, i);
            }
        }


    }

    /**
     * MERGE SORT
     * @param vet
     * @param l
     * @param r
     */

    public void mergeSort(ArrayList<Integer> vet, int l, int r){
        if(l<r){
            
            int m = (l+r)/2;

            mergeSort(vet, l, m);
            mergeSort(vet, m+1, r);
            merge(vet, l, r, m);
        }

    }

    private void merge(ArrayList<Integer> vet, int l, int r, int m){

        int n1 = m-l+1;
        int n2 = r-m;

        int [] left = new int[n1];    
        int [] right = new int[n2];


        for (int i = 0; i < n1; i++) {
            left[i]=vet.get(l+i);
        } 

        for (int i = 0; i < n2; i++) {
            right[i]=vet.get(m+1+i);
        }


        int k = l;
        int i=0;
        int j=0;

        while (i<n1 && j<n2) {

            if(left[i]<right[j]){
                vet.set(k, left[i]);
                i++;
            } else if(right[j]<left[i]){
                vet.set(k, right[j]);
                j++;
            }

            k++;
        }


        while(i<n1){
            vet.set(k, left[i]);
            i++;
            k++;
        }

        while (j<n2) {
            vet.set(k, right[j]);
            j++;
            k++;
        }
    }



    public static void main(String[] args) {


        ArrayList<Integer> vet = new ArrayList<>();

        vet.add(9);
        vet.add(2);
        vet.add(1);
        vet.add(7);
        vet.add(2);
        vet.add(1);

        pred p = new pred();

        p.mergeSort(vet, 0, 3);

        System.out.println(vet.toString());

        p.insertElem(vet, 0, vet.size()-1, 4);

        System.out.println(vet.toString());
    }

    
}