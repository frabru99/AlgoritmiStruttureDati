package Problem3n;

public class problem {



    public problem(){
    }


    public int function(int n1, int n2){

        int max_chain=0;
        int count =0;
        int n=0;

        
        for(int i = n1; i<=n2; i++){
            n = i;
            count = 0;
 

            while(n!= 1){

                if(n%2==0){
                    n = n/2;
                } else {
                    n = 3*n+1;
                }

                count++;

            }
            
            count++; //conto una volta in più per includere 1


            if(count> max_chain){
                max_chain=count;

            }

        }


        return max_chain;

    }


    
    
}
