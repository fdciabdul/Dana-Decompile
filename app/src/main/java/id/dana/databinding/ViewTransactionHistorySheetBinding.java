package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView;

/* loaded from: classes4.dex */
public final class ViewTransactionHistorySheetBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaCheckboxTriStatesButtonView getAuthRequestContext;
    public final CoordinatorLayout lookAheadTest;
    public final TextView moveToNextValue;
    private final CoordinatorLayout scheduleImpl;

    private ViewTransactionHistorySheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, DanaCheckboxTriStatesButtonView danaCheckboxTriStatesButtonView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, CoordinatorLayout coordinatorLayout2, RecyclerView recyclerView, TextView textView) {
        this.scheduleImpl = coordinatorLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.getAuthRequestContext = danaCheckboxTriStatesButtonView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.lookAheadTest = coordinatorLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.moveToNextValue = textView;
    }

    public static ViewTransactionHistorySheetBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_transaction_history_sheet, viewGroup, false);
        int i = R.id.btnApplyTransactionHistory;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnApplyTransactionHistory);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnCancelTransactionHistory);
            if (danaButtonSecondaryView != null) {
                DanaCheckboxTriStatesButtonView danaCheckboxTriStatesButtonView = (DanaCheckboxTriStatesButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.checkBoxParentHistory);
                if (danaCheckboxTriStatesButtonView != null) {
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
                    if (frameLayout != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.secondaryHash_res_0x7f0a08d3);
                        if (appCompatImageView != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvCheckboxHistory);
                            if (recyclerView != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                                if (textView != null) {
                                    return new ViewTransactionHistorySheetBinding(coordinatorLayout, danaButtonPrimaryView, danaButtonSecondaryView, danaCheckboxTriStatesButtonView, frameLayout, appCompatImageView, coordinatorLayout, recyclerView, textView);
                                }
                                i = R.id.tvTitle;
                            } else {
                                i = R.id.rvCheckboxHistory;
                            }
                        } else {
                            i = R.id.secondaryHash_res_0x7f0a08d3;
                        }
                    } else {
                        i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
                    }
                } else {
                    i = R.id.checkBoxParentHistory;
                }
            } else {
                i = R.id.btnCancelTransactionHistory;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
