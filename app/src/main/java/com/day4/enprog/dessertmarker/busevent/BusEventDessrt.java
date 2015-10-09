package com.day4.enprog.dessertmarker.busevent;

import com.day4.enprog.dessertmarker.dao.DessertItemDao;

/**
 * Created by Ladarat on 9/10/2558.
 */
public class BusEventDessrt {

    DessertItemDao dao;

    public BusEventDessrt(DessertItemDao dao) {
        this.dao = dao;
    }

    public DessertItemDao getDao() {
        return dao;
    }

    public void setDao(DessertItemDao dao) {
        this.dao = dao;
    }
}
