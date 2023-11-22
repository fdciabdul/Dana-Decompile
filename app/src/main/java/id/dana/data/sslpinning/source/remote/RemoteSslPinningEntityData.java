package id.dana.data.sslpinning.source.remote;

import android.content.Context;
import com.alipay.imobile.network.quake.IQuake;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.transport.http.UrlTransport;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import com.alipay.imobile.network.sslpinning.api.OnAddRemoteCertificatesListener;
import com.alipay.imobile.network.sslpinning.api.RemoteCertificateDownloadException;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.network.IOkHttpSSLPinningManager;
import id.dana.data.sslpinning.source.SslPinningEntityData;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Singleton
/* loaded from: classes2.dex */
public class RemoteSslPinningEntityData implements SslPinningEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int PlaceComponentResult = 0;
    private static final String TAG = "RemoteSslPinningEntityData";
    private static final String URL_TRANSPORT;
    private static char[] getAuthRequestContext;
    private final Context context;
    private boolean isSslPinningSuccess = false;
    private final IOkHttpSSLPinningManager okHttpSSLPinningManager;
    private final ISSLPinningManager sslPinningManager;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(new int[]{0, 12, 0, 0}, true, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1}, objArr);
        URL_TRANSPORT = ((String) objArr[0]).intern();
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext = new char[]{35492, 35565, 35566, 35569, 35567, 35566, 35577, 35575, 35581, 35534, 35537, 35533};
    }

    static /* synthetic */ String access$000() {
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'a' : (char) 28) != 'a') {
            return TAG;
        }
        String str = TAG;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    static /* synthetic */ boolean access$102(RemoteSslPinningEntityData remoteSslPinningEntityData, boolean z) {
        int i = BuiltInFictitiousFunctionClassFactory + 61;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        remoteSslPinningEntityData.isSslPinningSuccess = z;
        int i3 = PlaceComponentResult + 7;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    static /* synthetic */ ISSLPinningManager access$200(RemoteSslPinningEntityData remoteSslPinningEntityData) {
        int i = PlaceComponentResult + 91;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        ISSLPinningManager iSSLPinningManager = remoteSslPinningEntityData.sslPinningManager;
        try {
            int i3 = PlaceComponentResult + 25;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                return iSSLPinningManager;
            }
            Object obj = null;
            obj.hashCode();
            return iSSLPinningManager;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ IOkHttpSSLPinningManager access$300(RemoteSslPinningEntityData remoteSslPinningEntityData) {
        int i = PlaceComponentResult + 31;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        IOkHttpSSLPinningManager iOkHttpSSLPinningManager = remoteSslPinningEntityData.okHttpSSLPinningManager;
        int i3 = BuiltInFictitiousFunctionClassFactory + 33;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return iOkHttpSSLPinningManager;
        }
        int i4 = 0 / 0;
        return iOkHttpSSLPinningManager;
    }

    @Inject
    public RemoteSslPinningEntityData(Context context, ISSLPinningManager iSSLPinningManager, IOkHttpSSLPinningManager iOkHttpSSLPinningManager) {
        this.context = context;
        this.sslPinningManager = iSSLPinningManager;
        this.okHttpSSLPinningManager = iOkHttpSSLPinningManager;
    }

    @Override // id.dana.data.sslpinning.source.SslPinningEntityData
    public Observable<Boolean> addAndPersistRemoteCertificates(final int i, @Nullable final List<String> list) {
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.sslpinning.source.remote.RemoteSslPinningEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteSslPinningEntityData.this.m2052x2099a651(i, list);
            }
        });
        int i2 = BuiltInFictitiousFunctionClassFactory + 115;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            return defer;
        }
        int i3 = 55 / 0;
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addAndPersistRemoteCertificates$1$id-dana-data-sslpinning-source-remote-RemoteSslPinningEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2052x2099a651(final int i, final List list) throws Exception {
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sslpinning.source.remote.RemoteSslPinningEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RemoteSslPinningEntityData.this.m2051xb66a1e32(i, list, observableEmitter);
            }
        });
        int i2 = BuiltInFictitiousFunctionClassFactory + 107;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            return create;
        }
        int i3 = 11 / 0;
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addAndPersistRemoteCertificates$0$id-dana-data-sslpinning-source-remote-RemoteSslPinningEntityData  reason: not valid java name */
    public /* synthetic */ void m2051xb66a1e32(final int i, final List list, final ObservableEmitter observableEmitter) throws Exception {
        int i2 = BuiltInFictitiousFunctionClassFactory + 27;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        boolean z = false;
        try {
            this.isSslPinningSuccess = false;
            this.sslPinningManager.setPinningMode(0);
            this.okHttpSSLPinningManager.getAuthRequestContext(0);
            IQuake createInstance = Quake.createInstance(this.context);
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            Object[] objArr = new Object[1];
            a(new int[]{0, 12, 0, 0}, true, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1}, objArr);
            if (createInstance.getTransport(((String) objArr[0]).intern()) == null) {
                UrlTransport urlTransport = new UrlTransport(null, sSLContext.getSocketFactory());
                Object[] objArr2 = new Object[1];
                a(new int[]{0, 12, 0, 0}, true, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1}, objArr2);
                createInstance.registerTransport(((String) objArr2[0]).intern(), urlTransport);
                Object[] objArr3 = new Object[1];
                a(new int[]{0, 12, 0, 0}, true, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1}, objArr3);
                createInstance.setDefaultTransportName(((String) objArr3[0]).intern());
            }
            createInstance.setSSLPinningManager(this.sslPinningManager);
            if (!(1 != i)) {
                if (list == null) {
                    z = true;
                }
                if (!z && !list.isEmpty()) {
                    this.sslPinningManager.addAndPersistRemoteCertificates(list, new OnAddRemoteCertificatesListener() { // from class: id.dana.data.sslpinning.source.remote.RemoteSslPinningEntityData.1
                        @Override // com.alipay.imobile.network.sslpinning.api.OnAddRemoteCertificatesListener
                        public void onSuccess() {
                            String access$000 = RemoteSslPinningEntityData.access$000();
                            StringBuilder sb = new StringBuilder();
                            sb.append("download success certificatesUrl:");
                            sb.append(list);
                            DanaLog.MyBillsEntityDataFactory(access$000, sb.toString());
                            RemoteSslPinningEntityData.access$102(RemoteSslPinningEntityData.this, true);
                            RemoteSslPinningEntityData.access$200(RemoteSslPinningEntityData.this).setPinningMode(i);
                            try {
                                RemoteSslPinningEntityData.access$300(RemoteSslPinningEntityData.this).PlaceComponentResult(RemoteSslPinningEntityData.access$200(RemoteSslPinningEntityData.this).getCertificates());
                                RemoteSslPinningEntityData.access$300(RemoteSslPinningEntityData.this).getAuthRequestContext(i);
                                observableEmitter.onNext(Boolean.TRUE);
                                observableEmitter.onComplete();
                            } catch (Exception e) {
                                observableEmitter.onNext(Boolean.FALSE);
                                observableEmitter.onComplete();
                                Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                                Intrinsics.checkNotNullParameter("get certificates from A+ ISSLPinningManager", "");
                                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log("get certificates from A+ ISSLPinningManager");
                                Intrinsics.checkNotNullParameter(e, "");
                                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(e);
                            }
                        }

                        @Override // com.alipay.imobile.network.sslpinning.api.OnAddRemoteCertificatesListener
                        public void onFailure(RemoteCertificateDownloadException remoteCertificateDownloadException) {
                            observableEmitter.onNext(Boolean.FALSE);
                            observableEmitter.onComplete();
                        }
                    });
                    return;
                }
                if ((!this.sslPinningManager.getCertificates().isEmpty() ? 'S' : InputCardNumberView.DIVIDER) != ' ') {
                    int i4 = PlaceComponentResult + 95;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    this.isSslPinningSuccess = true;
                    this.sslPinningManager.setPinningMode(i);
                    try {
                        this.okHttpSSLPinningManager.PlaceComponentResult(this.sslPinningManager.getCertificates());
                        this.okHttpSSLPinningManager.getAuthRequestContext(i);
                        observableEmitter.onNext(Boolean.TRUE);
                    } catch (Exception e) {
                        observableEmitter.onNext(Boolean.FALSE);
                        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                        Intrinsics.checkNotNullParameter("get certificates from A+ ISSLPinningManager", "");
                        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log("get certificates from A+ ISSLPinningManager");
                        Intrinsics.checkNotNullParameter(e, "");
                        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(e);
                    }
                } else {
                    observableEmitter.onNext(Boolean.FALSE);
                }
                observableEmitter.onComplete();
                return;
            }
            observableEmitter.onNext(Boolean.FALSE);
            observableEmitter.onComplete();
        } catch (Exception e2) {
            observableEmitter.onError(e2);
        }
    }

    @Override // id.dana.data.sslpinning.source.SslPinningEntityData
    public Observable<Boolean> closeSslPinning() {
        int i = PlaceComponentResult + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            return addAndPersistRemoteCertificates(0, null);
        }
        try {
            return addAndPersistRemoteCertificates(0, null);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.sslpinning.source.SslPinningEntityData
    public Boolean isSslPinningSuccess() {
        int i = PlaceComponentResult + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Boolean valueOf = Boolean.valueOf(this.isSslPinningSuccess);
            int i3 = BuiltInFictitiousFunctionClassFactory + 31;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? Typography.quote : '%') != '\"') {
                return valueOf;
            }
            int i4 = 48 / 0;
            return valueOf;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        try {
            char[] cArr = getAuthRequestContext;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                    i5++;
                }
                int i6 = $10 + 123;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                int i8 = $10 + 73;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    int i10 = $10 + 63;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    try {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3 = cArr4;
            }
            if ((i4 > 0 ? '*' : '=') == '*') {
                int i12 = $11 + 61;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i14 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i14, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i14);
            }
            if ((z ? InputCardNumberView.DIVIDER : 'I') != 'I') {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? '\b' : '+') == '+') {
                        break;
                    }
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            String str = new String(cArr3);
            int i15 = $11 + 97;
            $10 = i15 % 128;
            int i16 = i15 % 2;
            objArr[0] = str;
        } catch (Exception e2) {
            throw e2;
        }
    }
}
