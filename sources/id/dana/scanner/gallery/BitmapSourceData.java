package id.dana.scanner.gallery;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.RGBLuminanceSource;

/* loaded from: classes5.dex */
public class BitmapSourceData {
    private Bitmap KClassImpl$Data$declaredNonStaticMembers$2;

    public BitmapSourceData(Bitmap bitmap) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bitmap;
    }

    public final LuminanceSource PlaceComponentResult() {
        int[] iArr = new int[this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth() * this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight()];
        Bitmap bitmap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth(), this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight());
        return new RGBLuminanceSource(this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth(), this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight(), iArr);
    }
}
