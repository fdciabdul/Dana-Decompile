package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemAdditionalFeeConfirmationBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final LinearLayout PlaceComponentResult;

    private ItemAdditionalFeeConfirmationBinding(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
    }

    public static ItemAdditionalFeeConfirmationBinding PlaceComponentResult(View view) {
        int i = R.id.tvFeeAmount;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvFeeAmount);
        if (appCompatTextView != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvFeeName);
            if (appCompatTextView2 != null) {
                return new ItemAdditionalFeeConfirmationBinding((LinearLayout) view, appCompatTextView, appCompatTextView2);
            }
            i = R.id.tvFeeName;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
