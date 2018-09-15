package cn.edu.myapplication1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.myapplication1.util.ToastUtil;

public class MenuTestActivity extends AppCompatActivity {
    private EditText editText01;
    private EditText editText02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
        editText01=findViewById(R.id.editText01);
        editText02=findViewById(R.id.editText02);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater() ;
        inflater.inflate(R.menu.optionmenu,menu);//压进布局
       /* menu.add(1,1,1,"hello1");
        menu.add(1,2,2,"hello2");//第一组第二个id 排序
        menu.addSubMenu(1,1,1,"hello1");
        menu.addSubMenu(1,1,1,"hello1");
        menu.addSubMenu("sub1");
        menu.addSubMenu("sub2");*/

        return super.onCreateOptionsMenu(menu);
    }



    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch(item.getItemId()){
            case R.id.Info:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
               return true;
            case R.id.sz:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sz1:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sz2:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sz3:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
        }*/
        Toast.makeText(this,item.getTitle().toString(),3000).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderIcon(R.drawable.touxiang);
        switch(v.getId()){
            case R.id.editText01:
                menu.add(0,Menu.FIRST+1,0,"菜单项1");
                menu.add(0,Menu.FIRST+2,0,"菜单项2");
                menu.add(0,Menu.FIRST+3,0,"菜单项3");
                break;
            case R.id.editText02:
                menu.add(0,Menu.FIRST+4,0,"菜单项1");
                menu.add(0,Menu.FIRST+5,0,"菜单项2");

                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

   @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu.FIRST+1:
            case Menu.FIRST+2:
            case Menu.FIRST+3:

                editText01.append("\n"+item.getTitle()+"被按下");
                break;

            case Menu.FIRST+4:
            case Menu.FIRST+5:

                editText02.append("\n"+item.getTitle()+"被按下");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
