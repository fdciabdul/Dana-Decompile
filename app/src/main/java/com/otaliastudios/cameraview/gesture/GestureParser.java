package com.otaliastudios.cameraview.gesture;

import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R;

/* loaded from: classes2.dex */
public class GestureParser {
    public int BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public int PlaceComponentResult;
    public int getAuthRequestContext;

    public GestureParser(TypedArray typedArray) {
        this.PlaceComponentResult = typedArray.getInteger(R.styleable.FragmentBottomSheetPaymentSettingBinding, GestureAction.DEFAULT_TAP.value());
        this.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getInteger(R.styleable.PrepareContext, GestureAction.DEFAULT_LONG_TAP.value());
        this.MyBillsEntityDataFactory = typedArray.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3, GestureAction.DEFAULT_PINCH.value());
        this.BuiltInFictitiousFunctionClassFactory = typedArray.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5, GestureAction.DEFAULT_SCROLL_HORIZONTAL.value());
        this.getAuthRequestContext = typedArray.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda4, GestureAction.DEFAULT_SCROLL_VERTICAL.value());
    }

    public static GestureAction PlaceComponentResult(int i) {
        return GestureAction.fromValue(i);
    }
}
