package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemSavedBankCardsV2Binding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView lookAheadTest;
    private final ConstraintLayout moveToNextValue;

    private ItemSavedBankCardsV2Binding(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.moveToNextValue = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
        this.lookAheadTest = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView4;
    }

    public static ItemSavedBankCardsV2Binding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.imageLogoFilter;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.imageLogoFilter);
        if (frameLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_change_icon);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.requiresTunnel);
                if (appCompatImageView2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.isHelperTextDisplayed);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_first_option);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPrefixDescription);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                                if (textView4 != null) {
                                    return new ItemSavedBankCardsV2Binding((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, textView, textView2, textView3, textView4);
                                }
                                i = R.id.tvTitle;
                            } else {
                                i = R.id.tvPrefixDescription;
                            }
                        } else {
                            i = R.id.cl_first_option;
                        }
                    } else {
                        i = R.id.isHelperTextDisplayed;
                    }
                } else {
                    i = R.id.requiresTunnel;
                }
            } else {
                i = R.id.iv_change_icon;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
