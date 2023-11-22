package id.dana.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import id.zelory.compressor.Compressor;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ImageResize {
    public static Bitmap getAuthRequestContext(Bitmap bitmap, int i) {
        return Bitmap.createScaledBitmap(bitmap, (int) (i * (bitmap.getWidth() / bitmap.getHeight())), i, true);
    }

    public static int PlaceComponentResult(Activity activity, int i) {
        return PlaceComponentResult(activity, i);
    }

    public static int PlaceComponentResult(Activity activity, float f) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) Math.ceil(f * r0.density);
    }

    public static RequestOptions getAuthRequestContext() {
        return new RequestOptions().NetworkUserEntityData$$ExternalSyntheticLambda0().getAuthRequestContext(new CircleCrop());
    }

    public static File BuiltInFictitiousFunctionClassFactory(Context context, File file) throws IOException {
        Compressor compressor = new Compressor(context);
        compressor.BuiltInFictitiousFunctionClassFactory = 500;
        compressor.getAuthRequestContext = 500;
        compressor.PlaceComponentResult = Bitmap.CompressFormat.JPEG;
        return compressor.BuiltInFictitiousFunctionClassFactory(file, file.getName());
    }
}
