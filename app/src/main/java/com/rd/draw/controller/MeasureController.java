package com.rd.draw.controller;

import android.util.Pair;
import android.view.View;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

/* loaded from: classes3.dex */
public class MeasureController {
    public static Pair<Integer, Integer> BuiltInFictitiousFunctionClassFactory(Indicator indicator, int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = indicator.PlaceComponentResult;
        int i6 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i7 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i8 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i9 = indicator.initRecordTimeStamp;
        int i10 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i11 = indicator.newProxyInstance;
        int i12 = indicator.GetContactSyncConfig;
        int i13 = i6 * 2;
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        Orientation orientation = indicator.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i5 != 0) {
            i4 = (i13 * i5) + (i7 * 2 * i5) + (i8 * (i5 - 1));
            i3 = i13 + i7;
            if (orientation == Orientation.HORIZONTAL) {
                i4 = i3;
                i3 = i4;
            }
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == AnimationType.DROP) {
            if (orientation == Orientation.HORIZONTAL) {
                i4 *= 2;
            } else {
                i3 *= 2;
            }
        }
        Orientation orientation2 = Orientation.HORIZONTAL;
        int i14 = i3 + i9 + i11;
        int i15 = i4 + i10 + i12;
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i14, size) : i14;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i15, size2) : i15;
        }
        if (size < 0) {
            size = 0;
        }
        int i16 = size2 >= 0 ? size2 : 0;
        indicator.readMicros = size;
        indicator.scheduleImpl = i16;
        return new Pair<>(Integer.valueOf(size), Integer.valueOf(i16));
    }
}
