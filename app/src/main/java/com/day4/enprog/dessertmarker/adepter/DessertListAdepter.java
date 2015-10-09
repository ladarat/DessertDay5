package com.day4.enprog.dessertmarker.adepter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.day4.enprog.dessertmarker.R;
import com.day4.enprog.dessertmarker.dao.DessertItemDao;
import com.day4.enprog.dessertmarker.manager.DessrtListManager;
import com.day4.enprog.dessertmarker.view.DessertListItem;

/**
 * Created by Ladarat on 8/10/2558.
 */
public class DessertListAdepter extends BaseAdapter{

    int lastPosition = -1;
    @Override
    public int getCount() {
        if(DessrtListManager.getInstance().getDao() == null)
            return 0;
        if(DessrtListManager.getInstance().getDao().getData() == null)
            return 0;
        return DessrtListManager.getInstance().getDao().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemViewType(position);
    }
//      V1
//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }

//    V1
//    @Override
//    public int getItemViewType(int position) {
//        return position%2 == 0 ? 0:1;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if(getItemViewType(position)== 0) {//V1
            DessertListItem item;
            if (convertView != null)
                item = (DessertListItem) convertView;
            else
                item = new DessertListItem(parent.getContext());

//        V1
//        }
//        else{
//            TextView item;
//            if (convertView != null)
//                item = (TextView) convertView;
//            else
//                item = new TextView(parent.getContext());
//            item.setText("Position"+ position);
//            return item;
//        }

        DessertItemDao dao = DessrtListManager.getInstance().getDao().getData().get(position);

        item.setItemName(dao.getName());
        item.setItemDescription(dao.getDescription());
        item.setImageUrl(dao.getImageURL());

        //poong
        if(position > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(), R.anim.up_from_button);
            item.startAnimation(anim);
            lastPosition = position;
        }

        return item;
    }
}
