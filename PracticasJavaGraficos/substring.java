import java.util.Random;
public class substring{

	public static void main( String args[]){
		String cadena = args[0];
		int i;

		for ( i=0;i<= cadena.length() ;i++  ) {
			System.out.println(cadena.substring(0,i));
		}
		for ( i=cadena.length();i>=0 ;i--  ) {
				System.out.println(cadena.substring(i,cadena.length()));
		}
	}


}
