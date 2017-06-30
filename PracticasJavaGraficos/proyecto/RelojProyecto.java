import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import java.net.URL;
import java.util.*;

class RelojProyecto extends JFrame{
    public static void main(String[] args) {
        RelojProyecto app = new RelojProyecto();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    Reloj Cara;

    public RelojProyecto(){
        super( "Reloj Proyecto" );
        setVisible( true );
        setResizable( false );
        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());
        Cara = new Reloj();
        content.add(Cara, BorderLayout.CENTER);
        this.pack();

        Cara.start();
    }
}

class Reloj extends JPanel {

    private int horas;
    private int minutos;
    private int segundos;
    private ImageIcon backgroundImage = null;

    private static final int  ESPACIO = 10;
    private static final float Pi2 = (float)(2.0 * Math.PI);
    private static final float Pi3 = (float)(3.0 * Math.PI);
    private static final float rad = (float)(Math.PI / 30.0);

    private int tamano;
    private int xCentro;
    private int yCentro;
    private BufferedImage muestra;
    private Timer t;

    public Reloj() {
        this.setPreferredSize(new Dimension(300,300));
        t = new javax.swing.Timer(1000,
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        update();
                    }
                });
    }

    public void update() {
        this.repaint();
    }

    public void start() {
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int ancho = getWidth();
        int alto = getHeight();
        tamano = ((ancho < alto) ? ancho : alto) - 2 * ESPACIO;
        xCentro = tamano/2 + ESPACIO;
        yCentro = tamano/2 + ESPACIO - 10;

        if (muestra == null || muestra.getWidth() != ancho || muestra.getHeight() != alto) {
            muestra = (BufferedImage)(this.createImage(ancho, alto));
            Graphics2D gc = muestra.createGraphics();
            URL im = getClass().getResource("reloj.png");
            backgroundImage = new ImageIcon(im);
            gc.drawImage(backgroundImage.getImage(), 0, 0, null);
        }

        Calendar now = Calendar.getInstance();
        horas   = now.get(Calendar.HOUR);
        minutos = now.get(Calendar.MINUTE);
        segundos = now.get(Calendar.SECOND);

        g2.drawImage(muestra, null, 0, 0);

        Manecillas(g);
    }

    private void Manecillas(Graphics g) {
        int radioSegundero = tamano/3;
        int radioMinutero = radioSegundero * 2/4 + 25;
        int radioHora   = radioSegundero/2 - 5 + 20;

        float fsegundos = segundos;
        float anguloSegundero = Pi3 - (rad * fsegundos);
        efecto(g, xCentro, yCentro, anguloSegundero, 0, radioSegundero);

        float fminutos = (float)(minutos + fsegundos/60.0);
        float anguloMinutero = Pi3 - (rad * fminutos);
        efecto(g, xCentro, yCentro, anguloMinutero, 0, radioMinutero);

        float fhours = (float)(horas + fminutos/60.0);
        float anguloHora = Pi3 - (5 * rad * fhours);
        efecto(g, xCentro, yCentro, anguloHora, 0, radioHora);
    }

    private void efecto(Graphics g, int x, int y, double angulo, int minRadius, int maxRadius) {
        float sine   = (float)Math.sin(angulo);
        float cosine = (float)Math.cos(angulo);

        int dxmin = (int)(minRadius * sine);
        int dymin = (int)(minRadius * cosine);

        int dxmax = (int)(maxRadius * sine);
        int dymax = (int)(maxRadius * cosine);
        g.drawLine( x+dxmin, y+dymin, x+dxmax, y+dymax);
    }
}