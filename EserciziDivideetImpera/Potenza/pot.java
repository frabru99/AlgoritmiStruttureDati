package EserciziDivideetImpera.Potenza;

public class pot {

   public  int pow =1;

    public int potenza(int a, int n){


        if(n>1){

            pow*=potenza(a, n/2);

        } else if (n==1) {
            return a;
        }
        
        if(n%2==0){
            return pow*pow;
        } else {
            return a*pow*pow;
        }
    }




    public static void main(String[] args) {


        pot p = new pot();


        System.out.println(p.potenza(2, 10));
        
    }
    
}
