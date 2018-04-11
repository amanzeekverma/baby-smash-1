import java.util.*;
import java.awt.event.*;
import java.awt.Robot;
import javax.swing.JFrame;

public class KeyBoardListen extends java.awt.event.KeyAdapter{

	private StringBuilder queque = new StringBuilder();
	private String match = null;
        private JFrame frame = null;

	public KeyBoardListen(String a, JFrame frame){
		match = a.toLowerCase();
                this.frame = frame;    //Records which frame captured the key stroke.
	}

	public void keyTyped(KeyEvent e){
		char c = Character.toLowerCase(e.getKeyChar());
                if (c < 97 || c > 122)   //Only check for small ascii printable text to be queued. Current use: to exit
                      return;
		queque.append(c);
		System.out.println("Typed " + queque);
		if(queque.length() > match.length()){
			queque.delete(0, 1);
		}
		System.out.println("queque " + queque + "| l :" + queque.length() + "; match.length() " + match.length() + ":" + match);
		if(queque.length() == match.length() && match.equals(queque.toString())){
			System.out.println("\nBye exiting on " + queque);
			System.exit(0);

		}
	}

        public void keyPressed(KeyEvent e){
               //System.out.println("Check Press: "+e.getExtendedKeyCode());
               if (e.getExtendedKeyCode()==KeyEvent.VK_ALT || e.getExtendedKeyCode()==KeyEvent.VK_TAB){
                   try {
                     Robot r = new Robot();
                     r.keyPress(KeyEvent.VK_ESCAPE); 
                     r.keyRelease(KeyEvent.VK_ESCAPE);
                     frame.requestFocus();
                     int mouse_x = frame.getWidth() / 2;
                     int mouse_y = frame.getHeight() / 2;
                     r.mouseMove(mouse_x, mouse_y);
                     r.mousePress(InputEvent.BUTTON1_MASK); //press the left mouse button
                     r.mouseRelease(InputEvent.BUTTON1_MASK); //release the left mouse button
                     r.keyPress(KeyEvent.VK_ESCAPE);
                     r.keyRelease(KeyEvent.VK_ESCAPE);
                   }catch(Exception ex){  //Mainly AWT Exception
                         ex.printStackTrace();
                   }
               }
        }
}
