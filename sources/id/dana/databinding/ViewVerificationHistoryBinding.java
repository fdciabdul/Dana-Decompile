package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewVerificationHistoryBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewVerificationHistoryBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.moveToNextValue = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
        this.PlaceComponentResult = appCompatTextView3;
    }

    public static ViewVerificationHistoryBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.iv_merchant_request_history_logo;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_merchant_request_history_logo);
        if (shapeableImageView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_merchant_request_history_status);
            if (appCompatImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_history_date);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_history_status);
                    if (appCompatTextView2 != null) {
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_history_title);
                        if (appCompatTextView3 != null) {
                            return new ViewVerificationHistoryBinding((ConstraintLayout) view, shapeableImageView, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                        }
                        i = R.id.tv_merchant_request_history_title;
                    } else {
                        i = R.id.tv_merchant_request_history_status;
                    }
                } else {
                    i = R.id.tv_merchant_request_history_date;
                }
            } else {
                i = R.id.iv_merchant_request_history_status;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
