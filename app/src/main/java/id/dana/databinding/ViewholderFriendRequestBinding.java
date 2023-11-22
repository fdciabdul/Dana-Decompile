package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.social.view.FriendRequestView;

/* loaded from: classes4.dex */
public final class ViewholderFriendRequestBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final FriendRequestView PlaceComponentResult;

    private ViewholderFriendRequestBinding(ConstraintLayout constraintLayout, FriendRequestView friendRequestView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = friendRequestView;
    }

    public static ViewholderFriendRequestBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        FriendRequestView friendRequestView = (FriendRequestView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.friendRequestView);
        if (friendRequestView != null) {
            return new ViewholderFriendRequestBinding((ConstraintLayout) view, friendRequestView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.friendRequestView)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
