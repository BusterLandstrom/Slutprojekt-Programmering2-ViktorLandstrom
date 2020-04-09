import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Key {

    /**/ //Declaring x and y position and also width and height of the key
    int x;
    int y;
    int width;
    int height;
    /**/

    /**/ //Declaring the key sprite
    final BufferedImage keySprite = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\KeySprite\\KeySprite1.png"));
    /**/

    /**/ //Key hit box
    static Rectangle keyHitBox;
    /**/


    /**/ //GamePanel object cast as gp
    GamePanel gp;
    /**/


    /**/ //Instantiating the player through constructor
    public Key(int x, int y, GamePanel gp) throws IOException {
        /**/ //Setting all variables same as parent variable
        this.gp = gp;
        this.x = x;
        this.y = y;
        /**/


        /**/ //Setting the character width, height and hit box
        width = 50;
        height = 50;
        keyHitBox = new Rectangle(x+10,y+5,width-20,height-5);
        /**/
    }
    /**/

    public void draw(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(1));
        g2d.drawImage(keySprite, x, y, width, height, null);
        g2d.setColor(Color.RED);
        g2d.drawRect(x+10,y+5,width-20,height-5);

    }

    public static Rectangle getKeyHitBox(){
        return keyHitBox;
    }
}
