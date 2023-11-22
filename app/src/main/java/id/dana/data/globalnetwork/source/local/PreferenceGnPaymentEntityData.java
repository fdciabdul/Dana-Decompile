package id.dana.data.globalnetwork.source.local;

import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.model.PaymentResult;
import id.dana.data.globalnetwork.source.GnPaymentEntityData;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PreferenceGnPaymentEntityData implements GnPaymentEntityData {
    private final GlobalNetworkPreference globalNetworkPreference;

    @Inject
    public PreferenceGnPaymentEntityData(GlobalNetworkPreference globalNetworkPreference) {
        this.globalNetworkPreference = globalNetworkPreference;
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<ForexResult> getForexRate(String str, String str2) {
        return Observable.just(new ForexResult());
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<List<ForexResult>> getListRealTimeForexRate(List<String> list, List<String> list2) {
        return Observable.just(new ArrayList());
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Forex> getForexCache(String str, String str2) {
        Forex forexCache = this.globalNetworkPreference.getForexCache(str2);
        return forexCache == null ? Observable.error(new Throwable()) : Observable.just(forexCache);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> saveForex(Forex forex) {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.saveForex(forex)));
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<String> getGnPaymentCode(String str) {
        return filterPaymentCode(this.globalNetworkPreference.getPaymentCodes()).flatMap(new Function() { // from class: id.dana.data.globalnetwork.source.local.PreferenceGnPaymentEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.fromIterable((List) obj);
            }
        });
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> saveGnPaymentCode(String str) {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.savePaymentCode(str)));
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<GnAuthResult> getGlobalNetworkAuth() {
        return Observable.just(new GnAuthResult(""));
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> clearGlobalNetwork() {
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<String> decodeGnQr(String str, String str2, boolean z) {
        return Observable.just("");
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<PayRequest> getPayRequest() {
        return Observable.just(null, null);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> openMerchantCashier() {
        return Observable.just(Boolean.TRUE);
    }

    public Observable<Boolean> invalidatePaymentCode(F2FPayResultResponse f2FPayResultResponse) {
        if (f2FPayResultResponse != null && f2FPayResultResponse.getOrderInfo() != null && f2FPayResultResponse.getOrderInfo().getPaymentCode() != null) {
            Set<PaymentResult> paymentCodeSet = this.globalNetworkPreference.getPaymentCodeSet();
            paymentCodeSet.remove(new PaymentResult(f2FPayResultResponse.getOrderInfo().getPaymentCode(), new Date(), false));
            this.globalNetworkPreference.savePaymentCodes(paymentCodeSet);
        }
        return Observable.just(Boolean.TRUE);
    }

    public Observable<List<String>> getAllPaymentCodes() {
        return filterPaymentCode(this.globalNetworkPreference.getPaymentCodes());
    }

    public Observable<Boolean> clearAllPaymentCodes() {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.savePaymentCodes(new HashSet())));
    }

    private Observable<List<String>> filterPaymentCode(List<PaymentResult> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<PaymentResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getCode());
        }
        return Observable.just(arrayList);
    }
}
