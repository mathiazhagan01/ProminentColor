package com.mathi.prominentcolorsample;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mathi.prominentcolor.ProminentColor;
import com.mathi.prominentcolor.ProminentColorListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button changeImage, colorButton;
    private int i = 0;
    private List<Drawable> imgList;
    ProminentColor prominentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        colorButton = (Button) findViewById(R.id.color);

        changeImage = (Button) findViewById(R.id.change_image);
        changeImage.setOnClickListener(changeImageListener);

        imgList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgList.add(getDrawable(R.drawable._1));
            imgList.add(getDrawable(R.drawable._2));
            imgList.add(getDrawable(R.drawable._3));
            imgList.add(getDrawable(R.drawable._4));
            imgList.add(getDrawable(R.drawable._5));
            imgList.add(getDrawable(R.drawable._6));
            imgList.add(getDrawable(R.drawable._7));
        } else {
            imgList.add(getResources().getDrawable(R.drawable._1));
            imgList.add(getResources().getDrawable(R.drawable._2));
            imgList.add(getResources().getDrawable(R.drawable._3));
            imgList.add(getResources().getDrawable(R.drawable._4));
            imgList.add(getResources().getDrawable(R.drawable._5));
            imgList.add(getResources().getDrawable(R.drawable._6));
            imgList.add(getResources().getDrawable(R.drawable._7));
        }

        prominentColor = new ProminentColor();
    }

    private View.OnClickListener changeImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (imgList.size() == i) {
                i = 0;
            }
            image.setImageDrawable(imgList.get(i));
            prominentColor.setBitmap(imgList.get(i));
            prominentColor.getColor(new ProminentColorListener() {

                @Override
                public void onGettingColor(int color) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(color);
                    }
                    colorButton.setBackgroundColor(color);
                }
            });
            ++i;
        }
    };
}
