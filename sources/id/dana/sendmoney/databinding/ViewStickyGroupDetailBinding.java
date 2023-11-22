package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewStickyGroupDetailBinding implements ViewBinding {
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    private final FrameLayout PlaceComponentResult;

    private ViewStickyGroupDetailBinding(FrameLayout frameLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout2) {
        this.PlaceComponentResult = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = frameLayout2;
    }

    public static ViewStickyGroupDetailBinding getAuthRequestContext(View view) {
        int i = R.id.newProxyInstance_res_0x7f0a0192;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonPrimaryView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ViewStickyGroupDetailBinding(frameLayout, danaButtonPrimaryView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
