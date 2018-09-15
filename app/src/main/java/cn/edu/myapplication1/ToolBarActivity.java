package cn.edu.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        toolbar=findViewById(R.id.my_toobar);
        //给toolbar加载菜单
     //   setSupportActionBar(toolbar);//需要重写onCreateOptionMenu()和onOptinItemSelected()
        //toolbar.inflateMenu(R.menu.demo);//需要设置菜单选择的事件监听器
        toolbar.inflateMenu(R.menu.optionmenu);
        toolbar.setTitle("详情页");
        toolbar.setSubtitle("副标题");
       // toolbar.setTitleTextColor(getResources().getColor(android.R.id.white));
        toolbar.setLogo(R.mipmap.ic_launcher);
       toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.search:
                        Toast.makeText(ToolBarActivity.this,"toolbar search",Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }
}
