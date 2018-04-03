import java.util.*;
import java.awt.event.*;

public class KeyBoardListen extends java.awt.event.KeyAdapter{

	private StringBuilder queque = new StringBuilder();
	private String match = null;

	public KeyBoardListen(String a){
		match = a.toLowerCase();
	}

	public void keyTyped(KeyEvent e){
		char c = Character.toLowerCase(e.getKeyChar());
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

}
