import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaVitoria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaVitoria extends TelaBase
{

    /**
     * Constructor for objects of class TelaVitoria.
     * 
     */
    public TelaVitoria(int pontuacao, int tempo)
    {
        super("vitoria.jpg");
        showText("Pontuação: " + pontuacao, getWidth()/2, getHeight()/4);
        showText("Tempo: " + tempo + "s", getWidth()/2, getHeight()/4 + 40);
        Greenfoot.playSound("Vitoria.mp3");
    }
    
    public void act(){
        iniciarJogo();
    }
}
