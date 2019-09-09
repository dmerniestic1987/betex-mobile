package ar.com.betex.betexmobile.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.entities.CryptoAsset;
import ar.com.betex.betexmobile.entities.Market;
import ar.com.betex.betexmobile.entities.P2pBet;
import ar.com.betex.betexmobile.entities.Runner;

/**
 * Esta clase provee métodos y datos para desarrollar el prototipo gráfico.
 * @author Diego Mernies
 */
public class DevelopUtils {

    public static List<P2pBet> hardcodeP2pBetList() {
        List<P2pBet> p2pList = new ArrayList<>();
        P2pBet p2p = new P2pBet();
        p2p.setCreatorUser("0xd51128F302755666c42e3920d72FF2FE632856a9");
        p2p.setBetId(new BigInteger("1"));
        p2p.setCryptoAsset(CryptoAsset.getBtxInstance());
        p2p.setMarket(hardcodeBoxMarketList().get(0));
        p2p.setMarketRunnerHash("0x7ab2d6e73d6ed4fb40fc1f97f051a183d01c3f469255b841a1cb529699310d28");
        p2p.setAmount(new BigInteger("109928188211"));
        p2pList.add(p2p);

        p2p = new P2pBet();
        p2p.setCreatorUser("0x99E985fA02a5F6EaE2a7F3e93C1c6d65574Cbc61");
        p2p.setBetId(new BigInteger("2"));
        p2p.setCryptoAsset(CryptoAsset.getBtxInstance());
        p2p.setMarket(hardcodeFutbalMarketList().get(0));
        p2p.setMarketRunnerHash("0xaf6ba8899cf54bc1b7a706a0ff8d1ec9aa8a68192e8f67dee5aa1cb447f63d67");
        p2p.setAmount(new BigInteger("100000"));
        p2pList.add(p2p);

        p2p = new P2pBet();
        p2p.setCreatorUser("@CocoLiso");
        p2p.setBetId(new BigInteger("3"));
        p2p.setCryptoAsset(CryptoAsset.getEtherInstance());
        p2p.setMarket(hardcodeMmaMarketList().get(0));
        p2p.setMarketRunnerHash("0x54e98336785618d63e155b229c0fcb0e9892b6687b75d0a26a0f13de11cc34db");
        p2p.setAmount(new BigInteger("10000000000"));
        p2pList.add(p2p);

        p2p = new P2pBet();
        p2p.setCreatorUser("Son Gokú");
        p2p.setBetId(new BigInteger("4"));
        p2p.setCryptoAsset(CryptoAsset.getEtherInstance());
        p2p.setMarket(hardcodeBoxMarketList().get(1));
        p2p.setMarketRunnerHash("0x3a9b7b81946809f2ebbcfce2301247f6c5b08351cee6b66d83d19f29f94d1094");
        p2p.setAmount(new BigInteger("900000000000"));
        p2pList.add(p2p);

        p2p = new P2pBet();
        p2p.setCreatorUser("Las pastillas");
        p2p.setBetId(new BigInteger("5"));
        p2p.setCryptoAsset(CryptoAsset.getBtxInstance());
        p2p.setMarket(hardcodeBoxMarketList().get(0));
        p2p.setMarketRunnerHash("0xec2b8aca5d7e0801f9f20de2e1b6ec0f5bcb7acfbc53302ec793b08e12f79885");
        p2p.setAmount(new BigInteger("890000000000"));
        p2pList.add(p2p);

        p2p = new P2pBet();
        p2p.setCreatorUser("0xd51128F302755666c42e3920d72FF2FE632856a9");
        p2p.setBetId(new BigInteger("1"));
        p2p.setCryptoAsset(CryptoAsset.getBtxInstance());
        p2p.setMarket(hardcodeFutbalMarketList().get(1));
        p2p.setAmount(new BigInteger("8910000000000"));
        p2p.setMarketRunnerHash("0x7ab2d6e73d6ed4fb40fc1f97f051a183d01c3f469255b841a1cb529699310d28");
        p2pList.add(p2p);

        return p2pList;
    }
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
        m.addRunner(new Runner(new BigInteger("1"), "Lesnar", R.drawable.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("2"), "Jon Jones", R.drawable.mma_fighter));
        m.setMarketStatus("open");
        m.setEventName("Lesnar V.S Jon Jones");
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
        m.addRunner(new Runner(new BigInteger("13"), "Diego Sánchez", R.drawable.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Anderson Silva", R.drawable.mma_fighter));
        m.setMarketStatus("open");
        m.setEventName("Sanchez V.S Silva");
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
        m.addRunner(new Runner(new BigInteger("9713"), "Son Gokú", R.drawable.mma_fighter));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Vegeta", R.drawable.mma_fighter));
        m.setEventName("Son Goku V.S Vegeta");
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("1"), "Many Pacquiao", R.drawable.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("2"), "Canelo Alvarez", R.drawable.boxeador));
        m.setEventName("Roger Stajman V.S Golovkin");
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("13"), "Roger Stajman", R.drawable.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Golovkin", R.drawable.boxeador));
        m.setEventName("Roger Stajman V.S Golovkin");
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("9713"), "Jorge Lopez", R.drawable.boxeador));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Jorge Perez", R.drawable.boxeador));
        m.setMarketStatus("open");
        m.setEventName("Jorge Lopez V.S Jorge Perez");
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
        m.addRunner(new Runner(new BigInteger("1"), "Menos de 2.5 goles", R.drawable.menor_goles));
        m.addRunner(new Runner(new BigInteger("2"), "Más de 2.5 goles", R.drawable.mayor_goles));
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("1"), "Goles Pares", R.drawable.menor_goles));
        m.addRunner(new Runner(new BigInteger("2"), "Goles impares", R.drawable.mayor_goles));
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO o DQ", R.drawable.boxing_training));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.drawable.boxing_definiton));
        m.setMarketStatus("open");
        m.setMarketName(market.getRunners().get(0).getRunnerName() + " - Victoria");
        m.setEventName(market.getCompetitionName());
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
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO o DQ", R.drawable.boxing_training));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.drawable.boxing_definiton));
        m.setMarketStatus("open");
        m.setMarketName(market.getRunners().get(2).getRunnerName() + " - Victoria");
        m.setEventName(market.getCompetitionName());
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
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO/SUB o DQ", R.drawable.mma_rodillazo));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.drawable.boxing_definiton));
        m.setMarketStatus("open");
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
        m.addRunner(new Runner(new BigInteger("1"), "KO/TKO/SUB o DQ", R.drawable.mma_rodillazo));
        m.addRunner(new Runner(new BigInteger("2"), "Decisión", R.drawable.boxing_definiton));
        m.setMarketStatus("open");
        m.setMarketName(market.getRunners().get(2).getRunnerName() + " - Victoria");
        marketList.add(m);
        m.setEventName(market.getCompetitionName());

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
        m.addRunner(new Runner(new BigInteger("1"), "Boca Juniors", R.drawable.boca_juniors));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.setMarketStatus("open");
        m.addRunner(new Runner(new BigInteger("2"), "River Plate", R.drawable.river_plate));
        m.setEventName("Boca Jrs. V.S. River Plate");
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
        m.setMarketStatus("open");
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("13"), "San Lorenzo", R.drawable.san_lorenzo));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("23"), "Huracán", R.drawable.huracan));
        m.setEventName("San Lorez V.S Huracán");
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
        m.setMarketStatus("open");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("8782"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Liverpool", R.drawable.liverpool));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Manchester City", R.drawable.manchester_city));
        m.setEventName("Liverpool V.S Manchester City");
        marketList.add(m);

        //******************************
        m = new Market();
        m.setMarketId(new BigInteger("90878"));
        m.setMarketType("MATCH_ODDS");
        m.setCompetitionId("198");
        m.setCompetitionName("Copa Libertadores");
        m.setCountryCode("INTL");
        m.setMarketStatus("open");
        m.setEventType("Fútbol");
        m.setEventId(new BigInteger("75412"));
        m.setStartDateGMT(calendar.getTime());
        m.addRunner(new Runner(new BigInteger("9713"), "Corintians", R.drawable.corinthians));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate", 0));
        m.addRunner(new Runner(new BigInteger("9723"), "Colo colo", R.drawable.colo_colo));
        m.setEventName("Corintians V.S Colo Colo");
        marketList.add(m);

        return marketList;
    }
}
