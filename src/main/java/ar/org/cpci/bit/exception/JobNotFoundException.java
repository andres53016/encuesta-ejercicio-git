package ar.org.cpci.bit.exception;

public class JobNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public JobNotFoundException(String nombre) {
        super(nombre);
    }
}
