package ar.edu.cpci.curso;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
public class Pregunta {
	private String texto;
	private List<String> opciones;
	private int tipo;
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
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
	public int compruebaRespuesta(String respuesta) throws FormatoIncorrectoException, OpcionIncorrectaException
	{
		int valor_int,correcto=0;
		if(this.tipo==0)
		{
			try
			{
				valor_int=Integer.parseInt(respuesta);
			}
			catch(Exception e)
			{
				throw new FormatoIncorrectoException(e);
			}
			if(valor_int>0 && valor_int<=this.opciones.size())
			{
				return (0);
			}
			else
			{
				throw new OpcionIncorrectaException();
			}
		}
		else
		{
			if(respuesta.isEmpty())
				return (0);
			for (String valor : respuesta.trim().split("\\s+"))
	  	  	{
				try
				{
					valor_int=Integer.parseInt(valor);
				}
				catch(Exception e)
				{
					throw new FormatoIncorrectoException(e);
				}
				if(valor_int>0 && valor_int<=this.opciones.size())
				{
					correcto=0;
				}
				else
				{
					throw new OpcionIncorrectaException();
				}
	  	  	}
			return (0);
		}
		
	}
}
