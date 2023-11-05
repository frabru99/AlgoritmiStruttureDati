package EserciziDivideetImpera.PuntoFisso;

public class fisso {

    public static int count=0;

    public static int findFisso(int[] vet, int l, int r){


        if(l<r){

            int m = (l+r)/2;

            count = findFisso(vet, l, m);
            count = findFisso(vet, m+1, r);
        } else if (l==r){
            if(vet[l]==l){
                count++;
            }
        }

        return count;

    }



    public static void main(String[] args) {

        int [] vet = {0, 2, 2, 3, 4};
        

        int cont = findFisso(vet, 0, vet.length-1);

        System.out.println(cont);
    }
    
}
