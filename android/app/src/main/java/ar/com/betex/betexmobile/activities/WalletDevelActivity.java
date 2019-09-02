package ar.com.betex.betexmobile.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.protocol.exceptions.TransactionException;

import java.math.BigInteger;

import ar.com.betex.betexmobile.blockchain.api.BetexMobileGondwanaApi;
import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.betexmobile.entities.ConfigurationRinkeby;
import ar.com.betex.betexmobile.exception.BetexException;
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
    private TextView versionView;
    private Configuration configuration;
    private BetexMobileGondwanaApi betexCoreApi;
    private Button holaMundo;
    private Button placeBet;
    private TextView restulTextView;
    private Context context;

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

        context = this;
        configuration = new ConfigurationRinkeby();
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
        restulTextView = this.findViewById(R.id.restulTextView);
        restulTextView.setText(betexWallet.getAddress());

        holaMundo = this.findViewById(R.id.holaMundo);
        betexCoreApi = new BetexMobileGondwanaApi(this, configuration);
        betexCoreApi.load();


        versionView = this.findViewById(R.id.versionView);
        versionView.setText(betexCoreApi.getClientVersion());

        holaMundo.setOnClickListener(view -> {
            betexCoreApi.getCommisionCancelBetBtx().subscribe(
                    comissionCancelBetBtx -> { versionView.setText(comissionCancelBetBtx.toString()); }
            );
        });

        placeBet = this.findViewById(R.id.placeBet);
        placeBet.setOnClickListener(view-> {
            betexCoreApi.cancelMarketBet(new BigInteger("11"))
                .subscribe(transactionReceipt -> {
                        String blockHash = transactionReceipt.getBlockHash();
                        updateTransactionHash(transactionReceipt.getTransactionHash());
                    },
                    exception -> {
                        TransactionException tex = (TransactionException) exception;
                        Log.e(TAG, tex.getMessage(), exception);
                        updateTransactionHash("ERROR");
                    }
                );
        });
    }

    private void updateTransactionHash(String transactionHash){
        restulTextView.setText(transactionHash);
        Toast.makeText(context, transactionHash, Toast.LENGTH_SHORT).show();
    }
}
