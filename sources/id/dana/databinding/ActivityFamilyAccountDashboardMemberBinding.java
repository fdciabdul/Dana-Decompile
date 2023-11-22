package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.familyaccount.view.managefamily.ManageFamilyView;
import id.dana.familyaccount.view.section.SectionCellView;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountDashboardMemberBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final StatusInformationView DatabaseTableConfigUtil;
    public final View GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final SectionCellView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final MaterialCardView getAuthRequestContext;
    public final RecyclerView getErrorConfigVersion;
    public final ManageFamilyView initRecordTimeStamp;
    public final ViewMemberDashboardSectionListOfBinding lookAheadTest;
    public final MaterialCardView moveToNextValue;
    private final ConstraintLayout newProxyInstance;
    public final MaterialCardView scheduleImpl;

    private ActivityFamilyAccountDashboardMemberBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, LayoutToolbarBinding layoutToolbarBinding, MaterialCardView materialCardView, MaterialCardView materialCardView2, MaterialCardView materialCardView3, RecyclerView recyclerView, ViewMemberDashboardSectionListOfBinding viewMemberDashboardSectionListOfBinding, SectionCellView sectionCellView, TextView textView, TextView textView2, View view, StatusInformationView statusInformationView, ManageFamilyView manageFamilyView) {
        this.newProxyInstance = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.MyBillsEntityDataFactory = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.getAuthRequestContext = materialCardView;
        this.scheduleImpl = materialCardView2;
        this.moveToNextValue = materialCardView3;
        this.getErrorConfigVersion = recyclerView;
        this.lookAheadTest = viewMemberDashboardSectionListOfBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sectionCellView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView2;
        this.GetContactSyncConfig = view;
        this.DatabaseTableConfigUtil = statusInformationView;
        this.initRecordTimeStamp = manageFamilyView;
    }

    public static ActivityFamilyAccountDashboardMemberBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_dashboard_member, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clIterateDisclaimer);
        int i = R.id.clMemberDashboard;
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clMemberDashboard);
            if (constraintLayout2 != null) {
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivIterateDisclaimerInfoIcon);
                if (imageView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvCapabilitySection);
                        if (materialCardView != null) {
                            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvIterateDisclaimer);
                            if (materialCardView2 != null) {
                                MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvProfileSection);
                                if (materialCardView3 != null) {
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvAvailableService);
                                    if (recyclerView != null) {
                                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionListOfFamily);
                                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                            ViewMemberDashboardSectionListOfBinding authRequestContext = ViewMemberDashboardSectionListOfBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                                            SectionCellView sectionCellView = (SectionCellView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionMonthlyLimit);
                                            if (sectionCellView != null) {
                                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvManageAvailableServicesTitle);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvServicesInfo);
                                                    if (textView2 != null) {
                                                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease);
                                                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                            StatusInformationView statusInformationView = (StatusInformationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewFamilyStatusInformation);
                                                            if (statusInformationView != null) {
                                                                ManageFamilyView manageFamilyView = (ManageFamilyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewMemberDashboard);
                                                                if (manageFamilyView != null) {
                                                                    return new ActivityFamilyAccountDashboardMemberBinding((ConstraintLayout) inflate, constraintLayout, constraintLayout2, imageView, MyBillsEntityDataFactory, materialCardView, materialCardView2, materialCardView3, recyclerView, authRequestContext, sectionCellView, textView, textView2, BuiltInFictitiousFunctionClassFactory3, statusInformationView, manageFamilyView);
                                                                }
                                                                i = R.id.viewMemberDashboard;
                                                            } else {
                                                                i = R.id.viewFamilyStatusInformation;
                                                            }
                                                        } else {
                                                            i = R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease;
                                                        }
                                                    } else {
                                                        i = R.id.tvServicesInfo;
                                                    }
                                                } else {
                                                    i = R.id.tvManageAvailableServicesTitle;
                                                }
                                            } else {
                                                i = R.id.sectionMonthlyLimit;
                                            }
                                        } else {
                                            i = R.id.sectionListOfFamily;
                                        }
                                    } else {
                                        i = R.id.rvAvailableService;
                                    }
                                } else {
                                    i = R.id.mcvProfileSection;
                                }
                            } else {
                                i = R.id.mcvIterateDisclaimer;
                            }
                        } else {
                            i = R.id.mcvCapabilitySection;
                        }
                    } else {
                        i = R.id.layoutToolbar;
                    }
                } else {
                    i = R.id.ivIterateDisclaimerInfoIcon;
                }
            }
        } else {
            i = R.id.clIterateDisclaimer;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.newProxyInstance;
    }
}
