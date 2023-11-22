package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.landing.view.RecipientRibbonView;

/* loaded from: classes4.dex */
public final class ItemHomeMenuSendmoneyBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final RecipientRibbonView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    private final ConstraintLayout moveToNextValue;

    private ItemHomeMenuSendmoneyBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecipientRibbonView recipientRibbonView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = constraintLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientRibbonView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static ItemHomeMenuSendmoneyBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.ivIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIcon);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivRedot);
            if (appCompatImageView2 != null) {
                RecipientRibbonView recipientRibbonView = (RecipientRibbonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.recipientRibbon);
                if (recipientRibbonView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvLabelNew);
                    if (textView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvSubtitle);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                            if (appCompatTextView2 != null) {
                                return new ItemHomeMenuSendmoneyBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, recipientRibbonView, textView, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tvTitle;
                        } else {
                            i = R.id.tvSubtitle;
                        }
                    } else {
                        i = R.id.tvLabelNew;
                    }
                } else {
                    i = R.id.recipientRibbon;
                }
            } else {
                i = R.id.ivRedot;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
