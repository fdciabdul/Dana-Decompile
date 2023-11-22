package id.dana.globalnetwork.currency;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;

/* loaded from: classes5.dex */
public final class GlobalNetworkPresenter_MembersInjector implements MembersInjector<GlobalNetworkPresenter> {
    public static void getAuthRequestContext(GlobalNetworkPresenter globalNetworkPresenter, Lazy<GetCountryCodeByLocationBlacklistedCountry> lazy) {
        globalNetworkPresenter.MyBillsEntityDataFactory(lazy);
    }

    public static void BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter, Lazy<IsAlipayConnectServiceFirstTime> lazy, Lazy<SaveAlipayConnectServiceFirstTime> lazy2, Lazy<GetWalletOauth> lazy3, Lazy<GetAuthCode> lazy4) {
        globalNetworkPresenter.MyBillsEntityDataFactory(lazy, lazy2, lazy3, lazy4);
    }

    public static void BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter, Lazy<GetPayRequest> lazy) {
        globalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(lazy);
    }
}
