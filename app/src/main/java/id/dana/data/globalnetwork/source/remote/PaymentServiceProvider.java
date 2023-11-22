package id.dana.data.globalnetwork.source.remote;

import android.graphics.PointF;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.alibaba.fastjson.JSON;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.MiniProgramMetaData;
import com.alipay.iap.android.wallet.acl.payment.PaymentRequest;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentService;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.source.remote.tracker.MiniProgramMixpanelTracker;
import id.dana.domain.util.AlipayConnectUtils;
import id.dana.lib.gcontainer.GContainer;
import io.reactivex.Emitter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.whenAvailable;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b*\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0014R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R*\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010)"}, d2 = {"Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider;", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentService;", "Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider$MiniProgramPaymentCompletedMessageEvent;", "event", "", "onMiniProgramPaymentCompleted", "(Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider$MiniProgramPaymentCompletedMessageEvent;)V", "openMerchantCashier", "()V", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;", "paymentRequest", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "apiContext", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "callback", "pay", "(Lcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "paymentResult", "setPaymentResult", "(Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;)V", "setPaymentResultWithoutCallback", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lio/reactivex/Emitter;", "", "decodeEmitter", "Lio/reactivex/Emitter;", "getDecodeEmitter", "()Lio/reactivex/Emitter;", "setDecodeEmitter", "(Lio/reactivex/Emitter;)V", "Lid/dana/data/globalnetwork/source/remote/tracker/MiniProgramMixpanelTracker;", "miniProgramAnalyticTracker$delegate", "Lkotlin/Lazy;", "getMiniProgramAnalyticTracker", "()Lid/dana/data/globalnetwork/source/remote/tracker/MiniProgramMixpanelTracker;", "miniProgramAnalyticTracker", "Lid/dana/data/globalnetwork/model/PayRequest;", "paymentEmitter", "getPaymentEmitter", "setPaymentEmitter", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "<init>", "Companion", "MiniProgramPaymentCompletedMessageEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PaymentServiceProvider implements PaymentService {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 0;
    private static final String TAG = "[PaymentServiceProvider]";
    private Callback<PaymentResult> callback;
    private Emitter<String> decodeEmitter;

    /* renamed from: miniProgramAnalyticTracker$delegate  reason: from kotlin metadata */
    private final Lazy miniProgramAnalyticTracker = LazyKt.lazy(new Function0<MiniProgramMixpanelTracker>() { // from class: id.dana.data.globalnetwork.source.remote.PaymentServiceProvider$miniProgramAnalyticTracker$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MiniProgramMixpanelTracker invoke() {
            return new MiniProgramMixpanelTracker(GContainer.getApplicationContext());
        }
    });
    private Emitter<PayRequest> paymentEmitter;
    private PaymentResult paymentResult;

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        MyBillsEntityDataFactory();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return;
        }
        int length = r1.length;
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = new char[]{170, 11219, 22067, 33433, 44483, 55364, 1190, 12043, 23165, 34499, 45352};
        BuiltInFictitiousFunctionClassFactory = 6016350901179570195L;
    }

    @JvmStatic
    public static final PaymentServiceProvider getInstance() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        PaymentServiceProvider companion = INSTANCE.getInstance();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 6 : 'J') != 6) {
            return companion;
        }
        int i4 = 48 / 0;
        return companion;
    }

    @JvmName(name = "getDecodeEmitter")
    public final Emitter<String> getDecodeEmitter() {
        Emitter<String> emitter;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        PlaceComponentResult = i % 128;
        try {
            if (!(i % 2 != 0)) {
                emitter = this.decodeEmitter;
            } else {
                emitter = this.decodeEmitter;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = PlaceComponentResult + 31;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return emitter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setDecodeEmitter")
    public final void setDecodeEmitter(Emitter<String> emitter) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Object obj = null;
        this.decodeEmitter = emitter;
        if (z) {
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.dollar : '=') != '$') {
            return;
        }
        obj.hashCode();
    }

    @JvmName(name = "getPaymentEmitter")
    public final Emitter<PayRequest> getPaymentEmitter() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Emitter<PayRequest> emitter = this.paymentEmitter;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            try {
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 == 0) {
                    return emitter;
                }
                int i4 = 9 / 0;
                return emitter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setPaymentEmitter")
    public final void setPaymentEmitter(Emitter<PayRequest> emitter) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            this.paymentEmitter = emitter;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            this.paymentEmitter = emitter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getMiniProgramAnalyticTracker")
    private final MiniProgramMixpanelTracker getMiniProgramAnalyticTracker() {
        int i = PlaceComponentResult + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        MiniProgramMixpanelTracker miniProgramMixpanelTracker = (MiniProgramMixpanelTracker) this.miniProgramAnalyticTracker.getValue();
        int i3 = PlaceComponentResult + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return miniProgramMixpanelTracker;
        }
        Object obj = null;
        obj.hashCode();
        return miniProgramMixpanelTracker;
    }

    @Override // com.alipay.iap.android.wallet.acl.payment.PaymentService
    public final void pay(PaymentRequest paymentRequest, APIContext apiContext, Callback<PaymentResult> callback) {
        String str;
        Intrinsics.checkNotNullParameter(paymentRequest, "");
        Intrinsics.checkNotNullParameter(apiContext, "");
        Intrinsics.checkNotNullParameter(callback, "");
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        StringBuilder sb = new StringBuilder();
        sb.append("[PaymentServiceProvider] JSAPI tradePay() triggered, PaymentRequest => ");
        sb.append(JSON.toJSONString(paymentRequest));
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        authRequestContext.getAuthRequestContext.log(obj);
        this.callback = callback;
        String source = apiContext.getSource();
        Object[] objArr = new Object[1];
        a((-1) - MotionEvent.axisFromString(""), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 11, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 62377), objArr);
        boolean areEqual = Intrinsics.areEqual(source, ((String) objArr[0]).intern());
        if (!(areEqual ? false : true) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        }
        Emitter<PayRequest> emitter = this.paymentEmitter;
        if (emitter != null) {
            emitter.onNext(new PayRequest(areEqual, paymentRequest, callback));
        }
        Emitter<String> emitter2 = this.decodeEmitter;
        if (emitter2 != null) {
            emitter2.onComplete();
            int i3 = PlaceComponentResult + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        }
        MiniProgramMixpanelTracker miniProgramAnalyticTracker = getMiniProgramAnalyticTracker();
        MiniProgramMetaData miniProgramInfo = apiContext.getMiniProgramInfo();
        if (miniProgramInfo != null) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            str = miniProgramInfo.getAppId();
        } else {
            str = null;
            int i7 = PlaceComponentResult + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            int i8 = i7 % 2;
        }
        miniProgramAnalyticTracker.trackBindingSuccess(str);
    }

    public final void setPaymentResult(PaymentResult paymentResult) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(paymentResult, "");
        this.paymentResult = paymentResult;
        Callback<PaymentResult> callback = this.callback;
        if (callback == null) {
            int i3 = PlaceComponentResult + 95;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            callback = null;
        }
        try {
            callback.result(paymentResult);
        } catch (Exception e) {
            throw e;
        }
    }

    public final void setPaymentResultWithoutCallback(PaymentResult paymentResult) {
        int i = PlaceComponentResult + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(paymentResult, "");
        this.paymentResult = paymentResult;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Subscribe
    public final void onMiniProgramPaymentCompleted(MiniProgramPaymentCompletedMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        PaymentResult result = event.getResult();
        Object[] objArr = null;
        if (!(result == null)) {
            Callback<PaymentResult> callback = this.callback;
            if (!(callback != null)) {
                int i = PlaceComponentResult + 105;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? (char) 4 : 'G') != 4) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    objArr.hashCode();
                }
                int i2 = PlaceComponentResult + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                callback = null;
            }
            callback.result(result);
        }
        EventBus.getDefault().unregister(this);
        int i4 = PlaceComponentResult + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 == 0) {
            int length = objArr.length;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider$MiniProgramPaymentCompletedMessageEvent;", "", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "result", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "getResult", "()Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "<init>", "(Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MiniProgramPaymentCompletedMessageEvent {
        private final PaymentResult result;

        public MiniProgramPaymentCompletedMessageEvent(PaymentResult paymentResult) {
            this.result = paymentResult;
        }

        @JvmName(name = "getResult")
        public final PaymentResult getResult() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider$Companion;", "", "Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider;", "getInstance", "()Lid/dana/data/globalnetwork/source/remote/PaymentServiceProvider;", "", "TAG", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentServiceProvider getInstance() {
            try {
                BaseService service = WalletServiceManager.getInstance().getService(PaymentService.class);
                if (service != null) {
                    return (PaymentServiceProvider) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.data.globalnetwork.source.remote.PaymentServiceProvider");
            } catch (Exception unused) {
                AlipayConnectUtils alipayConnectUtils = AlipayConnectUtils.INSTANCE;
                boolean z = true;
                try {
                    WalletServiceManager.getInstance().registerServices(PaymentServiceProvider.class);
                } catch (Exception unused2) {
                    z = false;
                }
                if (z) {
                    return getInstance();
                }
                return null;
            }
        }
    }

    public final void openMerchantCashier() {
        int i = PlaceComponentResult + 87;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Callback<PaymentResult> callback = this.callback;
        if (!(callback != null)) {
            int i3 = PlaceComponentResult + 119;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            callback = null;
        }
        try {
            callback.result(this.paymentResult);
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            StringBuilder sb = new StringBuilder();
            sb.append("[PaymentServiceProvider] openMerchantCashier() -> PaymentResult => ");
            sb.append(JSON.toJSONString(this.paymentResult));
            String obj = sb.toString();
            Intrinsics.checkNotNullParameter(obj, "");
            authRequestContext.getAuthRequestContext.log(obj);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 71;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            try {
                int i5 = $10 + 9;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            try {
                if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                    String str = new String(cArr);
                    int i7 = $10 + 21;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    objArr[0] = str;
                    return;
                }
                int i9 = $10 + 69;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
