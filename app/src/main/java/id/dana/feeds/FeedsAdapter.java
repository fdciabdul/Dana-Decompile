package id.dana.feeds;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.views.FeedsEmptyViewHolderFeeds;
import id.dana.feeds.views.FeedsFooterViewHolderFeeds;
import id.dana.feeds.views.FeedsViewHolderFeeds;
import id.dana.feeds.views.FeedsWrapperViewHolder;
import java.util.List;

/* loaded from: classes8.dex */
public class FeedsAdapter extends BaseRecyclerViewAdapter<FeedsWrapperViewHolder, ActivityModel> {
    public FeedsActions KClassImpl$Data$declaredNonStaticMembers$2;
    public FeedsViewHolderFeeds MyBillsEntityDataFactory;
    public int PlaceComponentResult = 8;
    public boolean getAuthRequestContext;

    /* loaded from: classes8.dex */
    public interface FeedsActions {
        void PlaceComponentResult(int i);

        void PlaceComponentResult(Context context, int i);

        void PlaceComponentResult(String str);

        void getAuthRequestContext();
    }

    public FeedsAdapter(List<ActivityModel> list) {
        setItems(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (getItems().size() == 0) {
            return 0;
        }
        return (this.getAuthRequestContext && i == getPlaceComponentResult() - 1) ? 2 : 1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        if (getItems().size() == 0) {
            return 1;
        }
        return super.getPlaceComponentResult() + (this.getAuthRequestContext ? 1 : 0);
    }

    public final boolean MyBillsEntityDataFactory(String str, int i) {
        return !TextUtils.isEmpty(str) && str.equals(getItems().get(i).PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new FeedsEmptyViewHolderFeeds(viewGroup.getContext(), viewGroup);
        }
        if (i == 1) {
            FeedsViewHolderFeeds feedsViewHolderFeeds = new FeedsViewHolderFeeds(viewGroup.getContext(), viewGroup);
            this.MyBillsEntityDataFactory = feedsViewHolderFeeds;
            feedsViewHolderFeeds.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
            this.MyBillsEntityDataFactory.getAuthRequestContext = new FeedsViewHolderFeeds.FeedsViewHolderActions() { // from class: id.dana.feeds.FeedsAdapter.1
                {
                    FeedsAdapter.this = this;
                }

                @Override // id.dana.feeds.views.FeedsViewHolderFeeds.FeedsViewHolderActions
                public final void KClassImpl$Data$declaredNonStaticMembers$2(int i2, boolean z) {
                    ActivityModel activityModel = FeedsAdapter.this.getItems().get(i2);
                    activityModel.moveToNextValue = !z ? 2 : 1;
                    FeedsAdapter.this.getItems().set(i2, activityModel);
                    FeedsAdapter.this.notifyItemChanged(i2);
                }

                @Override // id.dana.feeds.views.FeedsViewHolderFeeds.FeedsViewHolderActions
                public final void MyBillsEntityDataFactory(int i2) {
                    if (FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i2);
                    }
                }

                @Override // id.dana.feeds.views.FeedsViewHolderFeeds.FeedsViewHolderActions
                public final void PlaceComponentResult(Context context, int i2) {
                    if (FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(context, i2);
                    }
                }

                @Override // id.dana.feeds.views.FeedsViewHolderFeeds.FeedsViewHolderActions
                public final void MyBillsEntityDataFactory(String str) {
                    if (FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(str);
                    }
                }
            };
            return this.MyBillsEntityDataFactory;
        }
        FeedsFooterViewHolderFeeds feedsFooterViewHolderFeeds = new FeedsFooterViewHolderFeeds(viewGroup.getContext(), viewGroup);
        feedsFooterViewHolderFeeds.PlaceComponentResult = new FeedsFooterViewHolderFeeds.FooterFeedsViewHolderActions() { // from class: id.dana.feeds.FeedsAdapter$$ExternalSyntheticLambda0
            @Override // id.dana.feeds.views.FeedsFooterViewHolderFeeds.FooterFeedsViewHolderActions
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FeedsAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            }
        };
        return feedsFooterViewHolderFeeds;
    }
}
