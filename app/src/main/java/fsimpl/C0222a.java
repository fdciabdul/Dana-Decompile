package fsimpl;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* renamed from: fsimpl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0222a {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7818a = eV.a(30, 30, BitmapShader.class, "mBitmap");

    public static Bitmap a(BitmapShader bitmapShader) {
        if (a()) {
            try {
                return (Bitmap) f7818a.get(bitmapShader);
            } catch (IllegalAccessException e) {
                Log.e("Failed to retrieve mBitmap field value", e);
                return null;
            }
        }
        return null;
    }

    public static boolean a() {
        return f7818a != null;
    }
}
