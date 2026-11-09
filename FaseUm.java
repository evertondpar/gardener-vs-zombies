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
    private int pontuacao = 0;
    private int vida = 5 ;
    
    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        super("fase1.png",5);
        montarCenario();
        iniciarFase();
    }
    
    public void act(){
        if(getFaseIniciada()){
            showText("Se prepare! Os zumbis estão chegando!", 600, 50);
            showText("Pontos: "+ pontuacao, 100, 30);
            showText("Vida : " + vida, 100, 50);
        }
    }
    
    public void perderVida() {
        vida--;
        if (vida <= 0) {
            showText("DERROTA! Os zumbis invadiram!", getWidth()/2, getHeight()/2); //adiciona no meio
            Greenfoot.stop(); // Para o jogo imediatamente
        }
    }
    
    /**
     * Método para montar o cenário da primeira fase, adicionando o personagem
     * principal, item coletável para poder atirar o projetil e os inimigos.
     * 
     */
    private void montarCenario() {
        Zumbi zumbi = new Zumbi();
        Jardineiro jardineiro = new Jardineiro();
        PoderVerde poderVerde = new PoderVerde();
        
        addObject(jardineiro, 300, 580);
        addObject(poderVerde, 600, 580);
        
        addObject(new Zumbi(), 1050, 300);
        addObject(new Zumbi(), 1100, 500);
        addObject(new ZumbiForte(), 1150, 400);
    }
    
    /**
     * Método que será chamado quando um zumbi morrer
     */
    public void adicionarPontos(int pontos) {
        pontuacao=pontuacao + pontos;
    }
}
