package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.fullstory.instrumentation.InstrumentInjector;
import com.journeyapps.barcodescanner.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes8.dex */
public class LegacyPreviewScalingStrategy extends PreviewScalingStrategy {
    private static final String getAuthRequestContext = "LegacyPreviewScalingStrategy";

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public final Size KClassImpl$Data$declaredNonStaticMembers$2(List<Size> list, final Size size) {
        if (size == null) {
            return list.get(0);
        }
        Collections.sort(list, new Comparator<Size>() { // from class: com.journeyapps.barcodescanner.camera.LegacyPreviewScalingStrategy.1
            @Override // java.util.Comparator
            public /* synthetic */ int compare(Size size2, Size size3) {
                Size size4 = size2;
                Size size5 = size3;
                int i = LegacyPreviewScalingStrategy.BuiltInFictitiousFunctionClassFactory(size4, size).MyBillsEntityDataFactory - size4.MyBillsEntityDataFactory;
                int i2 = LegacyPreviewScalingStrategy.BuiltInFictitiousFunctionClassFactory(size5, size).MyBillsEntityDataFactory - size5.MyBillsEntityDataFactory;
                if (i == 0 && i2 == 0) {
                    return size4.compareTo(size5);
                }
                if (i == 0) {
                    return -1;
                }
                if (i2 != 0) {
                    if (i >= 0 || i2 >= 0) {
                        if (i <= 0 || i2 <= 0) {
                            return i < 0 ? -1 : 1;
                        }
                        return -size4.compareTo(size5);
                    }
                    return size4.compareTo(size5);
                }
                return 1;
            }
        });
        String str = getAuthRequestContext;
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

    public static Size BuiltInFictitiousFunctionClassFactory(Size size, Size size2) {
        Size size3;
        if (size2.getAuthRequestContext(size)) {
            while (true) {
                size3 = new Size((size.MyBillsEntityDataFactory * 2) / 3, (size.KClassImpl$Data$declaredNonStaticMembers$2 * 2) / 3);
                Size size4 = new Size((size.MyBillsEntityDataFactory * 1) / 2, (size.KClassImpl$Data$declaredNonStaticMembers$2 * 1) / 2);
                if (!size2.getAuthRequestContext(size4)) {
                    break;
                }
                size = size4;
            }
            return size2.getAuthRequestContext(size3) ? size3 : size;
        }
        while (true) {
            Size size5 = new Size((size.MyBillsEntityDataFactory * 3) / 2, (size.KClassImpl$Data$declaredNonStaticMembers$2 * 3) / 2);
            Size size6 = new Size((size.MyBillsEntityDataFactory * 2) / 1, (size.KClassImpl$Data$declaredNonStaticMembers$2 * 2) / 1);
            if (size2.getAuthRequestContext(size5)) {
                return size5;
            }
            if (size2.getAuthRequestContext(size6)) {
                return size6;
            }
            size = size6;
        }
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public final Rect getAuthRequestContext(Size size, Size size2) {
        Size BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(size, size2);
        String str = getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("Preview: ");
        sb.append(size);
        sb.append("; Scaled: ");
        sb.append(BuiltInFictitiousFunctionClassFactory);
        sb.append("; Want: ");
        sb.append(size2);
        InstrumentInjector.log_i(str, sb.toString());
        int i = (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory - size2.MyBillsEntityDataFactory) / 2;
        int i2 = (BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 - size2.KClassImpl$Data$declaredNonStaticMembers$2) / 2;
        return new Rect(-i, -i2, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory - i, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 - i2);
    }
}
