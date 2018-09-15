package cn.edu.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView iv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        iv_1=findViewById(R.id.iv_1);
        Glide.with(this).load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1536327795&di=dfcd8adf1a2d5f354fe9a386cfc9cda4&src=http://img17.3lian.com/d/file/201703/10/af3c23bfb5c55952a1b535c83f293944.jpg").into(iv_1);
    }
}
