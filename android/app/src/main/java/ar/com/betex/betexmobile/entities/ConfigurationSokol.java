package ar.com.betex.betexmobile.entities;

/**
 * Contiene los parámetros de configuración de la aplicación para apuntar a POA Sokol testnet
 * @author  dmernies
 */
public class ConfigurationSokol extends Configuration{
    private static final String ETHEREUM_ENDPOINT = "https://sokol.poa.network";
    private static final String BETEX_SELF_EXCLUDED_CONTRACT_ADDRESS = "0x02D7D0CC599D19332cf8ED42b8C5e1bEF9cE19FA";
    private static final String BETEX_TOKEN_CONTRACT_ADDRESS="0x7E05C42Fd1ba071128afd38978E91Fde78712FF7";
    private static final String BETEX_MOBILE_CONTRACT_ADDRESS = "0xcD302630700f0D857EC30D02c16Bb62BFACb6B6a";
    private static final String BETEX_SETTINGS_CONTRACT_ADDRESS = "0x0b6E99f9B328D05F2AD96c31b7EE82bEa82E2C2C";

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
