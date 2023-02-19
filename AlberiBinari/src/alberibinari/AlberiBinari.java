/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberibinari;

import java.util.Random;

/**
 *
 * @author rdngrl05a04h501o
 */
public class AlberiBinari {

    public static void main(String[] args) {
        
        Random random = new Random();
        int randNodo = random.nextInt(100);
        
        // random arrays for testing
        int oneTo100[] = {
            
            22, 66, 83, 77, 32, 54, 60, 90, 45, 12, 
            34, 73, 27, 58, 89, 38, 59, 17, 14, 35, 
            19, 94, 61, 29, 9, 79, 15, 8, 64, 98, 43, 
            71, 76, 56, 47, 95, 5, 96, 40, 65, 84, 86, 
            11, 72, 46, 21, 69, 88, 55, 50, 39, 53, 
            30, 42, 20, 87, 67, 48, 28, 62, 74, 41, 
            25, 75, 51, 91, 10, 85, 3, 78, 81, 13, 
            52, 68, 99, 36, 16, 57, 7, 6, 18, 1, 44, 
            97, 23, 2, 0, 24, 31, 70, 92, 4, 
            49, 80, 33, 63, 37, 26

        };
        int randomArr[] = {
            1, 6, 7, 2, 0, 4, 7, 2, 4, 8, 5, 3, 4, 1, 9
        };
        
        
        // actual program -->
        Albero x = new Albero(new Nodo(oneTo100[0]));
        for(int n: oneTo100){
            x.inserisciNodo(n);
        }
        
        // stampa l'altezza dell'albero
        System.out.println("Altezza dell\'albero: " + x.getAltezza());
        
        // stampa la posizione di un nodo (livello)
        System.out.println("(int)Nodo: " + randNodo + " al livello  " + x.getNodo(randNodo));
        
        // stampa il numero di foglie (nodi senza successori / figli)
        System.out.println("Numero totale di foglie dell'albero: " + x.contaFoglie());
        
        // stampa il numero di nodi intermedi, dato un nodo
        System.out.println("Nodi intermedi di (int)Nodo: " + randNodo + " --> " + x.contaNodi(randNodo));
        
        // le foglie sono allo stesso livello?
        System.out.println("Foglie allo stesso livello: " + x.livelloFoglieUguale());
        
        // stampa antenati di un certo nodo (dato il valore int)
        System.out.println("\nAntenati di (int)Nodo: " + randNodo);
        x.stampaAntenati(randNodo);
        
        // ci sono nodi con due figli uguali?
        System.out.println("\nNodi con 2 figli identici (boolean): " + x.haDueFigliUguali());
        
        // elimina nodi
        x.eliminaNodi(randNodo);
        System.out.println("\nEliminati nodi sotto (int)Nodo: " + randNodo);
        
        // ci sono nodi con due figli uguali?
        System.out.println("(int)Somma di tutti i valori dei nodi dell'albero: " + x.sommaValoriNodi());
        
        // end program
        System.out.println();
    }
}
