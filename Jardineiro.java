import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe do personagem principal do jogo, guardando sua vida,
 * poder atual, velocidade do jogador e controle de couldown dos tiros
 * Também gerencia a coleta de itens.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jardineiro extends Actor
{
    private String poderAtual;
    private static int velocidade = 3;
    private int tempoEsperaTiro = 0;
    private int tempoImunidade = 0;
    public Jardineiro () {
        this.poderAtual = "";

        definirImagem("jardineiro.png");
    }

    /**
     * Act - do whatever the Jardineiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        coletarItem();
        atirarProjetil();

        //decrementa o couldown do tiro a cada frame
        if (tempoEsperaTiro > 0) {
            tempoEsperaTiro--;
        }
        verificarColisaoComInimigo();
    }

    /**
     * Método que faz o personagem se movimentar ao clicar as teclas
     * específicas.
     */
    private void movimentar() {
        int distanciaX = 0;
        int distanciaY = 0;

        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            distanciaY -= velocidade;
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            distanciaY += velocidade;
        }
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            distanciaX -= velocidade;
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            distanciaX += velocidade;
        }

        // Atualiza a posição do personagem na tela
        setLocation(getX() + distanciaX, getY() + distanciaY);

    }
    
    /**
     * Método que identifica colisão com inimigo para
     * diminuir a pontuação
     */
    private void verificarColisaoComInimigo(){
        if (isTouching(Inimigo.class)) {
            // Recua e não deixa atravessar o zumbi
            setLocation(getX() - 4, getY());
            if(tempoImunidade == 0){
                MundoBase mundo = (MundoBase) getWorld();
                mundo.diminuirPontos(5);
                tempoImunidade = 60;
            }

        }
        if (tempoImunidade > 0) {
            tempoImunidade--;
        }
    }

    /**
     * Atualiza o poder atual do personagem.
     */
    private void setPoderAtual(String nomePoder){
        this.poderAtual = nomePoder;
    }

    /**
     * Coleta item presente no mundo.
     */
    private void coletarItem(){
        //identifica colisão com o item
        ItemColetavel item = (ItemColetavel) getOneIntersectingObject(ItemColetavel.class);

        //verifica se o item é existe
        if(item != null){
            Greenfoot.playSound("coleta_poder.mp3");
            //pega nome do poder concedido pelo item
            String nomePoder = item.getNomePoder();
            //atualiza poder atual
            setPoderAtual(nomePoder);
            //remove item do mundo
            item.removerItem();

            //troca imagem do jardineiro dependendo do seu poder
            if(nomePoder.equals("poderAzul")){
                definirImagem("jardineiro_poderGelo.png");
            }else{
                definirImagem("jardineiro_"+nomePoder+".png");
            }
        }
    }

    /**
     * Método para atirar o projétil caso tenha um poder.
     */
    private void atirarProjetil(){
        //verifica se apertou "espaço", se o poder é "poderVerde" e se o couldown já foi zerado
        if(Greenfoot.isKeyDown("space") 
        && !poderAtual.equals("") 
        && tempoEsperaTiro == 0){
            Greenfoot.playSound("poder.mp3");
            //verifica qual poder foi coletado
            if(poderAtual.equals("poderVerde")){
                //cria o projetil
                ProjetilVerde tiro = new ProjetilVerde();
                getWorld().addObject(tiro, getX() + 30, getY());
            }else if(poderAtual.equals("poderAzul")){
                ProjetilAzul tiro = new ProjetilAzul();
                getWorld().addObject(tiro, getX() + 30, getY());
            }
            //define couldown(tempo entre os tiros)
            tempoEsperaTiro = 60;
        }
    }

    /**
     * Método para definir imagem do jardineiro.
     */
    private void definirImagem(String diretorioImagem){
        GreenfootImage imagem = new GreenfootImage(diretorioImagem);
        imagem.scale(80, 120); 
        setImage(imagem);
    }
}
