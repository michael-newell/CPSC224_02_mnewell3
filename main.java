import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;

public class main extends JFrame implements ActionListener {
     private final int width = 800;
     private final int height = 800; 
     private int MouseX;
     private int MouseY;
  
     private Color blue = new Color(135, 206, 250);
     private Color brown = new Color(80, 30, 30);
     private Color grass = new Color(1, 198, 28);
     private Color gray = new Color(142, 142, 142);
    
     private int sParallax = 80;
     private int m2Parallax = 30;
     private int m3Parallax = 15;
     private int mParallax = 25;

     private Timer tListener;
      
    
    
    public main(){
        setTitle("Motion Parallax");
        getContentPane().setBackground(blue);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        
        tListener = new Timer(200, this);
        tListener.start();
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g); 
        
        int mountainX[] = {0, 200, 400};
        int mountainY[] = {800, 200, 800};

	int mountain3X[] = {200, 400, 600};
        int mountain3Y[] = {800, 200, 800};
	
	int mountain2X[] = {400, 600, 800};
        int mountain2Y[] = {800, 200, 800};
       

        for(int i=0; i<3; i++){
		mountainX[i] += (MouseX/mParallax);
		mountainY[i] += (MouseY/mParallax);
	
		mountain2X[i] += (MouseX/m2Parallax);
            	mountain2Y[i] += (MouseY/m2Parallax);

		mountain3X[i] += (MouseX/m3Parallax);
            	mountain3Y[i] += (MouseY/m3Parallax);
        }

	g.setColor(Color.yellow);
        g.fillOval(200+(MouseX/sParallax), 75+(MouseY/sParallax), 40, 40);

        g.setColor(gray);
        g.fillPolygon(mountainX, mountainY, 3);

	g.setColor(Color.BLACK);
        g.fillPolygon(mountain2X, mountain2Y, 3);
        
	g.setColor(Color.RED);
        g.fillPolygon(mountain3X, mountain3Y, 3);

	g.setColor(grass);
        g.fillRect(0, 750, 800, 100);
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    
    private class MyMouseMotionListener implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            MouseX = e.getX();
            MouseY = e.getY();
            
        }
        public void mouseDragged(MouseEvent e) {
            MouseX = e.getX();
            MouseY = e.getY();
            
        }
    }
    
    private class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            System.out.println("that tickles haha");
        }
        public void mousePressed(MouseEvent e) {
            System.out.println("I love it when you press your mouse :)");
        }
        public void mouseReleased(MouseEvent e) {
           
        }
        public void mouseEntered(MouseEvent e) {
            
        }
        public void mouseExited(MouseEvent e) {
            
        }
    }
    
    public static void main(String[] args) {
        new main();
    }
    
}
