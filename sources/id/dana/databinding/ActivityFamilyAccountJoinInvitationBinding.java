package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.familyaccount.view.joininvitation.JoinInvitationView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountJoinInvitationBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final DanaButtonSecondaryView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final JoinInvitationView moveToNextValue;

    private ActivityFamilyAccountJoinInvitationBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, LayoutToolbarBinding layoutToolbarBinding, LinearLayout linearLayout, TextView textView, JoinInvitationView joinInvitationView) {
        this.getErrorConfigVersion = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.PlaceComponentResult = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
        this.MyBillsEntityDataFactory = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.moveToNextValue = joinInvitationView;
    }

    public static ActivityFamilyAccountJoinInvitationBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_join_invitation, (ViewGroup) null, false);
        int i = R.id.btnAcceptInvitation;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnAcceptInvitation);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnRejectInvitation);
            if (danaButtonSecondaryView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llBtnContainer);
                    if (linearLayout != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCreateFamilyAccount);
                        if (textView != null) {
                            JoinInvitationView joinInvitationView = (JoinInvitationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewJoinInvitation);
                            if (joinInvitationView != null) {
                                return new ActivityFamilyAccountJoinInvitationBinding((ConstraintLayout) inflate, danaButtonPrimaryView, danaButtonSecondaryView, MyBillsEntityDataFactory, linearLayout, textView, joinInvitationView);
                            }
                            i = R.id.viewJoinInvitation;
                        } else {
                            i = R.id.tvCreateFamilyAccount;
                        }
                    } else {
                        i = R.id.llBtnContainer;
                    }
                } else {
                    i = R.id.layoutToolbar;
                }
            } else {
                i = R.id.btnRejectInvitation;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
