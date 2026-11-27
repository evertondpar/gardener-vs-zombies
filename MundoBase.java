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
    private int pontuacao;
    private GreenfootSound musicaDeFundo = new GreenfootSound("musica_fundo.mp3");
    private boolean poderColetado; //controla se o jogador já pegou o poder
    private int temporizadorZumbis; //nascimento dos zumbis a cada periodo
    private Jardineiro jardineiro;
    //cronometro do jogo
    private static int tempo = 0;
    private static boolean contandoTempo = false;
    /**
     * Constructor for objects of class MundoBase.
     * 
     */
    public MundoBase(String background,int inimigosVivos, Jardineiro jardineiro, int pontuacao)
    {    
        super(background);
        this.inimigosVivos = inimigosVivos;
        this.inimigosNaTela = 0;
        this.pontuacao = pontuacao;
        this.poderColetado = false;
        this.temporizadorZumbis = 0;
        this.jardineiro = jardineiro;
    }
    
    protected void setJardineiro(Jardineiro novoJardineiro){
        this.jardineiro = novoJardineiro;
    }
    
    protected Jardineiro obterJardineiro(){
        return jardineiro;
    }
    
    public boolean obterPoderColetado(){
        return poderColetado;
    }
    
    public void setPoderColetado(boolean coletado){
        this.poderColetado = coletado;
    }
    
    public int obterTemporizadorZumbis(){
        return temporizadorZumbis;
    }
    
    public void setTemporizadorZumbis(int tempo){
        this.temporizadorZumbis = tempo;
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
        pararCronometro();
        musicaDeFundo.stop();
        Greenfoot.setWorld(new TelaDerrota(pontuacao, getTempo()));
    }
    
    public void executarVitoria() {
        pararCronometro();
        musicaDeFundo.stop();
        Greenfoot.setWorld(new TelaVitoria(pontuacao, getTempo()));
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
    
    public static void iniciarCronometro(){
        tempo = 0;
        contandoTempo = true;
    }
    
    public static void pararCronometro(){
        contandoTempo = false;
    }
    
    protected void atualizarCronometro(){
        if(contandoTempo){
            tempo++;
        }
        if(contandoTempo || tempo > 0){
            showText("Tempo: " + (tempo / 60) + "s", 1050, 30);
        }
    }
    
    public static int getTempo(){
        // retorna o tempo, divide por 60 pois 60 frames = 1 seg
        return tempo / 60; 
    }
}
