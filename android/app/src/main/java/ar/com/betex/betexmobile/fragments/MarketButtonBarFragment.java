package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ar.com.betex.betexmobile.R;

/**
 * Corresponde a la botonera de los Mercados de apuestas
 * @author dmernies
 */
public class MarketButtonBarFragment extends Fragment implements View.OnClickListener {
    private OnEventTypeFilterClickedListener onEventTypeFilterClickedListener;
    private Button soccerEventTypeButton;
    private Button boxingEventTypeButton;
    private Button mmaEventTypeButton;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.soccerEventTypeButton){
            onEventTypeFilterClickedListener.onEventTypeClicked("Fútbol");
        }

        if (v.getId() == R.id.boxingEventTypeButton){
            onEventTypeFilterClickedListener.onEventTypeClicked("Boxeo");
        }

        if (v.getId() == R.id.mmaEventTypeButton){
            onEventTypeFilterClickedListener.onEventTypeClicked("MMA");
        }
    }

    public interface OnEventTypeFilterClickedListener {
        /**
         * Es el evento que se dispara cuando el usario selecciona un tipo de evento
         * de la botonera
         * @param eventType - Tipo de Evento para filtrar, por ejemplo fútbol, boxeo o MMA
         */
        public void onEventTypeClicked(String eventType);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        this.soccerEventTypeButton = v.findViewById(R.id.soccerEventTypeButton);
        this.soccerEventTypeButton.setOnClickListener(this);

        this.boxingEventTypeButton = v.findViewById(R.id.boxingEventTypeButton);
        this.boxingEventTypeButton.setOnClickListener(this);

        this.mmaEventTypeButton = v.findViewById(R.id.mmaEventTypeButton);
        this.mmaEventTypeButton.setOnClickListener(this);
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
