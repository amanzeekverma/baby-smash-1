import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.unix.X11.Display;
import com.sun.jna.platform.unix.X11.XClientMessageEvent;
import com.sun.jna.platform.unix.X11.XEvent;
/**
Tushar Kapila

open BSD licence

2013
Invite you to improve and add to this project.


*/

public class BabySmash extends JFrame{
	boolean isFullScreen =false;
	public static final String EXIT_STR =  "exitnow";
	public static final String HLP_STR = "Baby smash. To exit, type ) :" + EXIT_STR;
	Cntainer conty;
        
        //X-11 helpers.
        private static final int _NET_WM_STATE_REMOVE = 0;
	private static final int _NET_WM_STATE_ADD = 1;
	private static final int TRUE = 1;

	public BabySmash (GraphicsDevice device){
		super(device.getDefaultConfiguration());
                Container c = getContentPane();
                String osname = System.getProperty("os.name");
                //OSNAME CHECK STARTS
                if (osname.startsWith("Linux")){ //Covers Ubuntu and other X11 supported *nix
                    setVisible(true);
                    setFullScreenWindowX11(SwingUtilities.getWindowAncestor(c), true); 
                } else { //original code here.
		boolean ss = true;
		if(ss){
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//EXIT_ON_CLOSE
			isFullScreen = device.isFullScreenSupported();

		}
		setUndecorated(isFullScreen);
		setResizable(!isFullScreen);
		if (isFullScreen) {
                    System.out.println("I am here");
		    device.setFullScreenWindow(this);
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
		    //validate();
		} else {
		    // Windowed mode
		    pack();
		    setVisible(true);
		}
                } //OSNAME CHECK ENDS.

		//setContentPane(conty);
		c.setLayout(null);
		JButton b = new JButton ("_");
		//b.add
		c.add(b);
		b.setBounds(20,12,40,40);

		conty = new Cntainer(this);
		c.add(conty);
		conty.setBounds(0,110,2220,2240);

		setTitle(HLP_STR);

		KeyBoardListen keys = new KeyBoardListen (EXIT_STR);
		b.addKeyListener(keys);
		JLabel lbl = new JLabel (HLP_STR);
		c.add(lbl);
		lbl.setBounds(20,55, 600,89);
 	}

 public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.
            getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
        // REMIND : Multi-monitor full-screen mode not yet supported
        for (int i = 0; i < 1 /* devices.length */; i++) {
            BabySmash test = new BabySmash(devices[i]);

        }
    }
  
     public static boolean setFullScreenWindowX11(Window w, boolean fullScreen) {
	    X11 x = X11.INSTANCE;
	    Display display = null;
	    try {
	        display = x.XOpenDisplay(null);
	        int result = sendClientMessage(display, Native.getWindowID(w), "_NET_WM_STATE", new NativeLong(fullScreen ? _NET_WM_STATE_ADD : _NET_WM_STATE_REMOVE), x.XInternAtom(display, "_NET_WM_STATE_FULLSCREEN", false));
	        return result != 0;
	    }
	    finally {
	        if(display != null) {
	            x.XCloseDisplay(display);
	        }
	    }
	}
 
 
 private static int sendClientMessage(Display display, long wid, String msg, NativeLong data0, NativeLong data1) {
	    X11 x = X11.INSTANCE;
	    XEvent event = new XEvent();
	    event.type = X11.ClientMessage;
	    event.setType(XClientMessageEvent.class);
	    event.xclient.type = X11.ClientMessage;
	    event.xclient.serial = new NativeLong(0L);
	    event.xclient.send_event = TRUE;
	    event.xclient.message_type = x.XInternAtom(display, msg, false);
	    event.xclient.window = new com.sun.jna.platform.unix.X11.Window(wid);
	    event.xclient.format = 32;
	    event.xclient.data.setType(NativeLong[].class);
	    event.xclient.data.l[0] = data0;
	    event.xclient.data.l[1] = data1;
	    event.xclient.data.l[2] = new NativeLong(0L);
	    event.xclient.data.l[3] = new NativeLong(0L);
	    event.xclient.data.l[4] = new NativeLong(0L);
	    NativeLong mask = new NativeLong(X11.SubstructureRedirectMask | X11.SubstructureNotifyMask);
	    int result = x.XSendEvent(display, x.XDefaultRootWindow(display), 0, mask, event);
	    x.XFlush(display);
	    return result;
	}
 

    }
