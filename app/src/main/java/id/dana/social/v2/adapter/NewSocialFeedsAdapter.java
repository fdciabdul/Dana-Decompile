package id.dana.social.v2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.social.adapter.FeedNotificationSectionViewHolder;
import id.dana.social.adapter.FeedNotificationViewHolder;
import id.dana.social.adapter.FeedsSectionViewHolder;
import id.dana.social.adapter.GroupedFeedNotificationViewHolder;
import id.dana.social.adapter.SocialProfileHeaderViewHolder;
import id.dana.social.adapter.friendsheader.FetchingNewDataViewHolder;
import id.dana.social.adapter.friendsheader.LoadMoreViewHolder;
import id.dana.social.adapter.viewholder.FeedSyncingStateViewHolder;
import id.dana.social.adapter.viewholder.MyFeedEmptyStateViewHolder;
import id.dana.social.base.BaseSocialFeedsAdapter;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.v2.viewholder.FeedViewHolder;
import id.dana.social.v2.viewholder.FeedsEmptyViewHolder;
import id.dana.social.v2.viewholder.FeedsShimmerViewHolder;
import id.dana.social.v2.viewholder.GroupedFeedViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\r\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\r\u0010\u0018J\u0017\u0010\n\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/social/v2/adapter/NewSocialFeedsAdapter;", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/social/model/FeedViewHolderModel;", "PlaceComponentResult", "()Lid/dana/social/model/FeedViewHolderModel;", "", "getAuthRequestContext", "()Ljava/util/List;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Landroidx/recyclerview/widget/RecyclerView;", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "DatabaseTableConfigUtil", "()V", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "p1", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "(Lid/dana/social/model/FeedViewHolderModel;)V", "getErrorConfigVersion", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/recyclerview/widget/RecyclerView;", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSocialFeedsAdapter extends BaseSocialFeedsAdapter {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private RecyclerView MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    public NewSocialFeedsAdapter() {
        setItems(new ArrayList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        final BaseRecyclerViewHolder feedsShimmerViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            feedsShimmerViewHolder = new FeedsShimmerViewHolder(viewGroup);
        } else if (i == 1) {
            feedsShimmerViewHolder = new FeedsSectionViewHolder(viewGroup);
        } else {
            switch (i) {
                case 4:
                    FeedsEmptyViewHolder feedsEmptyViewHolder = new FeedsEmptyViewHolder(viewGroup, this.getErrorConfigVersion);
                    ViewTreeObserver viewTreeObserver = feedsEmptyViewHolder.itemView.getViewTreeObserver();
                    feedsShimmerViewHolder = feedsEmptyViewHolder;
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.social.v2.adapter.NewSocialFeedsAdapter$changeHeightDynamically$1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            View view = feedsShimmerViewHolder.itemView;
                            Intrinsics.checkNotNullExpressionValue(view, "");
                            if (view.getVisibility() == 0) {
                                feedsShimmerViewHolder.itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                ConstraintLayout constraintLayout = (ConstraintLayout) feedsShimmerViewHolder.itemView.findViewById(R.id.HttpClientAttributesExtractorBuilder_res_0x7f0a0443);
                                ViewGroup.LayoutParams layoutParams = constraintLayout != null ? constraintLayout.getLayoutParams() : null;
                                if (layoutParams != null) {
                                    layoutParams.height = viewGroup.getHeight() - ((int) feedsShimmerViewHolder.itemView.getY());
                                }
                                this.notifyItemChanged(feedsShimmerViewHolder.getAbsoluteAdapterPosition());
                            }
                        }
                    });
                    break;
                case 5:
                case 9:
                    feedsShimmerViewHolder = new FeedViewHolder(viewGroup, this.getErrorConfigVersion, getPlaceComponentResult(), false, false, false, false, false, this.getAuthRequestContext, 0, 760, null);
                    break;
                case 6:
                    feedsShimmerViewHolder = new FetchingNewDataViewHolder(viewGroup);
                    break;
                case 7:
                    feedsShimmerViewHolder = new LoadMoreViewHolder(viewGroup, new Function0<Unit>() { // from class: id.dana.social.v2.adapter.NewSocialFeedsAdapter$onCreateViewHolder$1
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
                            NewSocialFeedsAdapter.this.getErrorConfigVersion.PlaceComponentResult();
                        }
                    });
                    break;
                case 8:
                    feedsShimmerViewHolder = new SocialProfileHeaderViewHolder(viewGroup, true, getBuiltInFictitiousFunctionClassFactory(), this.getErrorConfigVersion);
                    break;
                case 10:
                    feedsShimmerViewHolder = new MyFeedEmptyStateViewHolder(viewGroup);
                    break;
                case 11:
                    feedsShimmerViewHolder = new GroupedFeedViewHolder(viewGroup, this.getErrorConfigVersion, 0, 4, null);
                    break;
                case 12:
                    feedsShimmerViewHolder = new FeedSyncingStateViewHolder(viewGroup);
                    break;
                case 13:
                    feedsShimmerViewHolder = new GroupedFeedNotificationViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 14:
                case 15:
                    feedsShimmerViewHolder = new FeedNotificationViewHolder(viewGroup, this.getErrorConfigVersion);
                    break;
                case 16:
                    feedsShimmerViewHolder = new FeedNotificationSectionViewHolder(viewGroup);
                    break;
                default:
                    feedsShimmerViewHolder = new FeedsSectionViewHolder(viewGroup);
                    break;
            }
        }
        return feedsShimmerViewHolder;
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

    @Override // id.dana.social.base.BaseSocialFeedsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).getErrorConfigVersion;
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final List<FeedViewHolderModel> getAuthRequestContext() {
        this.PlaceComponentResult = false;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            FeedModel.Companion companion = FeedModel.INSTANCE;
            arrayList.add(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory());
        }
        return arrayList;
    }

    @Override // id.dana.social.base.BaseSocialFeedsAdapter
    public final void DatabaseTableConfigUtil() {
        this.PlaceComponentResult = true;
        super.DatabaseTableConfigUtil();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttachedToRecyclerView(p0);
        this.MyBillsEntityDataFactory = p0;
        if (p0 != null) {
            p0.setLayoutManager(new LinearLayoutManager(p0.getContext()) { // from class: id.dana.social.v2.adapter.NewSocialFeedsAdapter$onAttachedToRecyclerView$1$1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public final boolean canScrollVertically() {
                    boolean z;
                    z = NewSocialFeedsAdapter.this.PlaceComponentResult;
                    return z;
                }
            });
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Intrinsics.checkNotNullExpressionValue(getItems(), "");
        if ((!r0.isEmpty()) != false) {
            List<FeedViewHolderModel> items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            Iterator<FeedViewHolderModel> it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                FeedViewHolderModel next = it.next();
                if (next.getErrorConfigVersion == 5 || next.getErrorConfigVersion == 9 || next.getErrorConfigVersion == 11) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                return true;
            }
        }
        return false;
    }
}
