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
		int []xarr = {0, 300, 600};
		int []yarr = {900, 0, 900};
		g.fillPolygon(xarr, yarr, 3);
		addListeners();
	}
	
	public static void main(String[] args)
	{
		main m = new main();
		JFrame frame = new JFrame();
		
		frame.setTitle("Motion Parallax");
		frame.setSize(900,900);
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
