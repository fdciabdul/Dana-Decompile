package id.dana.globalnetwork;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.danah5.extension.DanaGriverAppLanguageExtension;
import id.dana.danah5.extension.DanaGriverShareMenuExtension;
import id.dana.danah5.extension.DanaGriverUserAgentExtension;
import id.dana.danah5.httprequest.HttpRequestExtension;
import id.dana.domain.danah5.interactor.OpenH5;
import id.dana.domain.featureconfig.interactor.GetMarmotConfig;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;

/* loaded from: classes2.dex */
public final class AlipayConnectInitializer_MembersInjector implements MembersInjector<AlipayConnectInitializer> {
    public static void scheduleImpl(AlipayConnectInitializer alipayConnectInitializer, Lazy<GlobalNetworkProxyContract.Presenter> lazy) {
        alipayConnectInitializer.globalNetworkProxyPresenter = lazy;
    }

    public static void moveToNextValue(AlipayConnectInitializer alipayConnectInitializer, Lazy<OpenH5> lazy) {
        alipayConnectInitializer.openH5Lazy = lazy;
    }

    public static void getAuthRequestContext(AlipayConnectInitializer alipayConnectInitializer, Lazy<DanaGriverAppLanguageExtension> lazy) {
        alipayConnectInitializer.danaGriverAppLanguageExtension = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(AlipayConnectInitializer alipayConnectInitializer, Lazy<DanaGriverUserAgentExtension> lazy) {
        alipayConnectInitializer.danaGriverUserAgentExtension = lazy;
    }

    public static void PlaceComponentResult(AlipayConnectInitializer alipayConnectInitializer, Lazy<DanaGriverShareMenuExtension> lazy) {
        alipayConnectInitializer.danaShareMenuExtension = lazy;
    }

    public static void getErrorConfigVersion(AlipayConnectInitializer alipayConnectInitializer, Lazy<HttpRequestExtension> lazy) {
        alipayConnectInitializer.httpRequestExtension = lazy;
    }

    public static void MyBillsEntityDataFactory(AlipayConnectInitializer alipayConnectInitializer, Lazy<GetLatestSubdivision> lazy) {
        alipayConnectInitializer.getLatestSubdivision = lazy;
    }

    public static void lookAheadTest(AlipayConnectInitializer alipayConnectInitializer, Lazy<GetMarmotConfig> lazy) {
        alipayConnectInitializer.getMarmotConfig = lazy;
    }
}
