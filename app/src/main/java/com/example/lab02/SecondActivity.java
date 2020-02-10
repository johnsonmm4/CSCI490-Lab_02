package com.example.lab02;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public ImageView supermoon, waterfall;
    public int imageId;
    public static int responseCode = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        supermoon = findViewById(R.id.supermoon);
        waterfall = findViewById(R.id.waterfall);
        final Intent intent = new Intent(this, MainActivity.class);

        supermoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageId = R.drawable.supermoon;

                intent.putExtra("imageId", imageId);
                setResult(responseCode, intent);
                finish();
            }
        });

        waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageId = R.drawable.waterfall;

                intent.putExtra("imageId", imageId);
                setResult(responseCode, intent);
                finish();
            }
        });
    }

    public void finish(){
        Intent intent = new Intent();
        intent.putExtra("imageId", imageId);

        super.finish();
    }
}
