package com.example.thisspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Authorization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);
        Button btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this::OnClickSignIn);
        Button btnRegistration = (Button)findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(this::OnClickRegistration);
    }

    private void OnClickSignIn(View view) {
        startActivity(new Intent(Authorization.this,MainActivity.class));
    }
    private void OnClickRegistration(View view) {
        startActivity(new Intent(Authorization.this,Registration.class));
    }
}