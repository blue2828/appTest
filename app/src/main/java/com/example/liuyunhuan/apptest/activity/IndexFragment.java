package com.example.liuyunhuan.apptest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IndexFragment extends Fragment{
    private View rootView;
    private static IndexFragment indexFragment;
    private ListView listView;
    private InfoService infoService = null;
    public IndexFragment () {

    }
    public static IndexFragment getInstance () {
        if (null == indexFragment)
            indexFragment = new IndexFragment();
        return indexFragment;
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info, container, false);
        listView = view.findViewById(R.id.list_view);
        infoService = new InfoService();
        List<Map<String, Object>> list = infoService.getInfo(-1);
        // 参数一:上下文对象；
        // 参数二:数据源。List<Map<String,Object>【List集合里面是Map对象，Map对象的key是String】
        // 参数三:item对应的布局文件；
        // 参数四:表示由map中定义的key组成的字符串类型的数组
        // 参数五:需要显示的控件id组成的int类型的数组
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), list, R.layout.listview,
                new String[] {"infoId", "providerName", "locationInfo", "symbol"}, new int[]{R.id.tv0, R.id.tv1, R.id.tv2, R.id.tv3});
        listView.setAdapter(simpleAdapter);
        final Context that = this.getActivity();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> map = (HashMap<String, Object>) parent.getItemAtPosition(position);
                String infoId = String.valueOf(map.get("infoId"));
                Intent intent = new Intent(getActivity(), infoDetailActivity.class);
                intent.putExtra("infoId", infoId);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onResume () {
        super.onResume();
    }
}
