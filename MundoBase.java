import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MundoBase here.
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
    public MundoBase(int inimigosVivos)
    {    
        super("fase1.png");
        this.inimigosVivos = inimigosVivos;
    }
}
