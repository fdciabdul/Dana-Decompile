package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class ItemFaqPasskeyBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final DanaDividerView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ItemFaqPasskeyBinding(ConstraintLayout constraintLayout, DanaDividerView danaDividerView, ImageView imageView, TextView textView, TextView textView2) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = danaDividerView;
        this.MyBillsEntityDataFactory = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ItemFaqPasskeyBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_faq_passkey, viewGroup, false);
        int i = R.id.DatabaseTableConfigUtil_res_0x7f0a06d1;
        DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaDividerView != null) {
            i = R.id.icArrowPasskey;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (imageView != null) {
                i = R.id.tvDescriptionSection;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    i = R.id.tvTitlePasskey;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView2 != null) {
                        return new ItemFaqPasskeyBinding((ConstraintLayout) inflate, danaDividerView, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
