package BST;

public class bst {

    private node root;
    private int dim;

    public bst(){ //costruttore del bst
        dim =0;
        root = null;
    }


    public void initializeBST(){ //prima inizializzazione, costante di complessità 
        if(dim==0 && root==null){ //se non è stato mai inizializzato
            root = new node(); //creo il nuovo nodo con un valore casuale e lo dò alla radice 
            dim++; //aumento la dimensione 
            System.out.println("radice inizializzata!");
            return; //torno
        }

        System.out.println("Già inizializzato!"); //sennò già inizializzato, singleton
    }

    


    public void stampaBSTinorder(node x){ //stampa del BST, O(n)

        if(x!=null){ //finchè non è nullo
            stampaBSTinorder(x.getLeft()); //vado tutto a sinistra 

            if(x.getRight()!=null && x.getLeft() != null){ //stampo nei vari casi possibili, con due nodi, con un singolo e senza
                System.out.println("key: " + x.getKey() + " | left: " +x.getLeft().getKey() + " | right: "+x.getRight().getKey());

            } else if(x.getRight()!=null && x.getLeft() == null){
                System.out.println("key: " + x.getKey() + " | right: "+x.getRight().getKey());
  
            } else if(x.getRight()==null && x.getLeft() != null){
                System.out.println("key: " + x.getKey() + " | left: " +x.getLeft().getKey());
            } else {
                System.out.println("key: " + x.getKey());
            }


            stampaBSTinorder(x.getRight()); //vado tutto a destra
        }

    }




    //complessità O(h)
    public node search(int k, node x){ //ricerca, inizialmente dò una chiave k e root
        if( x == null || k == x.getKey()){ //se trovo x nullo, o ho trovato il valore con la stessa chiave, ritorno x
            return x;

        } else if(k<x.getKey()){ //invece se k < del valore di x allora ritorno la chiamata sul valore di sinistra 
            return search(k, x.getLeft());
        } 

        return search(k, x.getRight()); //sennò sul valore di destra 
        
    }

    //complessità O(h)
    public node min(node x){ //minimo 
        if(x.getLeft()!=null){ //finchè quello di sinistra non diventa nullo
            return min(x.getLeft()); //scendo tutto a sinistra 
        }
        
        return x; //ritorno x appena esco dall'if

    }

    //complessità O(h)
    public node max(node x){

        if(x.getRight()!=null){ //se quello di sinistra non è nullo
            return max(x.getRight()); //scendo 
        }

        return x; //ritorno x appena termino la discesa 
    }

    //complessità O(h)
    public node successore(int k){ //sennò prendere un valore e fare search 
        node x = search(k, root); //cerco il nodo di cui devo trovare il successore 

        
        if(x==null){ //se nullo torno errore 
            System.out.println("Non ho trovato l'elemento!");
            return null;
        } else {
            System.out.println("Trovato con chiave: "+x.getKey());
        }

        node y = null; //nodo di appoggio

        if(x.getRight()!=null){ //se ho l'albero di destra, è il suo minimo 
            return min(x.getRight()); //minimo del sottoalbero destro 
        } else { //sennò p visto come il genitore più basso che ha come figlio sinistro un aantenato di x 
            y = x.getFather(); //prendo il padre 

            while(y!=null && x==y.getRight()){ //itero finchè non è nullo e finchè non cade il fatto che sia figlio destro (finisce appena o nullo o è figlio sinistro)
            x=y; //passaggio in alto
            y=y.getFather();
            }
        }

        return y; //torno il successore
    }

    //complessità O(h)
    public void inserisci(int k){ //per inserire

        node l = search(k, root);

        if(l!=null){
            System.out.println("Elemento già presente!");
            return;
        }

        node y=null; //nodo di appoggio
        node x=root; //nodo radice 
        node z = new node(k); //nodo che devo inserire con costruttore a partire dall'elemento 

        while(x!=null){ //finchè non trovo x nullo, scorro fino alla fine dell'albero 
            y=x; //passo

            if(z.getKey()<x.getKey()){ //confronto, e scendo nella direzione giusta, se k<x.key allora sinistra, sennò destra 
                x = x.getLeft();
            } else{
                x=x.getRight();
            }
        }

        z.setFather(y); //arrivato in posizione assegno il padre di z ì, con y 

        if(y==null){ //se è radice, la cambio in z
            root = z;
        } else if(z.getKey()<y.getKey()){ //se invece è più piccolo lo lego a sinistra
            y.setLeft(z);

        } else if(z.getKey()>y.getKey()){ //sennò a destra, di y
            y.setRight(z);
        }


        dim++; //aumento la dimensione (facoltativo)


    }

    //complessità O(h)
    public node delete(int k){
        node z = search(k, root); //elemento da eliminare, lo cerco 

        if(z==null){
            System.out.println("Elemento da eliminare non trovato!"); //se non lo ho, ritorno nullo
            return null;
        }

        node y = null; //nodi di appoggio
        node x = null;


        if(z.getLeft()==null || z.getRight()==null){ //se uno dei due figli è null, ne ho uno o nessuno, primi due casi
            y = z;
        } else { //li ho entrambi, terzo caso 
           y = successore(z.getKey());
        }

        if(y.getLeft()!=null){ //se non è nullo allora posso affidare uno dei due figli non nulli
            x = y.getLeft();
        } else {
            x= y.getRight();
        }

        if(x!=null){ //se ho uno o due figli, collego giaà il figlio preso con il padre del nodo
            x.setFather(y.getFather());
        }

        //risoluzioni
        if(y.getFather() == null){ //se il padre di y è nullo allora radice 
            root = x; //do ad x la radice 

        } else if (y == y.getFather().getLeft()){ //se è un figlio di sinistra
            y.getFather().setLeft(x); //set come figlio sinistro (sostituendo y)
        } else { //se figlio di destra
            y.getFather().setRight(x); //set come figlio destro (sostituendo y)

        } 


        if(y!=z){ //ultimo caso, solo quando ho tutti e due i figli 
            z.setKey(y.getKey());
            z.setLeft(y.getLeft());
            z.setRight(y.getRight());
            z.setFather(y.getFather());
        }

        return y; //ritorno elemento eliminato!
    }

    public node getRoot() {
        return root;
    }


    public void setRoot(node root) {
        this.root = root;
    }


    public int getDim() {
        return dim;
    }


    public void setDim(int dim) {
        this.dim = dim;
    }






}
