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

    /**
     * Constructor for objects of class MundoBase.
     * 
     */
    public MundoBase(String background,int inimigosVivos)
    {    
        super(background);
        this.inimigosVivos = inimigosVivos;
    }
}
