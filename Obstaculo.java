import greenfoot.*;
/**
 * Write a description of class Obstaculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstaculo extends Actor 
{
    // instance variables - replace the example below with your own
    private int vidaObstaculo;

    /**
     * Constructor for objects of class Obstaculo
     */
    public Obstaculo(int vida, String imagemObstaculo){
        this.vidaObstaculo = vida;
        GreenfootImage imagem = new GreenfootImage(imagemObstaculo);
        imagem.scale(60,70);
        setImage(imagem);
    }

    public void act(){
        
    }
    
    public void receberDano(int dano){
        vidaObstaculo -= dano;
        Greenfoot.playSound("acerto_objeto.wav");
        if(vidaObstaculo <= 0){
            getWorld().removeObject(this);
        }
    }
}
