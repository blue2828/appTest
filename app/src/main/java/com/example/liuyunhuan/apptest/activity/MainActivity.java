package com.example.liuyunhuan.apptest.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liuyunhuan.apptest.R;
import com.example.liuyunhuan.apptest.entity.User;
import com.example.liuyunhuan.apptest.service.LoginService;
import com.example.liuyunhuan.apptest.util.JdbcUtil;
import com.example.liuyunhuan.apptest.util.LayoutUtil;
import com.example.liuyunhuan.apptest.util.StringUtil;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout ;
    private EditText editText;
    private Button button;
    private TextView textView;
    private WindowManager manager;
    private LayoutUtil layoutUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JdbcUtil.setPolicy();
        manager = this.getWindowManager();
        editText = findViewById(R.id.main_pwd);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        Drawable drawable = getResources().getDrawable(R.drawable.pwd);
        layoutUtil = new LayoutUtil();
        layoutUtil.setBounds(editText, drawable, new int[] {0, 0, 20, 20}, new boolean[] {true, false, false, false});
        LayoutUtil.setMargins(editText, new int[] {30, 160, 30, 0});
        RelativeLayout.LayoutParams lp =  (RelativeLayout.LayoutParams) editText.getLayoutParams();
        lp.width = LayoutUtil.getScreenWidth(manager) - 60;
        editText = findViewById(R.id.main_user);
        Drawable drawable2 = getResources().getDrawable(R.drawable.user);
        layoutUtil.setBounds(editText, drawable2, new int[] {0, 0, 20, 20}, new boolean[] {true, false, false, false});
        lp = (RelativeLayout.LayoutParams) editText.getLayoutParams();
        LayoutUtil.setMargins(editText, new int[] {30, 100, 30, 0});
        lp.width = LayoutUtil.getScreenWidth(manager) - 60;
        button = findViewById(R.id.main_loginBtn);
        RelativeLayout.LayoutParams btnLayoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
        btnLayoutParams.width = LayoutUtil.getScreenWidth(manager) - 60;
        LayoutUtil.setMargins(button, new int[] {30, 240, 30, 0});
    }
    public LoginService initLoginService () {
        return new LoginService();
    }
    public void click(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.main_loginBtn:
                editText = findViewById(R.id.main_user);
                String username = editText.getText().toString();
                editText = findViewById(R.id.main_pwd);
                String pwd = editText.getText().toString();
                if (StringUtil.isEmpty(username)) {
                     LayoutUtil.showSimpleDialog(this, "提示", "请填入账号");
                     break;
                }
                if (StringUtil.isEmpty(pwd)) {
                    LayoutUtil.showSimpleDialog(this, "提示", "请填入密码");
                    break;
                }
                boolean flag = initLoginService().checkLogin(new User(username, pwd));
                if (flag) {
                    Intent intent = new Intent(MainActivity.this, SwitchTabActivity.class);
                    intent.putExtra("loginFlag", true);
                    startActivity(intent);
                }else
                    LayoutUtil.showSimpleDialog(this, "提示", "账号或密码错误");
                break;
            default:
                break;
        }
    }
}
