import java.awt.*;
import javax.swing.*;

// Paint, repaint, update


public class Monito extends JFrame{
	 public static void main(String[] args) {
		new Monito();
	}
	public Monito(){
		super("german ayayaya");
		setSize(200,300);
		setVisible(true);
	}
	public void paint(Graphics lienzo){
		lienzo.drawString("ay mama",20,20);
		lienzo.drawArc(50,60,40,40,0,360);
	}
}