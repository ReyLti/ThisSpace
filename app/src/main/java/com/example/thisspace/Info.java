package com.example.thisspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);


        NavigationView myNavigatioView = findViewById(R.id.navigation_view_id);
        myNavigatioView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.Account:
                        startActivity(new Intent(Info.this,Account.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Info:
                        startActivity(new Intent(Info.this,Info.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Map:
                        startActivity(new Intent(Info.this,MapPlace.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Food:
                        startActivity(new Intent(Info.this,MapFood.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(Info.this,Settings.class));
                        myDrawerLayout.close();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        });
    }
}