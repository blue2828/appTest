package com.example.liuyunhuan.apptest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;
import com.example.liuyunhuan.apptest.util.StringUtil;

import java.util.List;
import java.util.Map;

public class infoDetailActivity extends AppCompatActivity {
    private ScrollView layout;
    private TextView textView;
    private InfoService infoService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.info_one_detail);
        Bundle bundle = getIntent().getExtras();
        String infoId = bundle.getString("infoId");
        pushDataToView(infoId);
        layout = (ScrollView) findViewById(R.id.info_one_detail_content);
        layout.setBackgroundColor(Color.rgb(229, 229, 229));
        initView();
    }
    public void pushDataToView (String infoId) {
        infoService = new InfoService();
        List <Map <String, Object>> list = infoService.getInfo(StringUtil.isEmpty(infoId) ? -1 : Integer.parseInt(infoId));
        if (list.size() > 0) {
            textView = findViewById(R.id.info_one_detail_infoId);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("infoId")))));
            textView = findViewById(R.id.info_one_detail_heighth);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("heighth") == null ? "未设置" : list.get(0).get("heighth") + "米"))));
            textView = findViewById(R.id.info_one_detail_single);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("single") == null ? "未设置" : list.get(0).get("single") + "元"))));
            textView = findViewById(R.id.info_one_detail_count);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("count") == null ? "未设置" : list.get(0).get("count") + "张"))));
            textView = findViewById(R.id.info_one_detail_total);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("total") == null ? "未设置" : list.get(0).get("total") + "元"))));
            textView = findViewById(R.id.info_one_detail_info_time);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("info_time") == null ? "未设置" : list.get(0).get("info_time")))));
            textView = findViewById(R.id.info_one_detail_colorName);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("colorName") == null ? "未设置" : list.get(0).get("colorName")))));
            textView = findViewById(R.id.info_one_detail_providerName);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("providerName") == null ? "未设置" : list.get(0).get("providerName")))));
            textView = findViewById(R.id.info_one_detail_address);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("address") == null ? "未设置" : list.get(0).get("address")))));
            textView = findViewById(R.id.info_one_detail_phone);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("phone") == null ? "未设置" : list.get(0).get("phone")))));
            textView = findViewById(R.id.info_one_detail_linkman);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("linkman") == null ? "未设置" : list.get(0).get("linkman")))));
            textView = findViewById(R.id.info_one_detail_locationInfo);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("locationInfo") == null ? "未设置" : list.get(0).get("locationInfo")))));
            textView = findViewById(R.id.info_one_detail_symbol);
            textView.setText(((String) textView.getText()).concat("     ").concat((String.valueOf(list.get(0).get("symbol") == null ? "未设置" : list.get(0).get("symbol")))));
        }
    }
    public void initView () {
        textView = findViewById(R.id.info_one_detail_infoId);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_heighth);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_single);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_count);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_total);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_info_time);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_colorName);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_providerName);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_address);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_phone);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_linkman);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_locationInfo);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView = findViewById(R.id.info_one_detail_symbol);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
    }
}
