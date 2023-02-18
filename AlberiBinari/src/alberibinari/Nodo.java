/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberibinari;

/**
 *
 * @author rdngrl05a04h501o
 */
public class Nodo {
    private int info;
    private Nodo SX = null;
    private Nodo DX = null;
    
    
    public Nodo(int info){
        this.info = info;
        this.SX = null;
        this.DX = null;
    }
    public Nodo(int info, Nodo SX, Nodo DX){
        this.info = info;
        this.SX = SX;
        this.DX = DX;
    }
    
    @Override
    public String toString(){
        String q = "";
        q += info;
        if(SX != null)
            q += "(" + SX + "),";
        else
            q += "(),";
        if(SX != null)
            q += "(" + DX + "),";
        else
            q += "(),";
        return q;
    }
    
    public int getInfo() {
        return info;
    }

    public Nodo getSX() {
        return SX;
    }

    public Nodo getDX() {
        return DX;
    }

    public void setSX(Nodo SX) {
        this.SX = SX;
    }

    public void setDX(Nodo DX) {
        this.DX = DX;
    }
}
