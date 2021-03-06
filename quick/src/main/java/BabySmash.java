import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import uk.co.caprica.vlcj.runtime.x.*;
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

        private static boolean isAdminMode = false;
        
	public BabySmash (GraphicsDevice device){
		super(device.getDefaultConfiguration());
                Container c = getContentPane();
                String osname = System.getProperty("os.name");
                //OSNAME CHECK STARTS
                if (osname.startsWith("Linux")){ //Covers Ubuntu and other X11 supported *nix
                    setVisible(true);
                    LibXUtil.setFullScreenWindow(SwingUtilities.getWindowAncestor(c), true); 
                } else { //original code here.
		boolean ss = true;
		if(ss){
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//EXIT_ON_CLOSE
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
               
                if (this.isAdminMode){
                   JButton emergencyExitB = new JButton("Emergency Exit");
                   c.add(emergencyExitB);
                   emergencyExitB.setBounds(1024,800,200,50);   
                   emergencyExitB.addActionListener(e -> System.exit(0));
                }

		conty = new Cntainer(this);
		c.add(conty);
		conty.setBounds(0,110,2220,2240);

		setTitle(HLP_STR);

		KeyBoardListen keys = new KeyBoardListen (EXIT_STR, this);
		this.addKeyListener(keys);
                b.addKeyListener(keys);
		JLabel lbl = new JLabel (HLP_STR);
		c.add(lbl);
		lbl.setBounds(20,55, 600,89);
                
                //Add mouse listener
                MouseListen mouseL = new MouseListen();
                this.addMouseListener(mouseL);
                this.addMouseMotionListener(mouseL);

 	}

 public static void main(String[] args) {
        if (args.length > 0){
           if (args[0].equals("admin")){
              isAdminMode = true;
           }
        }
        GraphicsEnvironment env = GraphicsEnvironment.
            getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
        // REMIND : Multi-monitor full-screen mode not yet supported
        for (int i = 0; i < 1 /* devices.length */; i++) {
            BabySmash test = new BabySmash(devices[i]);

        }
    }
}
