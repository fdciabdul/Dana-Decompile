package id.dana.requestmoney;

import dagger.MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class BaseRequestMoneyQrCardFragment_MembersInjector implements MembersInjector<BaseRequestMoneyQrCardFragment> {
    public static void MyBillsEntityDataFactory(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, RequestMoneyQrContract.Presenter presenter) {
        baseRequestMoneyQrCardFragment.requestMoneyQrPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, GenerateDeepLinkContract.TransferPresenter transferPresenter) {
        baseRequestMoneyQrCardFragment.transferDeepLinkPresenter = transferPresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, GenerateDeepLinkContract.ProfilePresenter profilePresenter) {
        baseRequestMoneyQrCardFragment.profileDeeplinkPresenter = profilePresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        baseRequestMoneyQrCardFragment.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }
}
