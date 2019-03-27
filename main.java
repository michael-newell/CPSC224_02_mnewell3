package motionparallax;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

public class MotionParallax extends JFrame implements ActionListener {
    //basic var stuff
    private int MouseX;
    private int MouseY;
    private final int W = 510;
    private final int H = 548; //top bar is 38 pixels...
    
    //Mouse information for listeners - shows up as text in panel
    private int click = 0;
    private String clicks = "Clicks: ";
    private String position = "Pos: --, --";
    private boolean drag = false;
    private String dragPosition = "Drag: --, --";
    private String mouseInOut = "---";
    private String mousePressed = "Mouse press: No";
    
    private Timer timeListener; //timeListener
    
    private Color skyBlue = new Color(135, 206, 250); //background color
    
    //PARALLAX...............
    private int sunParallax = 35;
    private int mountainParallax = 125;
    private int treeTrunkParallax = 80;
    private int treeLeavesParallax = 80;
    private int grassParallax = 100;
    
    public MotionParallax(){
        setTitle("Assignment 4: Motion Parallax"); //title
        getContentPane().setBackground(skyBlue); //backgroud color
        setSize(W, H); //Width/Height of box, couldn't stop it from being resized...
        setDefaultCloseOperation(EXIT_ON_CLOSE); //close when exit
        
        //mouse listeners
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        
        //timer for drawing
        timeListener = new Timer(100, this);
        timeListener.start();
        
        //show panel
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g); //paint method
        
        //mouse properties - from listeners
        g.drawString(position, 70, 80);
        g.drawString(clicks, 70, 100);
        g.drawString(mouseInOut, 70, 120);
        g.drawString(dragPosition, 70, 140);
        g.drawString(mousePressed, 70, 160);
        
        //new colors
        //Color name = new Color(R,G,B)
        Color skyBlue = new Color(135, 206, 250);
        Color brown = new Color(80, 30, 30);
        Color darkGreen = new Color(0, 158, 34);
        Color grass = new Color(1, 198, 28);
        Color gray = new Color(142, 142, 142);
        
        //polygon coordinates
        int mountainX[] = {0, 400, 200};
        int mountainY[] = {470, 470, 100};
        
        int triangleTreeX[] = {345, 425, 385};
        int triangleTreeY[] = {385, 385, 300};
        
        int points = 3; //for some reason fillPolygon needs points as a var...
        
        //draw singular bird
        //g.setColor(Color.black);
        //g.drawLine
        
                /* References for shapes:
                g.fillRect(x, y, Width, Height);
                g.drawLine(x1, y1, x2, y2);
                --  top bar checker:  --
                g.setColor(Color.BLACK);
                g.fillRect(x, y, WIDTH, HEIGHT);
                bar is about 38 pixels
                g.fillArc(50, 50, 50, 50, 50, 50);
                g.fillArc(x, y, w, h, startArc, arcAngle);
                g.
                */

        
        //mountain
        for(int i=0; i<3; i++){
            mountainX[i] += (MouseX/mountainParallax);
            mountainY[i] += (MouseY/mountainParallax);
        }
        g.setColor(gray);
        g.fillPolygon(mountainX, mountainY, points);
        
        //grass
        g.setColor(grass);
        g.fillRect(0/*+(MouseX/grassParallax)*/, 438+(MouseY/grassParallax), 500, 100);
                //the X coord is kinda pointless becuase the grass stays the same left and right...
        
        //tree (trunk and leaves)
        g.setColor(brown);
        g.fillRect(370+(MouseX/treeTrunkParallax), 380+(MouseY/treeTrunkParallax), 30, 80);
        for(int i=0; i<3; i++){
            triangleTreeX[i] += (MouseX/treeLeavesParallax);
            triangleTreeX[i] += (MouseY/treeLeavesParallax);
        }
        g.setColor(darkGreen);
        g.fillPolygon(triangleTreeX, triangleTreeY, points);
        
        //sun
        g.setColor(Color.yellow);
        g.fillOval(390+(MouseX/sunParallax), 80+(MouseY/sunParallax), 50, 50);
        
        
        
        
        /*
        //red reference bars - only used for testing and getting oriented
        g.setColor(Color.red);
        //x
        g.drawLine(0, 138, 500, 138);
        g.drawLine(0, 238, 500, 238);
        g.drawLine(0, 338, 500, 338);
        g.drawLine(0, 438, 500, 438);
        g.drawLine(0, 538, 500, 538);
        //y
        g.drawLine(100, 0, 100, 538);
        g.drawLine(200, 0, 200, 538);
        g.drawLine(300, 0, 300, 538);
        g.drawLine(400, 0, 400, 538);
        g.drawLine(500, 0, 500, 538);
        */
    }
    
    //when the timeListener activates the panel will repaint
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    
    private class MyMouseMotionListener implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            MouseX = e.getX();
            MouseY = e.getY();
            position = "Move: " + MouseX + ", " + MouseY;
            //repaint();
        }
        public void mouseDragged(MouseEvent e) {
            MouseX = e.getX();
            MouseY = e.getY();
            dragPosition = "Drag: " + MouseX + ", " + MouseY;
        }
    }
    
    private class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            click++;
            clicks = "Clicks: " + click;
        }
        public void mousePressed(MouseEvent e) {
            mousePressed = "Mouse press: Yes";
        }
        public void mouseReleased(MouseEvent e) {
            mousePressed = "Mouse press: No";
        }
        public void mouseEntered(MouseEvent e) {
            mouseInOut = "Entered";
        }
        public void mouseExited(MouseEvent e) {
            mouseInOut = "Exited";
        }
    }
    
    public static void main(String[] args) {
        new MotionParallax();
    }
    
}
