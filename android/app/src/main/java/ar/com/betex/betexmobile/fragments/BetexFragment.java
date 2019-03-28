package ar.com.betex.betexmobile.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import ar.com.betex.betexmobile.R;

/**
 * Superclase de los Fragemtns de Betex
 */
public class BetexFragment extends Fragment {

    protected void replaceFragment(Fragment fragment, String tag, String addToBackStack, int contentId){
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        transaction.replace(contentId, fragment, tag);
        transaction.setCustomAnimations(R.anim.pull_in_left, R.anim.push_out_left);
        transaction.addToBackStack(addToBackStack);
        transaction.commit();
    }
}
