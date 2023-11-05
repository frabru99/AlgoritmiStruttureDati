package Esercizio3;

import java.util.Random;

public class node {

    private int key;
    private int priority;
    private node left;
    private node right;
    
    
    public node(int key){
        Random rand = new Random();

        this.key = key;
        priority = rand.nextInt(100);
        left = null;
        right =  null;
        System.out.println("Key:" +key + ", Priority:"+priority);
    }


    public int getKey() {
        return key;
    }



    public void setKey(int key) {
        this.key = key;
    }



    public int getPriority() {
        return priority;
    }



    public void setPriority(int priority) {
        this.priority = priority;
    }


    public node getLeft() {
        return left;
    }


    public void setLeft(node left) {
        this.left = left;
    }


    public node getRight() {
        return right;
    }


    public void setRight(node right) {
        this.right = right;
    }

    


    

    
}
