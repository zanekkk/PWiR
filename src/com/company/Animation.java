package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.LinkedList;


//public class Animation extends Frame implements ActionListener {
public class Animation extends BasicGame {
    private SpriteSheet blueMAGsprite = null;
    private SpriteSheet redMAGsprite = null;

    private org.newdawn.slick.Animation blueMAGanimation = null;
    private org.newdawn.slick.Animation redMAGanimation = null;
    private Image CAULDRON1 = null;
    private Image CAULDRON2 = null;
    private Image CAULDRON3 = null;
    private Image bluePOTION = null;
    private LinkedList<Image> potions = new LinkedList<>();

    private Boolean collides = false;

    public Animation(String title){
        super(title);
        try {
            prepareGUI();
        }catch(Exception e){}
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        blueMAGsprite = new SpriteSheet("src/resources/blueMAG.png",75,71);
        redMAGsprite = new SpriteSheet("src/resources/redMAG.png",75,71);

        blueMAGanimation = new org.newdawn.slick.Animation(blueMAGsprite,400);
        redMAGanimation = new org.newdawn.slick.Animation(redMAGsprite,350);

        try {
            CAULDRON1 = new Image("src/resources/CAULDRON.jpg");
            CAULDRON2 = new Image("src/resources/CAULDRON.jpg");
            CAULDRON3 = new Image("src/resources/CAULDRON.jpg");
        } catch (Exception e) {
            System.out.print("Magowi nie udalo sie przyteleportowac!");
        }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        blueMAGanimation.update(i);
        redMAGanimation.update(i);
    }

    @Override
    public void render(GameContainer container, Graphics g)throws SlickException {

        CAULDRON1.draw(650,20);
        CAULDRON2.draw(650,220);
        CAULDRON3.draw(650,400);
//        CAULDRON3.draw(container.getInput().getMouseX(),container.getInput().getMouseY());
        blueMAGanimation.draw(50,180);
        redMAGanimation.draw(50,320);
        g.drawString("Collides: " + collides, 10,25);

        if(collides){
            potions.add(new Image("src/resources/redPOTION.jpg"));
            potions.getFirst().draw(150,150);
        }


        initKonsumentProducent(this);
    }

    private void prepareGUI() throws SlickException {

        AppGameContainer app = new AppGameContainer(this);
        app.setDisplayMode(800, 600, false);
        app.setAlwaysRender(true);
        app.start();
    }

    public void setCollides(Boolean collides){
        this.collides = collides;
    }


    public void putNewPotion(String nazwa) throws SlickException{
        if(nazwa.equals("RED")){
            potions.add(new Image("src/resources/redPOTION.jpg"));
            potions.getFirst().draw(150,150);
        }

    }


    private void initKonsumentProducent(Animation animation){
        Pojemnik poj1 = new Pojemnik(animation);
        Pojemnik poj2 = new Pojemnik(animation);

        Producent prod = new Producent(poj1, "BLUE", 1);
        Producent prod2 = new Producent(poj2, "RED",2);

        Konsument kons = new Konsument(poj1 , poj2 ,"Konsument1");
        Konsument kons2 = new Konsument(poj1, poj2 , "Konsument2");
        Konsument kons3 = new Konsument(poj1, poj2 ,"Konsument3");



        prod.start();
        prod2.start();

        kons.start();
        kons2.start();
        kons3.start();

    }


}
