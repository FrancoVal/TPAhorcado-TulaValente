package backend;

public class NoTieneChancesException extends Exception {
    public NoTieneChancesException(String mensaje) {
        super(mensaje);
    }
}