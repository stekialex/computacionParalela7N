import java.awt.*;
import javax.swing.*;

public class Diagrama extends JFrame{
	public int total,valores[];
	public float grados[][],porcentaje[];
	public String[] nombres;
	public Color colores[] ;

	 public static void main(String[] args) {
	 	
	 	if((args.length%2)==0 && args.length!=0){
			new Diagrama(args);

		 	
	 	}
	}
	public Diagrama(String[] args){
		super("german Diagrama pastel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// total=0;

		cargarColores();
		nombres = new String [args.length/2];
		 valores = new int [args.length/2];
		 grados = new float [args.length/2][2];
		 porcentaje = new float [args.length/2];

		 	for (int i=0;i<args.length ;i++ ) {
		 		int index = i/2;
		 			nombres[index]=args[i];
		 			i++;
		 			valores[index]=Integer.parseInt(args[i]);
		 			total+=valores[index];
		 		
		 	}


		
		calcularPorcentaje();
	}

	public void calcularPorcentaje(){
		float ultimoGrado = 0;

		for (int i=0;i<valores.length ;i++ ) {
			grados[i][0]= ultimoGrado;
			grados[i][1]=360*((float)(valores[i])/total);
			porcentaje[i]=(float)(valores[i])*100/total;
			ultimoGrado+= grados[i][1];
			System.out.println(grados[i][1]);
		}

		mostrarDiagrama();
	}
	public void mostrarDiagrama(){

		setSize(500,500);
		setVisible(true);


	}
	public void paint(Graphics lienzo){
		int ultimoletra=370;
		for (int i=0;i<valores.length ;i++ ) {
			
			lienzo.setColor(colores[i]);
			
			lienzo.fillArc(50,50,300,300,(int)grados[i][0],(int)grados[i][1]);
			lienzo.drawString((int)porcentaje[i]+"% "+nombres[i] ,50,ultimoletra);
			ultimoletra+=25;
		}
		
	}

	public void cargarColores(){

		colores = new Color [10];
		colores[0]= new Color(50,100,150);
		colores[1]= new Color(100,150,50);
		colores[2]= new Color(150,100,50);
		colores[3]= new Color(150,50,100);
		colores[4]= new Color(150,200,250);
		colores[5]= new Color(200,150,250);
		colores[6]= new Color(250,150,200);
		colores[7]= new Color(250,200,150);
		colores[8]= new Color(50,50,50);
		colores[9]= new Color(250,250,250);
	}

}