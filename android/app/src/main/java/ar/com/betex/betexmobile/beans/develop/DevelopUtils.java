package ar.com.betex.betexmobile.beans.develop;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.Runner;

public class DevelopUtils {

    public static List<Market> hardcodeMmaMarketList(){
        List<Market> marketList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR, 22);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2019);

        Market m = new Market();
        m.setMarketId(new BigInteger("1190"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("1777");
        m.setCompetitionName("UFC 251");
        m.setCountryCode("INTL");
        m.setEventType("MMA");
        m.setEventId(new BigInteger("1"));
        m.setCountryCode("AR");
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("1"), "Lesnar", R.mipmap.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("2"), "Jon Jones", R.mipmap.mma_fighter));
        marketList.add(m);

        //******************************
        m = new Market();
        m.setMarketId(new BigInteger("990"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("205");
        m.setCompetitionName("UFC 251");
        m.setCountryCode("INTL");
        m.setEventType("MMA");
        m.setEventId(new BigInteger("2"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("13"), "Diego Sánchez", R.mipmap.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Anderson Silva", R.mipmap.mma_fighter));
        marketList.add(m);

        //******************************
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.HOUR, 20);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.YEAR, 2019);

        m = new Market();
        m.setMarketId(new BigInteger("2890"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("105");
        m.setCompetitionName("UFC 251");
        m.setCountryCode("INTL");
        m.setEventType("MMA");
        m.setEventId(new BigInteger("8782"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Son Gokú", R.mipmap.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Vegeta", R.mipmap.mma_fighter));
        marketList.add(m);

        return marketList;
    }

    public static List<Market> hardcodeBoxMarketList(){
        List<Market> marketList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR, 17);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2019);

        Market m = new Market();
        m.setMarketId(new BigInteger("99865"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("1777");
        m.setCompetitionName("OMB");
        m.setCountryCode("INTL");
        m.setEventType("Boxeo");
        m.setEventId(new BigInteger("1"));
        m.setCountryCode("AR");
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("1"), "Many Pacquiao", R.mipmap.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("2"), "Canelo Alvarez", R.mipmap.boxeador));
        marketList.add(m);

        //******************************
        m = new Market();
        m.setMarketId(new BigInteger("858274"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("205");
        m.setCompetitionName("Título Mundial Walter");
        m.setCountryCode("INTL");
        m.setEventType("Boxeo");
        m.setEventId(new BigInteger("2"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("13"), "Roger Stajman", R.mipmap.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Golovkin", R.mipmap.boxeador));
        marketList.add(m);

        //******************************
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.HOUR, 20);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.YEAR, 2019);

        m = new Market();
        m.setMarketId(new BigInteger("787747"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("105");
        m.setCompetitionName("Combate Space");
        m.setCountryCode("INTL");
        m.setEventType("Boxeo");
        m.setEventId(new BigInteger("8782"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Jorge Lopez", R.mipmap.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Jorge Perez", R.mipmap.boxeador));
        marketList.add(m);

        return marketList;
    }

    public static List<Market> hardcodeAllMarketsFutbol(Market market){
        List<Market> marketList = new ArrayList<>();
        marketList.add(market);

        Market m = new Market();
        m.setMarketId(new BigInteger("8878774"));
        m.setMarketType("UNDER_2_5_GOALS");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "Menos de 2.5 goles", R.mipmap.menor_goles));
        m.addRunner(new Runner(new BigInteger("2"), "Más de 2.5 goles", R.mipmap.mayor_goles));
        m.setMarketName("Total de goles");
        marketList.add(m);

        m = new Market();
        m.setMarketId(new BigInteger("8866774"));
        m.setMarketType("GOALS_EVEN");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "Goles Pares", R.mipmap.menor_goles));
        m.addRunner(new Runner(new BigInteger("2"), "Goles impares", R.mipmap.mayor_goles));
        m.setMarketName("Goles pares e impares");
        marketList.add(m);

        return marketList;
    }

    public static List<Market> hardcodeAllMarketsBoxeo(Market market){
        List<Market> marketList = new ArrayList<>();
        marketList.add(market);

        Market m = new Market();
        m.setMarketId(new BigInteger("8878774"));
        m.setMarketType("WINNER");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO o DQ", R.mipmap.boxing_training));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.mipmap.boxing_definiton));
        m.setMarketName(market.getRunners().get(0).getRunnerName() + " - Victoria");
        marketList.add(m);

        m = new Market();
        m.setMarketId(new BigInteger("8899774"));
        m.setMarketType("WINNER");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO o DQ", R.mipmap.boxing_training));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.mipmap.boxing_definiton));
        m.setMarketName(market.getRunners().get(2).getRunnerName() + " - Victoria");
        marketList.add(m);

        return marketList;
    }

    public static List<Market> hardcodeAllMarketsMMA(Market market){
        List<Market> marketList = new ArrayList<>();
        marketList.add(market);

        Market m = new Market();
        m.setMarketId(new BigInteger("8878774"));
        m.setMarketType("WINNER");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO/SUB o DQ", R.mipmap.mma_rodillazo));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.mipmap.boxing_definiton));
        m.setMarketName(market.getRunners().get(0).getRunnerName() + " - Victoria");
        marketList.add(m);

        m = new Market();
        m.setMarketId(new BigInteger("8899774"));
        m.setMarketType("WINNER");
        m.setCompetitionId(market.getCompetitionId());
        m.setCompetitionName(market.getCompetitionName());
        m.setCountryCode(market.getCountryCode());
        m.setEventType(market.getEventType());
        m.setEventId(market.getEventId());
        m.setStartDateGMT(market.getStartDateGMT());
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO/SUB o DQ", R.mipmap.mma_rodillazo));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.mipmap.boxing_definiton));
        m.setMarketName(market.getRunners().get(2).getRunnerName() + " - Victoria");
        marketList.add(m);

        return marketList;
    }



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
