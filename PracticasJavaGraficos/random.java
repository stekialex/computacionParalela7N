import java.util.Random;
public class random{

	public static void main( String args[]){
		Random  numRand = new Random();
		int a = numRand.nextInt(100);
		int b = numRand.nextInt(100);
		System.out.println("numeros random " + a+" "+b);
		System.out.println("mayor "+Math.max(a,b));

	}


}
