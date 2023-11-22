package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.viewholder.FeedsSimpleShimmerViewHolder;
import id.dana.social.adapter.viewholder.FriendItemViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u000fX\u0086\"¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010"}, d2 = {"Lid/dana/social/adapter/FindFriendAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "getItemViewType", "(I)I", "", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "p1", "(Ljava/lang/String;Lid/dana/feeds/ui/enums/FriendshipStatus;)V", "Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;", "Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;", "getAuthRequestContext", "<init>", "Companion", "FriendItemListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FindFriendAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FriendModel>, FriendModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public FriendItemListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;", "", "Lid/dana/feeds/ui/model/FriendModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/feeds/ui/model/FriendModel;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface FriendItemListener {
        void BuiltInFictitiousFunctionClassFactory(FriendModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0);

        void MyBillsEntityDataFactory(FriendModel p0);

        void PlaceComponentResult(FriendModel p0);

        void getAuthRequestContext(FriendModel p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedsSimpleShimmerViewHolder feedsSimpleShimmerViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i != 0) {
            feedsSimpleShimmerViewHolder = new FeedsSimpleShimmerViewHolder(viewGroup, R.layout.viewholder_friend_skeleton);
        } else {
            FriendItemListener friendItemListener = this.getAuthRequestContext;
            if (friendItemListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendItemListener = null;
            }
            feedsSimpleShimmerViewHolder = new FriendItemViewHolder(viewGroup, friendItemListener);
        }
        return feedsSimpleShimmerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).initRecordTimeStamp;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 0; i++) {
            FriendModel.Companion companion = FriendModel.INSTANCE;
            arrayList.add(FriendModel.Companion.getAuthRequestContext());
        }
        setItems(arrayList);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, FriendshipStatus p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        List items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((FriendModel) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda0, p0)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            FriendModel friendModel = (FriendModel) getItems().get(i);
            Intrinsics.checkNotNullParameter(p1, "");
            friendModel.scheduleImpl = p1;
            friendModel.getAuthRequestContext = true;
            notifyItemChanged(i, friendModel);
        }
    }
}
