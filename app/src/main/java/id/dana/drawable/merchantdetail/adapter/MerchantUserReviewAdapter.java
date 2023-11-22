package id.dana.drawable.merchantdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.account.Account;
import id.dana.drawable.merchantdetail.adapter.MerchantUserReviewAdapter;
import id.dana.drawable.model.RatingViewHolderModel;
import id.dana.drawable.view.RatingStarView;
import id.dana.drawable.view.UserReviewView;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ImageResize;
import id.dana.utils.ShimmeringUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\b\u001d\u001e\u001f !\"#$B\u0007¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/nearbyme/model/ShopModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/model/ShopModel;)Ljava/util/List;", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "getAuthRequestContext", "()V", "", "PlaceComponentResult", "Z", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/domain/account/Account;", "Lid/dana/domain/account/Account;", "MyBillsEntityDataFactory", "<init>", "MerchantInputReviewItem", "MerchantOwnReviewItem", "MerchantRatingItem", "MerchantRatingReviewEmptyState", "MerchantRatingReviewHeader", "MerchantRatingReviewShimmer", "RatingSectionListener", "ReviewCoachmarkViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantUserReviewAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<RatingViewHolderModel>, RatingViewHolderModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Account MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public RatingSectionListener BuiltInFictitiousFunctionClassFactory;
    public boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public ShopModel KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "", "", "getAuthRequestContext", "()V", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "p0", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", "", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RatingSectionListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(int p0, MerchantConsultReviewModel p1);

        void getAuthRequestContext();

        void getAuthRequestContext(MerchantReviewModel p0);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((MerchantUserReviewAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantRatingItem merchantRatingItem;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i != 0) {
            switch (i) {
                case 2:
                    merchantRatingItem = new MerchantOwnReviewItem(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
                    break;
                case 3:
                    merchantRatingItem = new ReviewCoachmarkViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
                    break;
                case 4:
                    merchantRatingItem = new MerchantInputReviewItem(viewGroup, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
                    break;
                case 5:
                    merchantRatingItem = new MerchantRatingReviewEmptyState(viewGroup);
                    break;
                case 6:
                    merchantRatingItem = new MerchantRatingReviewShimmer(viewGroup);
                    break;
                case 7:
                    merchantRatingItem = new MerchantRatingReviewHeader(viewGroup);
                    break;
                default:
                    merchantRatingItem = new MerchantRatingReviewEmptyState(viewGroup);
                    break;
            }
        } else {
            merchantRatingItem = new MerchantRatingItem(viewGroup);
        }
        return merchantRatingItem;
    }

    public MerchantUserReviewAdapter() {
        getAuthRequestContext();
    }

    public final void getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        RatingViewHolderModel.Companion companion = RatingViewHolderModel.INSTANCE;
        arrayList.add(RatingViewHolderModel.Companion.PlaceComponentResult());
        RatingViewHolderModel.Companion companion2 = RatingViewHolderModel.INSTANCE;
        arrayList.add(RatingViewHolderModel.Companion.MyBillsEntityDataFactory());
        setItems(arrayList);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<RatingViewHolderModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof MerchantOwnReviewItem) {
            ((MerchantOwnReviewItem) p0).MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        super.onBindViewHolder((MerchantUserReviewAdapter) p0, p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).MyBillsEntityDataFactory;
    }

    public final List<RatingViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2(ShopModel p0) {
        ArrayList arrayList = new ArrayList();
        RatingViewHolderModel.Companion companion = RatingViewHolderModel.INSTANCE;
        arrayList.add(RatingViewHolderModel.Companion.PlaceComponentResult());
        if (NearbyExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            RatingViewHolderModel.Companion companion2 = RatingViewHolderModel.INSTANCE;
            arrayList.add(RatingViewHolderModel.Companion.BuiltInFictitiousFunctionClassFactory(p0));
        }
        if (this.PlaceComponentResult) {
            RatingViewHolderModel.Companion companion3 = RatingViewHolderModel.INSTANCE;
            arrayList.add(RatingViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$ReviewCoachmarkViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ReviewCoachmarkViewHolder extends BaseRecyclerViewHolder<RatingViewHolderModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final RatingSectionListener MyBillsEntityDataFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RatingViewHolderModel ratingViewHolderModel) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.SendMoneyPresenter_MembersInjector);
            if (appCompatImageView != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter$ReviewCoachmarkViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MerchantUserReviewAdapter.ReviewCoachmarkViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(MerchantUserReviewAdapter.ReviewCoachmarkViewHolder.this);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewCoachmarkViewHolder(ViewGroup viewGroup, RatingSectionListener ratingSectionListener) {
            super(viewGroup.getContext(), R.layout.view_review_coachmark, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.MyBillsEntityDataFactory = ratingSectionListener;
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReviewCoachmarkViewHolder reviewCoachmarkViewHolder) {
            Intrinsics.checkNotNullParameter(reviewCoachmarkViewHolder, "");
            RatingSectionListener ratingSectionListener = reviewCoachmarkViewHolder.MyBillsEntityDataFactory;
            if (ratingSectionListener != null) {
                ratingSectionListener.getAuthRequestContext();
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantOwnReviewItem;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "getAuthRequestContext", "Lid/dana/nearbyme/model/ShopModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/model/ShopModel;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantOwnReviewItem extends BaseRecyclerViewHolder<RatingViewHolderModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final RatingSectionListener getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        ShopModel MyBillsEntityDataFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RatingViewHolderModel ratingViewHolderModel) {
            RatingViewHolderModel ratingViewHolderModel2 = ratingViewHolderModel;
            if (ratingViewHolderModel2 == null || ratingViewHolderModel2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return;
            }
            UserReviewView userReviewView = (UserReviewView) this.itemView.findViewById(R.id.res_0x7f0a03ee_daggerdanaprotectionwidgetcomponent_danaprotectionwidgetcomponentimpl_provideeventtrackerqueueprovider);
            if (userReviewView != null) {
                userReviewView.setShopModel(this.MyBillsEntityDataFactory);
            }
            UserReviewView userReviewView2 = (UserReviewView) this.itemView.findViewById(R.id.res_0x7f0a03ee_daggerdanaprotectionwidgetcomponent_danaprotectionwidgetcomponentimpl_provideeventtrackerqueueprovider);
            if (userReviewView2 != null) {
                userReviewView2.setData(ratingViewHolderModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            UserReviewView userReviewView3 = (UserReviewView) this.itemView.findViewById(R.id.res_0x7f0a03ee_daggerdanaprotectionwidgetcomponent_danaprotectionwidgetcomponentimpl_provideeventtrackerqueueprovider);
            if (userReviewView3 != null) {
                userReviewView3.setRatingListener(this.getAuthRequestContext);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantOwnReviewItem(ViewGroup viewGroup, RatingSectionListener ratingSectionListener) {
            super(viewGroup.getContext(), R.layout.item_user_review, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.getAuthRequestContext = ratingSectionListener;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantInputReviewItem;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "PlaceComponentResult", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "MyBillsEntityDataFactory", "Lid/dana/domain/account/Account;", "getAuthRequestContext", "Lid/dana/domain/account/Account;", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;Lid/dana/domain/account/Account;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantInputReviewItem extends BaseRecyclerViewHolder<RatingViewHolderModel> {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final RatingSectionListener MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Account PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RatingViewHolderModel ratingViewHolderModel) {
            final RatingViewHolderModel ratingViewHolderModel2 = ratingViewHolderModel;
            if (ratingViewHolderModel2 == null || ratingViewHolderModel2.PlaceComponentResult == null) {
                return;
            }
            ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) this.itemView.findViewById(R.id.parsePerformanceSetDataSize);
            if (viewRatingStarBar != null) {
                viewRatingStarBar.setStarSelected(0);
            }
            ViewRatingStarBar viewRatingStarBar2 = (ViewRatingStarBar) this.itemView.findViewById(R.id.parsePerformanceSetDataSize);
            if (viewRatingStarBar2 != null) {
                viewRatingStarBar2.setOnStarClickListener(new ViewRatingStarBar.ClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter$MerchantInputReviewItem$bindData$1
                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
                    
                        r1 = r2.MyBillsEntityDataFactory;
                     */
                    @Override // id.dana.nearbyme.merchantreview.ViewRatingStarBar.ClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(int r3) {
                        /*
                            r2 = this;
                            id.dana.nearbyrevamp.model.RatingViewHolderModel r0 = id.dana.drawable.model.RatingViewHolderModel.this
                            id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel r0 = r0.PlaceComponentResult
                            if (r0 == 0) goto L11
                            id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter$MerchantInputReviewItem r1 = r2
                            id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter$RatingSectionListener r1 = id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter.MerchantInputReviewItem.getAuthRequestContext(r1)
                            if (r1 == 0) goto L11
                            r1.KClassImpl$Data$declaredNonStaticMembers$2(r3, r0)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantdetail.adapter.MerchantUserReviewAdapter$MerchantInputReviewItem$bindData$1.KClassImpl$Data$declaredNonStaticMembers$2(int):void");
                    }
                });
            }
            Account account = this.PlaceComponentResult;
            if (account != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
                if (appCompatImageView != null) {
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    GlideApp.getAuthRequestContext(appCompatImageView.getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAvatarUrl()).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) appCompatImageView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0)));
                }
                TextView textView = (TextView) this.itemView.findViewById(R.id.tvUserName);
                if (textView != null) {
                    textView.setText(account.getNickname());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantInputReviewItem(ViewGroup viewGroup, RatingSectionListener ratingSectionListener, Account account) {
            super(viewGroup.getContext(), R.layout.item_user_input_review, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.MyBillsEntityDataFactory = ratingSectionListener;
            this.PlaceComponentResult = account;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantRatingItem;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantRatingItem extends BaseRecyclerViewHolder<RatingViewHolderModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RatingViewHolderModel ratingViewHolderModel) {
            RatingViewHolderModel ratingViewHolderModel2 = ratingViewHolderModel;
            if (ratingViewHolderModel2 == null || ratingViewHolderModel2.BuiltInFictitiousFunctionClassFactory == null) {
                return;
            }
            TextView textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1530_getindosubdivisionsnamebylocation_lambda_3);
            if (textView != null) {
                String format = new DecimalFormat("##.0").format(ratingViewHolderModel2.BuiltInFictitiousFunctionClassFactory.readMicros);
                Intrinsics.checkNotNullExpressionValue(format, "");
                textView.setText(StringsKt.replace$default(format, ",", ".", false, 4, (Object) null));
            }
            RatingStarView ratingStarView = (RatingStarView) this.itemView.findViewById(R.id.setKybResponse);
            if (ratingStarView != null) {
                ratingStarView.setRating((float) ratingViewHolderModel2.BuiltInFictitiousFunctionClassFactory.readMicros);
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1548_newwalletpresenter_getinvestmentcardassets_1);
            if (textView2 != null) {
                textView2.setText(getContext().getResources().getQuantityString(R.plurals.f46702131820556, (int) ratingViewHolderModel2.BuiltInFictitiousFunctionClassFactory.SubSequence, Integer.valueOf((int) ratingViewHolderModel2.BuiltInFictitiousFunctionClassFactory.SubSequence)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantRatingItem(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_average_rating, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantRatingReviewEmptyState;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantRatingReviewEmptyState extends BaseRecyclerViewHolder<RatingViewHolderModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantRatingReviewEmptyState(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_review_empty_state, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantRatingReviewShimmer;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantRatingReviewShimmer extends BaseRecyclerViewHolder<RatingViewHolderModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RatingViewHolderModel ratingViewHolderModel) {
            ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_user_review_skeleton);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantRatingReviewShimmer(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_user_review_skeleton, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$MerchantRatingReviewHeader;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantRatingReviewHeader extends BaseRecyclerViewHolder<RatingViewHolderModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantRatingReviewHeader(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_rating_review_header, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
