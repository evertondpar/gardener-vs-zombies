import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaDerrota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaDerrota extends TelaBase
{

    /**
     * Constructor for objects of class TelaDerrota.
     * 
     */
    public TelaDerrota(int pontuacao)
    {
        super("derrota.jpg");
        showText("Pontuação: " + pontuacao, getWidth()/2, getHeight()/4);
        Greenfoot.playSound("derrotado.mp3");
    }
    
    public void act(){
        iniciarJogo();
    }
}
