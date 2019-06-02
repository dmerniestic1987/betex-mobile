package ar.com.betex.betexmobile.Exception;


/**
 * Excepciones de Betex Wallet
 */
public class BetexWalletException extends Exception {
    private String operation;
    private String code;

    public BetexWalletException(String message, Throwable cause){
       super(message, cause);
    }

    public BetexWalletException(String message){
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
