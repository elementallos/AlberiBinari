/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberibinari;

import java.util.ArrayList;



/**
 *
 * @author rdngrl05a04h501o
 */
public class Albero {
    private Nodo root = null;
    
    public Albero(Nodo root){
        this.root = root;
    }
    
    
    // inserisci un nuovo nodo nell'albero
    public void inserisciNodo(int value){ inserisciNodo(root, value); }
    private void inserisciNodo(Nodo root, int value){
        if(root == null){
            root = new Nodo(value);
        }
        
        if(value > root.getInfo()){
            if(root.getDX() == null)
                root.setDX(new Nodo(value));
            else
                inserisciNodo(root.getDX(), value);
        }else{
            if(root.getSX() == null)
                root.setSX(new Nodo(value));
            else
                inserisciNodo(root.getSX(), value);
        }
    }
    
    
    // trova altezza massima dell'albero
    public int getAltezza(){ return getAltezza(root); }
    private int getAltezza(Nodo root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = getAltezza(root.getSX());
            int rightDepth = getAltezza(root.getDX());
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    
    
    // trova la posizione di un nodo (livello)
    public int getNodo(int valore){ return getNodo(root, valore); }
    private int getNodo(Nodo root, int info){
        if (root == null) {
            return -1;
        }
        if (root.getInfo() == info) {
            return 0;
        }
        
        int leftDepth = getNodo(root.getSX(), info);
        if (leftDepth >= 0) {
            return leftDepth + 1;
        }
        
        int rightDepth = getNodo(root.getDX(), info);
        if (rightDepth >= 0) {
            return rightDepth + 1;
        }
        
        return -1; // se il nodo non esiste, ritorna un messaggio di errore (int: -1)
    }
    
    
    // conta tutte le foglie di un albero
    public int contaFoglie(){ return contaFoglie(root); }
    private int contaFoglie(Nodo root){
        if (root == null) {
            return 0;
        }
        
        if (root.getSX() == null && root.getDX() == null) {
            return 1;
        }
        
        int leftLeaves = contaFoglie(root.getSX());
        int rightLeaves = contaFoglie(root.getDX());
        return leftLeaves + rightLeaves;
    }
    
    
    // conta il numero di nodi intermedi data una certa radice
    public int contaNodi(){ return contaNodi(root); }
    public int contaNodi(int valore){ return contaNodi(trovaNodo(root, valore)); }
    private int contaNodi(Nodo root){
        if (root == null) {
            return 0;
        }
        
        int leftCount = contaNodi(root.getSX());
        int rightCount = contaNodi(root.getDX());
        
        return 1 + leftCount + rightCount;
    }
    
    
    // trova un nodo nell'albero
    private Nodo trovaNodo(Nodo root, int valore){
        if (root == null) {
            return null;
        }
        if (root.getInfo() == valore) {
            return root;
        }
        
        Nodo leftResult = trovaNodo(root.getSX(), valore);
        if (leftResult != null) {
            return leftResult;
        }
        
        return trovaNodo(root.getDX(), valore);
    }
    
    
    // visita l'albero in ordine decrescente
    public void visitaDecrescente(){ visitaDecrescente(root); }
    private void visitaDecrescente(Nodo root){
        if(root != null){
            visitaDecrescente(root.getDX());
            System.out.println(root.getInfo() + " ");
            visitaDecrescente(root.getSX());
        }
    }
    
    
    /*      TRUE: foglie allo stesso livello
            FALSE: foglie a livelli sfalsati        */
    public boolean livelloFoglieUguale(){ return livelloFoglieUguale(root); }
    private boolean livelloFoglieUguale(Nodo root){
        if (root == null) {
            return true;
        }
        
        ArrayList<Nodo> queue = new ArrayList<>();
        ArrayList<Integer> levels = new ArrayList<>();
        queue.add(root);
        levels.add(0);
        int expectedLevel = -1;
        int firstLeafLevel = -1;
        int i = 0;
        while (i < queue.size()) {
            Nodo node = queue.get(i);
            int level = levels.get(i);
            i++;
            if (node.getSX() == null && node.getDX() == null) {
                if (firstLeafLevel == -1) {
                    firstLeafLevel = level;
                } else if (level != firstLeafLevel) {
                    return false;
                }
            }
            if (node.getSX() != null) {
                queue.add(node.getSX());
                levels.add(level + 1);
            }
            if (node.getDX() != null) {
                queue.add(node.getDX());
                levels.add(level + 1);
            }
        }
        return true;
    }
    
    
    // stampa tutti gli antenati
    public void stampaAntenati(){ System.out.println("Nodo \"root\" (albero) non ha antenati"); }
    public void stampaAntenati(int valore){ stampaAntenati(trovaNodo(root, valore)); }
    private void stampaAntenati(Nodo node) {
        if (root == null || node == null) {
            return;
        }
        
        ArrayList<Nodo> antenati = new ArrayList<>();
        trovaAntenati(root, node, antenati);
        for (Nodo antenato : antenati) {
            System.out.print(antenato.getInfo() + " ");
        }
    }
    
    private boolean trovaAntenati(Nodo corrente, Nodo nodo, ArrayList<Nodo> antenati) {
        if (corrente == null) {
            return false;
        }
        if (corrente == nodo) {
            return true;
        }
        if (trovaAntenati(corrente.getSX(), nodo, antenati) || trovaAntenati(corrente.getDX(), nodo, antenati)) {
            antenati.add(corrente);
            return true;
        }
        return false;
    }


    // cerca un nodo che abbia due figli uguali
    public boolean haDueFigliUguali(){ return haDueFigliUguali(root); }
    private boolean haDueFigliUguali(Nodo root) {
        if (root == null) {
            return false;
        }
        return haDueFigliUguali(root.getSX(), root.getDX()) || haDueFigliUguali(root.getSX()) || haDueFigliUguali(root.getDX());
    }

    private boolean haDueFigliUguali(Nodo nodo1, Nodo nodo2) {
        if (nodo1 == null || nodo2 == null) {
            return false;
        }
        return nodo1.getInfo() == nodo2.getInfo() || haDueFigliUguali(nodo1.getSX(), nodo2.getSX()) || haDueFigliUguali(nodo1.getDX(), nodo2.getDX());
    }


    
    
    
    
    
    
    // visite -->
    public void preOrder(){ preOrder(root); }
    private void preOrder(Nodo root){
        if(root != null){
            System.out.println(root.getInfo() + " ");
            postOrder(root.getSX());
            postOrder(root.getDX());
        }
    }
    
    public void postOrder(){ postOrder(root); }
    private void postOrder(Nodo root){
        if(root != null){
            postOrder(root.getSX());
            postOrder(root.getDX());
            System.out.println(root.getInfo() + " ");
        }
    }
    
    public void inOrder(){ inOrder(root); }
    private void inOrder(Nodo root){
        if(root != null){
            postOrder(root.getSX());
            System.out.println(root.getInfo() + " ");
            postOrder(root.getDX());
        }
    }
}
