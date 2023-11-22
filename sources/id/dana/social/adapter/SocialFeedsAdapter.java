package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.social.adapter.friendsheader.FetchingNewDataViewHolder;
import id.dana.social.adapter.friendsheader.LoadMoreViewHolder;
import id.dana.social.adapter.viewholder.FeedSyncingStateViewHolder;
import id.dana.social.adapter.viewholder.FeedsSimpleShimmerViewHolder;
import id.dana.social.adapter.viewholder.MyFeedEmptyStateViewHolder;
import id.dana.social.base.BaseSocialFeedsAdapter;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.view.FeedsView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0003\u0010\u0016J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0017"}, d2 = {"Lid/dana/social/adapter/SocialFeedsAdapter;", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/social/model/FeedViewHolderModel;", "PlaceComponentResult", "()Lid/dana/social/model/FeedViewHolderModel;", "", "getAuthRequestContext", "()Ljava/util/List;", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/base/BaseRecyclerViewHolder;", "p0", "onViewRecycled", "(Lid/dana/base/BaseRecyclerViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "p1", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "(Lid/dana/social/model/FeedViewHolderModel;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialFeedsAdapter extends BaseSocialFeedsAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SocialFeedShimmerViewHolder socialFeedShimmerViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            socialFeedShimmerViewHolder = new SocialFeedShimmerViewHolder(viewGroup);
        } else if (i == 1) {
            socialFeedShimmerViewHolder = new FeedsSectionViewHolder(viewGroup);
        } else {
            switch (i) {
                case 4:
                    socialFeedShimmerViewHolder = new EmptyStateViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 5:
                case 9:
                    socialFeedShimmerViewHolder = new FeedViewHolder(viewGroup, this.getErrorConfigVersion, getPlaceComponentResult(), getKClassImpl$Data$declaredNonStaticMembers$2(), getMyBillsEntityDataFactory(), 0, 32, null);
                    break;
                case 6:
                    socialFeedShimmerViewHolder = new FetchingNewDataViewHolder(viewGroup);
                    break;
                case 7:
                    socialFeedShimmerViewHolder = new LoadMoreViewHolder(viewGroup, new Function0<Unit>() { // from class: id.dana.social.adapter.SocialFeedsAdapter$onCreateViewHolder$1
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
                            SocialFeedsAdapter.this.getErrorConfigVersion.PlaceComponentResult();
                        }
                    });
                    break;
                case 8:
                    socialFeedShimmerViewHolder = new SocialProfileHeaderViewHolder(viewGroup, false, getBuiltInFictitiousFunctionClassFactory(), null, 10, null);
                    break;
                case 10:
                    socialFeedShimmerViewHolder = new MyFeedEmptyStateViewHolder(viewGroup);
                    break;
                case 11:
                    socialFeedShimmerViewHolder = new GroupedFeedViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 12:
                    socialFeedShimmerViewHolder = new FeedSyncingStateViewHolder(viewGroup);
                    break;
                case 13:
                    socialFeedShimmerViewHolder = new GroupedFeedNotificationViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 14:
                case 15:
                    socialFeedShimmerViewHolder = new FeedNotificationViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 16:
                    socialFeedShimmerViewHolder = new FeedNotificationSectionViewHolder(viewGroup);
                    break;
                case 17:
                    socialFeedShimmerViewHolder = new FeedsSimpleShimmerViewHolder(viewGroup, R.layout.viewholder_feed_notif_shimmer);
                    break;
                default:
                    socialFeedShimmerViewHolder = new FeedsSectionViewHolder(viewGroup);
                    break;
            }
        }
        return socialFeedShimmerViewHolder;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled((SocialFeedsAdapter) ((BaseRecyclerViewHolder) viewHolder));
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final void getAuthRequestContext(FeedViewHolderModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<FeedViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        List<FeedViewHolderModel> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FeedViewHolderModel feedViewHolderModel : list) {
            if (feedViewHolderModel.getErrorConfigVersion == 8) {
                feedViewHolderModel = p0;
            }
            arrayList.add(feedViewHolderModel);
        }
        notifyDataSetChanged();
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final FeedViewHolderModel PlaceComponentResult() {
        List<FeedViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        for (FeedViewHolderModel feedViewHolderModel : items) {
            if (feedViewHolderModel.getErrorConfigVersion == 8) {
                return feedViewHolderModel;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView p0, List<ProfileCtaConfig> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        SocialProfileHeaderViewHolder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p1);
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onViewRecycled(BaseRecyclerViewHolder<FeedViewHolderModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewRecycled((SocialFeedsAdapter) p0);
        if (p0 instanceof FeedViewHolder) {
            FeedViewHolder feedViewHolder = (FeedViewHolder) p0;
            boolean placeComponentResult = getPlaceComponentResult();
            feedViewHolder.MyBillsEntityDataFactory = placeComponentResult;
            FeedsView feedsView = feedViewHolder.viewFeed;
            FeedsView feedsView2 = null;
            if (feedsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedsView = null;
            }
            feedsView.setShowCommentButton(placeComponentResult);
            boolean kClassImpl$Data$declaredNonStaticMembers$2 = getKClassImpl$Data$declaredNonStaticMembers$2();
            feedViewHolder.PlaceComponentResult = kClassImpl$Data$declaredNonStaticMembers$2;
            FeedsView feedsView3 = feedViewHolder.viewFeed;
            if (feedsView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedsView3 = null;
            }
            feedsView3.setShowSaymojiButton(kClassImpl$Data$declaredNonStaticMembers$2);
            boolean myBillsEntityDataFactory = getMyBillsEntityDataFactory();
            feedViewHolder.getAuthRequestContext = myBillsEntityDataFactory;
            FeedsView feedsView4 = feedViewHolder.viewFeed;
            if (feedsView4 != null) {
                feedsView2 = feedsView4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            feedsView2.setShowCaptionSection(myBillsEntityDataFactory);
        }
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final List<FeedViewHolderModel> getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            FeedModel.Companion companion = FeedModel.INSTANCE;
            arrayList.add(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory());
        }
        return arrayList;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            FeedModel.Companion companion = FeedModel.INSTANCE;
            arrayList.add(FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        setItems(arrayList);
    }

    public final boolean MyBillsEntityDataFactory() {
        Object obj;
        List<FeedViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) obj;
            if (feedViewHolderModel.getErrorConfigVersion == 17 || feedViewHolderModel.getErrorConfigVersion == 0) {
                break;
            }
        }
        return obj != null;
    }
}
