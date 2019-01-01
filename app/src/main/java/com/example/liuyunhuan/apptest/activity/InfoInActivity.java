package com.example.liuyunhuan.apptest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;

public class InfoInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_in);
    }
}
