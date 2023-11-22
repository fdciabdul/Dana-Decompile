package com.rd.draw.controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;
import com.rd.pageindicatorview.R;
import com.rd.utils.DensityUtils;
import id.dana.lib.drawbitmap.style.Pallette;

/* loaded from: classes8.dex */
public class AttributeController {
    private Indicator MyBillsEntityDataFactory;

    public AttributeController(Indicator indicator) {
        this.MyBillsEntityDataFactory = indicator;
    }

    public final void PlaceComponentResult(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lookAheadTest, 0, 0);
        BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes);
        MyBillsEntityDataFactory(obtainStyledAttributes);
        PlaceComponentResult(obtainStyledAttributes);
        KClassImpl$Data$declaredNonStaticMembers$2(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void BuiltInFictitiousFunctionClassFactory(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda4, -1);
        boolean z = typedArray.getBoolean(R.styleable.getErrorConfigVersion, true);
        int i = 0;
        boolean z2 = typedArray.getBoolean(R.styleable.GetContactSyncConfig, false);
        int i2 = typedArray.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, -1);
        if (i2 == -1) {
            i2 = 3;
        }
        int i3 = typedArray.getInt(R.styleable.isLayoutRequested, 0);
        if (i3 >= 0 && (i2 <= 0 || i3 <= i2 - 1)) {
            i = i3;
        }
        this.MyBillsEntityDataFactory.whenAvailable = resourceId;
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = z;
        this.MyBillsEntityDataFactory.getAuthRequestContext = z2;
        this.MyBillsEntityDataFactory.PlaceComponentResult = i2;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        this.MyBillsEntityDataFactory.DatabaseTableConfigUtil = i;
    }

    private void MyBillsEntityDataFactory(TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5, Color.parseColor("#33ffffff"));
        int color2 = typedArray.getColor(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3, Color.parseColor(Pallette.WHITE));
        this.MyBillsEntityDataFactory.FragmentBottomSheetPaymentSettingBinding = color;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = color2;
    }

    private void PlaceComponentResult(TypedArray typedArray) {
        AnimationType animationType;
        RtlMode rtlMode;
        boolean z = typedArray.getBoolean(R.styleable.DatabaseTableConfigUtil, false);
        long j = typedArray.getInt(R.styleable.scheduleImpl, 350);
        if (j < 0) {
            j = 0;
        }
        switch (typedArray.getInt(R.styleable.moveToNextValue, AnimationType.NONE.ordinal())) {
            case 0:
                animationType = AnimationType.NONE;
                break;
            case 1:
                animationType = AnimationType.COLOR;
                break;
            case 2:
                animationType = AnimationType.SCALE;
                break;
            case 3:
                animationType = AnimationType.WORM;
                break;
            case 4:
                animationType = AnimationType.SLIDE;
                break;
            case 5:
                animationType = AnimationType.FILL;
                break;
            case 6:
                animationType = AnimationType.THIN_WORM;
                break;
            case 7:
                animationType = AnimationType.DROP;
                break;
            case 8:
                animationType = AnimationType.SWAP;
                break;
            case 9:
                animationType = AnimationType.SCALE_DOWN;
                break;
            default:
                animationType = AnimationType.NONE;
                break;
        }
        int i = typedArray.getInt(R.styleable.PrepareContext, RtlMode.Off.ordinal());
        if (i == 0) {
            rtlMode = RtlMode.On;
        } else if (i == 1) {
            rtlMode = RtlMode.Off;
        } else if (i == 2) {
            rtlMode = RtlMode.Auto;
        } else {
            rtlMode = RtlMode.Auto;
        }
        boolean z2 = typedArray.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2, false);
        long j2 = typedArray.getInt(R.styleable.initRecordTimeStamp, 3000);
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = j;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = animationType;
        this.MyBillsEntityDataFactory.isLayoutRequested = rtlMode;
        this.MyBillsEntityDataFactory.lookAheadTest = z2;
        this.MyBillsEntityDataFactory.getErrorConfigVersion = j2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray) {
        Orientation orientation;
        if (typedArray.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, Orientation.HORIZONTAL.ordinal()) == 0) {
            orientation = Orientation.HORIZONTAL;
        } else {
            orientation = Orientation.VERTICAL;
        }
        int dimension = (int) typedArray.getDimension(R.styleable.newProxyInstance, DensityUtils.PlaceComponentResult(6));
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) typedArray.getDimension(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7, DensityUtils.PlaceComponentResult(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f = typedArray.getFloat(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8, 0.7f);
        if (f < 0.3f) {
            f = 0.3f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int dimension3 = (int) typedArray.getDimension(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6, DensityUtils.PlaceComponentResult(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        Indicator indicator = this.MyBillsEntityDataFactory;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        int i = indicator.KClassImpl$Data$declaredNonStaticMembers$2 == AnimationType.FILL ? dimension3 : 0;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = dimension;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = orientation;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = dimension2;
        this.MyBillsEntityDataFactory.PrepareContext = f;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
    }
}
