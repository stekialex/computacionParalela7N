import java.util.Random;
public class ordenar{

	public static void main( String args[]){
			System.out.println("ordenando "+ args.length+ "numeros");
		int numeros[]=new int [args.length]; 
		int temp;
		int i;
		int j;
		for ( i=0;i<args.length ;i++  ) {//copiar como int
			numeros[i]=0;
			numeros[i]= Integer.parseInt(args[i]);
		}
		for( i=0;i<numeros.length ;i++ ) {
			for(j = 0 ; j <numeros.length;j++){
				
				if(numeros[i]<numeros[j]){
					temp= numeros[j];
					numeros[j]=numeros[i];
					numeros[i]= temp;
				}
			
			}
		}

		for(i=0;i<numeros.length;i++){
			System.out.println(i+".-"+ numeros[i]);
		}

	}


}
