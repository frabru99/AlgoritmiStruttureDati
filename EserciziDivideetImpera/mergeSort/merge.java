package EserciziDivideetImpera.mergeSort;

/**
 * merge
 */
public class merge {


    //complessità caso medio O(nlogn)
    public void mergeSort(int [] vet, int l, int r){


        if(l<r){ //se l<r

            int m = (l+r)/2; //calcolo p'unto medio


            mergeSort(vet, l, m);
            mergeSort(vet, m+1, r); //divido 
            mergeS(vet, l, r, m); //impero

        }
    }


    private void mergeS(int [] vet, int l, int r, int m){

        int n1  = m-l+1;
        int n2 = r-m; //calcolo le dimensioni dei due vettori

        int [] left = new int[n1]; //li creo
        int [] right = new int[n2];

        for(int i=0; i<n1; i++){ // faccio un bel for di asegnazione die valori 
            left[i]=vet[l+i]; //l+1
        }

        for(int i=0; i<n2; i++){
            right[i]=vet[m+1+i]; //m+1+i
        }


        //fase di merge

        int i=0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2){ //scorro i vettori e confronto chi è meggiore, e assegno
            if(left[i]<right[j]){
                vet[k]=left[i];
                i++;
            } else {
                vet[k]=right[j];
                j++;
            }

            k++;
        }


        //se uno dei due vettori termina prima, assegno tutti gli elementi del rimanente 
        while(i<n1){
            vet[k]=left[i];
            i++;
            k++;
        }


        while(j<n2){
            vet[k]=right[j];
            j++;
            k++;
        }

    }


    public static void main(String[] args) {

        //implementiamo il merge sort 
        int [] vet = {10, 1, 20, -10, -30};

        merge m = new merge();

        m.mergeSort(vet, 0, vet.length-1);

        System.out.println("Vettore ordinato: ");

        for (int i = 0; i < vet.length; i++) {
            System.out.printf("%d\t", vet[i]);
            
        }


        
    }

    
}