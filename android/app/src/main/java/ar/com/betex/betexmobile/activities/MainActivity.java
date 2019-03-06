package ar.com.betex.betexmobile.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.develop.DevelopUtils;
import ar.com.betex.betexmobile.fragments.MarketEventeListFragments;
import ar.com.betex.betexmobile.fragments.MarketButtonBarFragment;
import ar.com.betex.betexmobile.fragments.MarketFragment;

public class MainActivity extends AppCompatActivity implements MarketButtonBarFragment.OnEventTypeFilterClickedListener, MarketEventeListFragments.OnEventMarketInteractionListener {
    private MarketFragment marketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        marketFragment = MarketFragment.newInstance("", "");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
                    return true;
                case R.id.nav_bottom_challeges:
                    return true;
                case R.id.nav_bottom_myBets:
                    return true;
            }
            return false;
        }
    };

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new  NavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_events) {

            } else if (id == R.id.nav_myBets) {

            } else if (id == R.id.nav_challeges) {

            } else if (id == R.id.nav_rules) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_help) {

            } else if (id == R.id.nav_settings) {

            } else if (id == R.id.nav_wallet) {

            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    //Se dispara cuadno se hace click en algún botón para cambiar el tipo de evento: Fútbol, boxeo o MMA
    @Override
    public void onEventTypeClicked(String eventType){
        MarketFragment marketFragment = (MarketFragment) getSupportFragmentManager().findFragmentById(R.id.marketFragment);
        marketFragment.setEventTypeTitle(eventType);

        MarketEventeListFragments listFragments = (MarketEventeListFragments)marketFragment.getChildFragmentManager().findFragmentById(R.id.marketEventListFragment);
        if ("Fútbol".equals(eventType)){
            listFragments.changeMarketList(DevelopUtils.hardcodeFutbalMarketList());
        }

        if ("Boxeo".equals(eventType)){
            listFragments.changeMarketList(DevelopUtils.hardcodeBoxMarketList());
        }

        if ("MMA".equals(eventType)){
            listFragments.changeMarketList(DevelopUtils.hardcodeMmaMarketList());
        }
    }

    //Se dispara cuando un usuario hace click en "Ver Más" de una lista determinada
    @Override
    public void onShowMoreMaketsSelected(Market item) {
        Toast.makeText(this, "VER MÁS: " + item.getMarketId(), Toast.LENGTH_SHORT).show();
    }

    //Se dispara cuando algún usuario quiere colocar una apuesta a favor de un runner determinado
    @Override
    public void onBackBetSelected(Market itemSelected, String oddSelected, BigInteger runner){
        Toast.makeText(this, "BACK SELECTED: " + itemSelected.getMarketId() + " ODD: " + oddSelected + " RUNER:" + runner, Toast.LENGTH_SHORT).show();
    }

    //Se dispara cuando algún usuario quiere colocar una apuesta en contra de un runner determinado
    @Override
    public void onLayBetSelected(Market itemSelected, String oddSelected, BigInteger runner){
        Toast.makeText(this, "LAY SELECTED: " + itemSelected.getMarketId() + " ODD: " + oddSelected + " RUNER:" + runner, Toast.LENGTH_SHORT).show();
    }
}
