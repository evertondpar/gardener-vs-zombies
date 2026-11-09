import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInicial extends TelaBase
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TelaInicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super("telainicial.png"); 
    }
    
    //sobreescrita do método act do próprio greenfoot
    @Override
    public void act(){
        Greenfoot.setWorld(new FaseUm());
        iniciarJogo();
    }
    
    //identifica o clique da tecla enter e inica jogo
    public void iniciarJogo(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
