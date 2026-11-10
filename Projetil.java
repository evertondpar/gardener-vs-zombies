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
    private String tipoProjetil; //guarda se é verde ou azul
    private static int velocidade = 3;
    
    public Projetil(String imagemProjetil, String tipoProjetil){
        this.imagemProjetil = imagemProjetil;
        this.tipoProjetil = tipoProjetil; //tipo do projetil
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
            //tanto verde quanto azul causam dano 3
            inimigoAtingido.receberDano(3);
            if(tipoProjetil.equals("azul")){
                inimigoAtingido.congelar();
            }
            getWorld().removeObject(this);
            return; //para aqui se ja escostou em um zumbi, senao testa o resto, dos obstaculos
        }
        Actor obstaculo = getOneIntersectingObject(Obstaculo.class);
        if(obstaculo != null){
            Obstaculo obstaculoAtingido = (Obstaculo) obstaculo;
            obstaculoAtingido.receberDano(1);
            getWorld().removeObject(this);
            return;
        }
    }
}
