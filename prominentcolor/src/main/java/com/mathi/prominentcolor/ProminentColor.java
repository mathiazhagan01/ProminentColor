package com.mathi.prominentcolor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * Created by Mathiazhagan on 10-07-2017.
 */

public class ProminentColor {

    public ProminentColorListener prominentColorListener;
    private Bitmap bitmap;

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setBitmap(Drawable drawable) {
        setBitmap(((BitmapDrawable) drawable).getBitmap());
    }

    private void getProminentColor() {
        Handler mainHandler = new Handler();
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                int col = readColor();
                if (prominentColorListener != null) {
                    prominentColorListener.onGettingColor(col);
                }
            }
        };
        mainHandler.post(myRunnable);
    }

    private int readColor() {
        long red = 0;
        long green = 0;
        long blue = 0;
        long count = 0;

        for (int y = 0; y < bitmap.getHeight(); y++) {
            for (int x = 0; x < bitmap.getWidth(); x++) {
                int c = bitmap.getPixel(x, y);

                count++;
                red += Color.red(c);
                green += Color.green(c);
                blue += Color.blue(c);
            }
        }
        return Color.rgb((int) (red / count), (int) (green / count), (int) (blue / count));
    }

    public void getColor(ProminentColorListener prominentColorListener) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap is null. Please set bitmap by setBitmap() method");
        } else {
            this.prominentColorListener = prominentColorListener;
            getProminentColor();
        }
    }
}
