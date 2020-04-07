import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground {

    int x;
    int y;
    int width;
    int height;

    /**/ //Declaring the ground sprite
    final BufferedImage groundSprite = ImageIO.read(new File("G:\\slutprojekt\\javaPrgrmDir\\Sprites\\GroundSprite\\GroundSprite.png"));
    /**/

    Rectangle groundHitBox;

    public Ground(int x,int y,int width,int height) throws IOException {


        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        groundHitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(groundSprite, x, y, width, height, null);

    }
}
