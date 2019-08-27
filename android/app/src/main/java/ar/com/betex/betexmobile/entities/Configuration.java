package ar.com.betex.betexmobile.entities;

public abstract class Configuration {
    public abstract String getEthereumEndPoint();

    public abstract String getBetexMobileContractAddress();

    public abstract String getBetexTokenContractAddress();

    public abstract String getBetexSelfExcludedContractAddress();

    public abstract String getBetexSettingsContractAddress();
}
