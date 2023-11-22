package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ItemTopUpAndPayAgentBinding implements ViewBinding {
    private final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout PlaceComponentResult;

    private ItemTopUpAndPayAgentBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.PlaceComponentResult = linearLayout2;
    }

    public static ItemTopUpAndPayAgentBinding MyBillsEntityDataFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) view;
        return new ItemTopUpAndPayAgentBinding(linearLayout, linearLayout);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
