package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import id.dana.R;
import id.dana.richview.EmptyState;
import id.dana.richview.SearchView;

/* loaded from: classes4.dex */
public final class LayoutBankListBinding implements ViewBinding {
    public final EmptyState BuiltInFictitiousFunctionClassFactory;
    public final AppBarLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final CollapsingToolbarLayout getAuthRequestContext;
    public final SearchView getErrorConfigVersion;
    public final RecyclerView lookAheadTest;
    private final CoordinatorLayout moveToNextValue;

    private LayoutBankListBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout, CollapsingToolbarLayout collapsingToolbarLayout, EmptyState emptyState, RecyclerView recyclerView, RecyclerView recyclerView2, SearchView searchView, TextView textView) {
        this.moveToNextValue = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appBarLayout;
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = collapsingToolbarLayout;
        this.BuiltInFictitiousFunctionClassFactory = emptyState;
        this.MyBillsEntityDataFactory = recyclerView;
        this.lookAheadTest = recyclerView2;
        this.getErrorConfigVersion = searchView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
    }

    public static LayoutBankListBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3439res_0x7f0a0094_networkuserentitydata_externalsyntheticlambda0;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3439res_0x7f0a0094_networkuserentitydata_externalsyntheticlambda0);
        if (appBarLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clBankListContainer);
            if (constraintLayout != null) {
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3698collapsing_toolbar);
                if (collapsingToolbarLayout != null) {
                    EmptyState emptyState = (EmptyState) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.esSearchBank);
                    if (emptyState != null) {
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvAllBank);
                        if (recyclerView != null) {
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvTopBank);
                            if (recyclerView2 != null) {
                                SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.svSearchBank);
                                if (searchView != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAllBankTitle);
                                    if (textView != null) {
                                        return new LayoutBankListBinding((CoordinatorLayout) view, appBarLayout, constraintLayout, collapsingToolbarLayout, emptyState, recyclerView, recyclerView2, searchView, textView);
                                    }
                                    i = R.id.tvAllBankTitle;
                                } else {
                                    i = R.id.svSearchBank;
                                }
                            } else {
                                i = R.id.rvTopBank;
                            }
                        } else {
                            i = R.id.rvAllBank;
                        }
                    } else {
                        i = R.id.esSearchBank;
                    }
                } else {
                    i = R.id.f3698collapsing_toolbar;
                }
            } else {
                i = R.id.clBankListContainer;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
