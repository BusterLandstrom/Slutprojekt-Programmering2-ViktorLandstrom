import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    /**/ //Declaring the player variable as player
    Player player;
    /**/

    Enemy enemy;

    ArrayList<Ground> grounds = new ArrayList<>();

    /**/ //Declaring Timer object as gameTimer
    Timer gameTimer;
    /**/

    /**/ //GamePanel constructor
    public GamePanel() throws IOException {

        player = new Player(400,300,this);
        enemy = new Enemy(850,350,this);

        createGround();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                player.set();
                enemy.set();
                repaint();
            }
        }, 0, 17);

    }

    public void createGround() throws IOException {
        for(int i = 50; i< 650; i+= 50){
            grounds.add(new Ground(i,600,50,50));
        }

        for(int i = 550; i< 1050; i+= 50){
            grounds.add(new Ground(i,500,50,50));
        }
    }
    /**/

    /**/ // Function to paint the panel window
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);
        enemy.draw(g2d);
        for(Ground ground: grounds) {
            ground.draw(g2d);
        }

    }
    /**/

    /**/ //Action event handler
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            player.keyUp = true;
        }
        if(e.getKeyChar() == 'a'|| e.getKeyChar() == 'A'){
            player.keyLeft = true;
        }
        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
            player.keyRight = true;
        }
        if(e.getKeyChar() == 'e' || e.getKeyChar() == 'E'){
            player.keyE = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            player.keyUp = false;
        }
        if(e.getKeyChar() == 'a'|| e.getKeyChar() == 'A'){
            player.keyLeft = false;
        }
        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
            player.keyRight = false;
        }
        if(e.getKeyChar() == 'e' || e.getKeyChar() == 'E'){
            player.keyE = false;
        }
    }
    /**/
}
