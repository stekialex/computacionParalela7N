import java.awt.*;
import javax.swing.*;

public class monito extends JFrame{
	 public static void main(String[] args) {
		new monito();
	}
	public monito(){
		super("german monito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setVisible(true);
	}
	public void paint(Graphics lienzo){
		lienzo.drawString("ay mama",250,20);
		//cara
		lienzo.drawArc(50,50,100,100,0,360);
		//ojos
		lienzo.drawArc(70,80,20,20,0,360);
		lienzo.drawArc(110,80,20,20,0,360);
		//boca
		lienzo.fillArc(75,100,50,30,180,180);
		//cuerpo
		lienzo.drawLine(100,150,100,220);
		//piernas
		lienzo.drawLine(100,220,50,270);
		lienzo.drawLine(100,220,150,270);
		// brazos
		lienzo.drawLine(100,170,50,150);
		lienzo.drawLine(100,170,150,150);
		
	}
}