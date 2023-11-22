package id.dana.savings.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.savings.model.TopUpModel;
import id.dana.savings.viewholder.SavingHistoryViewHolder;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.friendsheader.FetchingNewDataViewHolder;
import id.dana.social.adapter.friendsheader.LoadMoreViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/savings/adapter/HistoryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/savings/model/TopUpModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<TopUpModel>, TopUpModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    SocialFeedClickListener getAuthRequestContext = new BaseSocialFeedInteraction();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FetchingNewDataViewHolder fetchingNewDataViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            fetchingNewDataViewHolder = new FetchingNewDataViewHolder(viewGroup);
        } else if (i == 2) {
            fetchingNewDataViewHolder = new LoadMoreViewHolder(viewGroup, new Function0<Unit>() { // from class: id.dana.savings.adapter.HistoryAdapter$onCreateViewHolder$1
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
                    HistoryAdapter.this.getAuthRequestContext.PlaceComponentResult();
                }
            });
        } else {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            fetchingNewDataViewHolder = new SavingHistoryViewHolder(context, viewGroup);
        }
        return fetchingNewDataViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
