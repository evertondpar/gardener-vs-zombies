/**
 * Write a description of class ZumbiForte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZumbiForte extends Inimigo 
{
    /**
     * Constructor for objects of class ZumbiForte
     */
    public ZumbiForte(){
        super(12, 1, 10, "zumbi_forte.png");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
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
