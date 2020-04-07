import java.awt.*;

public class GameFrame extends javax.swing.JFrame {

    public GameFrame() {
        Color bgc = new Color(181,101,29);

        GamePanel gp = new GamePanel();
        gp.setLocation(0,0);
        gp.setBackground(bgc);
        gp.setVisible(true);
        gp.setSize(this.getSize());
        this.add(gp);
    }
}
