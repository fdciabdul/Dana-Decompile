package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class BottomSheetSelectDestinationBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final EmptyStateView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    public final SearchView moveToNextValue;
    private final CoordinatorLayout scheduleImpl;

    private BottomSheetSelectDestinationBinding(CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView, EmptyStateView emptyStateView, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, SearchView searchView, AppCompatTextView appCompatTextView) {
        this.scheduleImpl = coordinatorLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emptyStateView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.PlaceComponentResult = recyclerView;
        this.moveToNextValue = searchView;
        this.lookAheadTest = appCompatTextView;
    }

    public static BottomSheetSelectDestinationBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_select_destination, viewGroup, false);
        int i = R.id.MyBillsEntityDataFactory_res_0x7f0a012e;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.emptyCountryList;
            EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (emptyStateView != null) {
                i = R.id.flSelectDestination;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.containsObjectForKey_res_0x7f0a0a3d;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.res_0x7f0a111d_access_getfeaturedbanklistadapter_p;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (recyclerView != null) {
                            i = R.id.getSavingConfigPresenter_res_0x7f0a11d6;
                            SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (searchView != null) {
                                i = R.id.setValue;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView != null) {
                                    return new BottomSheetSelectDestinationBinding((CoordinatorLayout) inflate, appCompatImageView, emptyStateView, frameLayout, appCompatImageView2, recyclerView, searchView, appCompatTextView);
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
        return this.scheduleImpl;
    }
}
