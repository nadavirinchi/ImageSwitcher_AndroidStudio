package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayouthorizontal;
    ImageSwitcher imgswitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayouthorizontal = findViewById(R.id.linearlayouthorizontal);
        imgswitcher = findViewById(R.id.imgswitcher);

        imgswitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                ImageView imgView = new ImageView(MainActivity.this);
                imgView.setScaleType(ImageView.ScaleType.FIT_XY);
                imgView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                return imgView;

            }
        });

        for (int index = 0;index<Animal.anmalimages.length;index++){

            final int i = index;
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Integer.parseInt(Animal.animalnames[index]));
            imageView.setPadding(100,100,100,100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgswitcher.setImageResource(Animal.anmalimages[i]);
                    Toast.makeText(MainActivity.this, "this is" + Animal.animalnames[i], Toast.LENGTH_SHORT).show();
                }
               
            });
            linearLayouthorizontal.addView(imageView);

        }

    }

}