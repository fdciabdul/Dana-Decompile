package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.familyaccount.view.managefamily.ManageFamilyView;

/* loaded from: classes4.dex */
public final class ActivityFamilyOrganizerDetailBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final MaterialCardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final Group getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ManageFamilyView lookAheadTest;
    public final TextView moveToNextValue;
    public final View scheduleImpl;

    private ActivityFamilyOrganizerDetailBinding(ConstraintLayout constraintLayout, Group group, LayoutToolbarBinding layoutToolbarBinding, MaterialCardView materialCardView, TextView textView, TextView textView2, TextView textView3, View view, ManageFamilyView manageFamilyView, View view2) {
        this.getErrorConfigVersion = constraintLayout;
        this.getAuthRequestContext = group;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialCardView;
        this.MyBillsEntityDataFactory = textView;
        this.PlaceComponentResult = textView2;
        this.moveToNextValue = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.lookAheadTest = manageFamilyView;
        this.scheduleImpl = view2;
    }

    public static ActivityFamilyOrganizerDetailBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_organizer_detail, (ViewGroup) null, false);
        int i = R.id.groupManageFamilyAccount;
        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupManageFamilyAccount);
        if (group != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvProfileSection);
                if (materialCardView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDeleteFamilyAccount);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvFamilyName);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvFamilyNameLabel);
                            if (textView3 != null) {
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    ManageFamilyView manageFamilyView = (ManageFamilyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewManageFamily);
                                    if (manageFamilyView != null) {
                                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSkeleton);
                                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                            return new ActivityFamilyOrganizerDetailBinding((ConstraintLayout) inflate, group, MyBillsEntityDataFactory, materialCardView, textView, textView2, textView3, BuiltInFictitiousFunctionClassFactory2, manageFamilyView, BuiltInFictitiousFunctionClassFactory3);
                                        }
                                        i = R.id.viewSkeleton;
                                    } else {
                                        i = R.id.viewManageFamily;
                                    }
                                } else {
                                    i = R.id.f4551res_0x7f0a19ae_tomillis_feature_cashier_productionrelease;
                                }
                            } else {
                                i = R.id.tvFamilyNameLabel;
                            }
                        } else {
                            i = R.id.tvFamilyName;
                        }
                    } else {
                        i = R.id.tvDeleteFamilyAccount;
                    }
                } else {
                    i = R.id.mcvProfileSection;
                }
            } else {
                i = R.id.layoutToolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
