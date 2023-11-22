package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.familyaccount.view.joininvitation.JoinInvitationView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountInvalidJoinInvitationBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final JoinInvitationView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final LayoutToolbarBinding getAuthRequestContext;

    private ActivityFamilyAccountInvalidJoinInvitationBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, LayoutToolbarBinding layoutToolbarBinding, JoinInvitationView joinInvitationView) {
        this.PlaceComponentResult = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.getAuthRequestContext = layoutToolbarBinding;
        this.MyBillsEntityDataFactory = joinInvitationView;
    }

    public static ActivityFamilyAccountInvalidJoinInvitationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_invalid_join_invitation, (ViewGroup) null, false);
        int i = R.id.btnGotItInvitation;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnGotItInvitation);
        if (danaButtonPrimaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                JoinInvitationView joinInvitationView = (JoinInvitationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewJoinInvitation);
                if (joinInvitationView != null) {
                    return new ActivityFamilyAccountInvalidJoinInvitationBinding((ConstraintLayout) inflate, danaButtonPrimaryView, MyBillsEntityDataFactory, joinInvitationView);
                }
                i = R.id.viewJoinInvitation;
            } else {
                i = R.id.layoutToolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
