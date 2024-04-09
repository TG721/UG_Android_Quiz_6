package com.example.quiz_6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz_6.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    ActivitySecondBinding activitySecondBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySecondBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(activitySecondBinding.getRoot());

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName", "");
        String lastName = sharedPreferences.getString("LastName", "");
        String livingPlace = sharedPreferences.getString("livingPlace", "");
        String dateOfBirth = sharedPreferences.getString("DateOfBirth", "");

        TextView textViewInfo = activitySecondBinding.textViewResult;
        String userInfo = "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Living Place: " + livingPlace + "\n" +
                "Date of Birth: " + dateOfBirth;
        textViewInfo.setText(userInfo);
    }
}