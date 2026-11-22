import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FaseTres here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * gerar item final ao matar chefao, pegar esse item vai ser a condição para mostrar vitória
 */
public class FaseTres extends MundoBase
{
    private int contadorLapide = 0; // tempo para gerar uma nova lapide
    private int contadorChefe = 0;
    private boolean chefeGerado = false;
    private boolean chefeMorto = false;
    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseTres(Jardineiro jardineiroAnterior, int pontuacaoAnterior)
    {
        super("fase_final.jpg", 12, jardineiroAnterior, pontuacaoAnterior);
        montarCenario();
        iniciarFase();
        iniciarMusica();
    }

    public void act(){
        if(getFaseIniciada()){
            showText("Se prepare! O zumbi chefe e seus aliads estão chegando!", 600, 50);
            showText("Pontos: "+ getPontuacao(), 100, 30);
            if(!chefeGerado){
                contadorChefe++;

                if(contadorChefe >= 300){
                    
                    addObject(new ZumbiChefe(), 1150, 300);

                    chefeGerado = true;
                }
            }
            verificarChefeMorto();
            gerarZumbi();
            //gerarLapide();
        }
    }

    /**
     * Método para montar o cenário da primeira fase, adicionando o personagem
     * principal, item coletável para poder atirar o projetil e os inimigos.
     * 
     */
    private void montarCenario() {
        
        addObject(obterJardineiro(), 300, 580);
    }
    
    private void verificarChefeMorto(){
        if(getObjects(ZumbiChefe.class).isEmpty()){
            chefeMorto = true;
        }
    }

    private void gerarZumbi(){
        //se acabar os inimigos, não gera mais
        if(getInimigosVivos() == 0){
            return;
        }
        
        if((getInimigosNaTela() - 1) <= 0){
            int temporizadorInimigos = obterTemporizadorZumbis();
            super.setTemporizadorZumbis(temporizadorInimigos + 1);
            
            //a cada 5 seg surge nova onde de zumbis
            if(temporizadorInimigos >= 300){
                super.setTemporizadorZumbis(0);
                aumentarInimigosNaTela(3);
                //gera um zumbis normais e um fortes
                //ambos com alturas aleatorias, porem na extrema direita do mapa
                int posYForte = Greenfoot.getRandomNumber(450) + 150;
                addObject(new ZumbiCorredor(), 1150, posYForte);
                int posYNormalUm = Greenfoot.getRandomNumber(450) + 150;
                addObject(new ZumbiForte(), 1150, posYNormalUm);
                int posYNormalDois = Greenfoot.getRandomNumber(450) + 150;
                addObject(new Zumbi(), 1150, posYNormalDois);

            }
        }

    }

    //Gera lápides (obstáculos) na tela a cada 10 segundos (600 frames),
    //respeitando o limite máximo de 3 lápides simultâneas.
    private void gerarLapide(){
        contadorLapide++;
        //condicao para tempo de gerar uma nova lapide
        if(contadorLapide >= 600){
            contadorLapide = 0;
            //quantidade de lapides no mundo
            int quantidadeLapides = getObjects(LapideReforcada.class).size();
            //condicao para nao criar mais de 3 lapides por vez
            if(quantidadeLapides < 3){
                // Pega o jardineiro que está no mundo
                java.util.List<Jardineiro> listaJardineiros = getObjects(Jardineiro.class);
                if(!listaJardineiros.isEmpty()){
                    //pega o jardineiro do mundo
                    Jardineiro jardineiro = (Jardineiro) getObjects(Jardineiro.class).get(0);
                    //cria a lapide na mesma altura, mas um pouco a frente(para atrapalhar)
                    addObject(new LapideReforcada(), jardineiro.getX() + 80, jardineiro.getY());
                }
            }
        }
    }
}
