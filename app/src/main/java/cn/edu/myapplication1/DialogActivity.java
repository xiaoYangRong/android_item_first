package cn.edu.myapplication1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.edu.myapplication1.util.ToastUtil;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dialog1,dialog2,dialog3,dialog4,dialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialog1=findViewById(R.id.dialog1);
        dialog2=findViewById(R.id.dialog2);
        dialog3=findViewById(R.id.dialog3);
        dialog4=findViewById(R.id.dialog4);
        dialog5=findViewById(R.id.dialog5);
        dialog1.setOnClickListener(this);
        dialog2.setOnClickListener(this);
        dialog3.setOnClickListener(this);
        dialog4.setOnClickListener(this);
        dialog5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.dialog1:
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("请回答").setMessage("你觉得课程如何？")
                        .setIcon(R.drawable.touxiang2)
                        .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(DialogActivity.this, "你很诚实");
                            }
                        })
                        .setNeutralButton("还行", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(DialogActivity.this, "你再瞅瞅");
                            }
                        })
                        .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(DialogActivity.this, "睁眼说瞎话");

                            }
                        }).show();
                break;
            case R.id.dialog2:
                final String[] array = new String[]{"男", "女"};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                builder1.setTitle("选择性别：").setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, array[which]);
                    }
                }).show();

                break;
            case R.id.dialog3:
                final String[] array2 = new String[]{"男", "女"};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                builder2.setSingleChoiceItems(array2, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, array2[which]);
                        dialog.dismiss();
                    }
                }).setCancelable(false).show();

                break;
           case R.id.dialog4:
              /*  final String[] array3 = new String[]{"唱歌", "跳舞", "看书"};
                Boolean isSelected[] = new Boolean[]{false, false, true};
                AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                builder3.setTitle("选择兴趣：")
                        .setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                ToastUtil.showMsg(DialogActivity.this, array3[which] + ":" + isChecked);
                            }
                        }).show();*/
                break;
            case R.id.dialog5:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                View view= LayoutInflater.from(DialogActivity.this).inflate(R.layout.activity_dialog,null);
                EditText username=view.findViewById(R.id.username);
                EditText psd=view.findViewById(R.id.psd);
                Button btn_login=view.findViewWithTag(R.id.btn_login);
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    //点击登录事件
                    }
                });
                builder4.setTitle("请先登录").setView(view).show();
        }
    }
}
