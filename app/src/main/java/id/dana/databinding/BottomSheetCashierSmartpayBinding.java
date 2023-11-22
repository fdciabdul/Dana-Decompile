package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetCashierSmartpayBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView lookAheadTest;
    private final CoordinatorLayout scheduleImpl;

    private BottomSheetCashierSmartpayBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.scheduleImpl = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = frameLayout;
        this.MyBillsEntityDataFactory = imageView;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.getAuthRequestContext = textView;
        this.lookAheadTest = textView2;
    }

    public static BottomSheetCashierSmartpayBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_cashier_smartpay, viewGroup, false);
        int i = R.id.f3451isLayoutRequested_res_0x7f0a011f;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3451isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flCashierSmartpay);
            if (frameLayout != null) {
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivClose);
                if (imageView != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvIntroductionSmartpay);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.PayAssetMapper_Factory);
                            if (textView2 != null) {
                                return new BottomSheetCashierSmartpayBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, imageView, recyclerView, textView, textView2);
                            }
                            i = R.id.PayAssetMapper_Factory;
                        } else {
                            i = R.id.tvTitle;
                        }
                    } else {
                        i = R.id.rvIntroductionSmartpay;
                    }
                } else {
                    i = R.id.ivClose;
                }
            } else {
                i = R.id.flCashierSmartpay;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
