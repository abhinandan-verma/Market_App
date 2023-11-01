package com.example.market_app;

import android.view.View;

public interface ItemClickListener {
    default void onCLick(View v, int pos){

    }
}
