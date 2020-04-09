import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Enemy {

    /**/ //Declaring x and y position and also width and height of Player
    int x;
    int y;
    int width;
    int height;
    int direction = 0;
    double dirTimer = 1;
    /**/

    /**/ //Declaring the Player sprite
    final BufferedImage enemySprite1 = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\EnemySprite\\EnemySprite1.png"));
    final BufferedImage enemySprite2 = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\EnemySprite\\EnemySprite2.png"));
    final BufferedImage enemySprite3 = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\EnemySprite\\EnemySprite3.png"));

    /**/ //Declaring the variable for hit box as enemyHitBox
    static Rectangle enemyHitBox;
    /**/

    /**/ //X and Y speed of character
    double xs;
    double ys;
    /**/

    /**/ //GamePanel object cast as gp
    GamePanel gp;
    /**/

    /**/ //Instantiating the Player through constructor
    public Enemy(int x, int y, GamePanel gp) throws IOException {
        /**/ //Setting all variables same as parent variable
        this.gp = gp;
        this.x = x;
        this.y = y;
        /**/

        /**/ //Setting the character width, height and hit box
        width = 50;
        height = 50;
        enemyHitBox = new Rectangle(x,y,width,height);
        /**/
    }
    /**/

    /**/ //Moving the character
    public void set(){
        if(xs > 0 && xs < .75){
            xs = 0;
        }
        if(xs < 0 && xs > -.75){
            xs = 0;
        }
        if(dirTimer > 0){
            direction = 0;
        } else if(dirTimer < 0){
            direction = 1;
        }
        if(direction == 1) {
            xs = 2;
        } else if(direction == 0) {
            xs = -2;
        }
        dirTimer += -0.01;

        if (dirTimer < -1){
            dirTimer = 1;
        }
        enemyHitBox.x += xs;

        for(Ground ground: gp.grounds){
            if(enemyHitBox.intersects(ground.groundHitBox)){
                enemyHitBox.x -= xs;
                while(!ground.groundHitBox.intersects(enemyHitBox)){
                    enemyHitBox.x += Math.signum(xs);
                }
                enemyHitBox.x -= Math.signum(xs);
                xs = 0;
                x = enemyHitBox.x;
            }
        }

        ys += .2;

        enemyHitBox.y += ys;

        for(Ground ground: gp.grounds){
            if(enemyHitBox.intersects(ground.groundHitBox)){
                enemyHitBox.y -= ys;
                while(!ground.groundHitBox.intersects(enemyHitBox)){
                    enemyHitBox.y += Math.signum(ys);
                }

                enemyHitBox.y -= Math.signum(ys);
                ys = 0;
                y = enemyHitBox.y;
            }
        }

        x += xs;
        y += ys;

        enemyHitBox.x = x;
        enemyHitBox.y = y;
    }
    /**/

    public void draw(Graphics2D g2d){
        g2d.drawImage(enemySprite1, x, y, width, height, null);
        g2d.setColor(Color.RED);
        g2d.drawRect(x,y,width,height + 1);
    }

    public static Rectangle getEnemyHitBox(){
        return enemyHitBox;
    }
}
