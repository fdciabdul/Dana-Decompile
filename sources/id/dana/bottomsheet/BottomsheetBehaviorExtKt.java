package id.dana.bottomsheet;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\t\u0010\b\u001a\u0015\u0010\n\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\n\u0010\b"}, d2 = {"Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "", "MyBillsEntityDataFactory", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)Z", "PlaceComponentResult", "moveToNextValue"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomsheetBehaviorExtKt {
    public static final void getAuthRequestContext(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(5);
    }

    public static final void MyBillsEntityDataFactory(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        bottomSheetBehavior.setState(4);
    }

    public static final void BuiltInFictitiousFunctionClassFactory(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        bottomSheetBehavior.setState(6);
    }

    public static final boolean PlaceComponentResult(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        return bottomSheetBehavior.getState() == 3;
    }

    public static final boolean moveToNextValue(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        return bottomSheetBehavior.getState() == 5;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetBehavior<?> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "");
        return bottomSheetBehavior.getState() == 4 || bottomSheetBehavior.getState() == 6 || bottomSheetBehavior.getState() == 3;
    }
}
