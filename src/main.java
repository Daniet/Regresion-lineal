
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

import crear.*;
import logica.LeerArchivo;

public class main {


	public static void main(String[] args) {

		// almacenar datos 
		ArrayList<ArrayList<Double>> datos = new ArrayList<ArrayList<Double>>();
		
		// almacenar ruta
		String rutaArchivo, constanteString;
		int constante = 0;
		
		// columnad de informacion
		ArrayList<String> columnas = new ArrayList<String>();
		
		// capturar la informacion del teclado 
		Scanner entrada = new Scanner(System.in);
		
		// objeto para leer archivo
		LeerArchivo leerArchivo = new LeerArchivo();

		System.out.println("ingresar ruta de archivo:");
		// ruta del archivo
		rutaArchivo = entrada.nextLine();
		System.out.println("Ingresar el valor de Xk");
		// Almacenado el valor de la constante Xk
		constanteString = entrada.nextLine();
		constante = Integer.parseInt(constanteString);
		// relacion entre las columnas
		Integer[][] relaciones = { {0, 2}, {0,3}, {1,2}, {1,3}};
		// cabezaras de los resultados
		String[] cabezera = {"Pruebas", "Beta 0", "Beta 1", "Rxy", "R^2", "Yk"};
		// objeto para lerr datos
		LeerArchivo leer = new LeerArchivo();
		datos = leer.LeerDatos( rutaArchivo);
		// objetos para mostrar resutlado
		Consola consola = new Consola();
		// ejecucion de los resultado de regrewsion lienal
		ArrayList<ArrayList<String>> regresionLineal = consola.RegresionLineal(relaciones, cabezera, datos, constante);
		for( ArrayList<String> x: regresionLineal)
			System.out.println(x);
	} 

}
