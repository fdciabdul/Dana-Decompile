package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.view.WindowManager;
import com.fullstory.instrumentation.InstrumentInjector;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class BitmapLoadUtils {
    public static int PlaceComponentResult(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static int getAuthRequestContext(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static void PlaceComponentResult(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i, i2, bitmapLoadCallback).execute(new Void[0]);
    }

    public static Bitmap getAuthRequestContext(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e) {
            InstrumentInjector.log_e("BitmapLoadUtils", "transformBitmap: ", e);
            return bitmap;
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri) {
        InputStream openInputStream;
        int i = 0;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getExifOrientation: ");
            sb.append(uri.toString());
            InstrumentInjector.log_e("BitmapLoadUtils", sb.toString(), e);
        }
        if (openInputStream == null) {
            return 0;
        }
        i = new ImageHeaderParser(openInputStream).KClassImpl$Data$declaredNonStaticMembers$2();
        if (openInputStream != null) {
            if (openInputStream instanceof Closeable) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return i;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int MyBillsEntityDataFactory = EglUtils.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory > 0) {
            sqrt = Math.min(sqrt, MyBillsEntityDataFactory);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("maxBitmapSize: ");
        sb.append(sqrt);
        InstrumentInjector.log_d("BitmapLoadUtils", sb.toString());
        return sqrt;
    }

    public static void getAuthRequestContext(Closeable closeable) {
        if (closeable == null || !(closeable instanceof Closeable)) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
