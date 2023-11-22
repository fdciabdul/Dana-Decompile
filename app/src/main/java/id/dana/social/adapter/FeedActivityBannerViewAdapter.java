package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.viewholder.FeedActivityBannerLoadingViewHolder;
import id.dana.social.adapter.viewholder.FeedActivityBannerViewHolder;
import id.dana.social.model.FeedViewHolderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0010\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016"}, d2 = {"Lid/dana/social/adapter/FeedActivityBannerViewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "", "Lid/dana/social/model/FeedViewHolderModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "p2", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lid/dana/social/adapter/SocialFeedClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedActivityBannerViewAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<Integer>, Integer> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SocialFeedClickListener getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<FeedViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Function1<Integer, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<Integer, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((FeedActivityBannerViewAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedActivityBannerLoadingViewHolder feedActivityBannerLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            feedActivityBannerLoadingViewHolder = new FeedActivityBannerLoadingViewHolder(viewGroup);
        } else if (i == 1) {
            feedActivityBannerLoadingViewHolder = new FeedActivityBannerViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.social.adapter.FeedActivityBannerViewAdapter$skipActivityBanner$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    Function1 function1;
                    function1 = FeedActivityBannerViewAdapter.this.PlaceComponentResult;
                    function1.invoke(Integer.valueOf(i2));
                    FeedActivityBannerViewAdapter.MyBillsEntityDataFactory(FeedActivityBannerViewAdapter.this, i2);
                }
            }, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
        } else {
            feedActivityBannerLoadingViewHolder = new FeedActivityBannerLoadingViewHolder(viewGroup);
        }
        return feedActivityBannerLoadingViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedActivityBannerViewAdapter(Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12, SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.PlaceComponentResult = function1;
        this.BuiltInFictitiousFunctionClassFactory = function12;
        this.getAuthRequestContext = socialFeedClickListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        Integer num = getItems().get(p0);
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num.intValue();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<Integer> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FeedActivityBannerViewHolder feedActivityBannerViewHolder = p0 instanceof FeedActivityBannerViewHolder ? (FeedActivityBannerViewHolder) p0 : null;
        if (feedActivityBannerViewHolder != null) {
            List<FeedViewHolderModel> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(list, "");
            ActivityBannerAdapter activityBannerAdapter = feedActivityBannerViewHolder.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(list, "");
            activityBannerAdapter.setItems(list);
            feedActivityBannerViewHolder.getAuthRequestContext();
        }
        super.onBindViewHolder((FeedActivityBannerViewAdapter) p0, p1);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FeedActivityBannerViewAdapter feedActivityBannerViewAdapter, int i) {
        if (i == feedActivityBannerViewAdapter.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1) {
            feedActivityBannerViewAdapter.setItems(CollectionsKt.emptyList());
        }
    }
}
