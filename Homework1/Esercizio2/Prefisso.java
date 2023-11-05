package Esercizio2;

import java.util.ArrayList;

public class Prefisso {  
    


    private ArrayList<String> stringhe;
    private int dim;



    public Prefisso(int dim, ArrayList<String> stringhe){  //costruttore 
        this.dim =dim;
        this.stringhe = stringhe;

        stampaVect();
    }


    public void stampaVect(){ // funzione di stampa

        for(int i=0; i<dim; i++){
            System.out.printf("%s\t", stringhe.get(i));
        }
    }


    public String divide(int l, int r){  //funzione di divide
        String prefix = ""; //azzero ad ogni chiamata il prefisso

        
        if(l<r){ //se ho l < r
            int m = ((l+r)/2);

            String s1=divide(l, m); //chiamate ricorsive sulle due parti del vettore 
            String s2=divide(m+1, r);
            prefix = findPrefix(s1, s2); //trovo i prefissi

        } else if (l==r){ //nel caso base torno le stringhe 
            return stringhe.get(l);
        }

        return prefix; //ritorno il prefisso 
    }




    private String findPrefix(String s1, String s2){

        String prefix = ""; //lo azzero ogni volta 

        int min; //variabili di appoggio per il minimo tra le due stringhe 

        if(s1.length()< s2.length()){
            min = s1.length();
        } else {
            min = s2.length();
        }

        
        int i =0;
        while(i < min && s1.charAt(i)==s2.charAt(i)){  //con un while le confronto e torno poi il prefisso risultante
            prefix += Character.toString(s1.charAt(i));
            i++;
        }

       

        return prefix; //ritorno il prefisso 
    }

}
