import java.util.Random;
public class convertidor{

	public static void main( String args[]){
		String tipo = args[0];
		int i;
		boolean error = false;
		if(tipo.equals("-ip")||tipo.equals("-hex") ){
			int espacios = args[1].split("\\.").length;
			// System.out.println(args[1]);
			// System.out.println(espacios);
			if (espacios!=4){
				System.out.println("formato no valido");
				
			}else{

				String convertirString[] = new String [espacios];
				convertirString =args[1].split("\\.");
	 			
	 			int convertirNum[]=new int [espacios]; 
	 			String hex[]=new String [espacios]; 
				
				try{

					for ( i=0;i<espacios ;i++  ) {//copiar como int
						if(tipo.equals("-ip")){

							convertirNum[i]= Integer.parseInt(convertirString[i]);
							if(convertirNum[i]<0 || convertirNum[i]>255){
								System.out.println("Un numero excede 255 o es menor a 0... byebye");
								error= true;
								break;
							}
							hex[i]=Integer.toHexString(convertirNum[i]);
							
						}else{
							convertirNum[i] = (int) Long.parseLong(convertirString[i], 16);
							if(convertirNum[i]<0 || convertirNum[i]>255){
								System.out.println("Un numero excede 255 o es menor a 0... byebye");
								error= true;
								break;
								}
						}

					}
					if(error){

					}else if(tipo.equals("-ip")){
						System.out.println(hex[0]+"."+hex[1]+"."+hex[2]+"."+hex[3]);
					
					}else{
						System.out.println(convertirNum[0]+"."+convertirNum[1]+"."+convertirNum[2]+"."+convertirNum[3]);

					}
				}catch(NumberFormatException  ex){
					System.out.println("Error, no se pudo convertir");
				}



			}
		
		}else{
			System.out.println(tipo + " not suported");
		}
		
	}


}
