/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;


/**
 *
 * @author julia_000
 */
public class Cardapio {
    private String lancheManha;
    private String almoco;
    private String lancheTarde;
    private String janta;
    private String Ceia;
    private int cp = 0;
    
    
    public Cardapio(){
        this.cp = cp+1;
    }
    
    public Cardapio (String lm, String a, String lt, String j, String ln, int cp){
        this.lancheManha = lm;
        this.almoco = a;
        this.lancheTarde = lt;
        this.janta = j;
        this.Ceia = ln;
        this.cp = cp;
    }

    public String getLancheManha() {
        return lancheManha;
    }

    public String getAlmoco() {
        return almoco;
    }

    public String getLancheTarde() {
        return lancheTarde;
    }

    public String getJanta() {
        return janta;
    }
    
    public String getCeia(){
        return Ceia;
    }

    public int getCp() {
        return cp;
    }

    public void setLancheManha(String lancheManha) {
        this.lancheManha = lancheManha;
    }

    public void setAlmoco(String almoco) {
        this.almoco = almoco;
    }

    public void setLancheTarde(String lancheTarde) {
        this.lancheTarde = lancheTarde;
    }

    public void setJanta(String janta) {
        this.janta = janta;
    }

    public void setCeia(String Ceia) {
        this.Ceia = Ceia;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
    
    
    
    
}
