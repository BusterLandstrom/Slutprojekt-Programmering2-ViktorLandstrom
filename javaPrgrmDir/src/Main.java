import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.awt.Toolkit.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Main {

    /**/ //Main function to initiate all other functions and set base values
    public static void main(String[] args) throws IOException {
        GameFrame gf = new GameFrame();

        gf.setSize(1280, 720);

        Dimension screenSize = getDefaultToolkit().getScreenSize();
        gf.setLocation((int)(screenSize.getWidth()/2 - gf.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - gf.getSize().getHeight()/2));

        gf.setResizable(false);
        gf.setVisible(true);
        gf.setTitle("A Key Quest");

        gf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    /**/
}
