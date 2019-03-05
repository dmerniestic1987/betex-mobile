package ar.com.betex.betexmobile.beans.develop;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.Runner;

public class DevelopUtils {

    public static List<Market> hardcodeFutbalMarketList(){
        List<Market> marketList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR, 17);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2019);

        Market m = new Market();
        m.setMarketId(new BigInteger("123"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("19191");
        m.setCompetitionName("Copa Libertadores");
        m.setCountryCode("AR");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("1"));
        m.setCountryCode("AR");
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("1"), "Boca Juniors", R.mipmap.boca_juniors));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("2"), "River Plate", R.mipmap.river_plate));
        marketList.add(m);

        //******************************
        m = new Market();
        m.setMarketId(new BigInteger("58774"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("205");
        m.setCompetitionName("Súper Copa 2019");
        m.setCountryCode("AR");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("2"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("13"), "San Lorenzo", R.mipmap.san_lorenzo));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Huracán", R.mipmap.huracan));
        marketList.add(m);

        //******************************
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.HOUR, 20);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.YEAR, 2019);

        m = new Market();
        m.setMarketId(new BigInteger("1807"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("105");
        m.setCompetitionName("Champions League");
        m.setCountryCode("EN");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("8782"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Liverpool", R.mipmap.liverpool));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Manchester City", R.mipmap.manchester_city));
        marketList.add(m);

        //******************************
        m = new Market();
        m.setMarketId(new BigInteger("90878"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("198");
        m.setCompetitionName("Copa Libertadores");
        m.setCountryCode("INTL");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("75412"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Corintians", R.mipmap.corinthians));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Colo colo", R.mipmap.colo_colo));
        marketList.add(m);

        return marketList;
    }
}
