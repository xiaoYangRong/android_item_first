package cn.edu.myapplication1.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast toast;
    public  static  void showMsg(Context context,String msg){
        if(toast==null){
            toast= Toast.makeText(context,msg,toast.LENGTH_LONG);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }
}
