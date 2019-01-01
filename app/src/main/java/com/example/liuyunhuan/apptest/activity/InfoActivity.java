package com.example.liuyunhuan.apptest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;
import com.example.liuyunhuan.apptest.util.LayoutUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoActivity extends AppCompatActivity {
    private ListView listView;
    private InfoService infoService = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }
}
