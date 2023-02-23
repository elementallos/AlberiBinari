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
        int a[] = {
            
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
        int b[] = {
            4, 3, 5
        };
        
        
        // actual program -->
        Albero x = new Albero(new Nodo(b[0]));
        for(int n: b){
            x.inserisciNodo(n);
        }
        
        // test ->
        System.out.println("\n\n\n\n\n\t\tHey there!\n\n\n\n\n");
    }
}
