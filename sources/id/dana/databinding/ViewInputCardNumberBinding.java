package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewInputCardNumberBinding implements ViewBinding {
    public final AppCompatEditText BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final FrameLayout scheduleImpl;

    private ViewInputCardNumberBinding(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.lookAheadTest = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatEditText;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.getAuthRequestContext = appCompatImageView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.scheduleImpl = frameLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.moveToNextValue = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
    }

    public static ViewInputCardNumberBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_input_card_number, (ViewGroup) null, false);
        int i = R.id.f3747GetFriendsFeedWithInitFeedAndFeatureCheck_res_0x7f0a0671;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3747GetFriendsFeedWithInitFeedAndFeatureCheck_res_0x7f0a0671);
        if (appCompatEditText != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivCardLoading);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivCardScheme);
                if (appCompatImageView2 != null) {
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivCardType);
                    if (appCompatImageView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llCardScheme);
                        if (linearLayout != null) {
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llInputCard);
                            if (frameLayout != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorCard);
                                if (appCompatTextView != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                                    if (appCompatTextView2 != null) {
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvWarningCard);
                                        if (appCompatTextView3 != null) {
                                            return new ViewInputCardNumberBinding((ConstraintLayout) inflate, appCompatEditText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayout, frameLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                                        }
                                        i = R.id.tvWarningCard;
                                    } else {
                                        i = R.id.tvTitle;
                                    }
                                } else {
                                    i = R.id.tvErrorCard;
                                }
                            } else {
                                i = R.id.llInputCard;
                            }
                        } else {
                            i = R.id.llCardScheme;
                        }
                    } else {
                        i = R.id.ivCardType;
                    }
                } else {
                    i = R.id.ivCardScheme;
                }
            } else {
                i = R.id.ivCardLoading;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
