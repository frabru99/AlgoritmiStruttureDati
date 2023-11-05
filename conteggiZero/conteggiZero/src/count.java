import java.util.ArrayList;

public class count {
    
    private static int count =0;

    public count(){

    }


    public static int countsZero(ArrayList<Integer> vet, int l, int r){
        count =0;

        if(l<r){

            int m = (l+r)/2;

            count+= countsZero(vet, l, m);
            count+= countsZero(vet, m+1, r);
        } else if(vet.get(l)==0){
            return 1;
        } else {
            return 0;
        }



        return count;
    }


}