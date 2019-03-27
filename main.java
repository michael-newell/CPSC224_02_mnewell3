import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class main extends JPanel
{
	static int windowW = 800;
	static int windowH = 800;
	int centerX = windowW / 2;
	int centerY = windowH / 2;	
	
	int []mountain1x = {(windowW / 4), (windowW / 4) * 2, (windowW / 4) * 3};
	int []mountain1y = {windowH, 100, windowH};

	int []mountain2x = {0, (windowW / 4), (windowW / 4) * 2};
	int []mountain2y = {windowH, 100, windowH};

	int []mountain3x = {(windowW / 4) * 2, (windowW / 4) * 3, windowW};
	int []mountain3y = {windowH, 100, windowH};
	
	

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		setBackground(Color.CYAN);

		//first mountain
		g.fillPolygon(mountain1x, mountain1y, 3);
	
		//second mountain
		g.setColor(Color.YELLOW);
		g.fillPolygon(mountain2x, mountain2y, 3);
		addListeners();

		//third mountain
		g.setColor(Color.GRAY);
		g.fillPolygon(mountain3x, mountain3y, 3);
		addListeners();

		//ground
		Color brown = new Color(150,75,0);
		g.setColor(brown);
		g.fillRect(0, 675, 800, 300);
	}
	
	public static void main(String[] args)
	{
		main m = new main();
		JFrame frame = new JFrame();
		
		frame.setTitle("Motion Parallax");
		frame.setSize(windowW, windowH);
		
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
                
      }

      public void mouseReleased(MouseEvent e)
      {
         
      }

      public void mouseEntered(MouseEvent e)
      {
        
      }

      public void mouseExited(MouseEvent e)
      {
         mountain1x = new int[]{(windowW / 4), (windowW / 4) * 2, (windowW / 4) * 3};
	 mountain1y = new int[]{windowH, 100, windowH};

	 mountain2x = new int[]{0, (windowW / 4), (windowW / 4) * 2};
	 mountain2y = new int[]{windowH, 100, windowH};

	 mountain3x = new int[]{(windowW / 4) * 2, (windowW / 4) * 3, windowW};
	 mountain3y = new int[]{windowH, 100, windowH};
      }
   }

   public class MyMMListener implements MouseMotionListener
   {  
      public void mouseDragged(MouseEvent e)
      {
        
      }

      public void mouseMoved(MouseEvent e)
      {
	int mouseX = e.getX();
	int mouseY = e.getY();
	if (mouseX > centerX + 10)
	{
		for (int i = 0; i < mountain1x.length; i++)
		{
			mountain1x[i] += 3;
			mountain2x[i] += 2;
			mountain3x[i] += 1;
		}
		if (mouseX > 500)
		{
			centerX = 500;
		}
	}

	
	repaint();		 
      }
   }
}
