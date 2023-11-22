package id.dana.data.globalnetwork.source.remote;

import android.app.Application;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.member.MemberService;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.iap.ac.android.biz.IAPConnect;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.biz.common.model.ForeignExchangeQuote;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.mpm.DecodeParameter;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.source.GnPaymentEntityData;
import id.dana.data.globalnetwork.source.mapper.GnPaymentMapper;
import id.dana.data.miniprogram.provider.MemberServiceProvider;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.user.UserEntityRepository;
import id.dana.domain.globalnetwork.model.Forex;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes2.dex */
public class RemoteGnPaymentEntityData implements GnPaymentEntityData {
    private final Application application;
    public final PublishSubject<GnAuthResult> gnAuthResultPublishSubject = PublishSubject.PlaceComponentResult();
    private PaymentServiceProvider paymentServiceProvider;
    private final UserEntityRepository userEntityRepository;

    @Inject
    public RemoteGnPaymentEntityData(Application application, UserEntityRepository userEntityRepository, NetworkMiniPrograms networkMiniPrograms) {
        this.application = application;
        this.userEntityRepository = userEntityRepository;
        handleMemberInfo();
    }

    public void setResultPayment(String str, String str2) {
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setResultCode(str);
        paymentResult.setResultMessage(str2);
        getPaymentServiceProvider().setPaymentResult(paymentResult);
    }

    public void setResultPaymentWithoutCallback(String str, String str2) {
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setResultCode(str);
        paymentResult.setResultMessage(str2);
        getPaymentServiceProvider().setPaymentResultWithoutCallback(paymentResult);
    }

    private PaymentServiceProvider getPaymentServiceProvider() {
        if (this.paymentServiceProvider == null) {
            this.paymentServiceProvider = PaymentServiceProvider.getInstance();
        }
        return (PaymentServiceProvider) Objects.requireNonNull(this.paymentServiceProvider);
    }

    private void handleMemberInfo() {
        try {
            MemberServiceProvider memberServiceProvider = (MemberServiceProvider) WalletServiceManager.getInstance().getService(MemberService.class);
            UserEntityRepository userEntityRepository = this.userEntityRepository;
            Intrinsics.checkNotNullParameter(userEntityRepository, "");
            memberServiceProvider.getAuthRequestContext = userEntityRepository;
        } catch (WalletServiceManager.ServiceNotFoundException unused) {
        }
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<ForexResult> getForexRate(final String str, final String str2) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteGnPaymentEntityData.lambda$getForexRate$1(str, str2, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getForexRate$1(String str, String str2, final ObservableEmitter observableEmitter) throws Exception {
        QuoteCurrency quoteCurrency = new QuoteCurrency();
        quoteCurrency.sellCurrency = str;
        quoteCurrency.buyCurrency = str2;
        IAPConnect.inquireQuote(quoteCurrency, new InquireQuoteCallback() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda5
            @Override // com.iap.ac.android.biz.common.callback.InquireQuoteCallback
            public final void onResult(String str3, ForeignExchangeQuote foreignExchangeQuote) {
                RemoteGnPaymentEntityData.lambda$getForexRate$0(ObservableEmitter.this, str3, foreignExchangeQuote);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getForexRate$0(ObservableEmitter observableEmitter, String str, ForeignExchangeQuote foreignExchangeQuote) {
        if ("SUCCESS".equalsIgnoreCase(str)) {
            observableEmitter.onNext(GnPaymentMapper.map(foreignExchangeQuote));
        } else {
            observableEmitter.onNext(new ForexResult());
        }
        observableEmitter.onComplete();
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<List<ForexResult>> getListRealTimeForexRate(final List<String> list, final List<String> list2) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteGnPaymentEntityData.lambda$getListRealTimeForexRate$3(list, list2, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getListRealTimeForexRate$3(List list, List list2, final ObservableEmitter observableEmitter) throws Exception {
        final int size = list.size();
        final ArrayList arrayList = new ArrayList();
        InquireQuoteCallback inquireQuoteCallback = new InquireQuoteCallback() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda0
            @Override // com.iap.ac.android.biz.common.callback.InquireQuoteCallback
            public final void onResult(String str, ForeignExchangeQuote foreignExchangeQuote) {
                RemoteGnPaymentEntityData.lambda$getListRealTimeForexRate$2(arrayList, size, observableEmitter, str, foreignExchangeQuote);
            }
        };
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            String str2 = (String) list2.get(i);
            QuoteCurrency quoteCurrency = new QuoteCurrency();
            quoteCurrency.sellCurrency = str;
            quoteCurrency.buyCurrency = str2;
            IAPConnect.inquireQuote(quoteCurrency, inquireQuoteCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getListRealTimeForexRate$2(List list, int i, ObservableEmitter observableEmitter, String str, ForeignExchangeQuote foreignExchangeQuote) {
        if ("SUCCESS".equalsIgnoreCase(str)) {
            list.add(GnPaymentMapper.map(foreignExchangeQuote));
        } else {
            list.add(new ForexResult());
        }
        if (list.size() == i) {
            observableEmitter.onNext(list);
            observableEmitter.onComplete();
        }
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
    public Observable<String> getGnPaymentCode(final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteGnPaymentEntityData.this.m1336x92b4a418(str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getGnPaymentCode$4$id-dana-data-globalnetwork-source-remote-RemoteGnPaymentEntityData  reason: not valid java name */
    public /* synthetic */ void m1336x92b4a418(String str, final ObservableEmitter observableEmitter) throws Exception {
        IAPConnect.getPaymentCode(str, new IPaymentCodeListener() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData.1
            @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
            public void onPaymentCodeUpdated(String str2) {
                observableEmitter.onNext(str2);
                observableEmitter.onComplete();
            }

            @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
            public void onPaymentCodeUpdateFailed(String str2, String str3) {
                observableEmitter.onError(new Throwable(str2));
            }
        });
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> saveGnPaymentCode(String str) {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<GnAuthResult> getGlobalNetworkAuth() {
        return this.gnAuthResultPublishSubject;
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> clearGlobalNetwork() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteGnPaymentEntityData.lambda$clearGlobalNetwork$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$clearGlobalNetwork$5() throws Exception {
        IAPConnect.clear();
        return Boolean.TRUE;
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<String> decodeGnQr(final String str, final String str2, final boolean z) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteGnPaymentEntityData.this.m1335xf8eb6c96(str, str2, z, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$decodeGnQr$6$id-dana-data-globalnetwork-source-remote-RemoteGnPaymentEntityData  reason: not valid java name */
    public /* synthetic */ void m1335xf8eb6c96(String str, String str2, boolean z, final ObservableEmitter observableEmitter) throws Exception {
        getPaymentServiceProvider().setDecodeEmitter(observableEmitter);
        DecodeParameter decodeParameter = new DecodeParameter();
        decodeParameter.codeValue = str;
        decodeParameter.acDecodeConfigFromServer = str2;
        if (z) {
            decodeParameter.merchantType = "APP";
            decodeParameter.scene = ACConstants.Scene.SOURCE_FROM_OTHER_APP;
        } else {
            decodeParameter.scene = ACConstants.Scene.SOURCE_FROM_SCAN;
        }
        IAPConnect.decode(this.application, decodeParameter, new IDecodeCallback() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData.2
            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void dismissLoading() {
            }

            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void showLoading() {
            }

            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void onResult(Result result) {
                String str3 = result.resultCode;
                if ("SUCCESS".equals(result.resultCode) || "USER_CANCEL".equals(result.resultCode)) {
                    return;
                }
                observableEmitter.onError(new Throwable(result.resultMessage));
                RemoteGnPaymentEntityData.this.paymentServiceProvider.getPaymentEmitter().onError(new Throwable(result.resultCode));
            }
        });
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<PayRequest> getPayRequest() {
        final PaymentServiceProvider paymentServiceProvider = getPaymentServiceProvider();
        Objects.requireNonNull(paymentServiceProvider);
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PaymentServiceProvider.this.setPaymentEmitter(observableEmitter);
            }
        });
    }

    @Override // id.dana.data.globalnetwork.source.GnPaymentEntityData
    public Observable<Boolean> openMerchantCashier() {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteGnPaymentEntityData.this.m1337xfc722f34(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$openMerchantCashier$7$id-dana-data-globalnetwork-source-remote-RemoteGnPaymentEntityData  reason: not valid java name */
    public /* synthetic */ void m1337xfc722f34(ObservableEmitter observableEmitter) throws Exception {
        getPaymentServiceProvider().openMerchantCashier();
        observableEmitter.onNext(Boolean.TRUE);
    }
}
