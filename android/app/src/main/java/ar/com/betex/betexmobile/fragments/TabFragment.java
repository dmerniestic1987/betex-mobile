package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.ViewPagerFragmentAdapter;

public class TabFragment extends Fragment {
    protected static final String ARG_TITLES = "arg_titles_list_tab_fragment";

    protected List<String> titles;
    protected List<Fragment> fragments;
    protected TabLayout tabLayout;
    protected ViewPager viewPager;

    public static final String TAG = "TabFragment";

    public TabFragment() {
        super();
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
    }


    /**
     * Utiliza un método factory para obtener una nueva instacia del fragment
     * @param titles Parameter 1.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(List<String> titles) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_TITLES, new ArrayList<>(titles));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titles = getArguments().getStringArrayList(ARG_TITLES);
            initFragments();
        }
    }

    /*
        Inicializa los frgamntes;
     */
    protected void initFragments() {
        this.fragments = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        initTabLayout(view);
        return view;
    }

    private void initTabLayout(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        for (String title : this.titles){
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        viewPager.setOffscreenPageLimit(2);

        ViewPagerFragmentAdapter mFragmentAdapter = new ViewPagerFragmentAdapter(getFragmentManager(), fragments, titles);
        viewPager.setAdapter(mFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void addFragment(Fragment f){
        this.fragments.add(f);
    }

}
