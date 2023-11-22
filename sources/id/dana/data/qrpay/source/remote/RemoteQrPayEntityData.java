package id.dana.data.qrpay.source.remote;

import android.app.Application;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.iap.android.f2fpay.client.F2FPayClientContext;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.client.pay.F2FPayResult;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent;
import com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator;
import com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator;
import com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage;
import com.alipay.iap.android.f2fpay.extension.impl.DefaultSecureStorageImpl;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.plus.android.unipayresult.sdk.client.UnifierQueryClient;
import com.alipay.plus.android.unipayresult.sdk.client.UnifierQueryClientContext;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.f2fpay.extensions.PaymentCodeGeneratorImpl;
import id.dana.data.f2fpay.remote.F2FPayClientImpl;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.qrpay.constants.F2fPayTracker;
import id.dana.data.qrpay.source.QrPayEntityData;
import id.dana.data.security.SecureString;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes2.dex */
public class RemoteQrPayEntityData implements QrPayEntityData {
    private final Application application;
    private final DeviceInformationProvider deviceInformationProvider;
    private FeatureConfigEntityRepository featureConfigEntityRepository;
    private IF2FPayCallbackHolder payCallbackHolder;
    private F2FPayClientImpl payClient;
    private PublishSubject<OtpInitResult> otpInitResultPublishSubject = PublishSubject.PlaceComponentResult();
    private PublishSubject<F2FPayResult> payResultPublishSubject = PublishSubject.PlaceComponentResult();
    private PublishSubject<F2FPaymentCodeInfo> paymentCodeInfoPublishSubject = PublishSubject.PlaceComponentResult();
    private PublishSubject<Boolean> qrInitStatusPublishSubject = PublishSubject.PlaceComponentResult();

    @Inject
    public RemoteQrPayEntityData(Application application, DeviceInformationProvider deviceInformationProvider, FeatureConfigEntityRepository featureConfigEntityRepository) {
        this.application = application;
        this.deviceInformationProvider = deviceInformationProvider;
        this.featureConfigEntityRepository = featureConfigEntityRepository;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public void init(String str, int i) {
        SecureString KClassImpl$Data$declaredNonStaticMembers$2 = CookieUtil.KClassImpl$Data$declaredNonStaticMembers$2("m.dana.id");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(";Domain=.dana.id;");
        CookieUtil.getAuthRequestContext("https://mgs-gw.m.dana.id/mgw.htm", sb.toString());
        KClassImpl$Data$declaredNonStaticMembers$2.clear();
        UnifierQueryClient.getInstance().initialize(new UnifierQueryClientContext(new SyncProvider()));
        F2FPayClientImpl f2FPayClientImpl = new F2FPayClientImpl(str);
        this.payClient = f2FPayClientImpl;
        final PublishSubject<F2FPayResult> publishSubject = this.payResultPublishSubject;
        Objects.requireNonNull(publishSubject);
        f2FPayClientImpl.setPayResultCallback(new IF2FPayResultCallback() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData$$ExternalSyntheticLambda3
            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback
            public final void onPayResultArrived(F2FPayResult f2FPayResult) {
                PublishSubject.this.onNext(f2FPayResult);
            }
        });
        this.payCallbackHolder = this.payClient.addPaymentCodeCallback(new IF2FPaymentCodeCallback() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData.1
            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback
            public void onPaymentCodeUpdated(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
                RemoteQrPayEntityData.this.paymentCodeInfoPublishSubject.onNext(f2FPaymentCodeInfo);
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback
            public void onPaymentCodeGenerateFailed() {
                RemoteQrPayEntityData.this.paymentCodeInfoPublishSubject.onNext(new F2FPaymentCodeInfo());
                Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("f2fpay", "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "f2fpay");
                Intrinsics.checkNotNullParameter(F2fPayTracker.EVENT_NAME, "");
                Intrinsics.checkNotNullParameter(F2fPayTracker.PAYMENT_CODE_GENERATED_FAILED, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey(F2fPayTracker.EVENT_NAME, F2fPayTracker.PAYMENT_CODE_GENERATED_FAILED);
            }
        });
        ((IF2FPayInitializeComponent) this.payClient.getComponent(IF2FPayInitializeComponent.class)).addInitializeCallback(new IF2FPayInitializeCallback() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData.2
            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onOtpInfoChanged(OtpInitResult otpInitResult) {
                RemoteQrPayEntityData.this.otpInitResultPublishSubject.onNext(otpInitResult);
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeFailed(String str2) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("f2fpay", DanaLogConstants.Prefix.QRCODE_INIT_PREFIX, str2);
                Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("f2fpay", "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "f2fpay");
                Intrinsics.checkNotNullParameter(F2fPayTracker.EVENT_NAME, "");
                Intrinsics.checkNotNullParameter(F2fPayTracker.F2FPAY_FAILED_INITIALIZED, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey(F2fPayTracker.EVENT_NAME, F2fPayTracker.F2FPAY_FAILED_INITIALIZED);
                Intrinsics.checkNotNullParameter("Error Message", "");
                Intrinsics.checkNotNullParameter(str2, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Error Message", str2);
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeOtpSucceed() {
                RemoteQrPayEntityData.this.qrInitStatusPublishSubject.onNext(Boolean.TRUE);
            }
        });
        initializeF2FPay(this.application, this.payClient);
        ((IF2FPayResultHandleComponent) this.payClient.getComponent(IF2FPayResultHandleComponent.class)).setRefreshCodeWhenLastCodePayed(false);
        ((IF2FPayPaymentCodeComponent) this.payClient.getComponent(IF2FPayPaymentCodeComponent.class)).setRefreshTimeSeconds(i);
        this.payClient.startF2FPay();
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<Boolean> start(final String str, final int i) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteQrPayEntityData.this.m1724x390fd12e(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$id-dana-data-qrpay-source-remote-RemoteQrPayEntityData  reason: not valid java name */
    public /* synthetic */ Boolean m1724x390fd12e(String str, int i) throws Exception {
        if (this.payClient == null) {
            init(str, i);
        }
        this.payClient.startRefreshTask();
        return Boolean.TRUE;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<Boolean> reStart(final String str, final int i) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteQrPayEntityData.this.m1722x4bb2ebe0(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reStart$1$id-dana-data-qrpay-source-remote-RemoteQrPayEntityData  reason: not valid java name */
    public /* synthetic */ Boolean m1722x4bb2ebe0(String str, int i) throws Exception {
        if (this.payClient == null) {
            init(str, i);
        }
        this.payClient.startRefreshTask();
        return Boolean.TRUE;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Boolean pause() {
        F2FPayClientImpl f2FPayClientImpl = this.payClient;
        if (f2FPayClientImpl != null) {
            f2FPayClientImpl.stopRefreshTask();
        }
        return Boolean.TRUE;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Boolean stop() {
        try {
            F2FPayClientImpl f2FPayClientImpl = this.payClient;
            if (f2FPayClientImpl != null) {
                f2FPayClientImpl.stopRefreshTask();
                this.payClient.onDestroy();
                this.payClient = null;
            }
            IF2FPayCallbackHolder iF2FPayCallbackHolder = this.payCallbackHolder;
            if (iF2FPayCallbackHolder != null) {
                iF2FPayCallbackHolder.removeSelf();
                this.payCallbackHolder = null;
            }
        } catch (Exception unused) {
            this.payClient = null;
            this.payCallbackHolder = null;
        }
        return Boolean.TRUE;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<F2FPayResult> getPaymentResult() {
        return this.payResultPublishSubject;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<F2FPaymentCodeInfo> getPaymentCode() {
        return this.paymentCodeInfoPublishSubject;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<OtpInitResult> getOtpInitResult() {
        return this.otpInitResultPublishSubject;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<Boolean> getQrInitResult() {
        return this.qrInitStatusPublishSubject;
    }

    @Override // id.dana.data.qrpay.source.QrPayEntityData
    public Observable<Boolean> setSeedExtra(final String str, final String str2, final int i) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteQrPayEntityData.this.m1723x621c2a37(str2, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSeedExtra$2$id-dana-data-qrpay-source-remote-RemoteQrPayEntityData  reason: not valid java name */
    public /* synthetic */ Boolean m1723x621c2a37(String str, int i, String str2) throws Exception {
        if (this.payClient == null) {
            init(str, i);
        }
        this.payClient.setSeedExtra(str2);
        return Boolean.TRUE;
    }

    private void initializeF2FPay(Application application, IF2FPayClient iF2FPayClient) {
        iF2FPayClient.initialize(application, new F2FPayClientContext(application) { // from class: id.dana.data.qrpay.source.remote.RemoteQrPayEntityData.3
            @Override // com.alipay.iap.android.f2fpay.client.F2FPayClientContext
            public IF2FPaySecureStorage createSecureStorage() {
                return new DefaultSecureStorageImpl();
            }

            @Override // com.alipay.iap.android.f2fpay.client.F2FPayClientContext
            public IF2FPayDeviceIdGenerator createDeviceIdGenerator() {
                return RemoteQrPayEntityData.this.deviceInformationProvider;
            }

            @Override // com.alipay.iap.android.f2fpay.client.F2FPayClientContext
            public IF2FPayPaymentCodeGenerator createPaymentCodeGenerator() {
                return new PaymentCodeGeneratorImpl(RemoteQrPayEntityData.this.featureConfigEntityRepository);
            }
        });
    }
}
