package com.example.myapplication.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.myapplication.model.Wallpaper;

import java.util.List;

public final class WallpaperUtils {

    private int screenWidth;
    private int screenHeight;

    public WallpaperUtils(Context context) {
        screenWidth = ScreenUtils.getScreenWidth(context);
        screenHeight = ScreenUtils.getScreenHeight(context);
    }

    public Wallpaper getBestFitWallpaper(List<Wallpaper> wallpapers) {
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
