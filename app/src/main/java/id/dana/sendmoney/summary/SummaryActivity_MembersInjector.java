package id.dana.sendmoney.summary;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.summary.factory.SendMoneySummaryFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.social.contract.share.ShareToFeedsContract;

/* loaded from: classes5.dex */
public final class SummaryActivity_MembersInjector implements MembersInjector<SummaryActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SummaryActivity summaryActivity, SendMoneySummaryContract.Presenter presenter) {
        summaryActivity.sendMoneySummaryPresenter = presenter;
    }

    public static void getAuthRequestContext(SummaryActivity summaryActivity, SendMoneyConfirmationContract.Presenter presenter) {
        summaryActivity.sendMoneyConfirmationPresenter = presenter;
    }

    public static void PlaceComponentResult(SummaryActivity summaryActivity, SendMoneyConfirmationBankContract.Presenter presenter) {
        summaryActivity.sendMoneyConfirmationBankPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SummaryActivity summaryActivity, ExpiryContract.Presenter presenter) {
        summaryActivity.expiryPresenter = presenter;
    }

    public static void PlaceComponentResult(SummaryActivity summaryActivity, ShareToFeedsContract.Presenter presenter) {
        summaryActivity.shareToFeedsPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SummaryActivity summaryActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        summaryActivity.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }

    public static void getAuthRequestContext(SummaryActivity summaryActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        summaryActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SummaryActivity summaryActivity, SendMoneySummaryFactory sendMoneySummaryFactory) {
        summaryActivity.sendMoneySummaryFactory = sendMoneySummaryFactory;
    }
}
