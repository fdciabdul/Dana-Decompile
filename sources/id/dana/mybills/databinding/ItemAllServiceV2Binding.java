package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ItemAllServiceV2Binding implements ViewBinding {
    public final MaterialCardView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ItemAllServiceV2Binding(MaterialCardView materialCardView, AppCompatImageView appCompatImageView, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = materialCardView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = textView;
    }

    public static ItemAllServiceV2Binding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_all_service_v2, viewGroup, false);
        int i = R.id.res_0x7f0a0c2f_flowablereduce_reducesubscriber;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.res_0x7f0a18d2_navigationmenupresenter_headerviewholder;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                return new ItemAllServiceV2Binding((MaterialCardView) inflate, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
