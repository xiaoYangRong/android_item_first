package cn.edu.myapplication1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    //1.定义使用的组件对象

    private ImageView imageview;
    private RadioGroup rg;
    private CheckBox Java;
    private CheckBox Android;
    private CheckBox Math;
    private CheckBox English;
    private EditText et_ip;
    private EditText et_name;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //2.通过id获取控件对象
        imageview = findViewById(R.id.touxiang);
        rg = findViewById(R.id.rg);
        Java = findViewById(R.id.cb_1);
        Android = findViewById(R.id.cb_2);
        Math = findViewById(R.id.cb_3);
        English = findViewById(R.id.cb_4);
        btnConfirm = findViewById(R.id.confirm);

        et_name = (EditText) findViewById(R.id.et_name);
        et_name.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        et_ip = (EditText) findViewById(R.id.et_name);
        et_ip.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        imageview.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        et_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //关闭软键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null && imm.isActive()) {
                        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

                    }
                    return true;
                }
                return false;
            }
        });

        sendNormalNotification();

        //sendHontNotification();
       // foldNormalNotification();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.touxiang:
                imageview.setImageResource(R.drawable.touxiang2);
                break;
            case R.id.confirm:
                String name = et_name.getText().toString();
                String sex = "";
                int id = rg.getCheckedRadioButtonId();
                if (id == R.id.man) {
                    sex = "男";
                } else {
                    sex = "女";
                }
                String courses = "";
                if (Java.isChecked()) {
                    courses += Java.getText().toString() + "";

                }
                if (Android.isChecked()) {
                    courses += Android.getText().toString() + "";

                }
                if (Math.isChecked()) {
                    courses += Math.getText().toString() + "";

                }
                if (English.isChecked()) {
                    courses += English.getText().toString() + "";

                }
                courses = courses.substring(0, courses.length() - 1);
                String info = "个人信息：姓名=" + name + ",性别：" + sex + ",喜欢：" + courses;
                Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
                //Snackbar.make(v,info,Snackbar.LENGTH_LONG).show();//需要在app的build.gradle增加依赖项

                break;

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                String location = "触点坐标：" + x + "," + y;
                Toast.makeText(InfoActivity.this, location, Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);
    }

    //自定义通知 针对Android8.0
    public void sendNormalNotification() {
        //1.创建通知
        Notification.Builder builder = null;
        //2.通知操作,定义pendingIntent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel channel = new NotificationChannel(id, "正常通知", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
            builder = new Notification.Builder(InfoActivity.this, id);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        } else {
            builder = new Notification.Builder(InfoActivity.this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        }
//3.发送
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(1, builder.build());
        }
    }

    //折叠通知
    public void foldNormalNotification() {
        //1.创建通知
        Notification.Builder builder = null;
        //2.通知操作,定义pendingIntent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel channel = new NotificationChannel(id, "正常通知", NotificationManager.IMPORTANCE_LOW);

            builder = new Notification.Builder(InfoActivity.this, id);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        } else {
            builder = new Notification.Builder(InfoActivity.this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        }
//3.发送
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.notification_fold);
        Notification notification= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notification = builder.build();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notification.bigContentView=remoteViews;
        }
        manager.notify(1,notification);
    }
    //悬挂通知
    public void sendHontNotification() {
        //1.创建通知
        Notification.Builder builder = null;
        //2.通知操作,定义pendingIntent
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel channel = new NotificationChannel(id, "正常通知", NotificationManager.IMPORTANCE_LOW);

            builder = new Notification.Builder(InfoActivity.this, id);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setFullScreenIntent(pendingIntent,true)
                   .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        } else {
            builder = new Notification.Builder(InfoActivity.this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setFullScreenIntent(pendingIntent,true)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        }
        //设置悬挂的Intent
        Intent hIntent=new Intent();
        hIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hIntent.setClass(this,MainActivity.class);
        PendingIntent hangIntent=PendingIntent.getActivity(InfoActivity.this,0,hIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setFullScreenIntent(hangIntent,true);

//3.发送

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(1, builder.build());
        }
    }
}



