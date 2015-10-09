package com.day4.enprog.dessertmarker.manager.http;

import com.day4.enprog.dessertmarker.dao.DessertItemCollectionDao;

import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by Ladarat on 8/10/2558.
 */
public interface APIService {

    @POST("list")
    Call<DessertItemCollectionDao> loadDesserts();
}
