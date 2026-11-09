import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe base para os projéteis, guardando informações
 * básicas como imagem e velocidade.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projetil extends Actor
{
    private String imagemProjetil;
    private static int velocidade = 2;
    public Projetil(String imagemProjetil){
        this.imagemProjetil = imagemProjetil;
        GreenfootImage imagem = new GreenfootImage(imagemProjetil);
        imagem.scale(20, 20); 
        setImage(imagem);
    }
    
    /**
     * Act - do whatever the Projetil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(8);
        verificarBorda();
        if (getWorld() == null) {
            return;
        }
        danoNoZumbi();
    }
    
    
    /**
     * Verifica se o projétil bateu na borda da tela e remove do mundo.
     */
    private void verificarBorda() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    
    private void danoNoZumbi(){
        Actor zumbi = getOneIntersectingObject(Inimigo.class);
        if (zumbi != null){
            Inimigo inimigoAtingido = (Inimigo) zumbi;
            inimigoAtingido.receberDano(2);
            getWorld().removeObject(this);
        }
    }
    
}
