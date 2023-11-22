package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.domain.account.Account;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewSummaryModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantAverageRatingContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext(String p0);

        void getAuthRequestContext(String p0, String p1);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "getMerchantReviewFormFail", "", "getMerchantReviewFormSuccess", "reviewForm", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "onGetMerchantConsult", "merchantConsultReviewModel", "onGetUserAccount", "userAccount", "Lid/dana/domain/account/Account;", "onGetUserReviewCoachmarkVisibility", "shouldVisible", "", "onLoadingMerchantAverageRatingFail", "onLoadingMerchantAverageRatingSuccess", "merchantReviewSummaryModel", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult(MerchantConsultReviewModel merchantConsultReviewModel) {
                Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory(MerchantReviewSummaryModel merchantReviewSummaryModel);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(MerchantConsultReviewModel merchantConsultReviewModel);

        void MyBillsEntityDataFactory(boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(Account account);

        void getAuthRequestContext(MerchantConsultReviewModel merchantConsultReviewModel);
    }
}
