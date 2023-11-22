package id.dana.data.globalnetwork.source.mock;

import com.alipay.iap.android.wallet.acl.payment.PaymentAmount;
import com.alipay.iap.android.wallet.acl.payment.PaymentRequest;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentType;
import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.source.GnPaymentEntityData;
import id.dana.domain.globalnetwork.model.Forex;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class MockGlobalNetworkEntityData implements GnPaymentEntityData {
    public static /* synthetic */ void lambda$getPayRequest$0(PaymentResult paymentResult) {
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<ForexResult> getForexRate(String str, String str2) {
        ForexResult forexResult = new ForexResult();
        forexResult.setId("1");
        forexResult.setCurrencyPair("IDR/JPY");
        forexResult.setPrice("0.008");
        return Observable.just(forexResult);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<List<ForexResult>> getListRealTimeForexRate(List<String> list, List<String> list2) {
        return Observable.just(new ArrayList());
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Forex> getForexCache(String str, String str2) {
        return Observable.just(new Forex());
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> saveForex(Forex forex) {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<String> getGnPaymentCode(String str) {
        return Observable.just("281012026134677478611545");
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> saveGnPaymentCode(String str) {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<GnAuthResult> getGlobalNetworkAuth() {
        return Observable.just(new GnAuthResult("3435353535353"));
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> clearGlobalNetwork() {
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<String> decodeGnQr(String str, String str2, boolean z) {
        return Observable.just("uenfkefnekjfneskjfns");
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<PayRequest> getPayRequest() {
        return Observable.just(new PayRequest(false, new PaymentRequest(PaymentType.CASHIER_URL, "yenyenyen", new PaymentAmount(), new HashMap()), new MockGlobalNetworkEntityData$$ExternalSyntheticLambda0()));
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> openMerchantCashier() {
        return Observable.just(Boolean.TRUE);
    }
}
