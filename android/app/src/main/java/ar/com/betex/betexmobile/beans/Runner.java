package ar.com.betex.betexmobile.beans;

import java.math.BigInteger;

public class Runner {
    private BigInteger id;
    private String runnerName;

    public Runner(){
        super();
    }

    public Runner(BigInteger id, String name){
        super();
        this.id = id;
        this.runnerName = name;
    }

    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getRunnerName() {
        return runnerName;
    }
    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

}
