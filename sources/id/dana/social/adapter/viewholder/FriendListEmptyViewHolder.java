package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFriendListEmptyBinding;
import id.dana.feeds.ui.model.RelationshipItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/viewholder/FriendListEmptyViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/databinding/ViewholderFriendListEmptyBinding;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendListEmptyViewHolder extends ViewBindingRecyclerViewHolder<RelationshipItemModel, ViewholderFriendListEmptyBinding> {
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFriendListEmptyBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFriendListEmptyBinding MyBillsEntityDataFactory = ViewholderFriendListEmptyBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FriendListEmptyViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560280(0x7f0d0758, float:1.8745928E38)
            r2.<init>(r1, r0, r3)
            r2.getAuthRequestContext = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FriendListEmptyViewHolder.<init>(android.view.ViewGroup):void");
    }
}
