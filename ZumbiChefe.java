import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZumbiChefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZumbiChefe extends Inimigo
{
    
    public ZumbiChefe(){
        super(20, 1, "zumbi_gigante_completo.png");
    }
    /**
     * Act - do whatever the ZumbiChefe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
    
    @Override
    public void receberDano(int quantidadeDano){
        int vidaAtual = obterVida();
        
        if(vidaAtual > 0 && (vidaAtual - quantidadeDano) <= 0){
            getWorld().addObject(new Trofeu(), getX(), getY());
            Greenfoot.playSound("monstro_morrendo.mp3");
        }
        
        super.receberDano(quantidadeDano);
        
        if(obterVida() > 0){
            atualizarImagem();
        }
    }

    private void atualizarImagem(){
        int vida = obterVida();
        if(vida <= 13 && vida > 7){
            definirImagem("zumbi_gigante_sem_placa.png");
        }else if(vida <= 7){
            definirImagem("zumbi_gigante_final.png");
        }
    }
}
