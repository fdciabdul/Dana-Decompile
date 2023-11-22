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
public final class ViewVerificationActiveBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ViewVerificationActiveBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.scheduleImpl = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
        this.PlaceComponentResult = appCompatTextView3;
    }

    public static ViewVerificationActiveBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.CustomPopMenuExtension;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
        if (appCompatImageView != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_merchant_request_logo);
            if (shapeableImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_date);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_status);
                    if (appCompatTextView2 != null) {
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_merchant_request_title);
                        if (appCompatTextView3 != null) {
                            return new ViewVerificationActiveBinding((ConstraintLayout) view, appCompatImageView, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                        }
                        i = R.id.tv_merchant_request_title;
                    } else {
                        i = R.id.tv_merchant_request_status;
                    }
                } else {
                    i = R.id.tv_merchant_request_date;
                }
            } else {
                i = R.id.iv_merchant_request_logo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
