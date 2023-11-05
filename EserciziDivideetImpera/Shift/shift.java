package EserciziDivideetImpera.Shift;

public class shift {

    private int max=0;



    public int maxValue(int [] vet, int l, int r){

        if(l<r){

            int m = (l+r)/2;


            maxValue(vet, l, m);
            maxValue(vet, m+1, r);

        } else if (l==r){
            if(vet[l]>max){
                max=vet[l];
            }
        }
 
        return max;

    }




    public static void main(String[] args) {
        



        //preso un array ordinato, shiftato di tot posti, ad esempio 
        //con k =2

        int [] vet = {15, 18, 28, 30, -78, 56, 1, 7};

        shift s = new shift();
        //trovare il massimo in tempo O(logn)
        System.out.println("Il massimo è: "+ s.maxValue(vet, 0, vet.length-1));
    }
    
}
