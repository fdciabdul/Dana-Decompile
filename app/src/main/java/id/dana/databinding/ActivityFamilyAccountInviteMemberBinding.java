package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.familyaccount.view.invite.FamilyMembersPickerView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountInviteMemberBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final FamilyMembersPickerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final FamilyQuestionerViewBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final View lookAheadTest;
    public final LayoutToolbarBinding moveToNextValue;
    public final TextView scheduleImpl;

    private ActivityFamilyAccountInviteMemberBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, FamilyMembersPickerView familyMembersPickerView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LayoutToolbarBinding layoutToolbarBinding, View view, FamilyQuestionerViewBinding familyQuestionerViewBinding, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = familyMembersPickerView;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.moveToNextValue = layoutToolbarBinding;
        this.lookAheadTest = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = familyQuestionerViewBinding;
        this.scheduleImpl = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static ActivityFamilyAccountInviteMemberBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_invite_member, (ViewGroup) null, false);
        int i = R.id.btnInvitation;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnInvitation);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clSearchMember);
            if (constraintLayout != null) {
                FamilyMembersPickerView familyMembersPickerView = (FamilyMembersPickerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.contactPickerSheet);
                if (familyMembersPickerView != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.icContact);
                    if (appCompatImageView != null) {
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivSearch);
                        if (appCompatImageView2 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.memberPickerDimView);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.questionerSection);
                                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                        FamilyQuestionerViewBinding PlaceComponentResult = FamilyQuestionerViewBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHeaderPage);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSearch);
                                            if (textView2 != null) {
                                                return new ActivityFamilyAccountInviteMemberBinding((ConstraintLayout) inflate, danaButtonPrimaryView, constraintLayout, familyMembersPickerView, appCompatImageView, appCompatImageView2, MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory2, PlaceComponentResult, textView, textView2);
                                            }
                                            i = R.id.tvSearch;
                                        } else {
                                            i = R.id.tvHeaderPage;
                                        }
                                    } else {
                                        i = R.id.questionerSection;
                                    }
                                } else {
                                    i = R.id.memberPickerDimView;
                                }
                            } else {
                                i = R.id.layoutToolbar;
                            }
                        } else {
                            i = R.id.ivSearch;
                        }
                    } else {
                        i = R.id.icContact;
                    }
                } else {
                    i = R.id.contactPickerSheet;
                }
            } else {
                i = R.id.clSearchMember;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
