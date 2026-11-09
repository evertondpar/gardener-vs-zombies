import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Actor
{
    private int vida;
    private int velocidade;
    private int dano;
    
    public Inimigo(int vida, int velocidade, int dano, String imagemInimigo){
        this.vida = vida;
        this.velocidade = velocidade;
        this.dano = dano;
        definirImagem(imagemInimigo);
    }
    
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    private void definirImagem(String diretorioImagem){
        GreenfootImage imagem = new GreenfootImage(diretorioImagem);
        imagem.scale(80, 120); 
        setImage(imagem);
    }
    
    public int obterDano(){
        return dano;
    }
    
    public int obterVelocidade(){
        return velocidade;
    }
    
    public void receberDano(int quantidadeDeDano){
        vida =vida- quantidadeDeDano;
        if (vida<=0) {
            FaseUm fase = (FaseUm) getWorld();
            // Zumbi rápido dá mais pontos
            if (this instanceof ZumbiForte) {
                fase.adicionarPontos(20);
            } else {
                fase.adicionarPontos(10);
            }
            getWorld().removeObject(this);
        }
    }
}
