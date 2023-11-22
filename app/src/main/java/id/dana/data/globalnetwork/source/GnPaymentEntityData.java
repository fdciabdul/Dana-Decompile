package id.dana.data.globalnetwork.source;

import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.domain.globalnetwork.model.Forex;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface GnPaymentEntityData {
    Observable<Boolean> clearGlobalNetwork();

    Observable<String> decodeGnQr(String str, String str2, boolean z);

    Observable<Forex> getForexCache(String str, String str2);

    Observable<ForexResult> getForexRate(String str, String str2);

    Observable<GnAuthResult> getGlobalNetworkAuth();

    Observable<String> getGnPaymentCode(String str);

    Observable<List<ForexResult>> getListRealTimeForexRate(List<String> list, List<String> list2);

    Observable<PayRequest> getPayRequest();

    Observable<Boolean> openMerchantCashier();

    Observable<Boolean> saveForex(Forex forex);

    Observable<Boolean> saveGnPaymentCode(String str);
}
