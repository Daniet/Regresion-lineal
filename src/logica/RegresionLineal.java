package logica;

import java.util.ArrayList;

public class RegresionLineal {
	/*
	 * funciocn crear para multipar array list y retornar 
	 * la multiplicacion lista 
	 * */	
	public static ArrayList<Double> MultiplicarLista( ArrayList<Double> num1, ArrayList<Double> num2){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < num1.size(); x++)
			resultado.add( num1.get(x) * num2.get(x));
		return resultado;
	}
	/*
	 * saber la raiz cuadarda de las arraylist devolviendo un aarraylist double
	 * */
	public static ArrayList<Double> ListaRaizCuadrada( ArrayList<Double> numeros){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < numeros.size(); x++)
			resultado.add(numeros.get( x) * numeros.get( x));
		return resultado;
	}
	/*
	 * crear una un atributo douible sumando los numero de la lista
	 * */
	public static double Sumatoria( ArrayList<Double> numeros){
		
		double sumatoria = 0;
		for( double x: numeros)
			sumatoria += x;
		return sumatoria;
	}
	/*
	 * retorna el numero promedio de un alarraylist dousble
	 * */
	public static double Promedio( ArrayList<Double> numeros){
		return Sumatoria(numeros) / numeros.size();
	}
	/*
	 * return el valor de N para la regresion lienal 
	 * resiviendo como parametro el promedio de la
	 * columna X
	 * */
	public static double N( double promedioX){

		return promedioX * promedioX;
	}
	/*
	 * retorna el valor beta 1 de la regresion lineal
	 * resiviendo como parametro dos  araaylist doubel 
	 * */
	public static double Beta1( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double raizCuadradaPromedioX = promedioX * promedioX;
		double sumatoriaMultiplicarLista = Sumatoria( MultiplicarLista( num1, num2));
		double sumatoriaRaizCuadradaX = Sumatoria(ListaRaizCuadrada( num1));
		return ((sumatoriaMultiplicarLista) - (( N * promedioX) * promedioY)) / (sumatoriaRaizCuadradaX - (N * raizCuadradaPromedioX ));
	}
	/*
	 * retorna Rxy de la regresion lienal resividiendo 
	 * como parametro de dos arratylist double
	 * */
	public static double Rxy0( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double sumatoriaMultiplicarXY = Sumatoria( MultiplicarLista( num1, num2)); 
		double sumatoriaX = Sumatoria(num1);
		double sumatoriaY = Sumatoria(num2);
		return ( N * ( sumatoriaMultiplicarXY) - ( sumatoriaX * sumatoriaY) );
	}
	/*
	 * retorna Rxy de la regresion lienal resividiendo 
	 * como parametro de dos arratylist double
	 * */
	public static double Rxy( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double columnaX = num1.size() * (Sumatoria( ListaRaizCuadrada(num1))) - (Sumatoria( num1) * Sumatoria( num1));
		double columnaY = num1.size() * (Sumatoria( ListaRaizCuadrada(num2))) - (Sumatoria( num2) * Sumatoria( num2));
		double raizCuadradaColumnasXY = Math.sqrt( columnaX * columnaY);
		
		return Rxy0( num1, num2) / raizCuadradaColumnasXY;
	}
	
	/*
	 * retorna la reiz cudadra de de R resiviebdi como
	 * dos array list como parametros
	 * */
	public static double R2( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double Rxy = Rxy( num1, num2);
		return Rxy * Rxy;
	}
	/*
	 * retorna el valor de beta cero ctomando como
	 * parametro dos array list double
	 * */
	public static double Beta0( ArrayList<Double> num1, ArrayList<Double> num2){

		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double b1 = Beta1( num1, num2);
		return promedioY - 	( b1 * promedioX);
	}
	/*
	 * retorna el valor de Yk resiviendo como parametro dos arraylist 
	 * double y la constante XK
	 * */
	public static double Yk( ArrayList<Double> num1, ArrayList<Double> num2, double Xk){

		double b1 = Beta1( num1, num2);
		double b0 = Beta0( num1, num2);
		return b0 + ( b1 * Xk);
	}
	
}
