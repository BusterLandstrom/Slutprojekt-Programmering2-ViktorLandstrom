import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    /**/ //Declaring xand y position and also width and height of player
    int x;
    int y;
    int width;
    int height;
    /**/

    /**/ //Declaring the player sprite
    final BufferedImage charSprite = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\CharacterSprite\\CharacterSprite.png"));
    /**/

    /**/ //Declaring the variable for hit box as charHitBox
    Rectangle charHitBox;
    /**/

    /**/ //Checking if movement button is pressed
    boolean keyUp;
    boolean keyDown;
    boolean keyLeft;
    boolean keyRight;
    /**/

    /**/ //X and Y speed of character
    double xs;
    double ys;
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
        /**/
    }
    /**/

    /**/ //Moving the character
    public void set(){

        x += xs;
        y += ys;

        charHitBox.x = x;
        charHitBox.y = y;
    }
    /**/

    public void draw(Graphics2D g2d){
        g2d.drawImage(charSprite, x, y, width, height, null);
    }
}
