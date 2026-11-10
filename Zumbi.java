import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zumbi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zumbi extends Inimigo
{
    public Zumbi(){
        super(6, 1, 10, "zumbi.png");
        
    }
    /**
     * Act - do whatever the Zumbi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act(); //chama a contagem de congelamento(sem isso nao estava funcionando)
        setLocation(getX() - obterVelocidade(), getY());
        if (getX() <= 0) {
            FaseUm fase = (FaseUm) getWorld();    
            // Faz o jardineiro/base perder 1 de vida
            fase.perderVida();
            getWorld().removeObject(this);
        }
    }
    
}
