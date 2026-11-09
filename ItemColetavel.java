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

    public ItemColetavel (String imagemItem, String nomePoder){
        this.imagemItem = imagemItem;
        this.nomePoder = nomePoder;
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
    }
}
