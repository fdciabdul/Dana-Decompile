package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import java.util.List;

/* loaded from: classes3.dex */
public interface BarcodeCallback {

    /* renamed from: com.journeyapps.barcodescanner.BarcodeCallback$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static void PlaceComponentResult() {
        }
    }

    void getAuthRequestContext(BarcodeResult barcodeResult);

    void getAuthRequestContext(List<ResultPoint> list);
}
