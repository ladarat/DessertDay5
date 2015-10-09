package com.day4.enprog.dessertmarker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.day4.enprog.dessertmarker.R;
import com.day4.enprog.dessertmarker.adepter.DessertListAdepter;
import com.day4.enprog.dessertmarker.dao.DessertItemCollectionDao;
import com.day4.enprog.dessertmarker.manager.DessrtListManager;
import com.day4.enprog.dessertmarker.manager.http.HTTPManager;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {
    ListView listView;
    DessertListAdepter dessertListAdepter;
    SwipeRefreshLayout swipeRefreshLayout;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        //setRetainInstance(true);

        listView = (ListView) rootView.findViewById(R.id.listView);
        dessertListAdepter = new DessertListAdepter();
        listView.setAdapter(dessertListAdepter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//   ---V1             //TODO: Handle ListView Item Click click change page
//                Intent intent = new Intent(getActivity(), MoreInfoActivity.class);
//   ---V1             startActivity(intent);

                //Send Signal to Activity
                

            }
        });



        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view,
                                 int firstVisibleItem,
                                 int visibleItemCount,
                                 int totalItemCount) {
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
                if(firstVisibleItem + visibleItemCount >= totalItemCount){
                    //Load More
                }
            }
        });
        loadData();
    }

    private void loadData() {
        Call<DessertItemCollectionDao> call = HTTPManager.getInstance().getService().loadDesserts();

        call.enqueue(new Callback<DessertItemCollectionDao>() {
            @Override
            public void onResponse(Response<DessertItemCollectionDao> response, Retrofit retrofit) {
                if(response.isSuccess()){

                    DessrtListManager.getInstance().setDao(response.body());
                    dessertListAdepter.notifyDataSetChanged();

                    Toast.makeText(Contextor.getInstance().getContext(),
                            response.body().getData().get(0).getName(),
                            Toast.LENGTH_LONG)
                            .show();
                }else{
                    //Got Respone but wrong
                    try {
                        Toast.makeText(Contextor.getInstance().getContext(),
                                response.errorBody().string(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }catch (IOException e){

                    }
                }
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.getMessage(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
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
