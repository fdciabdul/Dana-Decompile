package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* loaded from: classes3.dex */
public class DecoderResultPointCallback implements ResultPointCallback {
    Decoder KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        Decoder decoder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (decoder != null) {
            decoder.foundPossibleResultPoint(resultPoint);
        }
    }
}
