import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Item Poder Verde, que concede ao jogador a habilidade de atirar projéteis
 * verde nos inimigos.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoderVerde extends ItemColetavel
{
    private int tempo = 0;
    private int velocidadeY = 2;
    
    public PoderVerde (){
        super("projetil_padrao.png", "poderVerde");
    }
    
    /**
     * Act - do whatever the PoderVerde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        mover();
    }
    
    /**
     * Faz o item ficar quicando no mapa para chamar atenção do jogador.
     */
    public void mover() {
        // muda o eixo y
        setLocation(getX(), getY() + velocidadeY);
        tempo++;

        // quando mudar 20 vezes inverte, fazendo o efeito de pulo
        if (tempo >= 20) {
            velocidadeY = velocidadeY * -1;
            tempo = 0; 
        }
    }
}
