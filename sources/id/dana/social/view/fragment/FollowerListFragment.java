package id.dana.social.view.fragment;

import android.content.Intent;
import android.view.View;
import id.dana.R;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.RestrictedContactActivity;
import id.dana.social.base.FriendshipListBaseFragment;
import id.dana.social.contract.FriendshipContract;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0017"}, d2 = {"Lid/dana/social/view/fragment/FollowerListFragment;", "Lid/dana/social/base/FriendshipListBaseFragment;", "", "p0", "Lid/dana/domain/social/ModifyRelationOperationType;", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "MyBillsEntityDataFactory", "()V", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "moveToNextValue", "()Landroid/view/View$OnClickListener;", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda2", "onResume", "(Ljava/lang/String;)V", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "<init>", "(Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FollowerListFragment extends FriendshipListBaseFragment {
    public Map<Integer, View> MyBillsEntityDataFactory;

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String scheduleImpl() {
        return "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowerListFragment(FriendshipListBaseFragment.ShowSnackbarInterface showSnackbarInterface) {
        super(showSnackbarInterface);
        Intrinsics.checkNotNullParameter(showSnackbarInterface, "");
        this.MyBillsEntityDataFactory = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        FriendshipContract.Presenter presenter = this.friendshipPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String getAuthRequestContext() {
        String string = getString(R.string.block_friendship);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String getErrorConfigVersion() {
        String string = getString(R.string.unblock_friendship);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String PlaceComponentResult() {
        String string = getString(R.string.friendship_block);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String string = getString(R.string.friendship_unblock);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final String lookAheadTest() {
        String string = getResources().getString(R.string.blocked_contacts_label);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final View.OnClickListener moveToNextValue() {
        return new View.OnClickListener() { // from class: id.dana.social.view.fragment.FollowerListFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowerListFragment.KClassImpl$Data$declaredNonStaticMembers$2(FollowerListFragment.this);
            }
        };
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FollowerListFragment followerListFragment) {
        Intrinsics.checkNotNullParameter(followerListFragment, "");
        Intent intent = new Intent(followerListFragment.getContext(), RestrictedContactActivity.class);
        intent.putExtra(RestrictedContactActivity.EXTRA_RELATIONSHIP_TYPE, RestrictedContactActivity.RELATIONSHIP_TYPE_FOLLOWER);
        followerListFragment.startActivity(intent);
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final void getAuthRequestContext(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FriendshipContract.Presenter presenter = this.friendshipPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.getAuthRequestContext(p0, p1);
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final void MyBillsEntityDataFactory() {
        FriendshipContract.Presenter presenter = this.friendshipPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FriendshipContract.Presenter presenter = this.friendshipPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.social.base.FriendshipListBaseFragment
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendshipAnalyticTracker = null;
        }
        friendshipAnalyticTracker.moveToNextValue(p0);
    }
}
