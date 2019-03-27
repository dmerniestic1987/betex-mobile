package ar.com.betex.betexmobile.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Bet;
import ar.com.betex.betexmobile.beans.Currency;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.fragments.ChallengeTabFragment;
import ar.com.betex.betexmobile.util.DevelopUtils;
import ar.com.betex.betexmobile.fragments.ExitDialogFragment;
import ar.com.betex.betexmobile.fragments.MarketEventListFragments;
import ar.com.betex.betexmobile.fragments.MarketButtonBarFragment;
import ar.com.betex.betexmobile.fragments.MarketFragment;
import ar.com.betex.betexmobile.fragments.MyBetsButtonBar;
import ar.com.betex.betexmobile.fragments.MyBetsFragment;
import ar.com.betex.betexmobile.fragments.WalletFragment;
import ar.com.betex.betexmobile.fragments.listener.OnMyBetSelectedListener;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;
import ar.com.betex.betexmobile.fragments.listener.OnPlaceBetFragmentListener;

public class MainActivity extends AppCompatActivity implements MarketButtonBarFragment.OnEventTypeFilterClickedListener
                                                             , MarketEventListFragments.OnEventMarketInteractionListener
                                                             , OnPlaceBetFragmentListener
                                                             , OnWalletCurrencyListSelectedListener
                                                             , ExitDialogFragment.OnContinuePlayingListener
                                                             , MyBetsButtonBar.OnMyBetTypeFilterClickedListener
                                                             , OnMyBetSelectedListener {
    private Fragment currentFragment;
    private static final String CURRENT_FRAGMENT = "current_fragment_main_activity";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this.onNavigationItemSelectedListener);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottonNavigation);
        navigation.setOnNavigationItemSelectedListener(this.onButtonNavigationViewItemSelectedListener);

        if (savedInstanceState == null) {
            this.replaceFragment(MarketFragment.newInstance(), MarketFragment.TAG);
        }
        else{
            currentFragment = getSupportFragmentManager().getFragment(savedInstanceState, CURRENT_FRAGMENT);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Guaradamos una instancia del fragment actual porque al rotar el dispositivo se dibujaba el
        //fragment de mercados aunque estemos en otra funcionalidad
        getSupportFragmentManager().putFragment(outState, CURRENT_FRAGMENT, currentFragment);
    }

    /**
     * Reemplaza un fragment
     * @param fragment
     * @param tag
     */
    protected void replaceFragment(Fragment fragment, String tag){
        this.currentFragment = fragment;
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrameLayout, fragment, tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //No quedan fragments para mostrar
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else {
                ExitDialogFragment myDiag = new ExitDialogFragment();
                myDiag.show(getSupportFragmentManager(), "Diag");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.toolbar_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Esto es el mensaje para el Button Navigation Item
    private BottomNavigationView.OnNavigationItemSelectedListener onButtonNavigationViewItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_bottom_events:
                    replaceFragment(MarketFragment.newInstance(), MarketFragment.TAG);
                    return true;
                case R.id.nav_bottom_challeges:
                    replaceFragment(ChallengeTabFragment.newInstance(), ChallengeTabFragment.TAG);
                    return true;
                case R.id.nav_bottom_myBets:
                    replaceFragment(MyBetsFragment.newInstance(), MyBetsFragment.TAG);
                    return true;
            }
            return false;
        }
    };

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new  NavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.nav_events) {
                replaceFragment(MarketFragment.newInstance(), MarketFragment.TAG);

            } else if (id == R.id.nav_myBets) {
                replaceFragment(MyBetsFragment.newInstance(), MyBetsFragment.TAG);

            } else if (id == R.id.nav_challeges) {

            } else if (id == R.id.nav_rules) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_help) {

            } else if (id == R.id.nav_settings) {

            } else if (id == R.id.nav_wallet) {
                replaceFragment(new WalletFragment(), WalletFragment.TAG);
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    //Se dispara cuadno se hace click en algún botón para cambiar el tipo de evento: Fútbol, boxeo o MMA
    @Override
    public void onEventTypeClicked(String eventType){
        MarketFragment marketFragment = (MarketFragment) getSupportFragmentManager().findFragmentByTag(MarketFragment.TAG);
        marketFragment.setEventTypeTitle(eventType);

        if ("Fútbol".equals(eventType)){
            marketFragment.drawMarketListFragment(DevelopUtils.hardcodeFutbalMarketList());
        }

        if ("Boxeo".equals(eventType)){
            marketFragment.drawMarketListFragment(DevelopUtils.hardcodeBoxMarketList());
        }

        if ("MMA".equals(eventType)){
            marketFragment.drawMarketListFragment(DevelopUtils.hardcodeMmaMarketList());
        }
    }

    //Se dispara cuando un usuario hace click en "Ver Más" de una lista determinada
    @Override
    public void onShowMoreMaketsSelected(Market item) {
        MarketFragment marketFragment = (MarketFragment) getSupportFragmentManager().findFragmentByTag(MarketFragment.TAG);

        if ("Boxeo".equals(item.getEventType())){
            marketFragment.drawAllMarketsByEvent(DevelopUtils.hardcodeAllMarketsBoxeo(item));
        }
        else if ("MMA".equals(item.getEventType())){
            marketFragment.drawAllMarketsByEvent(DevelopUtils.hardcodeAllMarketsMMA(item));
        }
        else {
            marketFragment.drawAllMarketsByEvent(DevelopUtils.hardcodeAllMarketsFutbol(item));
        }
    }

    //Se dispara cuando algún usuario quiere colocar una apuesta a favor de un runner determinado
    @Override
    public void onBackBetSelected(Market itemSelected, String oddSelected, BigInteger runnerId){
        MarketFragment marketFragment = (MarketFragment) getSupportFragmentManager().findFragmentByTag(MarketFragment.TAG);
        marketFragment.showPlaceBetScreen(itemSelected, oddSelected, runnerId, true);
    }

    //Se dispara cuando algún usuario quiere colocar una apuesta en contra de un runner determinado
    @Override
    public void onLayBetSelected(Market itemSelected, String oddSelected, BigInteger runnerId){
        MarketFragment marketFragment = (MarketFragment) getSupportFragmentManager().findFragmentByTag(MarketFragment.TAG);
        marketFragment.showPlaceBetScreen(itemSelected, oddSelected, runnerId, false);    }

    @Override
    public boolean placedBackBet() {
        return false;
    }

    @Override
    public boolean placedLayBet() {
        return false;
    }

    @Override
    public boolean cancelPlaceBet() {
        return false;
    }

    @Override
    public void onCurrencySelected(Currency currency) {
        WalletFragment walletFragment = (WalletFragment) getSupportFragmentManager().findFragmentByTag(WalletFragment.TAG);
        walletFragment.drawCurrencyFragment(currency);
    }

    @Override
    public void loadMarketEvents(){
        this.replaceFragment(MarketFragment.newInstance(), MarketFragment.TAG);
    }

    @Override
    public void onMyBetTypeClicked(String eventType) {
        MyBetsFragment marketFragment = (MyBetsFragment) getSupportFragmentManager().findFragmentByTag(MyBetsFragment.TAG);
        marketFragment.setMyBetTitle(eventType);
    }

    @Override
    public void onSelectedBetFromList(Bet bet) {

    }

    @Override
    public void onCancelSelectedBet(Bet bet) {

    }
}
