package Esercizio3;

import java.util.ArrayList;

public class Treap {

    public ArrayList<Integer> keys;
    public ArrayList<Integer> priorities;

    public Treap(int dim){ 
        keys = new ArrayList<Integer>();
        priorities = new ArrayList<Integer>();
    }


    public node treapInsert(int key, node root){

        if(root==null){ //se non ho nulla allora devo inserire la radice
            node n = newNode(key);

            //controllo se l'elemento o la priorita' sono stati gia' inseriti
            if(keys.contains(n.getKey()) || priorities.contains(n.getPriority())){
                System.out.println("\nElemento o priorita' gia' presente!");
                return null;
            }

            priorities.add(n.getPriority());
            keys.add(n.getKey());

            return n;

        }
        //senno vado avanti in maniera ricorsiva


        if(key<root.getKey()){ //se la chiave data risulta minore dei quello della radice, lo inserisco
            //subito a sinistra 
            node left = treapInsert(key, root.getLeft());

            root.setLeft(left);


            //controllo se devo ristabilire la priorita' ogni volta che inserisco 
            if(root.getLeft()!=null){
                
                if(root.getLeft().getPriority() < root.getPriority()){ //priorita' superiore minore
                    root = spostaDestra(root); //"ruoto a destra l'albero", traslo gli elementi a destra per ristabilire l'ordine
                }
            }


        } else { //qui invece devo fare lo stesso ma a destra

            node right = treapInsert(key, root.getRight());

            root.setRight(right);

            if(root.getRight() != null){
                if(root.getRight().getPriority() < root.getPriority()){
                    root = spostaSinistra(root);
                }
            }

        }

        return root;

       
    }

    public node newNode(int key){ //creo un nuovo nodo
        node n = new node(key);
        return n;
    }

    public node spostaDestra(node y){

        node x = y.getLeft();
        node t = x.getRight();


        x.setRight(y);
        y.setLeft(t);

        return x;
    }

    public node spostaSinistra(node x){
        node y = x.getRight();
        node t = y.getLeft();
        
        
        y.setLeft(x);
        x.setRight(t);

        return y;
    }


    public void stampaTreap(node root){

        if (root != null)
        {
            stampaTreap(root.getLeft());
            System.out.print("key: " + root.getKey() + " | priority: " + root.getPriority());
            if (root.getLeft() != null)
                System.out.print(" | left child: " + root.getLeft().getKey());
            if (root.getRight()!= null)
                System.out.print(" | right child: " + root.getRight().getKey());
            System.out.println();
            stampaTreap(root.getRight());
        }

    }


    
}
