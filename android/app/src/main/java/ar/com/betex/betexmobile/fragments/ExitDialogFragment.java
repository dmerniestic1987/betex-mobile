package ar.com.betex.betexmobile.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;

public class ExitDialogFragment extends DialogFragment {
    private OnContinuePlayingListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContinuePlayingListener) {
            listener = (OnContinuePlayingListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnContinuePlayingListener");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(getActivity())
            .setTitle(this.getResources().getString(R.string.exit_dialog_fragment_title))
            .setMessage(this.getResources().getString(R.string.exit_dialog_fragment_content))
            .setPositiveButton(this.getResources().getString(R.string.exit_dialog_fragment_exit), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                }
            })
            .setNegativeButton(this.getResources().getString(R.string.exit_dialog_fragment_continue), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                    listener.loadMarketEvents();
                }
            })
            .create();
    }

    public interface OnContinuePlayingListener{
        void loadMarketEvents();
    }
}
