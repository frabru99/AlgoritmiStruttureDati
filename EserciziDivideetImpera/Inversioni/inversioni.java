package EserciziDivideetImpera.Inversioni;

public class inversioni {

    private int inv=0;


    public int findInv(int [] vet, int l, int r){


        if(l<r){

            int m = (l+r)/2;

            findInv(vet, l, m);
            findInv(vet, m+1, r);
            //inv += Inversions(vet, l, r, m); 
        } else if(l==r){ //se l==r
            int index =l; //mi salvo l'indice in una variabile

            while(index<vet.length-1){ //finchè index minore dell'utlimo elemento
                if(vet[index]>=vet[index+1]){ //confronto con quello dopo
                    System.out.println(vet[index] + "e " + vet[index+1]);
                    inv++; //aumento inversioni!
                }

                index++;
            }

        }



        return inv;
    }



    public static void main(String[] args) {

        int [] vet = {1, 3, 4, 3, 1, 0}; //da rivedere!

        inversioni i = new inversioni();

        System.out.println(i.findInv(vet, 0, vet.length-1));
        
    }
    
}
