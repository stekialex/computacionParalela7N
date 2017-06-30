import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	 public static void main(String[] args) {
		new Ventana();
	}
	public Ventana(){
		super("german ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setVisible(true);
	}
	


}
