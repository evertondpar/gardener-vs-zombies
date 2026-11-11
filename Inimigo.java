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
    private int velocidadeOriginal; //guarda a velocidade com que o zumbi nasceu para o congelamento acabar
    private int dano;
    private int tempoCongelado = 0;
    private int direcaoDesvio = 0; //usado para o zumbi desviar de um obstaculo criado
    private static final int VELOCIDADE_DESVIO = 5;
    
    public Inimigo(int vida, int velocidade, int dano, String imagemInimigo){
        this.vida = vida;
        this.velocidade = velocidade;
        this.velocidadeOriginal = velocidade;
        this.dano = dano;
        definirImagem(imagemInimigo);
    }
    
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(verificarInvasao()){
            return;
        }
        
        mover();
        
        //condicao para descongelar o zumbi, depois de um tempo(5s)
        if(tempoCongelado > 0){
            tempoCongelado--;
            if(tempoCongelado == 0){
                //volta para a velocidade que ele tinha
                velocidade = velocidadeOriginal;
            }
        }
    }
    
    private void mover(){
        // se está desviando, continua o desvio (0 = esta andando)
        if(direcaoDesvio != 0){
            desviar();
            return;
        }
        int xAntigo = getX();
        setLocation(xAntigo - obterVelocidade(), getY());
        //se bater na lápide, escolhe um lado aleatório para desviar
        if(isTouching(Obstaculo.class)){
            setLocation(xAntigo, getY());
            direcaoDesvio = (Greenfoot.getRandomNumber(2) == 0) ? -1 : 1;
        }
    }
    
    private void desviar(){
        int novoY = getY() + direcaoDesvio * VELOCIDADE_DESVIO;

        // se chegou no limite do mapa, inverte o lado para nao agarrar
        if(novoY < 150 || novoY > 640){
            direcaoDesvio = -direcaoDesvio;
            return;
        }
        setLocation(getX(), novoY);

        // a cada frame tenta voltar a andar para a esquerda
        int xAntigo = getX();
        setLocation(xAntigo - obterVelocidade(), getY());
        if(isTouching(Obstaculo.class)){
            setLocation(xAntigo, getY()); //continua desviando
        } else {
            direcaoDesvio = 0;            //segue caminhando
        }
    }

    public boolean estaDesviando(){
        return direcaoDesvio != 0;
    }
    
    //o projetil azul chama esse metodo para congelar o zumbi por 5s
    public void congelar(){
        velocidade = 0;
        tempoCongelado = 300;
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
        Greenfoot.playSound("acerto_zumbi.mp3");
        if (vida<=0) {
            FaseUm fase = (FaseUm) getWorld();
            // Zumbi rápido dá mais pontos
            if (this instanceof ZumbiForte) {
                fase.adicionarPontos(20);
            } else {
                fase.adicionarPontos(10);
            }
            fase.removeObject(this);
            fase.decrementarInimigos();
        }
    }

    private boolean verificarInvasao() {
        if (getX() <= 0) {
            // Pega o mundo base
            MundoBase mundo = (MundoBase) getWorld();
            
            if (mundo != null) {
                mundo.executarDerrota();
            }
            
            // Remove o zumbi do mundo após a invasão
            getWorld().removeObject(this);
            
            return true;
        }
        return false;
    }
}
