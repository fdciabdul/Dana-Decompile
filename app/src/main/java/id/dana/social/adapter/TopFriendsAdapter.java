package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.friendsheader.TopFriendViewHolder;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR%\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0086\"¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/TopFriendsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopFriendsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FeedViewHolderModel>, FeedViewHolderModel> {
    public Function1<? super Boolean, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Function1<? super Boolean, Unit> function1 = this.BuiltInFictitiousFunctionClassFactory;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            function1 = null;
        }
        return new TopFriendViewHolder(viewGroup, function1, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
