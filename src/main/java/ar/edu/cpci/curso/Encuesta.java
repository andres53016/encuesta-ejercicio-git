package ar.edu.cpci.curso;
import java.util.List;
public class Encuesta {
	private String nombre;
	private List<Pregunta> pregunta;
	private int tipo;
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public void Encuesta(String nombre) {
		this.setNombre(nombre);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Pregunta> getPregunta() {
		return pregunta;
	}
	public void setPregunta(List<Pregunta> pregunta) {
		this.pregunta = pregunta;
	}
	
}
