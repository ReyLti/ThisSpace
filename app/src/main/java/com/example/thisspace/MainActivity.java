package com.example.thisspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);


        NavigationView myNavigatioView = findViewById(R.id.navigation_view_id);
        myNavigatioView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.Account:
                        startActivity(new Intent(myNavigatioView.getContext(),Account.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Info:
                        startActivity(new Intent(myNavigatioView.getContext(),Info.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Map:
                        startActivity(new Intent(myNavigatioView.getContext(),MapPlace.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Food:
                        startActivity(new Intent(myNavigatioView.getContext(),MapFood.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(myNavigatioView.getContext(),Settings.class));
                        myDrawerLayout.close();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        });
    }
}