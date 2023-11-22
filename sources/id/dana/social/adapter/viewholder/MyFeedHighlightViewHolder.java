package id.dana.social.adapter.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.MyFeedHighlightListener;
import id.dana.social.model.MyFeedHighlightModel;
import id.dana.social.view.FeedHighlightView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/adapter/viewholder/MyFeedHighlightViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/MyFeedHighlightModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/model/MyFeedHighlightModel;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "Lid/dana/social/adapter/MyFeedHighlightListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/MyFeedHighlightListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFeedHighlightViewHolder extends BaseRecyclerViewHolder<MyFeedHighlightModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MyFeedHighlightModel BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MyFeedHighlightModel myFeedHighlightModel) {
        MyFeedHighlightModel myFeedHighlightModel2 = myFeedHighlightModel;
        if (myFeedHighlightModel2 == null || Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, myFeedHighlightModel2)) {
            return;
        }
        FeedHighlightView feedHighlightView = (FeedHighlightView) this.itemView.findViewById(R.id.res_0x7f0a0883_callcsordianafragment_initlifecyclefragment_1_1_1);
        if (feedHighlightView != null) {
            feedHighlightView.render(myFeedHighlightModel2);
        }
        this.BuiltInFictitiousFunctionClassFactory = myFeedHighlightModel2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFeedHighlightViewHolder(ViewGroup viewGroup, MyFeedHighlightListener myFeedHighlightListener) {
        super(viewGroup.getContext(), R.layout.item_my_feed_highlight, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(myFeedHighlightListener, "");
        FeedHighlightView feedHighlightView = (FeedHighlightView) this.itemView.findViewById(R.id.res_0x7f0a0883_callcsordianafragment_initlifecyclefragment_1_1_1);
        if (feedHighlightView != null) {
            feedHighlightView.setListener(myFeedHighlightListener);
            feedHighlightView.setupAdapter();
        }
    }
}
