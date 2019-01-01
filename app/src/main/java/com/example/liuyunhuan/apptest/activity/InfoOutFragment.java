package com.example.liuyunhuan.apptest.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.service.InfoService;

import java.util.List;
import java.util.Map;

public class InfoOutFragment extends Fragment {
    private View rootView;
    private static InfoOutFragment indexFragment;
    private ListView listView;
    private InfoService infoService = null;
    public InfoOutFragment() {

    }
    public static InfoOutFragment getInstance () {
        if (null == indexFragment)
            indexFragment = new InfoOutFragment();
        return indexFragment;
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_out, container, false);
        listView = view.findViewById(R.id.info_out_list_view);
        infoService = new InfoService();
        List<Map<String, Object>> list = infoService.getOutInfo();
        // 参数一:上下文对象；
        // 参数二:数据源。List<Map<String,Object>【List集合里面是Map对象，Map对象的key是String】
        // 参数三:item对应的布局文件；
        // 参数四:表示由map中定义的key组成的字符串类型的数组
        // 参数五:需要显示的控件id组成的int类型的数组
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), list, R.layout.out_listview,
                new String[] {"ID", "symbol", "time"}, new int[]{R.id.out_tv0, R.id.out_tv1, R.id.out_tv2});
        listView.setAdapter(simpleAdapter);
        return view;
    }
    @Override
    public void onResume () {
        super.onResume();
    }
}
