package com.otaliastudios.cameraview.size;

import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SizeSelectorParser {
    public SizeSelector MyBillsEntityDataFactory;
    public SizeSelector PlaceComponentResult;

    public SizeSelectorParser(TypedArray typedArray) {
        SizeSelector PlaceComponentResult;
        SizeSelector PlaceComponentResult2;
        ArrayList arrayList = new ArrayList(3);
        if (typedArray.hasValue(R.styleable.D)) {
            arrayList.add(SizeSelectors.NetworkUserEntityData$$ExternalSyntheticLambda0(typedArray.getInteger(R.styleable.D, 0)));
        }
        if (typedArray.hasValue(R.styleable.B)) {
            arrayList.add(SizeSelectors.PlaceComponentResult(typedArray.getInteger(R.styleable.B, 0)));
        }
        if (typedArray.hasValue(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2)) {
            arrayList.add(SizeSelectors.getAuthRequestContext(typedArray.getInteger(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2, 0)));
        }
        if (typedArray.hasValue(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1)) {
            arrayList.add(SizeSelectors.BuiltInFictitiousFunctionClassFactory(typedArray.getInteger(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1, 0)));
        }
        if (typedArray.hasValue(R.styleable.getValueOfTouchPositionAbsolute)) {
            arrayList.add(SizeSelectors.KClassImpl$Data$declaredNonStaticMembers$2(typedArray.getInteger(R.styleable.getValueOfTouchPositionAbsolute, 0)));
        }
        if (typedArray.hasValue(R.styleable.C)) {
            arrayList.add(SizeSelectors.MyBillsEntityDataFactory(typedArray.getInteger(R.styleable.C, 0)));
        }
        if (typedArray.hasValue(R.styleable.A)) {
            arrayList.add(SizeSelectors.getAuthRequestContext(AspectRatio.MyBillsEntityDataFactory(typedArray.getString(R.styleable.A))));
        }
        if (typedArray.getBoolean(R.styleable.E, false)) {
            arrayList.add(SizeSelectors.MyBillsEntityDataFactory());
        }
        if (typedArray.getBoolean(R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1, false)) {
            arrayList.add(SizeSelectors.PlaceComponentResult());
        }
        if (!arrayList.isEmpty()) {
            PlaceComponentResult = SizeSelectors.MyBillsEntityDataFactory((SizeSelector[]) arrayList.toArray(new SizeSelector[0]));
        } else {
            PlaceComponentResult = SizeSelectors.PlaceComponentResult();
        }
        this.MyBillsEntityDataFactory = PlaceComponentResult;
        ArrayList arrayList2 = new ArrayList(3);
        if (typedArray.hasValue(R.styleable.isAuth)) {
            arrayList2.add(SizeSelectors.NetworkUserEntityData$$ExternalSyntheticLambda0(typedArray.getInteger(R.styleable.isAuth, 0)));
        }
        if (typedArray.hasValue(R.styleable.R)) {
            arrayList2.add(SizeSelectors.PlaceComponentResult(typedArray.getInteger(R.styleable.R, 0)));
        }
        if (typedArray.hasValue(R.styleable.S)) {
            arrayList2.add(SizeSelectors.getAuthRequestContext(typedArray.getInteger(R.styleable.S, 0)));
        }
        if (typedArray.hasValue(R.styleable.N)) {
            arrayList2.add(SizeSelectors.BuiltInFictitiousFunctionClassFactory(typedArray.getInteger(R.styleable.N, 0)));
        }
        if (typedArray.hasValue(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2)) {
            arrayList2.add(SizeSelectors.KClassImpl$Data$declaredNonStaticMembers$2(typedArray.getInteger(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2, 0)));
        }
        if (typedArray.hasValue(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0)) {
            arrayList2.add(SizeSelectors.MyBillsEntityDataFactory(typedArray.getInteger(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0, 0)));
        }
        if (typedArray.hasValue(R.styleable.Q)) {
            arrayList2.add(SizeSelectors.getAuthRequestContext(AspectRatio.MyBillsEntityDataFactory(typedArray.getString(R.styleable.Q))));
        }
        if (typedArray.getBoolean(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1, false)) {
            arrayList2.add(SizeSelectors.MyBillsEntityDataFactory());
        }
        if (typedArray.getBoolean(R.styleable.P, false)) {
            arrayList2.add(SizeSelectors.PlaceComponentResult());
        }
        if (!arrayList2.isEmpty()) {
            PlaceComponentResult2 = SizeSelectors.MyBillsEntityDataFactory((SizeSelector[]) arrayList2.toArray(new SizeSelector[0]));
        } else {
            PlaceComponentResult2 = SizeSelectors.PlaceComponentResult();
        }
        this.PlaceComponentResult = PlaceComponentResult2;
    }
}
