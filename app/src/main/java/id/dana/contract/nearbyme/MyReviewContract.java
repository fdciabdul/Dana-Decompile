package id.dana.contract.nearbyme;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.base.AbstractContractKt;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/MyReviewContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MyReviewContract {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J(\u0010\f\u001a\u00020\u00032\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u000eH&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/MyReviewContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onErrorGetReviewedMerchantList", "", "error", "", "operationType", "", "onGetReviewedMerchantsList", FirebaseAnalytics.Param.ITEMS, "", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "onGetTagsMerchants", "positiveAndNegativeTags", "Lkotlin/Pair;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "onGetUnreviewedMerchants", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.nearbyme.MyReviewContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str) {
                Intrinsics.checkNotNullParameter(th, "");
                Intrinsics.checkNotNullParameter(str, "");
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantReviewViewModel> list);

        void MyBillsEntityDataFactory(List<MerchantConsultReviewViewHolderModel> list);

        void MyBillsEntityDataFactory(Pair<? extends List<MerchantReviewTagModel>, ? extends List<MerchantReviewTagModel>> pair);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "hasMoreReviewed", "", "getHasMoreReviewed", "()Z", "setHasMoreReviewed", "(Z)V", "hasMoreUnreviewed", "getHasMoreUnreviewed", "setHasMoreUnreviewed", "fetchReviewedMerchantsList", "", "isLoadMore", "fetchUnreviewedMerchants", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(boolean z);

        boolean getAuthRequestContext();

        /* renamed from: id.dana.contract.nearbyme.MyReviewContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }
}
