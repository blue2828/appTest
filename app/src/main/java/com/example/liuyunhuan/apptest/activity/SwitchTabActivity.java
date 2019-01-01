package com.example.liuyunhuan.apptest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;


public class SwitchTabActivity extends AppCompatActivity {
    private ListView listView;
    private InfoService infoService = null;
    private RadioGroup radioGroup;
    private FragmentTransaction transaction;
    Fragment infoFm, info_in_fm, info_out_fm;
    private static final int VIEW_INFO_INDEX = 0;
    private static final int VIEW_INFO_IN_IDNEX = 1;
    private static final int VIEW_INFO_OUT_IDNEX = 2;
    private int temp_index = -1;
    private RadioButton radioButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_bar);
        initView();
    }
    private void initView () {
        radioGroup = (RadioGroup) findViewById(R.id.tab_bar_navcontent);
        infoFm = IndexFragment.getInstance();
        info_in_fm = InfoInFragment.getInstance();
        info_out_fm = InfoOutFragment.getInstance();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tab_bar_fragment_content, infoFm);
        transaction.commit();
    }
    public void switchView (View view) {
        switch (view.getId()) {
            case R.id.tab_bar_index :
                if (temp_index != VIEW_INFO_INDEX) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.tab_bar_fragment_content, infoFm);
                    transaction.commit();
                }
                temp_index = VIEW_INFO_INDEX;
                break;
            case R.id.tab_bar_info_in :
                if (temp_index != VIEW_INFO_IN_IDNEX) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.tab_bar_fragment_content, info_in_fm);
                    transaction.commit();
                }
                temp_index = VIEW_INFO_IN_IDNEX;
                break;
            case R.id.tab_bar_info_out :
            if (temp_index != VIEW_INFO_OUT_IDNEX) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.tab_bar_fragment_content, info_out_fm);
                transaction.commit();
            }
            temp_index = VIEW_INFO_OUT_IDNEX;
            break;
        }
    }
}
