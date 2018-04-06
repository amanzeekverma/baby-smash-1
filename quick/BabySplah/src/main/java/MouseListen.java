import java.util.*;
import java.awt.event.*;

public class MouseListen extends MouseAdapter implements MouseMotionListener{

	public void mouseClicked(MouseEvent e){
             System.out.println("Mouse Clicked at X:"+e.getX()+"  Y:"+e.getY());
        }
        
        public void mouseMoved(MouseEvent e){
             //Uncomment if mouse movement also needs to be recorded. This will produce a very versbose sysout
             //System.out.println("Mouse Moved to X:"+e.getX()+" Y:"+e.getY());        
        }

        public void mouseDragged(MouseEvent e) {
             System.out.println("Mouse Dragged to X:"+e.getX()+" Y:"+e.getY());        
        }
}
