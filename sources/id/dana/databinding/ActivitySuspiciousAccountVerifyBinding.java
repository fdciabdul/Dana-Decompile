package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivitySuspiciousAccountVerifyBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final LayoutToolbarBinding getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final AppCompatTextView scheduleImpl;

    private ActivitySuspiciousAccountVerifyBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, LayoutToolbarBinding layoutToolbarBinding, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = layoutToolbarBinding;
        this.MyBillsEntityDataFactory = linearLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
    }

    public static ActivitySuspiciousAccountVerifyBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_suspicious_account_verify, (ViewGroup) null, false);
        int i = R.id.btn_verify;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_verify);
        if (danaButtonPrimaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ic_diana);
            if (appCompatImageView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ll_content);
                    if (linearLayout != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title_desc);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title_verify);
                            if (appCompatTextView2 != null) {
                                return new ActivitySuspiciousAccountVerifyBinding((ConstraintLayout) inflate, danaButtonPrimaryView, appCompatImageView, MyBillsEntityDataFactory, linearLayout, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tv_title_verify;
                        } else {
                            i = R.id.tv_title_desc;
                        }
                    } else {
                        i = R.id.ll_content;
                    }
                } else {
                    i = R.id.SecurityGuardProfileProvider;
                }
            } else {
                i = R.id.ic_diana;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
