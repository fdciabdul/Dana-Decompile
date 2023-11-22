package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class FragmentVerifyPushChallengeBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;
    public final AppCompatTextView scheduleImpl;

    private FragmentVerifyPushChallengeBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = linearLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
        this.scheduleImpl = appCompatTextView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView4;
    }

    public static FragmentVerifyPushChallengeBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btn_resend;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_resend);
        if (danaButtonPrimaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_icon_bottomsheet);
            if (appCompatImageView != null) {
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_retry);
                if (linearLayout != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_countdown_bottomsheet);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc_bottomsheet);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_left_attempt);
                            if (appCompatTextView3 != null) {
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_bottomsheet);
                                if (appCompatTextView4 != null) {
                                    return new FragmentVerifyPushChallengeBinding((ConstraintLayout) view, danaButtonPrimaryView, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                }
                                i = R.id.tv_title_bottomsheet;
                            } else {
                                i = R.id.tv_left_attempt;
                            }
                        } else {
                            i = R.id.tv_desc_bottomsheet;
                        }
                    } else {
                        i = R.id.tv_countdown_bottomsheet;
                    }
                } else {
                    i = R.id.ll_retry;
                }
            } else {
                i = R.id.iv_icon_bottomsheet;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
