package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;

/* loaded from: classes5.dex */
public final class BottomSheetGlobalSendFormOptionBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final EmptyStateView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final SearchView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final RecyclerView lookAheadTest;
    private final CoordinatorLayout moveToNextValue;

    private BottomSheetGlobalSendFormOptionBinding(CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView, EmptyStateView emptyStateView, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, RecyclerView recyclerView, SearchView searchView, AppCompatTextView appCompatTextView) {
        this.moveToNextValue = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emptyStateView;
        this.getAuthRequestContext = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.PlaceComponentResult = linearLayout;
        this.lookAheadTest = recyclerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = searchView;
        this.getErrorConfigVersion = appCompatTextView;
    }

    public static BottomSheetGlobalSendFormOptionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_global_send_form_option, viewGroup, false);
        int i = R.id.MyBillsEntityDataFactory_res_0x7f0a012e;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.emptyOptionsList;
            EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (emptyStateView != null) {
                i = R.id.flTransactionPurpose;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.containsObjectForKey_res_0x7f0a0a3d;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.res_0x7f0a0d5a_submitreceiptresultmodel_creator;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (linearLayout != null) {
                            i = R.id.TwilioRepository_res_0x7f0a1113;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (recyclerView != null) {
                                i = R.id.getSavingConfigPresenter_res_0x7f0a11d6;
                                SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (searchView != null) {
                                    i = R.id.setValue;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (appCompatTextView != null) {
                                        return new BottomSheetGlobalSendFormOptionBinding((CoordinatorLayout) inflate, appCompatImageView, emptyStateView, frameLayout, appCompatImageView2, linearLayout, recyclerView, searchView, appCompatTextView);
                                    }
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
