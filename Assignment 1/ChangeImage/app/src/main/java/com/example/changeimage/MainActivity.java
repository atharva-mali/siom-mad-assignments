package com.example.changeimage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button changeButton;

    private int currentImageIndex = 0;
    private int[] imageArray = {R.drawable.image1, R.drawable.image2, R.drawable.image3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        changeButton = findViewById(R.id.changeButton);

        // Set initial image
        imageView.setImageResource(imageArray[currentImageIndex]);

        // Button click listener
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change image on button click
                currentImageIndex = (currentImageIndex + 1) % imageArray.length;
                imageView.setImageResource(imageArray[currentImageIndex]);

            }
        });
    }
}