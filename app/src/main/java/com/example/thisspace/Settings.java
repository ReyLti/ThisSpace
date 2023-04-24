package com.example.thisspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) NavigationView myNavigatioView = findViewById(R.id.navigation_view_id);
        Button btnSignOut = (Button)findViewById(R.id.btnSignOutAccount);
        btnSignOut.setOnClickListener(this::OnClick);


        myNavigatioView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.Account:
                        startActivity(new Intent(Settings.this,Account.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Info:
                        startActivity(new Intent(Settings.this,Info.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Map:
                        startActivity(new Intent(Settings.this,MapPlace.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Food:
                        startActivity(new Intent(Settings.this,MapFood.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(Settings.this,Settings.class));
                        myDrawerLayout.close();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        });
    }

    private void OnClick(View view) {
        startActivity(new Intent(Settings.this,Authorization.class));
    }
}