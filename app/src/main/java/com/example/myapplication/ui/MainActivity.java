package com.example.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.model.Wallpaper;
import com.example.myapplication.utils.WallpaperUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Wallpaper> wallpapers = new ArrayList<>();

        wallpapers.add(new Wallpaper(320, 480, ""));
        wallpapers.add(new Wallpaper(480, 850, ""));
        wallpapers.add(new Wallpaper(480, 854, ""));
        wallpapers.add(new Wallpaper(720, 1280, ""));
        wallpapers.add(new Wallpaper(1080, 1920, ""));
        wallpapers.add(new Wallpaper(1080, 2340, ""));

        WallpaperUtils wallpaperUtils = new WallpaperUtils(MainActivity.this);
        Wallpaper wallpaper = wallpaperUtils.getBestFitWallpaper(wallpapers);

        Log.d("Wallpaper", wallpaper.toString());
    }


}
