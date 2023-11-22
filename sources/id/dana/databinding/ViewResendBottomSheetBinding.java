package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewResendBottomSheetBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    private final CoordinatorLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final CoordinatorLayout scheduleImpl;

    private ViewResendBottomSheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, CoordinatorLayout coordinatorLayout2, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = coordinatorLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.scheduleImpl = coordinatorLayout2;
        this.lookAheadTest = textView;
        this.moveToNextValue = textView2;
    }

    public static ViewResendBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_resend_bottom_sheet, viewGroup, false);
        int i = R.id.btnCancelInvitation;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnCancelInvitation);
        if (danaButtonSecondaryView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnResendInvitation);
            if (danaButtonPrimaryView != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
                if (frameLayout != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivGrid);
                    if (appCompatImageView != null) {
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivTopUp);
                        if (appCompatImageView2 != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDescResend);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleResend);
                                if (textView2 != null) {
                                    return new ViewResendBottomSheetBinding(coordinatorLayout, danaButtonSecondaryView, danaButtonPrimaryView, frameLayout, appCompatImageView, appCompatImageView2, coordinatorLayout, textView, textView2);
                                }
                                i = R.id.tvTitleResend;
                            } else {
                                i = R.id.tvDescResend;
                            }
                        } else {
                            i = R.id.ivTopUp;
                        }
                    } else {
                        i = R.id.ivGrid;
                    }
                } else {
                    i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
                }
            } else {
                i = R.id.btnResendInvitation;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
