package com.example.newonemannager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.newonemannager.Activity.DangNhapActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    List<SlideModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DangNhapActivity.class));
            }
        });
        imageSlider = findViewById(R.id.slider);
        models.add(new SlideModel("https://st3.depositphotos.com/1561359/18406/v/1600/depositphotos_184065638-stock-illustration-arabica-coffee-ads.jpg", ScaleTypes.FIT));
        models.add(new SlideModel("https://mir-s3-cdn-cf.behance.net/project_modules/disp/0a26e710555531.560e6e605bf0e.jpg", ScaleTypes.FIT));
        models.add(new SlideModel("https://freight.cargo.site/t/original/i/055660021a5c1132aea1ffccd99c74cba1fd294a9ace670ebb5d2a721f0b25aa/13MKT_PS_BA2_MalibuDreamIBV2_o.jpg", ScaleTypes.FIT));
        models.add(new SlideModel("https://s3-ap-southeast-1.amazonaws.com/s3.loopme.my/img/newos/posts/2x/7092_WrCFGQ25Gg5mJCoo_.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(models);
    }
}