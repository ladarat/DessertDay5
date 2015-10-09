package com.day4.enprog.dessertmarker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.day4.enprog.dessertmarker.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DessertListItem extends FrameLayout {

    private TextView tvName;
    private TextView tvDescription;
    private ImageView ivImg;

    public DessertListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public DessertListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    public DessertListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    private void initInflate() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item_dessert, this);
    }

    private void initInstances() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImg = (ImageView)findViewById(R.id.img);
    }

    public void setItemName(String name){
        tvName.setText(name);
    }

    public void setItemDescription(String description){
        tvDescription.setText(description);
    }

    public void setImageUrl(String url){
        //TODO: Load Image Here
        Glide.with(getContext())
                .load(url)
//                .error()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImg);
    }

    private void initWithAttrs(AttributeSet attrs) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }


}
