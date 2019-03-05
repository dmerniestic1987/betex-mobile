package ar.com.betex.betexmobile.beans;

import java.math.BigInteger;

public class Runner {
    private BigInteger id;
    private String runnerName;
    private int imageId;

    public Runner(){
        super();
    }

    public Runner(BigInteger id, String name, int imageId){
        super();
        this.id = id;
        this.runnerName = name;
        this.imageId = imageId;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
