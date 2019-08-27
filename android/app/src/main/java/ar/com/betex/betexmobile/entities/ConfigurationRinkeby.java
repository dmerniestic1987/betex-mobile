package ar.com.betex.betexmobile.entities;

/**
 * Contiene los parámetros de configuración de la aplicación para apuntar a rinkeby
 * @author  dmernies
 */
public class Configuration {
    public static final String ETHEREUM_ENDPOINT = "https://kovan.infura.io/v3/a973f72655dc4760bfc81012fec47c86";
    public static final String BETEX_SELF_EXCLUDED_CONTRACT_ADDRESS = "0x5aC163aEDfb8E5e404eD070Bf3951aE7Da408d85";
    public static final String BETEX_TOKEN_CONTRACT_ADDRESS="0x4459C08d375254653aDc0546Efe7627A9F55fC19";
    public static final String BETEX_MOBILE_CONTRACT_ADDRESS = "0x0C4152a4D8d466dc280ee6569e729602466B120B";
    public static final String BETEX_SETTINGS_CONTRACT_ADDRESS = "0xB43CbEd40bd711B72221358F39a2F61C52BAa577";

    public String getEthereumEndPoint(){
        return ETHEREUM_ENDPOINT;
    }

    public String getBetexMobileContractAddress(){
        return BETEX_MOBILE_CONTRACT_ADDRESS;
    }

    public String getBetexTokenContractAddress(){
        return BETEX_TOKEN_CONTRACT_ADDRESS;
    }

    public String getBetexSelfExcludedContractAddress() {
        return BETEX_SELF_EXCLUDED_CONTRACT_ADDRESS;
    }

    public String getBetexSettingsContractAddress() {
        return BETEX_SETTINGS_CONTRACT_ADDRESS;
    }
}
