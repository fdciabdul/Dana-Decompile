package id.dana.animation.news.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.animation.news.viewholder.NewsWidgetViewHolder;
import id.dana.base.BaseAsyncRecyclerViewAdapter;
import id.dana.base.BaseAsyncRecyclerViewHolder;
import id.dana.base.BaseAsyncView;
import id.dana.domain.feeds.model.ActivityData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/home/news/adapter/NewsWidgetAdapter;", "Lid/dana/base/BaseAsyncRecyclerViewAdapter;", "Lid/dana/base/BaseAsyncRecyclerViewHolder;", "Lid/dana/domain/feeds/model/ActivityData;", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "NewsCellView"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsWidgetAdapter extends BaseAsyncRecyclerViewAdapter<BaseAsyncRecyclerViewHolder<ActivityData>, ActivityData> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new NewsWidgetViewHolder(new NewsCellView(this, context));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsWidgetAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        Intrinsics.checkNotNullParameter(recyclerView, "");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/news/adapter/NewsWidgetAdapter$NewsCellView;", "Lid/dana/base/BaseAsyncView;", "", "getLayoutId", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/home/news/adapter/NewsWidgetAdapter;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class NewsCellView extends BaseAsyncView {
        public Map<Integer, View> _$_findViewCache;
        final /* synthetic */ NewsWidgetAdapter this$0;

        @Override // id.dana.base.BaseAsyncView
        public final void _$_clearFindViewByIdCache() {
            this._$_findViewCache.clear();
        }

        @Override // id.dana.base.BaseAsyncView
        public final View _$_findCachedViewById(int i) {
            Map<Integer, View> map = this._$_findViewCache;
            View view = map.get(Integer.valueOf(i));
            if (view == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view;
        }

        @Override // id.dana.base.BaseAsyncView
        public final int getLayoutId() {
            return R.layout.widget_news_viewholder_relative;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewsCellView(NewsWidgetAdapter newsWidgetAdapter, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "");
            this.this$0 = newsWidgetAdapter;
            this._$_findViewCache = new LinkedHashMap();
        }
    }
}
