package cn.edu.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.myapplication1.util.ToastUtil;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {
    private Button toast1,toast2,toast3,toast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toast1=findViewById(R.id.toast1);
        toast2=findViewById(R.id.toast2);
        toast3=findViewById(R.id.toast3);
        toast4=findViewById(R.id.toast4);
        toast1.setOnClickListener(this);
        toast2.setOnClickListener(this);
        toast3.setOnClickListener(this);
        toast4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.toast1:
                Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                break;
            case R.id.toast2:
                Toast toastCenter=Toast.makeText(getApplicationContext(),"居中",Toast.LENGTH_LONG);
                toastCenter.setGravity(Gravity.CENTER,0,0);
                toastCenter.show();
                break;
            case R.id.toast3:
                Toast toastCustom=new Toast(getApplicationContext());
                LayoutInflater inflater=LayoutInflater.from(ToastActivity.this);
                View view=inflater.inflate(R.layout.layout_toast,null);
                ImageView imageView=view.findViewById(R.id.iv_toast);
                TextView textView=view.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.touxiang);
                textView.setText("自定义Toast");
                toastCustom.setView(view);
                toastCustom.setDuration(Toast.LENGTH_LONG);
                toastCustom.show();
                break;
            case R.id.toast4:
                ToastUtil.showMsg(getApplicationContext(),"包装过的toast");
        }
    }
}
