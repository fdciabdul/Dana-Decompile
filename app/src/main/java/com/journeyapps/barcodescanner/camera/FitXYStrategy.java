package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.journeyapps.barcodescanner.Size;

/* loaded from: classes8.dex */
public class FitXYStrategy extends PreviewScalingStrategy {
    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected final float PlaceComponentResult(Size size, Size size2) {
        if (size.MyBillsEntityDataFactory <= 0 || size.KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
            return 0.0f;
        }
        float f = (size.MyBillsEntityDataFactory * 1.0f) / size2.MyBillsEntityDataFactory;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        float f2 = (size.KClassImpl$Data$declaredNonStaticMembers$2 * 1.0f) / size2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (f2 < 1.0f) {
            f2 = 1.0f / f2;
        }
        float f3 = (1.0f / f) / f2;
        float f4 = ((size.MyBillsEntityDataFactory * 1.0f) / size.KClassImpl$Data$declaredNonStaticMembers$2) / ((size2.MyBillsEntityDataFactory * 1.0f) / size2.KClassImpl$Data$declaredNonStaticMembers$2);
        if (f4 < 1.0f) {
            f4 = 1.0f / f4;
        }
        return f3 * (((1.0f / f4) / f4) / f4);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public final Rect getAuthRequestContext(Size size, Size size2) {
        return new Rect(0, 0, size2.MyBillsEntityDataFactory, size2.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
