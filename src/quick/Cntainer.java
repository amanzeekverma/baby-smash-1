import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class Cntainer extends JComponent{

	String hlp2 = "More work to be done version 0.1. Tushar Kapila 2012 - 2013";

	static final int BREAK_TIME = 3000;

	int count = 0;
	long timelast = System.currentTimeMillis();
	Color c1 = new Color(200,0,134);
	Color c2 = new Color(200,110,4);
	Color c3 = new Color(20,10,134);

	public Cntainer(BabySmash s){
		Tmr tt = new Tmr(this);
		tt.start();
	}

	public void paint(Graphics g){
		super.paint(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, 3333,3700);

		g.setColor(Color.black);
		//g.drawString(BabySmash.HLP_STR, 20, 20);

		g.drawString(hlp2, 28, 40);

		if(System.currentTimeMillis() - timelast > BREAK_TIME){
			count++;
			if(count> 5)count=0;
			timelast = System.currentTimeMillis();
		}

		switch(count){
			case 0:
				g.setColor(Color.yellow);
				g.fillRect(80, 100, 870,900);
				break;

			case 1:
				g.setColor(Color.blue);
				g.fillRect(80, 120, 470,700);
				break;

			case 2:
				g.setColor(Color.yellow);
				g.fillRect(80, 130, 470,700);
				break;

			case 3:
				g.setColor(Color.red);
				g.drawRect(80, 112, 470,700);

				g.setColor(c1);
				g.fillRect(440, 300, 120,190);

				g.setColor(c3);
				g.fillOval(380, 300, 111, 145);

				g.setColor(Color.MAGENTA);
				g.fillRect(380, 400, 80, 90);
				break;

			case 4:
				g.setColor(Color.pink);
				g.fillRect(80, 100, 870,900);

				g.setColor(Color.cyan);
				g.fillOval(280, 300, 111, 145);

				g.setColor(Color.MAGENTA);
				g.fillRect(380, 400, 80, 90);
				break;

			case 5:
				g.setColor(Color.yellow);
				g.fillRect(80, 100, 870,900);
				break;

			default:
			g.setColor(Color.orange);
			g.drawLine(20,30,800, 400);
		}




	}



}

class Tmr extends Thread{

	static Cntainer c;
	Tmr(Cntainer cc){
		c = cc;
	}


		public void run(){
			try{
				int tt = Cntainer.BREAK_TIME + 400;
				while(true){

					//c.invalidate();
					c.repaint();
					Thread.sleep(tt);
				}
			}catch(Exception e){
				System.out.println("e " + e);
			}

			System.out.println("tme bnye ");
		}
	}