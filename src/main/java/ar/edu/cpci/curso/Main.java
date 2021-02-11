package ar.edu.cpci.curso;

import java.util.List;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		String archivo_encuesta = args[0];
		String archivo_salida = args[1];
//		String archivo_salida = "/tmp/encuesta.csv";
		Encuesta encuesta_1 = new Encuesta();
		Scanner inputs = new Scanner(System.in);
		List<Pregunta> preguntas = new ArrayList();
		Pregunta pregunta_tmp = new Pregunta("Que colores te gustan? Ingrese opciones separada por espacios");
		pregunta_tmp.addOpcion("Negro");
		pregunta_tmp.addOpcion("Rojo");
		pregunta_tmp.addOpcion("Verde");
		pregunta_tmp.addOpcion("Azul");
		pregunta_tmp.addOpcion("otro");
		pregunta_tmp.setTipo(1);
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Cual es tu deporte favorito?");
		pregunta_tmp.addOpcion("Futbol");
		pregunta_tmp.addOpcion("Basquet");
		pregunta_tmp.addOpcion("Volley");
		pregunta_tmp.addOpcion("otro");
		pregunta_tmp.setTipo(0);
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Tu sexo?");
		pregunta_tmp.addOpcion("Masculino");
		pregunta_tmp.addOpcion("Femenino");
		pregunta_tmp.addOpcion("Otro");
		pregunta_tmp.setTipo(0);
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Tu edad en que rango está?");
		pregunta_tmp.addOpcion("Menor a 20");
		pregunta_tmp.addOpcion("Entre 20 y 30");
		pregunta_tmp.addOpcion("Entre 30 y 40");
		pregunta_tmp.addOpcion("Entre 40 y 50");
		pregunta_tmp.addOpcion("Mayor a 50");
		pregunta_tmp.setTipo(0);
	    preguntas.add(pregunta_tmp);
	     
	    encuesta_1.setPregunta(preguntas);
	    List<String> respuesta_dada = new ArrayList();
	    int i=0;
	    String nombre;
	    System.out.println("Cual es tu nombre");
	    nombre=inputs.nextLine();
	    String respuesta_tmp;
	    respuesta_dada.add(nombre);
	    Pregunta pregunta;
	    while(i< preguntas.size())
	    {
	      pregunta=preguntas.get(i);
	      pregunta.PrintPregunta();
	      respuesta_tmp=inputs.nextLine();
	      if(pregunta.getTipo()==0)
	      {
	    	  try
	    	  {
	    		  if(pregunta.compruebaRespuesta(respuesta_tmp)==0)
	    		  {
	    			  respuesta_dada.add(respuesta_tmp);
	    			  i++;
	    		  }
	    			  
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  System.out.println(e);
	    	  }
	      }
	      else
	      {
	    	  try
	    	  {
	    		  if(pregunta.compruebaRespuesta(respuesta_tmp)==0)
	    		  {
	    			  respuesta_dada.add(respuesta_tmp);
	    			  i++;
	    		  }
		    		    
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  System.out.println(e);
	    	  }
	      }
	    }
	    
	    try {
	    	FileWriter csvWriter = new FileWriter(archivo_salida);
	    	csvWriter.append("Nombre");
	        csvWriter.append(",");
	        csvWriter.append("respuesta0");
	        csvWriter.append(",");
	        csvWriter.append("respuesta1");
	        csvWriter.append(",");
	        csvWriter.append("respuesta2");
	        csvWriter.append(",");
	        csvWriter.append("respuesta3");
	        csvWriter.append("\n");
	        csvWriter.append(String.join(",", respuesta_dada));
	        csvWriter.append("\n");
	        csvWriter.flush();
	        csvWriter.close();
	    }catch (Exception e) {
	    	System.out.println("hubo algun error");
			// TODO: handle exception
		}
	    System.out.println(respuesta_dada);
	}
}
