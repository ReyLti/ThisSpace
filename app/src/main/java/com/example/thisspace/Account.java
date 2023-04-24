package com.example.thisspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);


        NavigationView myNavigatioView = findViewById(R.id.navigation_view_id);
        TextView textView = findViewById(R.id.login);
        Button btnSignOut = (Button)findViewById(R.id.btnSignOutAccount);
        btnSignOut.setOnClickListener(this::OnClick);
        CircleImageView CIV = findViewById(R.id.profile_image);
        registerForContextMenu(CIV);

        myNavigatioView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.Account:
                        startActivity(new Intent(Account.this,Account.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Info:
                        startActivity(new Intent(Account.this,Info.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Map:
                        startActivity(new Intent(Account.this,MapPlace.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Food:
                        startActivity(new Intent(Account.this,MapFood.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(Account.this,Settings.class));
                        myDrawerLayout.close();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        });
    }

    private void OnClick(View view) {
        startActivity(new Intent(Account.this,Authorization.class));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.edit:
                Toast.makeText(this, "В будущем изменить фото профиля", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this, "В будущем удалить фото профиля", Toast.LENGTH_SHORT).show();
                return true;

        }
        return false;
    }
}