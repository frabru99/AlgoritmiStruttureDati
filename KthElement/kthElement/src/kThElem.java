import java.util.ArrayList;

public class kThElem {


    //quicksort
    public static  void quickSort(ArrayList<Integer> vet,int l, int r){

        if(l<r){
            int m = partition(vet, l, r);
            quickSort(vet, l, m-1);
            quickSort(vet, m+1, r);
        }
    }


    public static int partition(ArrayList<Integer> vet, int l, int r){

        int x = vet.get(r);

        int i = l-1;

        for(int j=l; j<r; j++){
            if(vet.get(j)<=x){
                i++;
                int temp = vet.get(i);
                vet.set(i, vet.get(j));
                vet.set(j, temp);
            }
        }

        int temp = vet.get(r);
        vet.set(r, vet.get(i+1));
        vet.set(i+1, temp);

        return i+1;
    }


    public static int valueInPosition(ArrayList<Integer> a1, ArrayList<Integer> a2, int k){
        if(k-1> a1.size()+a2.size()){
            return -1;
        }


        int i = 0; 
        int l= 0;
        int min =-1;
        int max=-1;

        for(int j =0; j<a1.size()+a2.size(); j++){
            
        


            try{

            if(a1.get(i) < a2.get(l) ){
                    min = a1.get(i);
                    max= a2.get(l);
                    i++;  
            } else if(a1.get(i) > a2.get(l) ){
                    min= a2.get(l);
                    max=a1.get(i);
                    l++;
            } 


            } catch (IndexOutOfBoundsException e) {
                return max; //gesione dell'out of bound exception
            } 

 
            if(j==k-1){
                    return min;
            }




            
        }

        


        return -1;

    }








    public static void main(String[] args) {
        ArrayList<Integer> a1 =new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();


        a1.add(3);
        a1.add(2);
        a1.add(7);
        a1.add(9);
        a1.add(6);

        a2.add(8);
        a2.add(4);
        a2.add(1);
        a2.add(8);


        quickSort(a1, 0, a1.size()-1);
        quickSort(a2, 0, a2.size()-1);
        


        System.out.println("L'array a1 ordinato: " + a1.toString());
        System.out.println("L'array a2 ordinato: " + a2.toString());


        System.out.println("Lelemento nella posizione scelta è: " + valueInPosition(a1, a2, 9));


        



        
        
    }




    
}
