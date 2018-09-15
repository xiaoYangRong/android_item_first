package cn.edu.myapplication1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private EditText username;
    private EditText psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        psd = findViewById(R.id.psd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        username.setOnKeyListener(new View.OnKeyListener() {
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


        // Intent intent=new Intent(LoginActivity.this,InfoActivity.class);
        // startActivity(intent);
        // Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String name = String.valueOf(username.getText());
                String password = String.valueOf(psd.getText());
                login(name, password);
                break;
        }
    }

    private void login(String name, String password) {
        if ("niit".equals(name) && "111".equals(password)) {
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra("username", name);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
        }
    }

    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderIcon(R.drawable.touxiang2);
        switch(v.getId()){
            case R.id.editText1:
                menu.add(0,MENU1,0,"菜单项1")

        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }*/

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
            builder = new Notification.Builder(LoginActivity.this, id);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

        } else {
            builder = new Notification.Builder(LoginActivity.this);
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

}





