package EserciziDivideetImpera.colori;

public class colori {


    public void colorRecurrency(int [] vet, int l , int r){  //ricorrenze di un certo numero consecutive
        
        if(vet.length<3){
            return;
        }


        if(l<r){

            int m = (l+r)/2;

            colorRecurrency(vet, l, m);
            colorRecurrency(vet, m+1, r); //suddivisiuone solita

        } else if (vet[l]==1 && l<=vet.length-3){ //se il valore che sto prendendo nin considerazione in l = 1, 
            //e mi trovo in n una posizione in cui posso trovare 3 instanze
            

            if(vet[l+1]==1 && vet[l+2]==1){ //se li ho di seguito anche nei prossimi due v alori allora consecutivi!
                System.out.println("\nCi sono 3 istanze di rosso consecutive");
                System.out.printf("\nNelle posizioni da %d a %d", l, l+2);
                System.exit(0);
                
            }

            


        }

    }

    public static void main(String[] args) {

        int [] vet = {2, 2, 1, 1, 1};

        for (int i = 0; i < vet.length; i++) {
            System.out.printf("%d\t", vet[i]);
        }

        colori c = new colori();

        c.colorRecurrency(vet, 0, vet.length-1);

        
    }
    
}
