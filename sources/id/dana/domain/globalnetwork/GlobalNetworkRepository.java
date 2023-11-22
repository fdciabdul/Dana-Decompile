package id.dana.domain.globalnetwork;

import id.dana.domain.globalnetwork.model.Auth;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.domain.globalnetwork.model.GnConsultInfo;
import id.dana.domain.globalnetwork.model.Pay;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface GlobalNetworkRepository {
    Observable<Boolean> clearAllPaymentCodes();

    Observable<Boolean> clearGlobalNetwork();

    Observable<String> decodeGnQr(String str, String str2, boolean z);

    GnConsultInfo doGnConsult(Map<String, String> map, String str);

    Observable<Boolean> getAlipayConnectServiceFirstTime();

    Observable<String> getCountryCodeByLocation();

    Observable<Forex> getForexCache(String str, String str2);

    Observable<Forex> getForexRate(String str, String str2);

    Observable<Auth> getGlobalNetworkAuth();

    Observable<List<String>> getGnCScanBBlacklistedCountry();

    Observable<List<String>> getMerchantBlockRegistration();

    Observable<Pay> getPayRequest();

    Observable<List<Forex>> getRealtimeForexList(List<String> list, List<String> list2);

    Observable<String> getSelectedCountryCode();

    Observable<F2FPayResultResponse> getUniPaymentResult(String str);

    Observable<Boolean> isCScanBEnabled();

    Observable<Boolean> isGoogleBlockRegistration();

    Observable<Boolean> openMerchantCashier();

    Observable<Boolean> saveAlipayConnectServiceFirstTime(Boolean bool);

    Observable<Boolean> saveForex(Forex forex);

    Observable<Boolean> savePaymentCode(String str);

    Observable<Boolean> sendRiskEvent(String str, String str2);
}
