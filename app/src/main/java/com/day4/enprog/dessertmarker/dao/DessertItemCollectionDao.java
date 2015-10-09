package com.day4.enprog.dessertmarker.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ladarat on 8/10/2558.
 */
public class DessertItemCollectionDao {
    @SerializedName("success")      private boolean success;
    @SerializedName("data")         private List<DessertItemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DessertItemDao> getData() {
        return data;
    }

    public void setData(List<DessertItemDao> data) {
        this.data = data;
    }
}
