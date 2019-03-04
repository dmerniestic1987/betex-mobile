package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;

/**
 * Corresponde a la botonera de los Mercados de apuestas
 * @author dmernies
 */
public class MarketButtonBarFragment extends Fragment {
    private OnEventTypeFilterClickedListener onEventTypeFilterClickedListener;

    public interface OnEventTypeFilterClickedListener {
        /**
         * Es el evento que se dispara cuando el usario selecciona un tipo de evento
         * de la botonera
         * @param eventType - Tipo de Evento para filtrar, por ejemplo fútbol, boxeo o MMA
         */
        public void onEventTypeClicked(String eventType);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onEventTypeFilterClickedListener = (OnEventTypeFilterClickedListener) context;
        } catch (Exception e) {
            throw new RuntimeException(context.toString() + " la comunciación no se ha podido realizar");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_button_bar_market, container, false);
    }
}
