package ar.com.betex.betexmobile.exception;


/**
 * Excepciones de Betex Wallet
 */
public class BetexException extends Exception {
    private String operation;
    private String code;

    public BetexException(String message, Throwable cause){
       super(message, cause);
    }

    public BetexException(String message){
        super(message);
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
