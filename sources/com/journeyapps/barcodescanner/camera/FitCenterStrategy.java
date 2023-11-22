package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.fullstory.instrumentation.InstrumentInjector;
import com.journeyapps.barcodescanner.Size;

/* loaded from: classes3.dex */
public class FitCenterStrategy extends PreviewScalingStrategy {
    private static final String BuiltInFictitiousFunctionClassFactory = "FitCenterStrategy";

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected final float PlaceComponentResult(Size size, Size size2) {
        if (size.MyBillsEntityDataFactory <= 0 || size.KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
            return 0.0f;
        }
        Size MyBillsEntityDataFactory = size.MyBillsEntityDataFactory(size2);
        float f = (MyBillsEntityDataFactory.MyBillsEntityDataFactory * 1.0f) / size.MyBillsEntityDataFactory;
        if (f > 1.0f) {
            f = (float) Math.pow(1.0f / f, 1.1d);
        }
        float f2 = ((size2.MyBillsEntityDataFactory * 1.0f) / MyBillsEntityDataFactory.MyBillsEntityDataFactory) * ((size2.KClassImpl$Data$declaredNonStaticMembers$2 * 1.0f) / MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        return f * (((1.0f / f2) / f2) / f2);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public final Rect getAuthRequestContext(Size size, Size size2) {
        Size MyBillsEntityDataFactory = size.MyBillsEntityDataFactory(size2);
        String str = BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("Preview: ");
        sb.append(size);
        sb.append("; Scaled: ");
        sb.append(MyBillsEntityDataFactory);
        sb.append("; Want: ");
        sb.append(size2);
        InstrumentInjector.log_i(str, sb.toString());
        int i = (MyBillsEntityDataFactory.MyBillsEntityDataFactory - size2.MyBillsEntityDataFactory) / 2;
        int i2 = (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 - size2.KClassImpl$Data$declaredNonStaticMembers$2) / 2;
        return new Rect(-i, -i2, MyBillsEntityDataFactory.MyBillsEntityDataFactory - i, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 - i2);
    }
}
