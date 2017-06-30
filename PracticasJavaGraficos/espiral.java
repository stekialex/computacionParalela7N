import java.awt.*;
import javax.swing.*;
public class espiral extends JFrame implements Runnable{
	public int rCambio=6;
	public int tamano=150;
	public int count=1;
	private Thread thr;
	 public static void main(String[] args) {
		new espiral();

	}
	public espiral(){
		super("german espiral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setVisible(true);
		thr = new Thread(this);
		thr.start();
	}
	public void run(){
		while(count!=tamano){
			try{
				thr.sleep(80);
			}catch(InterruptedException ex){

			}
			repaint();
		}
	}
	public void paint(Graphics lienzo){
		int centroFijo=500,centro;
		int mCambio;
		int avanzaGrados=180,g2=0,g1=180;
		mCambio= rCambio/2;
		// lienzo.drawLine()
		if(count<=tamano) {
		
			


			centro = centroFijo-(count*mCambio);
				
					if(count ==1){

					lienzo.drawArc(centro,centro,rCambio*count,rCambio*count,g1,avanzaGrados);
				
					lienzo.drawArc(centro-rCambio,centro,rCambio*count,rCambio*count,g2,avanzaGrados);
					}
					else {
				
					lienzo.drawArc(centro-rCambio,centro,rCambio*count,rCambio*count,g2,avanzaGrados);
					lienzo.drawArc(centro,centro,rCambio*count,rCambio*count,g1,avanzaGrados);
					
					}

			
			
		}
	count +=2;
		
	}
}