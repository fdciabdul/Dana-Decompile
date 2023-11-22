package id.dana.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class FragmentVerifyReferralCodeBinding implements ViewBinding {
    public final AppCompatEditText BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatButton PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ScrollView getErrorConfigVersion;
    public final ScrollView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final LinearLayoutCompat scheduleImpl;

    private FragmentVerifyReferralCodeBinding(ScrollView scrollView, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatEditText appCompatEditText, LinearLayoutCompat linearLayoutCompat, ScrollView scrollView2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.getErrorConfigVersion = scrollView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.PlaceComponentResult = appCompatButton;
        this.getAuthRequestContext = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatEditText;
        this.scheduleImpl = linearLayoutCompat;
        this.lookAheadTest = scrollView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
    }

    public static FragmentVerifyReferralCodeBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.btn_check_code;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_check_code);
        if (danaButtonSecondaryView != null) {
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_continue_register);
            if (appCompatButton != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.footer);
                if (appCompatTextView != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.image);
                    if (appCompatImageView != null) {
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.input_code);
                        if (appCompatEditText != null) {
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.layout_footer);
                            if (linearLayoutCompat != null) {
                                ScrollView scrollView = (ScrollView) view;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_subtitle);
                                if (appCompatTextView2 != null) {
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                                    if (appCompatTextView3 != null) {
                                        return new FragmentVerifyReferralCodeBinding(scrollView, danaButtonSecondaryView, appCompatButton, appCompatTextView, appCompatImageView, appCompatEditText, linearLayoutCompat, scrollView, appCompatTextView2, appCompatTextView3);
                                    }
                                    i = R.id.tv_title;
                                } else {
                                    i = R.id.tv_subtitle;
                                }
                            } else {
                                i = R.id.layout_footer;
                            }
                        } else {
                            i = R.id.input_code;
                        }
                    } else {
                        i = R.id.image;
                    }
                } else {
                    i = R.id.footer;
                }
            } else {
                i = R.id.btn_continue_register;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
