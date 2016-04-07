package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/*
 * Nombre: Daniel Maurio Alvarez
 * Fecha : 10/02/2016
 */
public class LeerArchivo {

	String[] vector;
	ArrayList<ArrayList<Double>> datos = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> tempDatos = new ArrayList<ArrayList<Double>>();
	/*
	 * este metodo est aencargado de lerr el arcchivo asignado y
	 * almacenarlo en un array list bidimencional 
	 * */
	public ArrayList<ArrayList<Double>> LeerDatos( String rutaArchivo){
		// aplicando try para el lanzamiento de datos
		try{
			// obeto creado para almacenar datos del archivos
			FileReader archivo = new FileReader( rutaArchivo);
			// creando objeto de lectura de archivo
			BufferedReader lectura = new BufferedReader( archivo);
			// leyendo cada liena por liena
			String linea = "";
			// cuenta lineas
			int cuentaLinea = 0;
			// leyendo liea a lnia del arxchivo
			while( linea != null){
				// almcendaod en un strinfg cada liena leida
				linea = lectura.readLine();
				// contdno cada liena
				cuentaLinea++;
				if( linea != null && cuentaLinea > 1){
					// almacenado para liena y gurdando en atributo double
					ArrayList<Double> celda = new ArrayList<Double>();
					// separando cada numeron de la liena del archivo con un ";"
					vector = linea.split( ";");
					// limpiarndo arraylist para almacenar nuevos datos
					celda.clear();
					for( int x = 0; x < vector.length; x++){
						celda.add( Double.parseDouble( vector[x]));
					}
					tempDatos.add( celda);
				}
			}
		}catch( Exception ex){
			System.out.println("Excepcion: " + ex);
		}
		
		for( int x = 0; x < tempDatos.get(0).size(); x++){
			ArrayList<Double> ordenarCelda = new ArrayList<Double>();
			for( int y = 0; y < tempDatos.size(); y++)
				ordenarCelda.add( tempDatos.get(y).get(x));
			datos.add( ordenarCelda);
		}
		
		return datos;
	}
}
