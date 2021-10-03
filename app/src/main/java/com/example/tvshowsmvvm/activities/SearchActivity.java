package com.example.tvshowsmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.tvshowsmvvm.R;
import com.example.tvshowsmvvm.databinding.ActivityMainBinding;

public class SearchActivity extends AppCompatActivity {

    private ActivityMainBinding activitySearchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);

    }
}