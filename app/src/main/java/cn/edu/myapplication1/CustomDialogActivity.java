package cn.edu.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.myapplication1.util.ToastUtil;
import cn.edu.myapplication1.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_customDialog1;
    private Button btn_customDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        btn_customDialog1=(Button)findViewById(R.id.btn_customDialog1);
        btn_customDialog2=(Button)findViewById(R.id.btn_customDialog2);
        btn_customDialog1.setOnClickListener(this);
        btn_customDialog2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_customDialog1:
                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示")
                        .setMessage("确认删除吗？")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"cancel...");
                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"confirm...");

                            }
                        }).show();
                break;
            case R.id.btn_customDialog2:
                break;


        }
        }

}
