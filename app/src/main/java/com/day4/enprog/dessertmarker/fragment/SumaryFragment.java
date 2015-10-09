package com.day4.enprog.dessertmarker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.day4.enprog.dessertmarker.R;
import com.day4.enprog.dessertmarker.dao.DessertItemDao;
import com.day4.enprog.dessertmarker.manager.DessrtListManager;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SumaryFragment extends Fragment {

    TextView tvName;
    TextView tvDescription;
    ImageView tvImg;

    private DessertItemDao selectedDao;

    public SumaryFragment() {
        super();
    }

    public static SumaryFragment newInstance() {
        SumaryFragment fragment = new SumaryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sumary, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        //setRetainInstance(true);

        tvName = (TextView) rootView.findViewById(R.id.tvName);
        tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        tvImg = (ImageView) rootView.findViewById(R.id.img);

        selectedDao = DessrtListManager.getInstance().getSelectDao(); //u can save onSaveInstancState

        tvName.setText(selectedDao.getName());
        tvDescription.setText(selectedDao.getDescription());
        Glide.with(getActivity())
                .load(selectedDao.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//Cache Big picture for each picture
                .into(tvImg);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
