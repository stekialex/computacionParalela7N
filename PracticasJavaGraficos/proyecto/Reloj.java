
import java.util.Calendar;
import java.awt.*;
import java.awt.BasicStroke;
import javax.swing.*;
import java.io.File;

import javax.sound.sampled.*;
// import javax.io.IOException;
// import javax.javax.imageio.ImageIO;
/**
 *
 * @author Alonso
 */
public class Reloj extends JFrame implements Runnable{

    private Thread hilo;
    public Reloj() 
	{
		super ("Reloj");
		setResizable(false);
		setSize(450, 450);
		setVisible(true);

			
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                hilo = new Thread(this);
                hilo.start();

            try{
            	Clip sonido= AudioSystem.getClip();
				sonido.open(AudioSystem.getAudioInputStream(new File("src/motor3.wav")));
				sonido.loop(100000);
            }catch(Exception e){
            	System.out.println(e);
            }
		


	}
    
    public static void main (String args[])	
	{
		new Reloj();

	}

	private Image fondo;
	private Image buffer;
    private int manecillaGrande=150;
    private int manecillaSegundero=170;
    private int manecillaChica=130;
    private int first=0;
    private int sonidoSonando=0;
    private int min;
    private int hora;
        private int sec;

    @Override
	public void paint (Graphics g)
	{
		if (fondo == null)
		{
			
			
			
     //pintar circulo del Reloj
     fondo = createImage(getWidth(),getHeight());
			Graphics gfondo = fondo.getGraphics();
			gfondo.setClip(0,0,getWidth(), getHeight());
           ImageIcon fondiu = new ImageIcon("img/rinBMW.png");
				gfondo.drawImage(fondiu.getImage(),0,0,this);
                        gfondo.setColor(Color.red);
                        
			// gfondo.drawOval((getWidth()-200)/2,(getHeight()-200)/2, 200, 200);
		}
		update(g);
	}

    @Override
	public void update(Graphics g)
	{
		double x1,y1,angulito1,x2,y2,angulito2,x3,y3,angulito3;
		g.setClip(0,0,getWidth(),getHeight());
		Calendar cal = Calendar.getInstance();

		if (cal.get(Calendar.MINUTE) != min )
		{
			first++;;
			//regenerar la imagen de fondo
			hora = cal.get(Calendar.HOUR);
			min = cal.get(Calendar.MINUTE);

			//crea la imagen estatica
			buffer = createImage(getWidth(), getHeight());
			Graphics gbuffer = buffer.getGraphics();
			gbuffer.setClip(0,0,getWidth(), getHeight());
			gbuffer.drawImage(fondo,0,20,this);
			// gbuffer.setStroke(new BasicStroke(4));


            gbuffer.setColor(Color.ORANGE);
            angulito1 =angulo12(hora);
			x1 =getx(angulito1,manecillaChica);
			y1 =gety(angulito1,manecillaChica);
			gbuffer.drawLine(getWidth()/2, getHeight()/2,(getHeight()/2)+(int)x1,(getHeight()/2)+(int)y1);

			// gbuffer.fillArc((getWidth()-manecillaChica)/2, (getHeight()-manecillaChica)/2, manecillaChica, manecillaChica, angulo12(hora), 5);
            gbuffer.setColor(Color.BLUE);
            angulito2 =angulo60(min);
			x2 =getx(angulito2,manecillaGrande);
			y2 =gety(angulito2,manecillaGrande);
			gbuffer.drawLine(getWidth()/2, getHeight()/2,(getHeight()/2)+(int)x2,(getHeight()/2)+(int)y2);

			// gbuffer.fillArc((getWidth()-manecillaGrande)/2, (getHeight()-manecillaGrande)/2, manecillaGrande, manecillaGrande, angulo60(min), 5);
                       
		}   

		//pintar buffer 
		g.drawImage(buffer, 0 , 0, this);
		sec = cal.get(Calendar.SECOND);

		//pintar ente movil
                g.setColor(Color.RED);

                //cuando sepa girar una imagen aqui ira.
		// g.drawImage(imgSegundero, 0 , 0, this);
		angulito3 =angulo60(sec);
		x3 =getx(angulito3,manecillaSegundero);
		y3 =gety(angulito3,manecillaSegundero);
		// g.setStroke(new BasicStroke(4));
		g.drawLine(getWidth()/2, getHeight()/2,(getHeight()/2)+(int)x3,(getHeight()/2)+(int)y3);
		
		if(sonidoSonando==5){
			// try(
				
			sonidoSonando=0;

		}else{
			sonidoSonando++;
		}
		// g.fillArc((getWidth()-manecillaSegundero)/2, (getHeight()-manecillaSegundero)/2, manecillaSegundero, manecillaSegundero, angulo60(sec), 5);
	}

    @Override
    public void run() {
        while (true) {
        try
        {
           hilo.sleep(1000);
        }
        catch(InterruptedException ex){}
        repaint();
    }}

    private int angulo12(int hora) {
        if (hora < 3)
            return (360/12)* Math.abs(hora-3);
        if (hora > 3 )
            return (360/12) * (3 - hora);
        return 0;
      
    }

    private int angulo60(int min) {
        if (min < 15 )
            return (360/60)*Math.abs(min-15);
        if (min > 15 )
            return (360/60)*(15-min);
        return 0;
    
    }

    private double getx(double angulo,int radio) {
    	double x = (double)radio * (double)(Math.sin(Math.toRadians(angulo)));
        return x;
    } 
    private double gety(double angulo,int radio) {
    	double y = (double)radio * (double)(Math.cos(Math.toRadians(angulo)));
        return y;
    }
}

