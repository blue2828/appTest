package com.example.liuyunhuan.apptest.util;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liuyunhuan.apptest.R;

public class LayoutUtil{
    public static void setMargins(View view, int[] params) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(params[0], params[1], params[2], params[3]);
    }
    public void setBounds (View view,  Drawable d, int[] bounds, boolean[] flags) {
        d.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        if (view instanceof EditText)
            ((EditText) view).setCompoundDrawables(flags[0] ? d : null, flags[1] ? d : null, flags[2] ? d : null, flags[3] ? d : null);
        if (view instanceof Button)
            ((Button) view).setCompoundDrawables(flags[0] ? d : null, flags[1] ? d : null, flags[2] ? d : null, flags[3] ? d : null);
        if (view instanceof TextView)
            ((TextView) view).setCompoundDrawables(flags[0] ? d : null, flags[1] ? d : null, flags[2] ? d : null, flags[3] ? d : null);
    }
    public static void setBgAlpha (View view, float alpha) {
        view.setAlpha(alpha);
    }
    public static void setComponentFullWidth (View view, WindowManager manager) {
        Display display = manager.getDefaultDisplay();
        int width = display.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
    }
    public static int getScreenWidth (WindowManager manager) {
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }
    public static void showSimpleDialog (AppCompatActivity activity, String title, String message) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setIcon(R.drawable.tip);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
