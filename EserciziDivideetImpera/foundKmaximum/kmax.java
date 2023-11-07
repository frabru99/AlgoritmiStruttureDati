package EserciziDivideetImpera.foundKmaximum;

import java.util.Collections;

public class kmax {


    //programma in cuui trovo la i esima statistica d'ordine, ma per il masismo!

    public int foundKMax(int [] vet, int l, int r, int i){ //statistica d'ordine, gli passo i, ricorda dveo tornare i-1 visto che l'utente intende las statistica partendo da 1 e non da 0!

        
        if(l<r){ //se l<r

            int m = partition(vet, l, r); //partition solita, solo con il massimo

            int k = m-l+1; //calcolo k con m-l+1

            if(i==k){ //se ho trovato, allora ritorno vet[l-1]
                
                return vet[i-1];
            } else { //senno..

                if(i>k){ //se la statistica e' maggiore, allora vado a destra del vettore, con una statisticfa i-k!
                    foundKMax(vet, m+1, r, i-k);
                } else if (i<k){
                    foundKMax(vet, l,  m-1, i); //senno' se piu' piccolo ci  vado constatitisca uguale, sulla parte sinistra del vettore!
                }
            }
            
        } else if (l==r){ //se l==r torno vet[l]
            return vet[l];
        }
       
        return vet[i-1]; //di base torno sempre i-1

    }


    public int partition(int [] vet, int l, int r){  //solita procedura di partiution, solo che per trovare il massimo, ho messo i piu' grandi prima del pivot e non i piu' piccoli!

        int x = vet[r];

        int i = l-1;

        for(int j=l; j<=r; j++){
            if(vet[j]>x){
                i++;

                
                int temp = vet[j];
                vet[j]= vet[i];
                vet[i]=temp;
            }
        }

        int temp = vet[r];
        vet[r]=vet[i+1];
        vet[i+1]=temp;

        return i+1;    

    }


    public static void main(String[] args) {

        int [] vet = {3, 2, 1, 5, 6, 4, 8}; //do' un vettore in ingresso

        kmax m = new kmax();

       int l =  m.foundKMax(vet, 0, vet.length-1, 1); //lo trovo

       System.out.println(l);
        
    }
    
}
