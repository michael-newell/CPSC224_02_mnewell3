import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class main extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		setBackground(Color.CYAN);

		//first mountain
		int []xarr = {200, 400, 600};
		int []yarr = {800, 100, 800};
		g.fillPolygon(xarr, yarr, 3);
	
		//second mountain
 		xarr = new int[] {0, 200, 400};
		yarr = new int[] {800, 100, 800};
		g.setColor(Color.YELLOW);
		g.fillPolygon(xarr, yarr, 3);
		addListeners();

		//third mountain
 		xarr = new int[] {400, 600, 800};
		yarr = new int[] {800, 100, 800};
		g.setColor(Color.GRAY);
		g.fillPolygon(xarr, yarr, 3);
		addListeners();

		//ground
		Color brown = new Color(150,75,0);
		g.setColor(brown);
		g.fillRect(0, 675, 800, 50);
	}
	
	public static void main(String[] args)
	{
		main m = new main();
		JFrame frame = new JFrame();
		
		frame.setTitle("Motion Parallax");
		frame.setSize(800,800);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(m);
		
	}
	public void addListeners()
	{
		addMouseListener(new MyMListener());
		addMouseMotionListener(new MyMMListener());
	}
   public class MyMListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         
      }

      public void mouseClicked(MouseEvent e)
      {
                System.out.println("Clicked!");
      }

      public void mouseReleased(MouseEvent e)
      {
         
      }

      public void mouseEntered(MouseEvent e)
      {
        
      }

      public void mouseExited(MouseEvent e)
      {
         
      }
   }

   public class MyMMListener implements MouseMotionListener
   {  
      public void mouseDragged(MouseEvent e)
      {
        
      }

      public void mouseMoved(MouseEvent e)
      {
         
      }
   }
}
