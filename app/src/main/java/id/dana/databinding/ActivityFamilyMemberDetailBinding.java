package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.familyaccount.view.managefamily.ManageFamilyView;
import id.dana.familyaccount.view.section.SectionCellView;

/* loaded from: classes4.dex */
public final class ActivityFamilyMemberDetailBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final ManageFamilyView DatabaseTableConfigUtil;
    public final View GetContactSyncConfig;
    public final MaterialCardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final MaterialCardView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final Group PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final View lookAheadTest;
    public final SectionCellView moveToNextValue;
    public final SectionCellView scheduleImpl;

    private ActivityFamilyMemberDetailBinding(ConstraintLayout constraintLayout, Group group, LayoutToolbarBinding layoutToolbarBinding, MaterialCardView materialCardView, MaterialCardView materialCardView2, RecyclerView recyclerView, TextView textView, SectionCellView sectionCellView, SectionCellView sectionCellView2, TextView textView2, View view, View view2, ManageFamilyView manageFamilyView, View view3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.PlaceComponentResult = group;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialCardView;
        this.MyBillsEntityDataFactory = materialCardView2;
        this.getAuthRequestContext = recyclerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.scheduleImpl = sectionCellView;
        this.moveToNextValue = sectionCellView2;
        this.getErrorConfigVersion = textView2;
        this.lookAheadTest = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view2;
        this.DatabaseTableConfigUtil = manageFamilyView;
        this.GetContactSyncConfig = view3;
    }

    public static ActivityFamilyMemberDetailBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_member_detail, (ViewGroup) null, false);
        int i = R.id.groupManageFamilyAccount;
        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupManageFamilyAccount);
        if (group != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvManageAvailableServices);
                if (materialCardView != null) {
                    MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvProfileSection);
                    if (materialCardView2 != null) {
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvManageAvailableServices);
                        if (recyclerView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionDeleteMember);
                            if (textView != null) {
                                SectionCellView sectionCellView = (SectionCellView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionHistory);
                                if (sectionCellView != null) {
                                    SectionCellView sectionCellView2 = (SectionCellView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionTransactionLimit);
                                    if (sectionCellView2 != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvManageAvailableServicesTitle);
                                        if (textView2 != null) {
                                            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease);
                                            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vDividerBottomSectionHistory);
                                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                    ManageFamilyView manageFamilyView = (ManageFamilyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewManageFamily);
                                                    if (manageFamilyView != null) {
                                                        View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSkeleton);
                                                        if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                            return new ActivityFamilyMemberDetailBinding((ConstraintLayout) inflate, group, MyBillsEntityDataFactory, materialCardView, materialCardView2, recyclerView, textView, sectionCellView, sectionCellView2, textView2, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, manageFamilyView, BuiltInFictitiousFunctionClassFactory4);
                                                        }
                                                        i = R.id.viewSkeleton;
                                                    } else {
                                                        i = R.id.viewManageFamily;
                                                    }
                                                } else {
                                                    i = R.id.vDividerBottomSectionHistory;
                                                }
                                            } else {
                                                i = R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease;
                                            }
                                        } else {
                                            i = R.id.tvManageAvailableServicesTitle;
                                        }
                                    } else {
                                        i = R.id.sectionTransactionLimit;
                                    }
                                } else {
                                    i = R.id.sectionHistory;
                                }
                            } else {
                                i = R.id.sectionDeleteMember;
                            }
                        } else {
                            i = R.id.rvManageAvailableServices;
                        }
                    } else {
                        i = R.id.mcvProfileSection;
                    }
                } else {
                    i = R.id.mcvManageAvailableServices;
                }
            } else {
                i = R.id.layoutToolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
