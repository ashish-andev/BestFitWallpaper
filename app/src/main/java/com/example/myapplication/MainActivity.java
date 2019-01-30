package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Wallpaper> wallpapers = new ArrayList<>();

        wallpapers.add(new Wallpaper(100, 100, ""));
        wallpapers.add(new Wallpaper(100, 100, ""));
        wallpapers.add(new Wallpaper(100, 100, ""));
        wallpapers.add(new Wallpaper(100, 100, ""));
        wallpapers.add(new Wallpaper(100, 100, ""));

        Wallpaper wallpaper = getBestFitWallpaper(wallpapers,
                ScreenUtils.getScreenWidth(MainActivity.this),
                ScreenUtils.getScreenHeight(MainActivity.this));

        Log.i("Wallpaper", wallpaper.toString());
    }


    private Wallpaper getBestFitWallpaper(List<Wallpaper> wallpapers,
                                          int screenWidth, int screenHeight) {

        Wallpaper wallpaper = null;

        float diff = 0;
        float ratio = ((float) screenHeight / (float) screenWidth);

        for (Wallpaper wp : wallpapers) {
            if (wp.getWidth() == screenWidth && wp.getHeight() == screenHeight) {
                wallpaper = wp;
                break;
            } else {
                float wpRatio = ((float) screenHeight / (float) screenWidth);
                float tempDiff = Math.abs(ratio - wpRatio);
                if (diff == 0 || tempDiff < diff) {
                    diff = tempDiff;
                    wallpaper = wp;
                } else if (tempDiff == diff && wp.getWidth() > wallpaper.getWidth()
                        && wp.getHeight() > wallpaper.getHeight()) {
                    wallpaper = wp;
                }

            }
        }
        return wallpaper;
    }
}
