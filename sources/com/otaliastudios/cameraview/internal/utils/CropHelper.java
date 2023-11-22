package com.otaliastudios.cameraview.internal.utils;

import android.graphics.Rect;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes2.dex */
public class CropHelper {
    public static Rect BuiltInFictitiousFunctionClassFactory(Size size, AspectRatio aspectRatio) {
        int round;
        int i = size.BuiltInFictitiousFunctionClassFactory;
        int i2 = size.getAuthRequestContext;
        int i3 = 0;
        if (aspectRatio.KClassImpl$Data$declaredNonStaticMembers$2(size)) {
            return new Rect(0, 0, i, i2);
        }
        AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(i, i2);
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory > aspectRatio.getAuthRequestContext / aspectRatio.MyBillsEntityDataFactory) {
            int round2 = Math.round(i2 * (aspectRatio.getAuthRequestContext / aspectRatio.MyBillsEntityDataFactory));
            int round3 = Math.round((i - round2) / 2.0f);
            i = round2;
            i3 = round3;
            round = 0;
        } else {
            int round4 = Math.round(i / (aspectRatio.getAuthRequestContext / aspectRatio.MyBillsEntityDataFactory));
            round = Math.round((i2 - round4) / 2.0f);
            i2 = round4;
        }
        return new Rect(i3, round, i + i3, i2 + round);
    }
}
