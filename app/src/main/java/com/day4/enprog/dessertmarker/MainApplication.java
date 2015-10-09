package com.day4.enprog.dessertmarker;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Ladarat on 8/10/2558.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Intialize Thing(s) Here

        Contextor.getInstance().init(getApplicationContext());
    }
}
