package cn.edu.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    //1.定义使用的组件对象
    private Button btnLogin;
    private Button btnCheckBox;
    private Button btn_info;
    private Button btnImageView;
    private Button btnToast;
    private Button btnRadioGroup;
    private Button btnTouch;
    private Button btnDialog;
    private Button btnProgressBar;
    private Button btnCustomDialog;
    private Button btnMenu;
    private Button btnToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.通过id获取控件对象
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCheckBox = (Button) findViewById(R.id.btnCheckBox);
        btn_info = (Button) findViewById(R.id.info);
        btnImageView = (Button) findViewById(R.id.btnImageView);
        btnToast=findViewById(R.id.btn_Toast);
        btnRadioGroup=findViewById(R.id.btn_RadioGroup);
        btnTouch=findViewById(R.id.btn_Touch);
        btnDialog=findViewById(R.id.btn_Dialog);
        btnToolBar=findViewById(R.id.btn_toolbar);

        btnProgressBar=findViewById(R.id.btn_ProgessBar);
        btnCustomDialog=findViewById(R.id.btn_customDialog);
        btnMenu=findViewById(R.id.btn_menu);

        //3.设置按钮监听事件
        //3.1内部匿名类
        //3.2Activity实现接口，重写onClick
        //3.3处理监听事件
       btnLogin.setOnClickListener(this);
        btnCheckBox.setOnClickListener(this);
        btn_info.setOnClickListener(this);
        btnImageView.setOnClickListener(this);
        btnToast.setOnClickListener(this);
        btnRadioGroup.setOnClickListener(this);
        btnTouch.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
        btnProgressBar.setOnClickListener(this);
        btnCustomDialog.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnToolBar.setOnClickListener(this);
    /*  btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //跳转到登录界面
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //跳转到CheckBox界面
                Intent intent=new Intent(MainActivity.this,CheckBoxActivity.class);
                startActivity(intent);
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到info界面
                Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });
        btnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到info界面
                Intent intent=new Intent(MainActivity.this,ImageViewActivity.class);
                startActivity(intent);
            }
        });*/

    }
        @Override
        public void onClick (View v){
            Intent intent=null;
            switch (v.getId()) {
                case R.id.btnLogin:
                     intent = new Intent(MainActivity.this, LoginActivity.class);
                    break;
                case R.id.btnCheckBox:
                     intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.info:
                     intent = new Intent(MainActivity.this, InfoActivity.class);
                    break;
                case R.id.btnImageView:
                     intent= new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_Toast:
                    intent= new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_RadioGroup:
                    intent= new Intent(MainActivity.this, RadioGroupActivity.class);
                    break;
                case R.id.btn_Touch:
                    intent= new Intent(MainActivity.this, TouchActivity.class);
                    break;
                case R.id.btn_Dialog:
                    intent= new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_ProgessBar:
                    intent= new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_customDialog:
                    intent= new Intent(MainActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_menu:
                    intent= new Intent(MainActivity.this, MenuTestActivity.class);
                    break;
                case R.id.btn_toolbar:
                    intent= new Intent(MainActivity.this, ToolBarActivity.class);
                    break;
            }

            startActivity(intent);

        }
    }


