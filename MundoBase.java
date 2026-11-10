import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Classe do mundo base para as fases, guardando a quantidade de inimigos
 * restantes a eliminar.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoBase extends TelaBase
{
    //quantidade de inimigos vivos na fase.
    private int inimigosVivos;
    private int inimigosNaTela;
    private boolean faseIniciada;
    /**
     * Constructor for objects of class MundoBase.
     * 
     */
    public MundoBase(String background,int inimigosVivos)
    {    
        super(background);
        this.inimigosVivos = inimigosVivos;
        this.inimigosNaTela = 0;
    }
    
    public void iniciarFase(){
        faseIniciada = true;
    }
    
    public boolean getFaseIniciada(){
        return faseIniciada;
    }
    
    public int getInimigosVivos() {
        return inimigosVivos;
    }
    
    public int getInimigosNaTela() {
        return inimigosNaTela;
    }
    
    public void decrementarInimigos() {
        if (inimigosVivos > 0) {
            inimigosVivos--;
            inimigosNaTela--;
        }
    }
    
    public void aumentarInimigosNaTela(int quantidade){
        inimigosNaTela += quantidade;
    }
}
