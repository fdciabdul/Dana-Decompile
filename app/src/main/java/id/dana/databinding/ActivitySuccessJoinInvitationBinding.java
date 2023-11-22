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
public final class ActivitySuccessJoinInvitationBinding implements ViewBinding {
    public final JoinInvitationView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutToolbarBinding MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;

    private ActivitySuccessJoinInvitationBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, LayoutToolbarBinding layoutToolbarBinding, JoinInvitationView joinInvitationView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = joinInvitationView;
    }

    public static ActivitySuccessJoinInvitationBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_success_join_invitation, (ViewGroup) null, false);
        int i = R.id.btnAwesome;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnAwesome);
        if (danaButtonPrimaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                JoinInvitationView joinInvitationView = (JoinInvitationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewJoinInvitation);
                if (joinInvitationView != null) {
                    return new ActivitySuccessJoinInvitationBinding((ConstraintLayout) inflate, danaButtonPrimaryView, MyBillsEntityDataFactory, joinInvitationView);
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
