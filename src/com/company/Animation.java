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

    private LinkedList<Potion> redPotions = new LinkedList<>();
    private LinkedList<Potion> bluePotions = new LinkedList<>();

    private int time = 0;
    private int duration = 1000;

    private Boolean collides = false;

    private float x = 50;
    private int cauldronNumber = 1;

    public Animation(String title) {
        super(title);
        try {
            prepareGUI();
        } catch (Exception e) {
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        blueMAGsprite = new SpriteSheet("src/resources/blueMAG.png", 75, 71);
        redMAGsprite = new SpriteSheet("src/resources/redMAG.png", 75, 71);

        blueMAGanimation = new org.newdawn.slick.Animation(blueMAGsprite, 400);
        redMAGanimation = new org.newdawn.slick.Animation(redMAGsprite, 350);

        redPotions.add(new Potion("RED", 1, cauldronNumber));
        bluePotions.add(new Potion("BLUE", 1, cauldronNumber));

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

        System.out.print(i + " ");

        time += i;

        System.out.println(" " + time);
        if (time >= duration) {
            cauldronNumber++;

            redPotions.add(new Potion("RED", redPotions.getLast().getNumber() + 1, cauldronNumber));

            for (int n = 0; n <= redPotions.size() - 1; n++) {
                choosePlaceByCounter(redPotions, n, 0);
            }

            if (cauldronNumber == 3) {
                cauldronNumber = 0;
            }



            bluePotions.add(new Potion("BLUE", bluePotions.getLast().getNumber() + 1, cauldronNumber));

            for (int n = 0; n <= bluePotions.size() - 1; n++) {
                choosePlaceByCounter(bluePotions, n, 30);
            }

            if (cauldronNumber == 3) {
                cauldronNumber = 0;
            }
            time = 0;
        }






    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        drawCOULDRONS();
        drawMAG();

        for (int i = 0; i <= redPotions.size() - 1; i++) {
            redPotions.get(i).getImage().draw(redPotions.get(i).getX(), redPotions.get(i).getY(), 0.2f);
            g.drawString(Integer.toString(redPotions.get(i).getNumber()), redPotions.get(i).getX() + 10, redPotions.get(i).getY() - 20);
        }

        for (int i = 0; i <= bluePotions.size() - 1; i++) {
            bluePotions.get(i).getImage().draw(bluePotions.get(i).getX(), bluePotions.get(i).getY(), 0.2f);
            g.drawString(Integer.toString(bluePotions.get(i).getNumber()), bluePotions.get(i).getX() + 10, bluePotions.get(i).getY() - 20);
        }
    }

    private void prepareGUI() throws SlickException {

        AppGameContainer app = new AppGameContainer(this);
        app.setDisplayMode(800, 600, false);
        app.setAlwaysRender(true);
        app.start();
    }

    public void setCollides(Boolean collides) {
        this.collides = collides;
    }

    public void drawCOULDRONS() {
        CAULDRON1.draw(650, 20);
        CAULDRON2.draw(650, 220);
        CAULDRON3.draw(650, 400);
    }


    public void drawMAG() {
        blueMAGanimation.draw(50, 200);
        redMAGanimation.draw(50, 320);
    }

    public void choosePlaceByCounter(LinkedList<Potion> potions, int n, int colorMove) {
        if (potions.get(n).getCounter() == 5) {
            chooseCauldron(potions, n, colorMove);

        } else if (potions.get(n).getCounter() < 5 && n != 0 && potions.get(n - 1).getCounter() != 1) {
            potions.get(n).setX((int) (potions.get(n).getX() + 50));
            potions.get(n).setCounter(potions.get(n).getCounter() + 1);

        } else if (potions.get(n).getCounter() < 5 && n == 0) {
            potions.get(n).setX((int) (potions.get(n).getX() + 50));
            potions.get(n).setCounter(potions.get(n).getCounter() + 1);

        } else if (potions.get(n).getCounter() > 5) {
            potions.get(n).setX(1000);
            potions.get(n).setY(1000);
            //  redPotions.remove(n);

        }
    }

    public void chooseCauldron(LinkedList<Potion> potions, int n, int colorMove) {
        if (potions.get(n).getCauldronNumber() == 1) {
            potions.get(n).setGoToCauldron(true);
            potions.get(n).setX(650 + colorMove);
            potions.get(n).setY(20);
            potions.get(n).setCounter(potions.get(n).getCounter() + 1);

        } else if (potions.get(n).getCauldronNumber() == 2) {
            potions.get(n).setGoToCauldron(true);
            potions.get(n).setX(650 + colorMove);
            potions.get(n).setY(250);
            potions.get(n).setCounter(potions.get(n).getCounter() + 1);

        } else {
            potions.get(n).setGoToCauldron(true);
            potions.get(n).setX(650 + colorMove);
            potions.get(n).setY(400);
            potions.get(n).setCounter(potions.get(n).getCounter() + 1);
        }
    }

}
