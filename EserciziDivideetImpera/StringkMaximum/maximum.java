package EserciziDivideetImpera.StringkMaximum;

public class maximum {


    public void quickSort(String [] array, int l, int r){
        
        
        if(l<r){

            int m = partition(array, l, r);
            quickSort(array, l, m-1);
            quickSort(array, m+1, r);


        }
    }


    private int partition(String [] array, int l, int r){
        String x = array[r];

        int i = l-1;

        for(int j=l; j<r; j++){
            if(Integer.valueOf(array[j])<Integer.valueOf(x)){
                i++;

                String temp = array[j];
                array[j]=array[i];
                array[i]=temp;

            }

        }


        String temp = array[r];
        array[r]=array[i+1];
        array[i+1]=temp;

        return i+1;
    }




    public static void main(String[] args) {
        

        String [] array = {"9", "5", "7", "8"};


        int k =4;


        maximum m = new maximum();

        m.quickSort(array, 0, array.length-1);

        System.out.println("Massimo di ordine " + k +": " + array[array.length-k]);

    }
    
}
