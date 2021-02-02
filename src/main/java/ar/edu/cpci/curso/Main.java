package ar.edu.cpci.curso;

import java.util.List;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Encuesta encuesta_1 = new Encuesta();
		Scanner inputs = new Scanner(System.in);
		List<Pregunta> preguntas = new ArrayList();
		Pregunta pregunta_tmp = new Pregunta("Que color te gusta?");
		pregunta_tmp.addOpcion("Negro");
		pregunta_tmp.addOpcion("Rojo");
		pregunta_tmp.addOpcion("Verde");
		pregunta_tmp.addOpcion("Azul");
		pregunta_tmp.addOpcion("otro");
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Cual es tu deporte favorito?");
		pregunta_tmp.addOpcion("Futbol");
		pregunta_tmp.addOpcion("Basquet");
		pregunta_tmp.addOpcion("Volley");
		pregunta_tmp.addOpcion("otro");
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Tu sexo?");
		pregunta_tmp.addOpcion("Masculino");
		pregunta_tmp.addOpcion("Femenino");
		pregunta_tmp.addOpcion("Otro");
		preguntas.add(pregunta_tmp);
		
		pregunta_tmp = new Pregunta("Tu edad en que rango está?");
		pregunta_tmp.addOpcion("Menor a 20");
		pregunta_tmp.addOpcion("Entre 20 y 30");
		pregunta_tmp.addOpcion("Entre 30 y 40");
		pregunta_tmp.addOpcion("Entre 40 y 50");
		pregunta_tmp.addOpcion("Mayor a 50");
	    preguntas.add(pregunta_tmp);
	    
	    List<String> respuesta_dada = new ArrayList();
	    int i=0;
	    String nombre;
	    System.out.println("Cual es tu nombre");
	    nombre=inputs.nextLine();
	    respuesta_dada.add(nombre);
	    
	    for(Pregunta pregunta:preguntas)
	    {
	      pregunta.PrintPregunta();
	      respuesta_dada.add(Integer.toString(inputs.nextInt()));
	    }
	    
	    try {
	    	FileWriter csvWriter = new FileWriter("/tmp/encuesta.csv");
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
