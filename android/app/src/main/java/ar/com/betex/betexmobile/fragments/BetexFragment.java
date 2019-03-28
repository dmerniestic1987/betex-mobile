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
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transaction.addToBackStack(addToBackStack);
        transaction.commit();
    }
}
