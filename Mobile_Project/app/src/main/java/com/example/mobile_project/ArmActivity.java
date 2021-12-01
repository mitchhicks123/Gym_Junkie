package com.example.mobile_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ArmActivity extends AppCompatActivity {

    Button addButton;
    Button homeButton, mapButton, userButton;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arm_home);

        dbHandler = new DBHandler(ArmActivity.this);

        //search db for notes then pull them an display
        String[] answer;
        String toaster = "";
        answer = dbHandler.readArmWorkouts(getUsername());

        if (answer[0].equals("fail")){
            Toast.makeText(ArmActivity.this, "No Workouts Yet", Toast.LENGTH_SHORT).show();
        }
        else {
            for (int i = 0; i < answer.length; i++){
                toaster += " " + answer[i];
            }
            Toast.makeText(ArmActivity.this, toaster, Toast.LENGTH_SHORT).show();
        }


        //initiate buttons
        homeButton = findViewById(R.id.home);
        mapButton = findViewById(R.id.map);
        userButton = findViewById(R.id.user);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmActivity.this, MainActivity2.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });
        //update the address given by the user
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmActivity.this, MapActivity.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });
        //update the address given by the user
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmActivity.this, UserActivity.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });

        addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmActivity.this, ArmSubmitActivity.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });
    }

    public String getUsername() {
        Intent intent = getIntent();
        String username = intent.getExtras().getString("user");
        return username;
    }
}
