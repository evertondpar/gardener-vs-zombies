import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInstrucoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInstrucoes extends TelaBase
{

    /**
     * Constructor for objects of class TelaInstrucoes.
     * 
     */
    public TelaInstrucoes()
    {
        super("instrucoes.jpg");
    }
    
    public void act(){
        voltarParaTelaInicial();
    }
    
    //identifica o clique da tecla enter e inica jogo
    public void voltarParaTelaInicial(){
        if(Greenfoot.isKeyDown("backspace")){
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}
