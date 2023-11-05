
package EserciziDivideetImpera.ProdottoSottovettori;

/**
 * Prodotto
 * Classe di ricerca del prodotto massimo nei sottovettori 
 */
public class prodotto {

    private int max; //la classe ospita un massimo globale, un massimo sinistro e un destro, 
    private int maxs;
    private int maxd;
    private int prods; //variabili di appoggio per i prodotti sinistri e destri 
    private int prodd;
    


    public prodotto(){ //inizializzo i prodotti e i massimi
        max=1;
        maxs=1;
        maxd=1;
        prods=1;
        prodd=1;
    }


    /**
     * This function returns the max product in the subarrays
     * @param vet,l,r 
     * @return the max products betwenn all subarrays.
     */

    public int prodMax(int [] vet, int l, int r){

        if(l<r){  //solita funzione divide et impera 

            int m = (l+r)/2;

            prodMax(vet, l, m);
            prodMax(vet, m+1, r);
            max = findProdMax(vet, l, r, m);
        }

        return max; //ritorno il massimo

    }

    /**
     * 
     * @param vet array
     * @param l left index
     * @param r right index
     * @param m medium
     * @return local maximum
     */

    private int findProdMax(int [] vet, int l, int r, int m) {

        maxs=1;
        maxd=1;
        prods=1;
        prodd=1; //inizializzo sempre tutti a 1

        for(int i = m; i>=l; i--){  //vado dal centro in giù
            prods*=vet[i]; //salvo i prodotti

            if(prods>maxs){ //se magigorni del maxs
                maxs=prods; //lo assegno
            }
        }

        for(int j = m+1; j<r; j++){ //faccio lo stesso col sotto vettore destro 
            prodd *= vet[j]; // calcolo

            if(prodd>maxd){ //se è maggiore del maxd 
                maxd=prodd; //assegno a maxd
            }

        }


        if(maxs*maxd>=max){ //se il prodotto dei due è maggiore del massimo, glielo affido. 
            max=maxs*maxd;
        } 

        System.out.println(max +", "+ maxs + maxd);
        return max;
        
    }


    public static void main(String[] args) {

        prodotto p = new prodotto();
        int [] vet = {-50, -3, -10, 6};

        System.out.println("prodotto max: " + p.prodMax(vet, 0, vet.length));
        
    }

    
}

