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
    private int contadorItem = 0; //tempo para gerar um novo item no mapa
    private int contadorLapide = 0; // tempo para gerar uma nova lapide
    private boolean poderColetado = false; //controla se o jogador já pegou o poder
    private int temporizadorZumbis = 0; //nascimento dos zumbis a cada periodo

    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        super("fase1.png",8);
        montarCenario();
        iniciarFase();
    }

    public void act(){
        if(getFaseIniciada()){
            showText("Se prepare! Os zumbis estão chegando!", 600, 50);
            showText("Pontos: "+ pontuacao, 100, 30);
            showText("Vida : " + vida, 100, 50);

            if(!poderColetado && getObjects(PoderVerde.class).isEmpty()){
                poderColetado = true;
            }

            //so comeca a gerar zumbi e lapide se o poder ja foi coletado
            if(poderColetado){
                gerarZumbi();
                gerarLapide();
            }
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
        Jardineiro jardineiro = new Jardineiro();
        addObject(jardineiro, 300, 580);

        addObject(new PoderVerde(), 600, 580);
    }

    private void gerarZumbi(){
        //se acabar os inimigos, não gera mais
        if(getInimigosVivos() <= 0){
            return;
        }

        if(getInimigosNaTela() == 0){
            temporizadorZumbis++;

            //a cada 5 seg surge nova onde de zumbis
            if(temporizadorZumbis >= 300){
                temporizadorZumbis = 0;
                aumentarInimigosNaTela(2);
                //gera um zumbis normais e um fortes
                //ambos com alturas aleatorias, porem na extrema direita do mapa
                int posYForte = Greenfoot.getRandomNumber(450) + 150;
                addObject(new ZumbiForte(), 1150, posYForte);
                int posYNormal = Greenfoot.getRandomNumber(450) + 150;
                addObject(new Zumbi(), 1150, posYNormal);

            }
        }

    }

    /**
     * Método que será chamado quando um zumbi morrer
     */
    public void adicionarPontos(int pontos) {
        pontuacao=pontuacao + pontos;
    }

    //Gera lápides (obstáculos) na tela a cada 10 segundos (600 frames),
    //respeitando o limite máximo de 3 lápides simultâneas.
    private void gerarLapide(){
        contadorLapide++;
        //condicao para tempo de gerar uma nova lapide
        if(contadorLapide >= 600){
            contadorLapide = 0;
            //quantidade de lapides no mundo
            int quantidadeLapides = getObjects(Lapide.class).size();
            //condicao para nao criar mais de 3 lapides por vez
            if(quantidadeLapides < 3){
                // Pega o jardineiro que está no mundo
                java.util.List<Jardineiro> listaJardineiros = getObjects(Jardineiro.class);
                if(!listaJardineiros.isEmpty()){
                    //pega o jardineiro do mundo
                    Jardineiro jardineiro = (Jardineiro) getObjects(Jardineiro.class).get(0);
                    //cria a lapide na mesma altura, mas um pouco a frente(para atrapalhar)
                    addObject(new Lapide(), jardineiro.getX() + 80, jardineiro.getY());
                }
            }
        }
    }
}
