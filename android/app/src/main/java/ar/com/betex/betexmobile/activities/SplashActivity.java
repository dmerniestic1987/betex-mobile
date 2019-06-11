package ar.com.betex.betexmobile.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.api.BetexCoreApi;
import ar.com.betex.betexmobile.blockchain.wallet.BetexWallet;
import ar.com.betex.betexmobile.blockchain.wallet.FileBetexWallet;
import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.betexmobile.exception.BetexException;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private BetexWallet betexWallet;
    private Configuration configuration;
    private Context context;

    static {
        Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
        Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        configuration = new Configuration();
        betexWallet = FileBetexWallet.getInstance(this);

        if (!betexWallet.isWalletCreated()){
            try {
                betexWallet.createWallet("wallet1", "clave001");
                Intent myIntent = new Intent(SplashActivity.this, WellcomeActivity.class);
                this.startActivity(myIntent);

            } catch (BetexException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }

        else {
            try {
                betexWallet.loadWallet("clave001");
                Intent myIntent = new Intent(SplashActivity.this, MainActivity.class);
                this.startActivity(myIntent);
            } catch (BetexException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }
}
