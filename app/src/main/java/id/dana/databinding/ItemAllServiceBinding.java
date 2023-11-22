package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemAllServiceBinding implements ViewBinding {
    private final MaterialCardView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final AppCompatImageView getAuthRequestContext;

    private ItemAllServiceBinding(MaterialCardView materialCardView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = materialCardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ItemAllServiceBinding getAuthRequestContext(View view) {
        int i = R.id.res_0x7f0a0a68_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0a68_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0c2f_flowablereduce_reducesubscriber);
            if (appCompatImageView2 != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a18d2_navigationmenupresenter_headerviewholder);
                if (textView != null) {
                    return new ItemAllServiceBinding((MaterialCardView) view, appCompatImageView, appCompatImageView2, textView);
                }
                i = R.id.res_0x7f0a18d2_navigationmenupresenter_headerviewholder;
            } else {
                i = R.id.res_0x7f0a0c2f_flowablereduce_reducesubscriber;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
