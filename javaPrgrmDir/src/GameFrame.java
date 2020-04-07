import java.awt.*;
import java.io.IOException;

public class GameFrame extends javax.swing.JFrame {

    /**/ //GameFrame constructor
    public GameFrame() throws IOException {
        Color bgc = new Color(51,255,221);

        GamePanel gp = new GamePanel();
        gp.setLocation(0,0);
        gp.setBackground(bgc);
        gp.setVisible(true);
        gp.setSize(this.getSize());
        this.add(gp);
    }
    /**/
}
