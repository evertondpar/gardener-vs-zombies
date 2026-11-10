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
    
    public void act(){
        super.act();
        alinharComJardineiro();
        
    }
    
    private void alinharComJardineiro(){
        java.util.List<Jardineiro> jardineiros = getWorld().getObjects(Jardineiro.class);
        if (!jardineiros.isEmpty()) {
            Jardineiro jardineiro = jardineiros.get(0);
            if (jardineiro.getY() > getY()) {
                setLocation(getX(), getY() + 1);
            } else if (jardineiro.getY() < getY()) {
                setLocation(getX(), getY() - 1);
            }
        }
    }
}
