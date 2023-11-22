package id.dana.drawable.merchantdetail.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import id.dana.drawable.merchantdetail.bottomsheet.CustomMerchantDetailBottomsheetBehavior;

/* loaded from: classes9.dex */
public final /* synthetic */ class CustomMerchantDetailBottomsheetBehavior$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int MyBillsEntityDataFactory;
    public final /* synthetic */ CustomMerchantDetailBottomsheetBehavior PlaceComponentResult;

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        CustomMerchantDetailBottomsheetBehavior customMerchantDetailBottomsheetBehavior = this.PlaceComponentResult;
        View view = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = this.MyBillsEntityDataFactory;
        if (i2 == 4) {
            i = customMerchantDetailBottomsheetBehavior.PlaceComponentResult;
        } else if (i2 == 3) {
            i = customMerchantDetailBottomsheetBehavior.BuiltInFictitiousFunctionClassFactory;
        } else if (customMerchantDetailBottomsheetBehavior.MyBillsEntityDataFactory && i2 == 5) {
            i = customMerchantDetailBottomsheetBehavior.getAuthRequestContext;
        } else if (i2 == 6) {
            i = customMerchantDetailBottomsheetBehavior.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal state argument: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (customMerchantDetailBottomsheetBehavior.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(view, view.getLeft(), i)) {
            customMerchantDetailBottomsheetBehavior.KClassImpl$Data$declaredNonStaticMembers$2(2);
            ViewCompat.PlaceComponentResult(view, new CustomMerchantDetailBottomsheetBehavior.SettleRunnable(view, i2));
            return;
        }
        customMerchantDetailBottomsheetBehavior.KClassImpl$Data$declaredNonStaticMembers$2(i2);
    }
}
