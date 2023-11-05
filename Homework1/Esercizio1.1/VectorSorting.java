

public class VectorSorting {

    private int [] vet;
    private int dim;
    private int cont; //numero degli scambi inizializzato per tutto il vettore
    

    //puoi ragionare sia con bubble sort sia normalmente sia divide et impera 

    public VectorSorting(int dim, int [] values){
        cont=0;
        this.dim=dim;
        vet = new int[dim];
        vet = values;
    }

    

    public void stampaVet(){

        for(int i=0; i<this.dim; i++){
            System.out.printf("%d\t",  vet[i]);
        }
    
    }


    public int sortDivide(int l, int r){ //operazione di suddivisione
        

        if(l<r){ //limite sinistro minore di limite destro
            int m = (l+r)/2; //calcolo il pto medio

            sortDivide(l, m); //sulla parte sinistra 
            sortDivide(m+1, r); //sulla parte destra
            cont += sortImpera(l, r, m); //chiamata del sorting, con aumento del conteggio degli scambi sui sottovettori 
             
        }

        return cont; //ritorn il conteggio totale

    }

    public int sortImpera(int l, int r, int m){  //merge sort con conteggio degli scambi adiacenti
        int cont=0;

        int n1 = m-l+1; //dimensioni dei due sottovettori 
        int n2 = r-m; 

        int [] left = new int[n1];
        int [] right= new int[n2]; //li instanzio


        for(int i=0; i<n1; i++){ 
            left[i] = vet[l+i];
        }

        for(int j=0; j<n2; j++){ //assegno i valori nei due vettori
            right[j]= vet[m+j+1];
        }


        int i =0;
        int j=0;
        int k = l;



        while(i<n1 && j< n2){ //confronto e assegnazione
            if(left[i]<right[j]){
                vet[k]=left[i];
                i++;
            } else {
                vet[k]=right[j];            
                j++;
                cont += n1 - i; //in questo caso sto contando il numero di "inversioni", quando i è minore di j e Ai > Aj
            }
            k++;
        }


        while(i<n1){ //assegno i valori restanti
            vet[k]=left[i];
            i++;
            k++;
        }

         while(j<n2){
            vet[k]=right[j];
            j++;
            k++;
        }


    
        return cont;


    }

    
}
