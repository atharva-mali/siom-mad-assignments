package com.example.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Get references to the EditText and Button
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button showPasswordButton = findViewById(R.id.showPasswordButton);

        // Set an OnClickListener on the Button
        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the password from the EditText
                String password = passwordEditText.getText().toString();

                // Show the password in a Toast
                Toast.makeText(MainActivity.this, "Password: " + password, Toast.LENGTH_SHORT).show();

            }
        });

    }
}