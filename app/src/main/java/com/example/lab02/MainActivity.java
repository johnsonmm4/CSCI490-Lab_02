package com.example.lab02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public Button setBackground;
    public int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, SecondActivity.class);
        setBackground = findViewById(R.id.setBackground);


        setBackground.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivityForResult(intent, REQUEST_CODE);
            }
        }
        );


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1){
            Bundle extras = data.getExtras();
            imageId = extras.getInt("imageId");

            View currentView = this.findViewById(android.R.id.content);
            currentView.setBackground(getDrawable(imageId));
        }
    }

}
