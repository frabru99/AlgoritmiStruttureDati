package BST;

import java.util.Random;

public class node {

    private int key;
    private node right;
    private node left;
    private node father;
    private Random rand=new Random();



    public node(){
        key = rand.nextInt(10);
        right = null;
        left=null;
        father = null;
    }

    public node(int k){
        key = k;
        right = null;
        left=null;
        father = null;
    }


    public int getKey() {
        return key;
    }



    public void setKey(int key) {
        this.key = key;
    }



    public node getRight() {
        return right;
    }



    public void setRight(node right) {
        this.right = right;
    }



    public node getLeft() {
        return left;
    }



    public void setLeft(node left) {
        this.left = left;
    }



    public Random getRand() {
        return rand;
    }



    public void setRand(Random rand) {
        this.rand = rand;
    }

    public node getFather() {
        return father;
    }



    public void setFather(node father) {
        this.father = father;
    }


    
}
