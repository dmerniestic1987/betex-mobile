package ar.com.betex.betexmobile.beans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Market {
    private BigInteger marketId;
    private String marketType;
    private String competitionId;
    private String competitionName;
    private String eventType;
    private BigInteger eventId;
    private String countryCode;
    private Date startDateGMT;
    private List<Runner> runners;

    public Market(){
        super();
        this.runners = new ArrayList<>();
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
}
