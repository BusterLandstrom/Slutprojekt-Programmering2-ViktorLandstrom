import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Main {

    public static void main(String[] args) {

        GameFrame gf = new GameFrame();

        gf.setSize(1280, 720);

        Dimension screenSize = getDefaultToolkit().getScreenSize();
        gf.setLocation((int)(screenSize.getWidth()/2 - gf.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - gf.getSize().getHeight()/2));

        gf.setResizable(false);
        gf.setVisible(true);
        gf.setTitle("A Key Quest");

        gf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
