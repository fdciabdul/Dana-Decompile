package id.dana.glidetransformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes5.dex */
public class MaskTransformation extends BitmapTransformation {
    private static final Paint getAuthRequestContext;
    private final int PlaceComponentResult;

    static {
        Paint paint = new Paint();
        getAuthRequestContext = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public MaskTransformation(int i) {
        this.PlaceComponentResult = i;
    }

    @Override // id.dana.glidetransformations.BitmapTransformation
    protected final Bitmap getAuthRequestContext(Context context, BitmapPool bitmapPool, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(width, height, Bitmap.Config.ARGB_8888);
        KClassImpl$Data$declaredNonStaticMembers$2.setHasAlpha(true);
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(context, this.PlaceComponentResult);
        KClassImpl$Data$declaredNonStaticMembers$2.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(KClassImpl$Data$declaredNonStaticMembers$2);
        PlaceComponentResult.setBounds(0, 0, width, height);
        PlaceComponentResult.draw(canvas);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, getAuthRequestContext);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.MaskTransformation.1");
        sb.append(this.PlaceComponentResult);
        messageDigest.update(sb.toString().getBytes(MyBillsEntityDataFactory));
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.PlaceComponentResult * 10) - 1949385457;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof MaskTransformation) && ((MaskTransformation) obj).PlaceComponentResult == this.PlaceComponentResult;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaskTransformation(maskId=");
        sb.append(this.PlaceComponentResult);
        sb.append(")");
        return sb.toString();
    }
}
