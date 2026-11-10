import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe que vai servir de base para todas as telas do jogo, assim
 * o tamanho da janela é definido em um só local.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaBase extends World
{

    /**
     * Constructor for objects of class TelaBase.
     * 
     */
    public TelaBase(String diretorioBackground)
    {    
        //Cria a tela com 1200x800 pixels
        super(1200, 800, 1); 
        carregarFundo(diretorioBackground);
        
    }
    
    private void carregarFundo(String diretorioImagem){
        //carrega a imagem
        GreenfootImage fundo = new GreenfootImage(diretorioImagem);
        
        //redimensiona a imagem para a largura do mundo
        fundo.scale(getWidth(), getHeight());
        
        //passa a imagem como fundo para o mundo
        setBackground(fundo);
    }
}
