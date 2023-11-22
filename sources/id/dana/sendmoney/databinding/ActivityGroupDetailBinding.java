package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;

/* loaded from: classes5.dex */
public final class ActivityGroupDetailBinding implements ViewBinding {
    public final ViewBodyGroupDetailBinding BuiltInFictitiousFunctionClassFactory;
    public final ViewDialogEditGroupNameBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final EmptyStateView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ViewToolbarBinding PlaceComponentResult;
    public final NestedScrollView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ViewStickyGroupDetailBinding lookAheadTest;
    public final ViewHeaderGroupDetailBinding moveToNextValue;
    public final ViewHistoryAddFavoriteBinding scheduleImpl;

    private ActivityGroupDetailBinding(ConstraintLayout constraintLayout, EmptyStateView emptyStateView, NestedScrollView nestedScrollView, ViewToolbarBinding viewToolbarBinding, ViewBodyGroupDetailBinding viewBodyGroupDetailBinding, ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding, ViewHeaderGroupDetailBinding viewHeaderGroupDetailBinding, ViewHistoryAddFavoriteBinding viewHistoryAddFavoriteBinding, View view, ViewStickyGroupDetailBinding viewStickyGroupDetailBinding) {
        this.getErrorConfigVersion = constraintLayout;
        this.MyBillsEntityDataFactory = emptyStateView;
        this.getAuthRequestContext = nestedScrollView;
        this.PlaceComponentResult = viewToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = viewBodyGroupDetailBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewDialogEditGroupNameBinding;
        this.moveToNextValue = viewHeaderGroupDetailBinding;
        this.scheduleImpl = viewHistoryAddFavoriteBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.lookAheadTest = viewStickyGroupDetailBinding;
    }

    public static ActivityGroupDetailBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.activity_group_detail, (ViewGroup) null, false);
        int i = R.id.errorStateView;
        EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (emptyStateView != null) {
            i = R.id.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (nestedScrollView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.FamilyManageAvailableServicesAdapter_res_0x7f0a135a))) != null) {
                ViewToolbarBinding authRequestContext = ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                i = R.id.viewBodyGroupDetail;
                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    ViewBodyGroupDetailBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewBodyGroupDetailBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory3);
                    i = R.id.res_0x7f0a1a83_falconfacade_falconimagecutproxy;
                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                        ViewDialogEditGroupNameBinding MyBillsEntityDataFactory = ViewDialogEditGroupNameBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4);
                        i = R.id.getBackgroundScanPeriod;
                        View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (BuiltInFictitiousFunctionClassFactory5 != null) {
                            ViewHeaderGroupDetailBinding KClassImpl$Data$declaredNonStaticMembers$22 = ViewHeaderGroupDetailBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory5);
                            i = R.id.viewHistoryAddFavorite;
                            View BuiltInFictitiousFunctionClassFactory6 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (BuiltInFictitiousFunctionClassFactory6 != null) {
                                ViewHistoryAddFavoriteBinding PlaceComponentResult = ViewHistoryAddFavoriteBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory6);
                                i = R.id.res_0x7f0a1add_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider;
                                View BuiltInFictitiousFunctionClassFactory7 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (BuiltInFictitiousFunctionClassFactory7 != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.viewStickyGroupDetail))) != null) {
                                    return new ActivityGroupDetailBinding((ConstraintLayout) inflate, emptyStateView, nestedScrollView, authRequestContext, KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory7, ViewStickyGroupDetailBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2));
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
        return this.getErrorConfigVersion;
    }
}
