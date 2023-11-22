package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.adapter.viewholder.FeedsSectionSpaceViewHolder;
import id.dana.social.adapter.viewholder.FeedsSectionTitleViewHolder;
import id.dana.social.adapter.viewholder.FeedsSimpleShimmerViewHolder;
import id.dana.social.adapter.viewholder.FeedsViewAllSectionViewHolder;
import id.dana.social.adapter.viewholder.FriendRequestViewHolder;
import id.dana.social.adapter.viewholder.FriendSectionDividerViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00030\u00030\u0012J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u000eJ\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lid/dana/social/adapter/FriendRequestAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "friendRequestSectionFontType", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", "(Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;)V", "createShimmer", "", "shimmerItemCount", "", "withSectionTitle", "", "withSpace", "createShimmerWithViewAll", "getAllFriendRequestItem", "", "kotlin.jvm.PlatformType", "getItemViewType", "position", "isShowingShimmer", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeFriendRequestItemWithSectionChecking", "userIdToRemove", "", "updateFriendRequestState", "userId", "status", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "FriendRequestListener", "FriendRequestSectionFontType", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendRequestAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FriendModel>, FriendModel> {
    private FriendRequestListener KClassImpl$Data$declaredNonStaticMembers$2;
    private FriendRequestSectionFontType PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", "", "Lid/dana/feeds/ui/model/FriendModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/ui/model/FriendModel;)V", "getAuthRequestContext", "PlaceComponentResult", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface FriendRequestListener {
        void BuiltInFictitiousFunctionClassFactory(FriendModel p0);

        void PlaceComponentResult();

        void getAuthRequestContext(FriendModel p0);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "BOLD_GREY"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum FriendRequestSectionFontType {
        DEFAULT,
        BOLD_GREY
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FriendRequestViewHolder friendRequestViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            friendRequestViewHolder = new FriendRequestViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (i == 2) {
            friendRequestViewHolder = new FeedsViewAllSectionViewHolder(viewGroup, new Function0<Unit>() { // from class: id.dana.social.adapter.FriendRequestAdapter$onCreateViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FriendRequestAdapter.FriendRequestListener friendRequestListener;
                    friendRequestListener = FriendRequestAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    friendRequestListener.PlaceComponentResult();
                }
            });
        } else if (i == 3) {
            String string = viewGroup.getContext().getString(R.string.friend_request_section_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            friendRequestViewHolder = new FeedsSectionTitleViewHolder(viewGroup, string, this.PlaceComponentResult);
        } else if (i == 4) {
            friendRequestViewHolder = new FriendSectionDividerViewHolder(viewGroup);
        } else if (i == 5) {
            friendRequestViewHolder = new FeedsSectionSpaceViewHolder(viewGroup);
        } else if (i == 6) {
            friendRequestViewHolder = new FeedsSimpleShimmerViewHolder(viewGroup, R.layout.viewholder_friendlist_view_all_skeleton);
        } else {
            friendRequestViewHolder = new FeedsSimpleShimmerViewHolder(viewGroup, R.layout.viewholder_friend_request_skeleton);
        }
        return friendRequestViewHolder;
    }

    public /* synthetic */ FriendRequestAdapter(FriendRequestSectionFontType friendRequestSectionFontType, FriendRequestListener friendRequestListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FriendRequestSectionFontType.DEFAULT : friendRequestSectionFontType, friendRequestListener);
    }

    public FriendRequestAdapter(FriendRequestSectionFontType friendRequestSectionFontType, FriendRequestListener friendRequestListener) {
        Intrinsics.checkNotNullParameter(friendRequestSectionFontType, "");
        Intrinsics.checkNotNullParameter(friendRequestListener, "");
        this.PlaceComponentResult = friendRequestSectionFontType;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = friendRequestListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItems().get(position).initRecordTimeStamp;
    }

    public final void MyBillsEntityDataFactory(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new FriendModel(null, null, null, false, null, null, null, 1, false, 0L, false, 1919, null));
        }
        if (z) {
            FriendModel.Companion companion = FriendModel.INSTANCE;
            arrayList.add(FriendModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        setItems(arrayList);
    }

    public final void getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            arrayList.add(new FriendModel(null, null, null, false, null, null, null, 1, false, 0L, false, 1919, null));
        }
        FriendModel.Companion companion = FriendModel.INSTANCE;
        arrayList.add(FriendModel.Companion.NetworkUserEntityData$$ExternalSyntheticLambda0());
        setItems(arrayList);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (getItems().size() == 2) {
            List<FriendModel> items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            if (((FriendModel) CollectionsKt.first((List) items)).initRecordTimeStamp == 3) {
                List<FriendModel> items2 = getItems();
                Intrinsics.checkNotNullExpressionValue(items2, "");
                if (Intrinsics.areEqual(((FriendModel) CollectionsKt.last((List) items2)).NetworkUserEntityData$$ExternalSyntheticLambda0, str)) {
                    setItems(new ArrayList());
                    return;
                }
            }
        }
        List<FriendModel> items3 = getItems();
        Intrinsics.checkNotNullExpressionValue(items3, "");
        int i = 0;
        Iterator<FriendModel> it = items3.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().NetworkUserEntityData$$ExternalSyntheticLambda0, str)) {
                break;
            } else {
                i++;
            }
        }
        removeItem(i);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Object obj;
        List<FriendModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FriendModel) obj).initRecordTimeStamp == 1) {
                break;
            }
        }
        return obj != null;
    }

    public final void getAuthRequestContext(String str, FriendshipStatus friendshipStatus) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(friendshipStatus, "");
        List items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((FriendModel) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda0, str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            FriendModel friendModel = (FriendModel) getItems().get(i);
            Intrinsics.checkNotNullParameter(friendshipStatus, "");
            friendModel.scheduleImpl = friendshipStatus;
            notifyItemChanged(i, friendModel);
        }
    }
}
