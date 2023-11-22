package id.dana.social.adapter.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFriendRequestBinding;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.view.FriendRequestView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/viewholder/FriendRequestViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "Lid/dana/databinding/ViewholderFriendRequestBinding;", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", "getAuthRequestContext", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendRequestViewHolder extends ViewBindingRecyclerViewHolder<FriendModel, ViewholderFriendRequestBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FriendRequestAdapter.FriendRequestListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        FriendModel friendModel = (FriendModel) obj;
        if (friendModel != null) {
            FriendRequestView friendRequestView = getBinding().PlaceComponentResult;
            friendRequestView.setListener(this.MyBillsEntityDataFactory);
            friendRequestView.setData(friendModel);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFriendRequestBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFriendRequestBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewholderFriendRequestBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FriendRequestViewHolder(android.view.ViewGroup r3, id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560281(0x7f0d0759, float:1.874593E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FriendRequestViewHolder.<init>(android.view.ViewGroup, id.dana.social.adapter.FriendRequestAdapter$FriendRequestListener):void");
    }
}
