package ar.edu.cpci.curso;
import java.util.List;
import java.util.ArrayList;
public class Pregunta {
	private String texto;
	private List<String> opciones;
	public Pregunta(String texto) {
		this.opciones = new ArrayList();
		this.setTexto(texto);
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public List<String> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}
	public void addOpcion(String opcion) {
		this.opciones.add(opcion);
	}
	public void PrintPregunta() {
		System.out.println(this.texto);
		int i = 1;
		for(String opcion:this.opciones) {
			System.out.println(i++ +" - "+opcion);
		}
			
	    
	}
}
