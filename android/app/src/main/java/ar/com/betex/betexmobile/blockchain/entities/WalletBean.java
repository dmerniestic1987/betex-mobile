package ar.com.betex.betexmobile.blockchain.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Bean que representa a una wallet.
 * @author Diego Mernies
 */
public class WalletBean implements Parcelable {
    private String betexName = "";
    private String sha256BetexPassword = "";
    private String web3jWalletFilePath = "";
    private String address = "";

    public WalletBean(){
        super();
    }

    protected WalletBean(Parcel in) {
        betexName = in.readString();
        sha256BetexPassword = in.readString();
        web3jWalletFilePath = in.readString();
        address = in.readString();
    }

    public static final Creator<WalletBean> CREATOR = new Creator<WalletBean>() {
        @Override
        public WalletBean createFromParcel(Parcel in) {
            return new WalletBean(in);
        }

        @Override
        public WalletBean[] newArray(int size) {
            return new WalletBean[size];
        }
    };

    public String getBetexName() {
        return betexName;
    }

    public void setBetexName(String betexName) {
        this.betexName = betexName;
    }

    /**
     * Se guarda el hash de la clave en vez de la clave plana.
     * @return sha256BetexPassword
     */
    public String getSha256BetexPassword() {
        return sha256BetexPassword;
    }

    public void setSha256BetexPassword(String sha256BetexPassword) {
        this.sha256BetexPassword = sha256BetexPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeb3jWalletFilePath() {
        return web3jWalletFilePath;
    }

    public void setWeb3jWalletFilePath(String web3jWalletFilePath) {
        this.web3jWalletFilePath = web3jWalletFilePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(betexName);
        dest.writeString(sha256BetexPassword);
        dest.writeString(web3jWalletFilePath);
        dest.writeString(address);
    }
}
