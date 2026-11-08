import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Actor
{
    private int vida;
    private int velocidade;
    private int dano;
    
    public Inimigo(int vida, int velocidade, int dano){
        this.vida = vida;
        this.velocidade = velocidade;
        this.dano = dano;
    }
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
