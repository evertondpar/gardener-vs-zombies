import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Primeira fase do jogo, com n inimigos a eliminar para que libere a passagem
 * para a próxima fase.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseUm extends MundoBase
{

    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        super("fase1.png",5);
        montarCenario();
    }
    
    /**
     * Método para montar o cenário da primeira fase, adicionando o personagem
     * principal, item coletável para poder atirar o projetil e os inimigos.
     * 
     */
    private void montarCenario() {
        
        Jardineiro jardineiro = new Jardineiro();
        PoderVerde poderVerde = new PoderVerde();
        addObject(jardineiro, 300, 580);
        addObject(poderVerde, 600, 580);
        
        
    }
}
