package fsimpl;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import com.fullstory.jni.FSNativeHooks;
import java.io.InputStream;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class dX extends dW {
    public dX() {
        super(15);
        int i;
        Method a2;
        int i2 = Build.VERSION.SDK_INT;
        Method a3 = dZ.a(AssetManager.class, "destroyAsset", null, Integer.TYPE);
        a(0, a3, a3 == null ? null : dZ.a(FSNativeHooks.class, "destroyAsset", AssetManager.class, Integer.TYPE), AssetManager.class);
        Method a4 = dZ.a(AssetManager.class, "destroyAsset", null, Long.TYPE);
        a(1, a4, a4 == null ? null : dZ.a(FSNativeHooks.class, "destroyAsset", AssetManager.class, Long.TYPE), AssetManager.class);
        if (i2 >= 28) {
            Class a5 = eV.a("android.graphics.ImageDecoder");
            Method a6 = dZ.a(a5, "nCreate", eV.a("android.graphics.ImageDecoder"), InputStream.class, byte[].class, eV.a("android.graphics.ImageDecoder$Source"));
            a(2, a6, a6 == null ? null : dZ.a(FSNativeHooks.class, "nCreate", Class.class, Object.class, InputStream.class, byte[].class, Object.class), a5);
        }
        if (i2 >= 28) {
            Class a7 = eV.a("android.graphics.ImageDecoder");
            Method a8 = dZ.a(a7, "nCreate", eV.a("android.graphics.ImageDecoder"), Long.TYPE, eV.a("android.graphics.ImageDecoder$Source"));
            a(3, a8, a8 == null ? null : dZ.a(FSNativeHooks.class, "nCreate", Class.class, Object.class, Long.TYPE, Object.class), a7);
        }
        if (i2 < 28 || i2 > 28) {
            i = 13;
        } else {
            Class a9 = eV.a("android.graphics.ImageDecoder");
            Method a10 = dZ.a(a9, "nDecodeBitmap", Bitmap.class, Long.TYPE, eV.a("android.graphics.ImageDecoder"), Boolean.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, eV.a("android.graphics.ColorSpace"));
            if (a10 == null) {
                i = 13;
                a2 = null;
            } else {
                i = 13;
                a2 = dZ.a(FSNativeHooks.class, "nDecodeBitmap", Class.class, Bitmap.class, Long.TYPE, Object.class, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Object.class);
            }
            a(4, a10, a2, a9);
        }
        if (i2 >= 29) {
            Class a11 = eV.a("android.graphics.ImageDecoder");
            Class[] clsArr = new Class[i];
            clsArr[0] = Long.TYPE;
            clsArr[1] = eV.a("android.graphics.ImageDecoder");
            clsArr[2] = Boolean.TYPE;
            clsArr[3] = Integer.TYPE;
            clsArr[4] = Integer.TYPE;
            clsArr[5] = Rect.class;
            clsArr[6] = Boolean.TYPE;
            clsArr[7] = Integer.TYPE;
            clsArr[8] = Boolean.TYPE;
            clsArr[9] = Boolean.TYPE;
            clsArr[10] = Boolean.TYPE;
            clsArr[11] = Long.TYPE;
            clsArr[12] = Boolean.TYPE;
            Method a12 = dZ.a(a11, "nDecodeBitmap", Bitmap.class, clsArr);
            a(5, a12, a12 == null ? null : dZ.a(FSNativeHooks.class, "nDecodeBitmap", Class.class, Bitmap.class, Long.TYPE, Object.class, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Long.TYPE, Boolean.TYPE), a11);
        }
        Method a13 = dZ.a(AssetManager.class, "nativeAssetDestroy", null, Long.TYPE);
        a(6, a13, a13 == null ? null : dZ.a(FSNativeHooks.class, "nativeAssetDestroy", Class.class, Long.TYPE), AssetManager.class);
        Method a14 = dZ.a(BitmapFactory.class, "nativeDecodeAsset", Bitmap.class, Integer.TYPE, Rect.class, BitmapFactory.Options.class);
        a(7, a14, a14 == null ? null : dZ.a(FSNativeHooks.class, "nativeDecodeAsset", Class.class, Bitmap.class, Integer.TYPE, Rect.class, BitmapFactory.Options.class), BitmapFactory.class);
        Method a15 = dZ.a(BitmapFactory.class, "nativeDecodeAsset", Bitmap.class, Integer.TYPE, Rect.class, BitmapFactory.Options.class, Boolean.TYPE, Float.TYPE);
        a(8, a15, a15 == null ? null : dZ.a(FSNativeHooks.class, "nativeDecodeAsset", Class.class, Bitmap.class, Integer.TYPE, Rect.class, BitmapFactory.Options.class, Boolean.TYPE, Float.TYPE), BitmapFactory.class);
        Method a16 = dZ.a(BitmapFactory.class, "nativeDecodeAsset", Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class);
        a(9, a16, a16 == null ? null : dZ.a(FSNativeHooks.class, "nativeDecodeAsset", Class.class, Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class), BitmapFactory.class);
        Method a17 = dZ.a(BitmapFactory.class, "nativeDecodeAsset", Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class, Boolean.TYPE, Float.TYPE);
        a(10, a17, a17 == null ? null : dZ.a(FSNativeHooks.class, "nativeDecodeAsset", Class.class, Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class, Boolean.TYPE, Float.TYPE), BitmapFactory.class);
        if (i2 >= 29) {
            Method a18 = dZ.a(BitmapFactory.class, "nativeDecodeAsset", Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class, Long.TYPE, Long.TYPE);
            a(11, a18, a18 == null ? null : dZ.a(FSNativeHooks.class, "nativeDecodeAsset", Class.class, Bitmap.class, Long.TYPE, Rect.class, BitmapFactory.Options.class, Long.TYPE, Long.TYPE), BitmapFactory.class);
        }
        Method a19 = dZ.a(AssetManager.class, "nativeOpenNonAsset", Long.TYPE, Long.TYPE, Integer.TYPE, String.class, Integer.TYPE);
        a(12, a19, a19 == null ? null : dZ.a(FSNativeHooks.class, "nativeOpenNonAsset", Class.class, Long.TYPE, Long.TYPE, Integer.TYPE, String.class, Integer.TYPE), AssetManager.class);
        Method a20 = dZ.a(AssetManager.class, "openNonAssetNative", Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE);
        a(13, a20, a20 == null ? null : dZ.a(FSNativeHooks.class, "openNonAssetNative", AssetManager.class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE), AssetManager.class);
        Method a21 = dZ.a(AssetManager.class, "openNonAssetNative", Long.TYPE, Integer.TYPE, String.class, Integer.TYPE);
        a(14, a21, a21 == null ? null : dZ.a(FSNativeHooks.class, "openNonAssetNative", AssetManager.class, Long.TYPE, Integer.TYPE, String.class, Integer.TYPE), AssetManager.class);
    }
}
