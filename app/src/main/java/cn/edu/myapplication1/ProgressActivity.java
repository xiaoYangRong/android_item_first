package cn.edu.myapplication1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import cn.edu.myapplication1.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mpb3;
    private Button btnStart,progressDialog1,progressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mpb3=findViewById(R.id.pb3);
        btnStart=findViewById(R.id.btn_ProgessBar);
        progressDialog1=findViewById(R.id.btn_progressDialog1);
        progressDialog2=findViewById(R.id.btn_progressDialog2);
        progressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this, "cancel.....");
                    }
                });
               // progressDialog.setCancelable(false);//设置不可取消
                progressDialog.show();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

    }
       Handler handler=new Handler(){
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
               if(mpb3.getProgress()<100){
                   handler.postDelayed(runnable,500);
                  // mpb1.setProgress(mpb1.getProgress()+5);
               }else{
                   ToastUtil.showMsg(ProgressActivity.this, "加载完成");
               }
           }
       };
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mpb3.setProgress(mpb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };


}
