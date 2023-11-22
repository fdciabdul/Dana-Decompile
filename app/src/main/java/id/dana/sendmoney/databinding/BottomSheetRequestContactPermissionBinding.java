package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class BottomSheetRequestContactPermissionBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final DanaButtonGhostView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    private final CoordinatorLayout moveToNextValue;

    private BottomSheetRequestContactPermissionBinding(CoordinatorLayout coordinatorLayout, DanaButtonGhostView danaButtonGhostView, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = coordinatorLayout;
        this.getAuthRequestContext = danaButtonGhostView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.getErrorConfigVersion = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static BottomSheetRequestContactPermissionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_request_contact_permission, viewGroup, false);
        int i = R.id.scheduleImpl;
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonGhostView != null) {
            i = R.id.initRecordTimeStamp;
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaButtonPrimaryView != null) {
                i = R.id.j;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.secondaryHash_res_0x7f0a08d3;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.FlowableConcatMapEagerPublisher;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.TrustRiskLogin$Params;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatTextView != null) {
                                i = R.id.setValue;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView2 != null) {
                                    return new BottomSheetRequestContactPermissionBinding((CoordinatorLayout) inflate, danaButtonGhostView, danaButtonPrimaryView, frameLayout, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
