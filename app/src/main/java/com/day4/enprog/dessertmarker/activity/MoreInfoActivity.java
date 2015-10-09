package com.day4.enprog.dessertmarker.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.day4.enprog.dessertmarker.R;
import com.day4.enprog.dessertmarker.fragment.MoreInfoFragment;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MoreInfoFragment.newInstance())
                    .commit();
        }
    }
}
