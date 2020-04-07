import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player {
    /**/ //Declaring x and y position and also width and height of player
    int x;
    int y;
    int width;
    int height;
    /**/

    public int hp = 10;

    /**/ //Declaring the player sprite
    final BufferedImage charSprite = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\CharacterSprite\\CharacterSprite.png"));
    /**/

    /**/ //Projectile variables
    int px;
    int py;
    int pw = 15;
    int ph = 15;
    double shootMax = 50;
    double shooting = 0;
    boolean canShoot = true;
    boolean isShooting = false;
    int shootDir;
    Rectangle projHitBox;
    /**/

    /**/ //Declaring the variable for hit box as charHitBox
    Rectangle charHitBox;
    /**/

    /**/ //Checking if movement button is pressed
    boolean keyUp;
    boolean keyLeft;
    boolean keyRight;
    boolean keyE;
    int direction = 1;
    /**/

    /**/ //X and Y speed of character
    double xs;
    double ys;
    int maxSpeed = 5;
    /**/

    /**/ //GamePanel object cast as gp
    GamePanel gp;
    /**/

    /**/ //Instantiating the player through constructor
    public Player(int x, int y, GamePanel gp) throws IOException {
        /**/ //Setting all variables same as parent variable
        this.gp = gp;
        this.x = x;
        this.y = y;
        /**/


        /**/ //Setting the character width, height and hit box
        width = 50;
        height = 50;
        charHitBox = new Rectangle(x,y,width,height);
        projHitBox = new Rectangle(px,py,pw,ph);
        /**/
    }
    /**/
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp += hp;
    }

    /**/ //Moving the character
    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight){
            xs *= 0.8;
        } else if (keyLeft && !keyRight){
            direction = 0;
            xs--;
        } else if (!keyLeft && keyRight){
            direction = 1;
            xs++;
        }
        if (shooting >= shootMax && !canShoot && isShooting){
            isShooting = false;
            shooting = 0;
            canShoot = true;
        }

        if(keyE){
            if (direction == 1){
                if(canShoot) {
                    if (!isShooting){
                        if (shooting > 0) {
                            shootDir = 1;
                            canShoot = false;
                            px = x + width;
                            py = y + (height / 2);
                            isShooting = true;
                        }
                    }
                }
            } else if (direction == 0){
                if(canShoot) {
                    if (!isShooting){
                        if (shooting > 0) {
                            shootDir = 0;
                            canShoot = false;
                            px = x;
                            py = y + (height / 2);
                            isShooting = true;
                        }
                    }
                }
            }
        }

        if(shootDir == 1) {
            px += 10;
        } else if(shootDir == 0) {
            px += -10;
        }

        shooting += 0.3;

        if(xs > 0 && xs < .75){
            xs = 0;
        }
        if(xs < 0 && xs > -.75){
            xs = 0;
        }

        if(xs > maxSpeed) {
            xs = 5;
        }
        if(xs < -maxSpeed) {
            xs = -5;
        }

        if(keyUp){
            charHitBox.y ++;
                for (Ground ground : gp.grounds) {
                    if (ground.groundHitBox.intersects(charHitBox)) {
                        ys = -8;
                    }
                }
            charHitBox.y--;
        }

        ys += .2;

        charHitBox.x += xs;

        for(Ground ground: gp.grounds){
            if(charHitBox.intersects(ground.groundHitBox)){
                charHitBox.x -= xs;
                while(!ground.groundHitBox.intersects(charHitBox)){
                    charHitBox.x += Math.signum(xs);
                }

                charHitBox.x -= Math.signum(xs);
                xs = 0;
                x = charHitBox.x;
            }
        }

        charHitBox.y += ys;

        for(Ground ground: gp.grounds){
            if(charHitBox.intersects(ground.groundHitBox)){
                charHitBox.y -= ys;
                while(!ground.groundHitBox.intersects(charHitBox)){
                    charHitBox.y += Math.signum(ys);
                }

                charHitBox.y -= Math.signum(ys);
                ys = 0;
                y = charHitBox.y;
            }
        }

       /**/ //Enemy hit box setup for character interaction
       if(charHitBox.intersects(Enemy.getEnemyHitBox())){
           hp += -0.2;
           if(charHitBox.intersects(Enemy.getEnemyHitBox())){
               charHitBox.x -= xs;
               while(!Enemy.getEnemyHitBox().intersects(charHitBox)){
                   charHitBox.x += Math.signum(xs);
               }

               charHitBox.x -= Math.signum(xs);
               xs = 0;
               x = charHitBox.x;
           }

           if(charHitBox.intersects(Enemy.getEnemyHitBox())){
               charHitBox.y -= ys;
               while(!Enemy.getEnemyHitBox().intersects(charHitBox)){
                   charHitBox.y += Math.signum(ys);
               }

               charHitBox.y -= Math.signum(ys);
               ys = 0;
               y = charHitBox.y;
           }
       }
       /**/

        x += xs;
        y += ys;

        charHitBox.x = x;
        charHitBox.y = y;
    }
    /**/

    public void draw(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(1));
        g2d.drawImage(charSprite, x, y, width, height, null);
        g2d.setColor(Color.RED);
        g2d.drawRect(x,y,width,height + 1);
        if (isShooting) {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(px, py, pw, ph);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(5, 5, (int) shooting * 2, 20);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawRect(5, 5, 100, 20);
            g2d.setStroke(new BasicStroke(1));
        }
        g2d.setColor(Color.RED);
        g2d.fillRect(150, 5, hp * 10, 20);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(150, 5, 100, 20);
        g2d.setStroke(new BasicStroke(1));
    }
}
