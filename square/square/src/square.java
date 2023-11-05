public class square {

    private static int i =0;

    private static int squareInt(int n){


        if(i*i>n){
            return i-1;
        }

        i++;
        return squareInt(n);

    }

    public static void main(String[] args) {


        System.out.println("La radice di 9 è: " + squareInt(9));
        
    }
    
}
