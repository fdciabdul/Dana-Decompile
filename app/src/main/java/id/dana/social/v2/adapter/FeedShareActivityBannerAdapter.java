package id.dana.social.v2.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012"}, d2 = {"Lid/dana/social/v2/adapter/FeedShareActivityBannerAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "p0", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedShareActivityBannerAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<Integer>, Integer> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public MyFeedHeaderModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<Integer, Unit> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<PreviewActivityData> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((FeedShareActivityBannerAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new FeedShareActivityBannerViewHolder(viewGroup, this.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedShareActivityBannerAdapter(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<Integer> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FeedViewHolderModel.Companion companion = FeedViewHolderModel.INSTANCE;
        List<FeedViewHolderModel> authRequestContext = FeedViewHolderModel.Companion.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        FeedShareActivityBannerViewHolder feedShareActivityBannerViewHolder = p0 instanceof FeedShareActivityBannerViewHolder ? (FeedShareActivityBannerViewHolder) p0 : null;
        if (feedShareActivityBannerViewHolder != null) {
            Intrinsics.checkNotNullParameter(authRequestContext, "");
            FeedActivityAdapter feedActivityAdapter = feedShareActivityBannerViewHolder.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(authRequestContext, "");
            feedActivityAdapter.setItems(authRequestContext);
        }
        super.onBindViewHolder((FeedShareActivityBannerAdapter) p0, p1);
    }
}
