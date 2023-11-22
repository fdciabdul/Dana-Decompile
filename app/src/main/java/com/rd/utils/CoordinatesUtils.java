package com.rd.utils;

import android.util.Pair;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

/* loaded from: classes3.dex */
public class CoordinatesUtils {
    public static int getAuthRequestContext(Indicator indicator, int i) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
            return MyBillsEntityDataFactory(indicator, i);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(indicator, i);
    }

    private static int PlaceComponentResult(Indicator indicator, int i) {
        int i2 = indicator.PlaceComponentResult;
        int i3 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i4 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i5 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i4 / 2;
            int i9 = i6 + i3 + i8;
            if (i == i7) {
                return i9;
            }
            i6 = i9 + i3 + i5 + i8;
        }
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        return indicator.KClassImpl$Data$declaredNonStaticMembers$2 == AnimationType.DROP ? i6 + (i3 * 2) : i6;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Indicator indicator, float f, float f2) {
        int i;
        if (indicator == null) {
            return -1;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 != Orientation.HORIZONTAL) {
            f2 = f;
            f = f2;
        }
        int i2 = indicator.PlaceComponentResult;
        int i3 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i4 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i5 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
            i = indicator.scheduleImpl;
        } else {
            i = indicator.readMicros;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = (i3 * 2) + (i4 / 2) + (i6 > 0 ? i5 : i5 / 2) + i7;
            boolean z = f >= ((float) i7) && f <= ((float) i8);
            boolean z2 = f2 >= 0.0f && f2 <= ((float) i);
            if (z && z2) {
                return i6;
            }
            i6++;
            i7 = i8;
        }
        return -1;
    }

    public static Pair<Integer, Float> KClassImpl$Data$declaredNonStaticMembers$2(Indicator indicator, int i, float f, boolean z) {
        int i2 = indicator.PlaceComponentResult;
        int i3 = indicator.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (z) {
            i = (i2 - 1) - i;
        }
        boolean z2 = false;
        if (i < 0) {
            i = 0;
        } else {
            int i4 = i2 - 1;
            if (i > i4) {
                i = i4;
            }
        }
        boolean z3 = i > i3;
        boolean z4 = !z ? i + 1 >= i3 : i + (-1) >= i3;
        if (z3 || z4) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
            i3 = i;
        }
        float f2 = 0.0f;
        if (i3 == i && f != 0.0f) {
            z2 = true;
        }
        if (z2) {
            i = z ? i - 1 : i + 1;
        } else {
            f = 1.0f - f;
        }
        if (f > 1.0f) {
            f2 = 1.0f;
        } else if (f >= 0.0f) {
            f2 = f;
        }
        return new Pair<>(Integer.valueOf(i), Float.valueOf(f2));
    }

    private static int MyBillsEntityDataFactory(Indicator indicator) {
        int i = indicator.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        return indicator.KClassImpl$Data$declaredNonStaticMembers$2 == AnimationType.DROP ? i * 3 : i;
    }

    public static int MyBillsEntityDataFactory(Indicator indicator, int i) {
        int MyBillsEntityDataFactory;
        if (indicator == null) {
            return 0;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
            MyBillsEntityDataFactory = PlaceComponentResult(indicator, i);
        } else {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(indicator);
        }
        return MyBillsEntityDataFactory + indicator.initRecordTimeStamp;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Indicator indicator, int i) {
        int PlaceComponentResult;
        if (indicator == null) {
            return 0;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
            PlaceComponentResult = MyBillsEntityDataFactory(indicator);
        } else {
            PlaceComponentResult = PlaceComponentResult(indicator, i);
        }
        return PlaceComponentResult + indicator.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }
}
