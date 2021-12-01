package com.example.mobile_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {
    Button homeButton, mapButton, userButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        homeButton = findViewById(R.id.home);
        mapButton = findViewById(R.id.map);
        userButton = findViewById(R.id.user);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MainActivity2.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });
        //update the address given by the user
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MapActivity.class);
                intent.putExtra("user", getUsername());
                startActivity(intent);
            }
        });
        //update the address given by the user
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, UserActivity.class);
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
