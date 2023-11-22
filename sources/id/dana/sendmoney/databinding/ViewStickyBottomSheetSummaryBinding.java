package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes3.dex */
public final class ViewStickyBottomSheetSummaryBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final FrameLayout scheduleImpl;

    private ViewStickyBottomSheetSummaryBinding(FrameLayout frameLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.scheduleImpl = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static ViewStickyBottomSheetSummaryBinding PlaceComponentResult(View view) {
        int i = R.id.newProxyInstance_res_0x7f0a0192;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonPrimaryView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.getContainerAuth_res_0x7f0a08ac;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView != null) {
                i = R.id.setValue;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (textView != null) {
                    i = R.id.tvTotalAmount;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (textView2 != null) {
                        return new ViewStickyBottomSheetSummaryBinding(frameLayout, danaButtonPrimaryView, frameLayout, appCompatImageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
