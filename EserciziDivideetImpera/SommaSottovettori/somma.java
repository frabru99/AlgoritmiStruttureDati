package EserciziDivideetImpera.SommaSottovettori;

public class somma {

    public static int max= 0; //variabili di supporto
    public static int maxs=0;
    public static int maxd=0;
    public static int sum1=0;
    public static int sum2=0;
    
    

    public static int maxSum(int[] vet, int l, int r){
        
    
        if(l<r){

            int m= (l+r)/2; //se l<r

            maxSum(vet, l, m);
            maxSum(vet, m+1, r);
            max=impera(vet, l, r, m);            
        }


        return max;

    }

    
    public static int impera(int [] vet, int l , int r, int m){

        
        sum1=0;  //inizializzo a 0 ad ogni chiamata della funzione impera
        sum2=0;
        maxs=0;
        maxd=0;

        
        
        
        for(int k = m; k>=l; k--){ //sommo tutto qurllo che c'è dal punto medio in giù, e mi prendo il massimo valore, fino a l, quindi decremento
            sum1+=vet[k]; 

            if(sum1>maxs){ //massimo della somma dei sotto vettori di sinistra
                maxs=sum1;
            }

        }


        for(int g =m+1; g<r; g++){ //invece qui lo faccio da m+1 fino a r, e trovo la massima somma 
            sum2+=vet[g];
            
            if(sum2>maxd){ 
                maxd=sum2;
            }
        }

        
        

        System.out.println("Mezzo: " + maxs+maxd);

    
        if(maxs+maxd>=max){ //ma se la somma dei due è il massimo, pongo il massimo alla loro somma
            max = maxs+maxd;
        } else if (maxs>=maxd+maxs && maxs>=max){
            max = maxs;
        } else if(maxd>=maxd+maxs && maxd>=max){
            max=maxd;
        }

       

        
        return max; //torno max

    }


    public static void main(String[] args) {


        int [] vet = {-2, -7, 1, 1, 2, 10, -2}; //vettore di prova 

        int val = maxSum(vet, 0, vet.length); //avvio la funzione sul vettore 

        System.out.println("Massima somma= " + val); //stampo
        
    }


    
    
}
