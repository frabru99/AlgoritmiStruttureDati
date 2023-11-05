package Esercitazione2;
import java.util.ArrayList;

/**
 * Tree
 */
public class Tree {

    private ArrayList<Integer> tree;
    private int altezza;
    private int nodi;
    private ArrayList<Integer> foglia;


    public Tree(int h){
        altezza = h;
        nodi = (int) (Math.pow(2, h)-1);

        tree=new ArrayList<Integer>();
        foglia = new ArrayList<Integer>();

        
        for(int i=0; i< nodi; i++){ //ricorda che se il numero è pari resta lo stesso, sennò è diverso. 
            tree.add(i+1);
        }

        ArrayList<Integer> dispari = new ArrayList<Integer>();

        for(int i=0; i<nodi; i++){
            if(2*i+2> nodi){ //allora nodo foglia 
                if(tree.get(i)%2==0){
                    foglia.add(tree.get(i));
                } else {
                    dispari.add(tree.get(i));
                }
            }
        }

        foglia.addAll(dispari);

    
        stampaTree();

        System.out.println("\n");
        for(int l=0; l<foglia.size(); l++){
            System.out.printf("%d\t", foglia.get(l));
        }


    }


    public void stampaTree(){
        for(int i=0; i<nodi; i++){
            System.out.printf("%d\t", tree.get(i));
        }
    }


    public int findPositionSphere(int n){

        return (foglia.get(n%((nodi+1)/2)));

    }





    
}