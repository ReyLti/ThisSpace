package com.example.thisspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

public class MapPlace extends AppCompatActivity {
    private MapView mapview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("31899d0b-d03c-4258-a635-432c92349ccc");
        setContentView(R.layout.map_place);
        MapKitFactory.initialize(this);
        mapview = (MapView) findViewById(R.id.mapview);
        mapview.getMap().setNightModeEnabled(true);
        mapview.getMap().move(
                new CameraPosition(new Point(55.046782, 82.917103), 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        mapview.getMap().getMapObjects().addPlacemark(new Point(55.046782, 82.917103), ImageProvider.fromResource(this, R.drawable.ic_baseline_shop_24));
        mapview.getMap().getMapObjects().addPlacemark(new Point(55.045940, 82.917388), ImageProvider.fromResource(this, R.drawable.ic_baseline_sports_hockey_24));
        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);


        NavigationView myNavigatioView = findViewById(R.id.navigation_view_id);
        myNavigatioView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.Account:
                        startActivity(new Intent(MapPlace.this,Account.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Info:
                        startActivity(new Intent(MapPlace.this,Info.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Map:
                        startActivity(new Intent(MapPlace.this,MapPlace.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Food:
                        startActivity(new Intent(MapPlace.this,MapFood.class));
                        myDrawerLayout.close();
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(MapPlace.this,Settings.class));
                        myDrawerLayout.close();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        });
    }
    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }


}