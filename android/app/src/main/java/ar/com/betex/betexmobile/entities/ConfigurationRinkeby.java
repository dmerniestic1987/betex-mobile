package ar.com.betex.betexmobile.entities;

/**
 * Contiene los parámetros de configuración de la aplicación para apuntar a rinkeby
 * @author  dmernies
 */
public class ConfigurationRinkeby extends Configuration{
    private static final String ETHEREUM_ENDPOINT = "https://rinkeby.infura.io/v3/a973f72655dc4760bfc81012fec47c86";
    private static final String BETEX_SELF_EXCLUDED_CONTRACT_ADDRESS = "0x176D291324d21B8a0cfE6b4eC3B271e6Aad909FA";
    private static final String BETEX_TOKEN_CONTRACT_ADDRESS="0x4A3e76d5aAEEE68eB1190207E234C35D27DBDAA2";
    private static final String BETEX_MOBILE_CONTRACT_ADDRESS = "0x1e4D32a1EA1503ba6a6af338F91F821e561503af";
    private static final String BETEX_SETTINGS_CONTRACT_ADDRESS = "0x82c6d1fdA7c4f55AC37466820b2598978B41113a";

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
