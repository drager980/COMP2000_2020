import javax.swing.*;
import java.awt.*;

public class mymain extends JFrame {
    public static void main(String[] args) throws Exception {
    }

    public class Cell {
        public Color clr= Color.WHITE;
        public int x,y,size;
        public Cell(int xpos, int ypos, int scale, Color c) {
            x = xpos;
            y = ypos;
            size = scale;
            clr = c;
        }

        public void draw(Graphics g) {
            g.setColor(clr); 
            g.fillRect(x,y,size,size);
            g.setColor(Color.BLACK); 
            g.drawRect(x,y,size,size);
        }
    }

    public class Grid {
        public Cell[][] c = new Cell[20][20];
        public Grid() {
            for(int y= 0; y < 19; y++) {
                int ypos = 10+y*35;
                for(int x=  0; x < 19 ; x++) {
                    int xpos = 10+x*35;
                   c[x][y] = new Cell(xpos,ypos,35,Color.WHITE);
                }
            }
        }
       
        public void paint(Graphics g) {
            for(int y = 0; y < 19;y++) {    
                for(int x=0; x<19; x++) {
                    c[x][y].draw(g);
                }
            }
        }
    }

    public class Canvas extends JPanel {
        public Grid grid = new Grid();
        public Canvas() {
            setPreferredSize(new Dimension(720,720));
        }
        
        @Override
        public void paint(Graphics g) {
            grid.paint(g);
        }
    }

    public mymain(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    //public void run(){


    //}
}