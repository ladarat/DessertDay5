package com.day4.enprog.dessertmarker.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.day4.enprog.dessertmarker.dao.DessertItemCollectionDao;
import com.day4.enprog.dessertmarker.dao.DessertItemDao;
import com.google.gson.Gson;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DessrtListManager {

    private static DessrtListManager instance;

    public static DessrtListManager getInstance() {
        if (instance == null)
            instance = new DessrtListManager();
        return instance;
    }

    private Context mContext;
    private DessertItemCollectionDao dao;
    private DessertItemDao selectDao;

    private DessrtListManager() {
        mContext = Contextor.getInstance().getContext();
        loadCache();
    }




    public DessertItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(DessertItemCollectionDao dao) {
        this.dao = dao;
        saveCache();
    }

    private void saveCache() {
        String json = new Gson().toJson(dao);

        SharedPreferences pref = mContext.getSharedPreferences("dessert", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("json", json);
        editor.apply();
    }

    private void loadCache() {
        SharedPreferences pref = mContext.getSharedPreferences("dessert", Context.MODE_PRIVATE);
        String json = pref.getString("json", null);
        if(json == null){
            return;
        }
        dao = new Gson().fromJson(json, DessertItemCollectionDao.class);

    }

    public DessertItemDao getSelectDao() {
        return selectDao;
    }

    public void setSelectDao(DessertItemDao selectDao) {
        this.selectDao = selectDao;
    }
}
