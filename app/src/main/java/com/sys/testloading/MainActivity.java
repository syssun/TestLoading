package com.sys.testloading;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    AVLoadingIndicatorView av;
    Button btnstart,btnend;
    Timer timer ;
    View layout;
    LinearLayout line;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.activity_main, null);
        initView();
        LoadingFrame loadingFrame = new LoadingFrame(this) {
            @Override
            public View onSuccessView() {
                return layout;
            }//放回布局
            @Override
            public int onLoad() {
                return -1;
            }//加载数据
        };
        loadingFrame.show();//展示
        setContentView(loadingFrame);//放入主布局中
    }
    private void initView(){
        btnend = findViewById(R.id.btn_end);
        btnstart  = findViewById(R.id.btn_start);
    }
    public void btnStart(View view){
        Toast.makeText(context,"点击start",Toast.LENGTH_SHORT).show();
    }
}