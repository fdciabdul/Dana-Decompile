package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewTooltipTextDanaVizPromptBinding implements ViewBinding {
    private final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;

    private ViewTooltipTextDanaVizPromptBinding(FrameLayout frameLayout, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewTooltipTextDanaVizPromptBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4513res_0x7f0a1902_getzendeskbasicticket_domain_productionrelease);
        if (textView != null) {
            return new ViewTooltipTextDanaVizPromptBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f4513res_0x7f0a1902_getzendeskbasicticket_domain_productionrelease)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
