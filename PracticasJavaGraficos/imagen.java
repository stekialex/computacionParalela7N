import java.awt.*;
import javax.swing.*;

public class imagen extends JFrame{
	 public static void main(String[] args) {
		new imagen();
	}
	public imagen(){
		super("german imagen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}
	public void paint(Graphics lienzo){
		Image img = Toolkit.getDefaultToolkit().getImage("img/pineapple.jpg");
		lienzo.drawImage(img,100,100,this);
	}
}