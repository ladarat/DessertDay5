package com.day4.enprog.dessertmarker.manager.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HTTPManager {

    private static HTTPManager instance;

    public static HTTPManager getInstance() {
        if (instance == null)
            instance = new HTTPManager();
        return instance;
    }

    private Context mContext;
    private APIService mService;

    private HTTPManager() {
        mContext = Contextor.getInstance().getContext();


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nuuneoi.com/courses/dessert_maker/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mService = retrofit.create(APIService.class);
    }

    public  APIService getService(){
        return mService;
    }
}
