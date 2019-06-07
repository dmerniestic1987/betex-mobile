package ar.com.betex.betexmobile.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import ar.com.betex.betexmobile.Exception.BetexException;
import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.wallet.BetexWallet;
import ar.com.betex.betexmobile.blockchain.wallet.FileBetexWallet;

/**
 * Actividad de desarrollo para consultar el estado de las Wallet
 * @author Diego Mernies
 */
public class WalletDevelActivity extends AppCompatActivity {
    private static final String TAG = "WalletDevelActivity";
    private BetexWallet betexWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_devel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        betexWallet = FileBetexWallet.getInstance(this);

        if (!betexWallet.isWalletCreated()){
            try {
                betexWallet.createWallet("wallet1", "clave001");

            } catch (BetexException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }

        else {
            try {
                betexWallet.loadWallet("clave001");
            } catch (BetexException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }
}
