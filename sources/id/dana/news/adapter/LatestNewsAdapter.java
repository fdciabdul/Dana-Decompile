package id.dana.news.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.views.FeedsWrapperViewHolder;
import id.dana.news.viewholders.NewsFullViewHolder;
import id.dana.news.viewholders.NewsLoadingViewHolder;
import id.dana.news.viewholders.NewsViewHolderNews;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00192\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\n8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015"}, d2 = {"Lid/dana/news/adapter/LatestNewsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/feeds/views/FeedsWrapperViewHolder;", "Lid/dana/feeds/model/ActivityModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "()Z", "PlaceComponentResult", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/news/adapter/LatestNewsAdapter$NewsActions;", "Lid/dana/news/adapter/LatestNewsAdapter$NewsActions;", "", "<init>", "(Ljava/util/List;)V", "Companion", "NewsActions"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LatestNewsAdapter extends BaseRecyclerViewAdapter<FeedsWrapperViewHolder, ActivityModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public NewsActions BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/news/adapter/LatestNewsAdapter$NewsActions;", "", "Lid/dana/feeds/model/ActivityModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/feeds/model/ActivityModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface NewsActions {
        void getAuthRequestContext(ActivityModel p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        NewsViewHolderNews newsViewHolderNews;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            NewsViewHolderNews newsViewHolderNews2 = new NewsViewHolderNews(viewGroup.getContext(), viewGroup);
            newsViewHolderNews2.MyBillsEntityDataFactory = new NewsViewHolderNews.FeedsViewHolderActions() { // from class: id.dana.news.adapter.LatestNewsAdapter$$ExternalSyntheticLambda0
                @Override // id.dana.news.viewholders.NewsViewHolderNews.FeedsViewHolderActions
                public final void MyBillsEntityDataFactory(ActivityModel activityModel) {
                    LatestNewsAdapter.BuiltInFictitiousFunctionClassFactory(LatestNewsAdapter.this, activityModel);
                }
            };
            newsViewHolderNews = newsViewHolderNews2;
        } else if (i == 3) {
            newsViewHolderNews = new NewsFullViewHolder(viewGroup.getContext(), viewGroup);
        } else {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            newsViewHolderNews = new NewsLoadingViewHolder(context, viewGroup);
        }
        return newsViewHolderNews;
    }

    public LatestNewsAdapter(List<? extends ActivityModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = "";
        setItems(list);
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getItems().size() == 0) {
            return 1;
        }
        return super.getItemCount() + (this.PlaceComponentResult ? 1 : 0);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(LatestNewsAdapter latestNewsAdapter, ActivityModel activityModel) {
        Intrinsics.checkNotNullParameter(latestNewsAdapter, "");
        NewsActions newsActions = latestNewsAdapter.BuiltInFictitiousFunctionClassFactory;
        if (newsActions != null) {
            Intrinsics.checkNotNullExpressionValue(activityModel, "");
            newsActions.getAuthRequestContext(activityModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        ActivityModel item = getItem(p0);
        String str = item != null ? item.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (str == null) {
            str = "NORMAL";
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        if (Intrinsics.areEqual("FULL", upperCase)) {
            return 3;
        }
        return (this.PlaceComponentResult && p0 == getItemCount() - 1) ? 2 : 1;
    }
}
