package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.viewholder.FeedHighlightLoadingViewHolder;
import id.dana.social.adapter.viewholder.FeedHighlightViewHolder;
import id.dana.social.model.FeedHighlightModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/FeedHighlightAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedHighlightModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHighlightAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FeedHighlightModel>, FeedHighlightModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<FeedHighlightModel, Unit> MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedHighlightLoadingViewHolder feedHighlightLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 2) {
            feedHighlightLoadingViewHolder = new FeedHighlightViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.social.adapter.FeedHighlightAdapter$onCreateViewHolder$1
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
                    FeedHighlightModel feedHighlightModel = FeedHighlightAdapter.this.getItems().get(i2);
                    if (feedHighlightModel != null) {
                        function1 = FeedHighlightAdapter.this.MyBillsEntityDataFactory;
                        function1.invoke(feedHighlightModel);
                    }
                }
            });
        } else {
            feedHighlightLoadingViewHolder = new FeedHighlightLoadingViewHolder(viewGroup);
        }
        return feedHighlightLoadingViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedHighlightAdapter(Function1<? super FeedHighlightModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        FeedHighlightModel feedHighlightModel = getItems().get(p0);
        if (feedHighlightModel != null) {
            return feedHighlightModel.lookAheadTest;
        }
        return 1;
    }
}
