package id.dana.social.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.v2.adapter.FriendHeaderAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bB+\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000e\u001a\u00020\b2\u0019\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/social/v2/view/FeedsTopFriendsView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "Lid/dana/feeds/ui/model/FriendModel;", "friendList", "", "setData", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "action", "setOnTopFriendClick", "(Lkotlin/jvm/functions/Function1;)V", "setup", "()V", "Lid/dana/social/v2/adapter/FriendHeaderAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/v2/adapter/FriendHeaderAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsTopFriendsView extends BaseRichView {
    private FriendHeaderAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedsTopFriendsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedsTopFriendsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_top_friends;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsTopFriendsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FeedsTopFriendsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsTopFriendsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvTopFriends);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            FriendHeaderAdapter friendHeaderAdapter = new FriendHeaderAdapter();
            this.BuiltInFictitiousFunctionClassFactory = friendHeaderAdapter;
            recyclerView.setAdapter(friendHeaderAdapter);
        }
    }

    public final void setData(List<FriendModel> friendList) {
        Intrinsics.checkNotNullParameter(friendList, "");
        FriendHeaderAdapter friendHeaderAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (friendHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendHeaderAdapter = null;
        }
        friendHeaderAdapter.setItems(friendList);
    }

    public final void setOnTopFriendClick(final Function1<? super FriendModel, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        FriendHeaderAdapter friendHeaderAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (friendHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendHeaderAdapter = null;
        }
        friendHeaderAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.v2.view.FeedsTopFriendsView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                FeedsTopFriendsView.$r8$lambda$FsZlxYtZvsi3lUhDddp7s5fqvU4(Function1.this, this, i);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$FsZlxYtZvsi3lUhDddp7s5fqvU4(Function1 function1, FeedsTopFriendsView feedsTopFriendsView, int i) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(feedsTopFriendsView, "");
        FriendHeaderAdapter friendHeaderAdapter = feedsTopFriendsView.BuiltInFictitiousFunctionClassFactory;
        if (friendHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendHeaderAdapter = null;
        }
        FriendModel item = friendHeaderAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        function1.invoke(item);
    }
}
