import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPress extends KeyAdapter {
    /**/ //GamePanel object cast as gp
    GamePanel gp;
    /**/

    public KeyPress (GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyPressed (KeyEvent e){
        gp.keyPressed(e);
    }

    @Override
    public void keyReleased (KeyEvent e){
        gp.keyReleased(e);
    }
}
