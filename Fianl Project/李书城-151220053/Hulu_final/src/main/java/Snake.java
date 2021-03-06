import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.util.Random;

public class Snake extends Speices implements Runnable{
    public int cnt;
    public Snake(int x, int y, int cnt, Fight fight, String pic) {
        super(x, y, fight, pic);

        URL loc = this.getClass().getClassLoader().getResource(pic);
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.cnt = cnt;
    }
    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }

    public void run() {
        while (!Thread.interrupted()) {
            Random rand = new Random();
            try {
                if(this.dead ==1) break;
                Thread.sleep(rand.nextInt(200) + 200);

                Thing2D t = fight.fightWithJustice(this);
                this.fight.snakeStrength(t, this);

                this.repaint();

            } catch (Exception e) {

            }
        }
    }
    /*
        public Snake()
    {
        this.spieces = 1;
    }
    public void appear(){
        System.out.print("蛇");
    }
    public int return_index()
    {
        return 1;
    }
     */
}