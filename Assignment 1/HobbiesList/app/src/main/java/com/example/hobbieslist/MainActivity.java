package com.example.hobbieslist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxReading;
    private CheckBox checkBoxGaming;
    private CheckBox checkBoxTraveling;
    private CheckBox checkBoxCooking;
    private TextView textViewHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxGaming = findViewById(R.id.checkBoxGaming);
        checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        checkBoxCooking = findViewById(R.id.checkBoxCooking);
        textViewHobbies = findViewById(R.id.textViewHobbies);

        Button buttonShowHobbies = findViewById(R.id.buttonShowHobbies);
        buttonShowHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder selectedHobbies = new StringBuilder("Selected Hobbies:\n");

                if (checkBoxReading.isChecked()) {
                    selectedHobbies.append("Reading\n");
                }
                if (checkBoxGaming.isChecked()) {
                    selectedHobbies.append("Gaming\n");
                }
                if (checkBoxTraveling.isChecked()) {
                    selectedHobbies.append("Traveling\n");
                }
                if (checkBoxCooking.isChecked()) {
                    selectedHobbies.append("Cooking\n");
                }

                if (selectedHobbies.toString().equals("Selected Hobbies:\n")) {
                    selectedHobbies.append("None");
                }

                textViewHobbies.setText(selectedHobbies.toString());

            }
        });

    }
}