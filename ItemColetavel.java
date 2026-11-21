import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe base para os itens coletáveis do jogo, guardando a imagem do item,
 * seu nome para ser identificado na classe Jardineiro e o método para remove-lo
 * normalmente ao pegá-lo.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemColetavel extends Actor
{
    private String imagemItem;
    private String nomePoder;
    private int tempo;
    private int velocidadeY;

    public ItemColetavel (String imagemItem, String nomePoder){
        this.imagemItem = imagemItem;
        this.nomePoder = nomePoder;
        this.tempo = 0;
        this.velocidadeY = 2;
        GreenfootImage imagem = new GreenfootImage(imagemItem);
        imagem.scale(40, 40); 
        setImage(imagem);
    }

    /**
     * Remove o item do mundo.
     */
    public void removerItem () {
        World mundo = getWorld();
        mundo.removeObject(this);
    }

    /**
     * Retorna o nome do item.
     */
    public String getNomePoder(){
        return nomePoder;
    }

    /**
     * Act - do whatever the ItemColetavel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
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
