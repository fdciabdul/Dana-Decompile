package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BaseFamilyTopupBottomSheetBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final CoordinatorLayout MyBillsEntityDataFactory;
    public final ViewTopupFirstTimerBottomSheetBinding PlaceComponentResult;
    public final ViewTopupBottomSheetBinding getAuthRequestContext;

    private BaseFamilyTopupBottomSheetBinding(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout2, ViewTopupBottomSheetBinding viewTopupBottomSheetBinding, ViewTopupFirstTimerBottomSheetBinding viewTopupFirstTimerBottomSheetBinding) {
        this.MyBillsEntityDataFactory = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout2;
        this.getAuthRequestContext = viewTopupBottomSheetBinding;
        this.PlaceComponentResult = viewTopupFirstTimerBottomSheetBinding;
    }

    public static BaseFamilyTopupBottomSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.base_family_topup_bottom_sheet, viewGroup, false);
        int i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
        if (frameLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSheetTopup);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewTopupBottomSheetBinding BuiltInFictitiousFunctionClassFactory2 = ViewTopupBottomSheetBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSheetTopupFirstTimer);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    return new BaseFamilyTopupBottomSheetBinding(coordinatorLayout, frameLayout, coordinatorLayout, BuiltInFictitiousFunctionClassFactory2, ViewTopupFirstTimerBottomSheetBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3));
                }
                i = R.id.viewSheetTopupFirstTimer;
            } else {
                i = R.id.viewSheetTopup;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
