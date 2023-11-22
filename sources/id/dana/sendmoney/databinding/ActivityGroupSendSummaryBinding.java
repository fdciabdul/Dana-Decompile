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
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog;

/* loaded from: classes3.dex */
public final class ActivityGroupSendSummaryBinding implements ViewBinding {
    public final GroupSendEditNameDialog BuiltInFictitiousFunctionClassFactory;
    public final EmptyStateView KClassImpl$Data$declaredNonStaticMembers$2;
    public final NestedScrollView MyBillsEntityDataFactory;
    public final ViewGroupSendEditProfileBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ViewToolbarBinding PlaceComponentResult;
    public final ViewGroupSendMemberAmountBinding getAuthRequestContext;
    public final ViewStickyBottomSheetSummaryBinding getErrorConfigVersion;
    private final ConstraintLayout moveToNextValue;
    public final View scheduleImpl;

    private ActivityGroupSendSummaryBinding(ConstraintLayout constraintLayout, EmptyStateView emptyStateView, NestedScrollView nestedScrollView, ViewToolbarBinding viewToolbarBinding, ViewGroupSendMemberAmountBinding viewGroupSendMemberAmountBinding, GroupSendEditNameDialog groupSendEditNameDialog, ViewGroupSendEditProfileBinding viewGroupSendEditProfileBinding, View view, ViewStickyBottomSheetSummaryBinding viewStickyBottomSheetSummaryBinding) {
        this.moveToNextValue = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emptyStateView;
        this.MyBillsEntityDataFactory = nestedScrollView;
        this.PlaceComponentResult = viewToolbarBinding;
        this.getAuthRequestContext = viewGroupSendMemberAmountBinding;
        this.BuiltInFictitiousFunctionClassFactory = groupSendEditNameDialog;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewGroupSendEditProfileBinding;
        this.scheduleImpl = view;
        this.getErrorConfigVersion = viewStickyBottomSheetSummaryBinding;
    }

    public static ActivityGroupSendSummaryBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View BuiltInFictitiousFunctionClassFactory3;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d006c_networkuserentitydata_externalsyntheticlambda0, (ViewGroup) null, false);
        int i = R.id.emptyStateView;
        EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (emptyStateView != null) {
            i = R.id.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (nestedScrollView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.CreateOrderTopUpFamilyBalance_res_0x7f0a1361))) != null) {
                ViewToolbarBinding authRequestContext = ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                i = R.id.res_0x7f0a1a68_flowlivedataconversions_aslivedata_1;
                View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (BuiltInFictitiousFunctionClassFactory4 != null) {
                    ViewGroupSendMemberAmountBinding MyBillsEntityDataFactory = ViewGroupSendMemberAmountBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4);
                    i = R.id.res_0x7f0a1a83_falconfacade_falconimagecutproxy;
                    GroupSendEditNameDialog groupSendEditNameDialog = (GroupSendEditNameDialog) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (groupSendEditNameDialog != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.setLastTelemetrySync))) != null) {
                        ViewGroupSendEditProfileBinding authRequestContext2 = ViewGroupSendEditProfileBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                        i = R.id.res_0x7f0a1add_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider;
                        View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (BuiltInFictitiousFunctionClassFactory5 != null && (BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.RoundedCornerTreatment_res_0x7f0a1ae4))) != null) {
                            return new ActivityGroupSendSummaryBinding((ConstraintLayout) inflate, emptyStateView, nestedScrollView, authRequestContext, MyBillsEntityDataFactory, groupSendEditNameDialog, authRequestContext2, BuiltInFictitiousFunctionClassFactory5, ViewStickyBottomSheetSummaryBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3));
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
