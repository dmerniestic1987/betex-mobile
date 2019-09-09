package ar.com.betex.betexmobile.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa a un mercado
 * @author  Diego Mernies
 */
public class Market implements Serializable {
    private BigInteger marketId;
    private String marketType;
    private String marketName;
    private String competitionId;
    private String competitionName;
    private String eventType;
    private BigInteger eventId;
    private String eventName;
    private String marketStatus;
    private String countryCode;
    private Date startDateGMT;
    private List<Runner> runners;


    public Market(){
        super();
        this.runners = new ArrayList<>();
    }

    public Runner getRunnerByRunnerId(BigInteger runnerId){
        for (Runner runner : runners){
            if (runner.getId().equals(runnerId)){
                return runner;
            }
        }

        return null;
    }
    public BigInteger getMarketId() {
        return marketId;
    }
    public void setMarketId(BigInteger marketId) {
        this.marketId = marketId;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }
    public String getCompetitionId() {
        return competitionId;
    }
    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }
    public String getCompetitionName() {
        return competitionName;
    }
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
    public BigInteger getEventId() {
        return eventId;
    }
    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public Date getStartDateGMT() {
        return startDateGMT;
    }
    public void setStartDateGMT(Date startDateGMT) {
        this.startDateGMT = startDateGMT;
    }
    public String getMarketType() {
        return marketType;
    }
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void addRunner(Runner runner){
        this.runners.add(runner);
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(String status) {
        this.marketStatus = status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
