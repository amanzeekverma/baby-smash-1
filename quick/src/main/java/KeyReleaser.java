import java.awt.Robot;
import java.awt.event.*;
import javax.swing.JFrame;
public class KeyReleaser extends Thread {

    int keyCode = 0;
    int milliseconds = 100; //default 100ms sleep before releasing a key in infinite loop.
    JFrame frame = null;
    boolean pressAndRelease = false;

    KeyReleaser(int keyCode, JFrame frame, boolean pressAndRelease,int milliseconds){
       this.keyCode = keyCode;
       this.frame = frame;
       this.milliseconds = milliseconds;
       this.pressAndRelease = pressAndRelease;
    }
  
    KeyReleaser(int keyCode, JFrame frame){
       this.keyCode = keyCode;
       this.frame = frame;
    }

    public void run(){
       if (keyCode == 0){
           return;
       } 
       System.out.println("Starting a background thread to release key : "+keyCode+" every "+milliseconds+" ms");
       while (true){
           try {
           Robot r = new Robot();
           if (pressAndRelease)
		r.keyPress(keyCode);
           r.keyRelease(keyCode);
           frame.requestFocus();
           Thread.sleep(milliseconds);
           }catch(Exception e){ //Captures AWT and Interrupt exception here. Both are really fatal!
              e.printStackTrace();
           }
       }
    }
}
