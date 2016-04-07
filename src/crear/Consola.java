package crear;

import java.text.DecimalFormat;
import java.util.ArrayList;

import logica.*;

public class Consola {

	public Consola() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * esta fucion crea un arraylist de string para mostrar la
	 * informacion de una forma mas clara el entregar el resutlado
	 * los datos que resive son una relacioncion de columna de forma 
	 * vector lineal un vectro de las cabecerasdel resutlado y unsarraylist
	 * double de los datos resicibidos 
	 * */
	public ArrayList<ArrayList<String>> RegresionLineal( Integer[][] relaciones, String[] cabezera, ArrayList<ArrayList<Double>> datos, double Yk ){
		// alamacenas la longitude los caracteres
		ArrayList<Integer> longitudColumna = new ArrayList<Integer>();
		// almacenas las columans uqe se van mostrar
		ArrayList<String> columna = new ArrayList<String>();
		// almacena el reultado delas tablas 
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		// calcular regresion lineal
		RegresionLineal rl = new RegresionLineal();
		// gudar la longitud icnias de los cacteres de las columans
		for( String x: cabezera){
			columna.add(x);
			longitudColumna.add( x.length());
		}
		tabla.add(columna);
		// formatea los resltados de la tabla
		DecimalFormat f = new DecimalFormat("#.####");
		// calcual y almacen los resultado es de la regresion lineal
		for( int x = 0; x < datos.size(); x++){
			ArrayList<String> columnaData = new ArrayList<String>();
			columnaData.add( "test " + ( x + 1 )+ " ");
			columnaData.add( f.format(rl.Beta0( datos.get(relaciones[x][0]), datos.get(relaciones[x][1]))) + " ");
			columnaData.add( f.format(rl.Beta1( datos.get(relaciones[x][0]), datos.get(relaciones[x][1]))) + " ");
			columnaData.add( f.format(rl.Rxy(   datos.get(relaciones[x][0]), datos.get(relaciones[x][1]))) + " ");
			columnaData.add( f.format(rl.R2(    datos.get(relaciones[x][0]), datos.get(relaciones[x][1]))) + " ");
			columnaData.add( f.format(rl.Yk(    datos.get(relaciones[x][0]), datos.get(relaciones[x][1]), 386)) + " ");
			
			if( columnaData.size() > 0)
				tabla.add(columnaData);
		}
		// almacena la cantidad e maxima longitud de catareres para cada columna 
		for( int x = 0; x < tabla.size(); x++){
			for( int y = 0; y < tabla.get(x).size(); y++){
				if( longitudColumna.get(y) < tabla.get(x).get(y).length())
					longitudColumna.set(y, tabla.get(x).get(y).length());
			}
		}
		// crea los espacion encesario par auna mejor voisualizacion de los datos
		for( int x = 0;  x < tabla.size(); x++){
			ArrayList<String> celda = new ArrayList<String>();
			for( int y = 0;  y < tabla.get(x).size(); y++){
				String espacios = " ";
				if( longitudColumna.get(y) != tabla.get(x).get(y).length()){
					for( int z = tabla.get(x).get(y).length(); z < longitudColumna.get(y); z++)
						espacios += " ";
				}
				celda.add( espacios + tabla.get(x).get(y) + " ");
			}
			tabla.set(x, celda);
		}
		
		return tabla;
	}
}
