package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierHeaderBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final ShapeableImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewCashierHeaderBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.moveToNextValue = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
        this.MyBillsEntityDataFactory = appCompatTextView3;
    }

    public static ViewCashierHeaderBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.f3606clHeaderContent;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3606clHeaderContent);
        if (constraintLayout != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.standardListIterator);
            if (shapeableImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4286res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4288tvMerchantType);
                    if (appCompatTextView2 != null) {
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.writeMapEntryField);
                        if (appCompatTextView3 != null) {
                            return new ViewCashierHeaderBinding((ConstraintLayout) view, constraintLayout, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                        }
                        i = R.id.writeMapEntryField;
                    } else {
                        i = R.id.f4288tvMerchantType;
                    }
                } else {
                    i = R.id.f4286res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit;
                }
            } else {
                i = R.id.standardListIterator;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
