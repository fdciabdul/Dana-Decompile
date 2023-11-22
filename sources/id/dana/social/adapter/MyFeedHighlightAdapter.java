package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.social.adapter.viewholder.MyFeedHighlightViewHolder;
import id.dana.social.model.MyFeedHighlightModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/social/adapter/MyFeedHighlightAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/social/adapter/viewholder/MyFeedHighlightViewHolder;", "Lid/dana/social/model/MyFeedHighlightModel;", "", "p0", "getItemViewType", "(I)I", "", "BuiltInFictitiousFunctionClassFactory", "()Lkotlin/Unit;", "Lid/dana/social/adapter/MyFeedHighlightListener;", "getAuthRequestContext", "Lid/dana/social/adapter/MyFeedHighlightListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/social/adapter/MyFeedHighlightListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFeedHighlightAdapter extends BaseRecyclerViewAdapter<MyFeedHighlightViewHolder, MyFeedHighlightModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MyFeedHighlightListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return R.layout.item_my_feed_highlight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MyFeedHighlightViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public MyFeedHighlightAdapter(MyFeedHighlightListener myFeedHighlightListener) {
        Intrinsics.checkNotNullParameter(myFeedHighlightListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myFeedHighlightListener;
        BuiltInFictitiousFunctionClassFactory();
    }

    public final Unit BuiltInFictitiousFunctionClassFactory() {
        MyFeedHighlightModel myFeedHighlightModel;
        Function0<Unit> function0;
        List<MyFeedHighlightModel> items = getItems();
        if (items == null || (myFeedHighlightModel = (MyFeedHighlightModel) CollectionsKt.firstOrNull((List) items)) == null || (function0 = myFeedHighlightModel.BuiltInFictitiousFunctionClassFactory) == null) {
            return null;
        }
        function0.invoke();
        return Unit.INSTANCE;
    }
}
