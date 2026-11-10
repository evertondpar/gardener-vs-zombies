import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Classe do mundo base para as fases, guardando a quantidade de inimigos
 * restantes a eliminar.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoBase extends TelaBase
{
    //quantidade de inimigos vivos na fase.
    private int inimigosVivos;
    private int inimigosNaTela;
    private boolean faseIniciada;
    private int pontuacao = 0;
    private GreenfootSound musicaDeFundo = new GreenfootSound("musica_fundo.mp3");
    /**
     * Constructor for objects of class MundoBase.
     * 
     */
    public MundoBase(String background,int inimigosVivos)
    {    
        super(background);
        this.inimigosVivos = inimigosVivos;
        this.inimigosNaTela = 0;
    }
    
    public void iniciarFase(){
        faseIniciada = true;
    }
    
    public boolean getFaseIniciada(){
        return faseIniciada;
    }
    
    public int getInimigosVivos() {
        return inimigosVivos;
    }
    
    public int getInimigosNaTela() {
        return inimigosNaTela;
    }
    
    public void decrementarInimigos() {
        if (inimigosVivos > 0) {
            inimigosVivos--;
            inimigosNaTela--;
        }
    }
    
    public void aumentarInimigosNaTela(int quantidade){
        inimigosNaTela += quantidade;
    }

    public void executarDerrota() {
        musicaDeFundo.stop();
        Greenfoot.setWorld(new TelaDerrota(pontuacao));
        Greenfoot.stop(); // Para o jogo imediatamente
    }
    
    public void executarVitoria() {
        musicaDeFundo.stop();
        Greenfoot.setWorld(new TelaVitoria(pontuacao));
        Greenfoot.stop(); // Para o jogo imediatamente
    }
    
    /**
     * Método que será chamado quando um zumbi morrer
     */
    public void adicionarPontos(int pontos) {
        pontuacao=pontuacao + pontos;
    }
    
    public void diminuirPontos(int pontos) {
        if(pontuacao > 0){
            pontuacao=pontuacao - pontos;
        }
    }
    
    public int getPontuacao(){
        return pontuacao;
    }
    
    public void iniciarMusica(){
        //toca a musica de fundo em loop
        if(!musicaDeFundo.isPlaying()){
            musicaDeFundo.setVolume(40);
            musicaDeFundo.playLoop();
        }
    }
}
