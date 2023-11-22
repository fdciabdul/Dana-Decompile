package id.dana.social;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class RelationshipBottomSheetDialog_ViewBinding implements Unbinder {
    private RelationshipBottomSheetDialog MyBillsEntityDataFactory;

    public RelationshipBottomSheetDialog_ViewBinding(RelationshipBottomSheetDialog relationshipBottomSheetDialog, View view) {
        this.MyBillsEntityDataFactory = relationshipBottomSheetDialog;
        relationshipBottomSheetDialog.cvFriendship = (FrameLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cv_friendship, "field 'cvFriendship'", FrameLayout.class);
        relationshipBottomSheetDialog.clFriendship = (CoordinatorLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_friendship_bottom_sheet_coordinator, "field 'clFriendship'", CoordinatorLayout.class);
        relationshipBottomSheetDialog.vpFriendship = (ViewPager) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.vp_friendship, "field 'vpFriendship'", ViewPager.class);
        relationshipBottomSheetDialog.rbFollower = (RadioButton) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rb_follower, "field 'rbFollower'", RadioButton.class);
        relationshipBottomSheetDialog.rbFollowing = (RadioButton) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rb_following, "field 'rbFollowing'", RadioButton.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        RelationshipBottomSheetDialog relationshipBottomSheetDialog = this.MyBillsEntityDataFactory;
        if (relationshipBottomSheetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        relationshipBottomSheetDialog.cvFriendship = null;
        relationshipBottomSheetDialog.clFriendship = null;
        relationshipBottomSheetDialog.vpFriendship = null;
        relationshipBottomSheetDialog.rbFollower = null;
        relationshipBottomSheetDialog.rbFollowing = null;
    }
}
