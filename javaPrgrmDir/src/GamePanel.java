import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    /**/ //Declaring the player variable as player
    Player player;
    /**/

    /**/ //Declaring Timer object as gameTimer
    Timer gameTimer;
    /**/

    /**/ //GamePanel constructor
    public GamePanel() throws IOException {

        player = new Player(400,300,this);

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                player.set();
                repaint();
            }
        }, 0, 17);

    }
    /**/

    /**/ // Function to paint the panel window
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

    }
    /**/

    /**/ //Action event handler
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    /**/
}
