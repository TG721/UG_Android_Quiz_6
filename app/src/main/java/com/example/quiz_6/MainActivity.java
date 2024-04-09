package com.example.quiz_6;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.quiz_6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                EditText editTextFirstName = findViewById(R.id.editTextFirstName);
                editor.putString("firstName", editTextFirstName.getText().toString());
                EditText editTextLastName = findViewById(R.id.editTextTextLastName);
                editor.putString("LastName", editTextLastName.getText().toString());
                EditText editTextLivingPlace = findViewById(R.id.editTextTextLivingPlace);
                editor.putString("livingPlace", editTextLivingPlace.getText().toString());
                EditText editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
                editor.putString("DateOfBirth", editTextDateOfBirth.getText().toString());

                editor.apply();
                Toast.makeText(MainActivity.this,"Data Saved", Toast.LENGTH_SHORT).show();
            }
        });
        activityMainBinding.buttonGoToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }


}