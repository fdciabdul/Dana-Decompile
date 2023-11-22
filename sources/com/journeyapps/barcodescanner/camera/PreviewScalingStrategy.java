package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.fullstory.instrumentation.InstrumentInjector;
import com.journeyapps.barcodescanner.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class PreviewScalingStrategy {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "PreviewScalingStrategy";

    protected float PlaceComponentResult(Size size, Size size2) {
        return 0.5f;
    }

    public abstract Rect getAuthRequestContext(Size size, Size size2);

    public Size KClassImpl$Data$declaredNonStaticMembers$2(List<Size> list, final Size size) {
        if (size != null) {
            Collections.sort(list, new Comparator<Size>() { // from class: com.journeyapps.barcodescanner.camera.PreviewScalingStrategy.1
                @Override // java.util.Comparator
                public /* synthetic */ int compare(Size size2, Size size3) {
                    return Float.compare(PreviewScalingStrategy.this.PlaceComponentResult(size3, size), PreviewScalingStrategy.this.PlaceComponentResult(size2, size));
                }
            });
        }
        String str = KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("Viewfinder size: ");
        sb.append(size);
        InstrumentInjector.log_i(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview in order of preference: ");
        sb2.append(list);
        InstrumentInjector.log_i(str, sb2.toString());
        return list.get(0);
    }
}
