package ar.com.betex.betexmobile.entities;

/**
 * Contiene los parámetros de configuración de la aplicación.
 * @author  dmernies
 */
public class Configuration {
    public static final String ETHEREUM_ENDPOINT = "https://rinkeby.infura.io/a973f72655dc4760bfc81012fec47c86";
    public static final String BETEX_CORE_CONTRACT_ADDRESS="0x9090bAF75c678B6e4E6479E529bfFd2Ec2133d73";
    public static final String VERSUS_MATCHES_CONTRACT_ADDRESS="0xe102dAB5404Dd8C17ff7f7853330C08f43D1F0Ba";
    public static final String BETEX_TOKEN_CONTRACT_ADDRESS="0x1186d5f10Ed2b69158691Eaa720aF91Cb5a35632";

    public String getEthereumEndPoint(){
        return ETHEREUM_ENDPOINT;
    }

    public String getBetexCoreContractAddress(){
        return BETEX_CORE_CONTRACT_ADDRESS;
    }

    public String getVersusMatchesContractAddress(){
        return VERSUS_MATCHES_CONTRACT_ADDRESS;
    }
}
