package ar.edu.cpci.curso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		String archivo_encuesta = args[0];
		String archivo_salida = args[1];
//		String archivo_salida = "/tmp/encuesta.csv";
		Encuesta encuesta_1 = new Encuesta();
		Scanner inputs = new Scanner(System.in);
		List<Pregunta> preguntas = new ArrayList();
		try
		{
			BufferedReader reader_encuesta = new BufferedReader (new FileReader(archivo_encuesta));
			String line;
			Pregunta pregunta_tmp = new Pregunta("");
			encuesta_1.setNombre(reader_encuesta.readLine());
			encuesta_1.setTipo(Integer.parseInt(reader_encuesta.readLine()));
			if(encuesta_1.isCorregible())
			{
				encuesta_1.setRespuesta_correcta(reader_encuesta.readLine().split(","));
			}
			while ((line = reader_encuesta.readLine()) != null) {
				
				if(line.charAt(0)=='#')
				{
					if(pregunta_tmp.getTexto().length()>0)
					{
						preguntas.add(pregunta_tmp);
					}
					pregunta_tmp = new Pregunta(line.substring(1));
					pregunta_tmp.setTipo(1);
				}
				else if(line.charAt(0)=='%')
				{
					if(pregunta_tmp.getTexto().length()>0)
					{
						preguntas.add(pregunta_tmp);
					}
					pregunta_tmp = new Pregunta(line.substring(1));
					pregunta_tmp.setTipo(0);
				}
				else
				{
					pregunta_tmp.addOpcion(line);
				}
			}
			preguntas.add(pregunta_tmp);
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.exit(0);
		}
	    encuesta_1.setPregunta(preguntas);
	    List<String> respuesta_dada = new ArrayList();
	    int i=0;
	    String nombre;
	    System.out.println("Cual es tu nombre");
	    nombre=inputs.nextLine();
	    String respuesta_tmp;
	    respuesta_dada.add(nombre);
	    Pregunta pregunta;
	    String respuesta_correcta;
	    while(i< encuesta_1.getPregunta().size())
	    {
	      pregunta=encuesta_1.getPregunta().get(i);
	      pregunta.PrintPregunta();
	      respuesta_tmp=inputs.nextLine();
	      if(pregunta.getTipo()==0)
	      {
	    	  try
	    	  {
	    		  if(pregunta.compruebaRespuesta(respuesta_tmp)==0)
	    		  {
	    			  if(encuesta_1.isCorregible())
	    			  {
	    				  respuesta_correcta=encuesta_1.getRespuesta_correcta()[i];
	    				  if(respuesta_correcta.equals(respuesta_tmp))
	    				  {
	    					  System.out.println("Respuesta Correcta");
	    				  }
	    				  else
	    				  {
	    					  System.out.println("Respuesta Incorrecta");
	    				  }
	    			  }
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
	    			  if(encuesta_1.isCorregible())
	    			  {
	    				  respuesta_correcta=encuesta_1.getRespuesta_correcta()[i];
	    				  if(respuesta_correcta==respuesta_tmp)
	    				  {
	    					  System.out.println("Respuesta Correcta");
	    				  }
	    				  else
	    				  {
	    					  System.out.println("Respuesta Incorrecta");
	    				  }
	    			  }
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
