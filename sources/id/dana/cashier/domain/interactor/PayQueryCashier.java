package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/PayQueryCashier;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/domain/interactor/PayQueryCashier$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/PayQueryCashier$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayQueryCashier extends BaseUseCase<CashierPay, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public PayQueryCashier(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierPay> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.getIsReload()) {
            Long delay = params.getDelay();
            Observable flatMap = Observable.timer(delay != null ? delay.longValue() : 1000L, TimeUnit.MILLISECONDS).flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.PayQueryCashier$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m587buildUseCase$lambda0;
                    m587buildUseCase$lambda0 = PayQueryCashier.m587buildUseCase$lambda0(PayQueryCashier.this, params, (Long) obj);
                    return m587buildUseCase$lambda0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        return CashierRepository.CC.payCashier$default(this.cashierRepository, params.getCashierPayRequest(), params.getIsGpsActive(), null, 4, null);
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final ObservableSource m587buildUseCase$lambda0(PayQueryCashier payQueryCashier, Params params, Long l) {
        Intrinsics.checkNotNullParameter(payQueryCashier, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(l, "");
        return CashierRepository.CC.payCashier$default(payQueryCashier.cashierRepository, params.getCashierPayRequest(), params.getIsGpsActive(), null, 4, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B-\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/cashier/domain/interactor/PayQueryCashier$Params;", "", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierPayRequest", "Lid/dana/cashier/domain/model/CashierPayRequest;", "getCashierPayRequest", "()Lid/dana/cashier/domain/model/CashierPayRequest;", "", "delay", "Ljava/lang/Long;", "getDelay", "()Ljava/lang/Long;", "", "isGpsActive", "Z", "()Z", "isReload", "<init>", "(Lid/dana/cashier/domain/model/CashierPayRequest;ZZLjava/lang/Long;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CashierPayRequest cashierPayRequest;
        private final Long delay;
        private final boolean isGpsActive;
        private final boolean isReload;

        public /* synthetic */ Params(CashierPayRequest cashierPayRequest, boolean z, boolean z2, Long l, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierPayRequest, z, z2, l);
        }

        @JvmStatic
        public static final Params createPayQueryRequest(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2, String str8, Long l) {
            return INSTANCE.createPayQueryRequest(str, str2, str3, str4, str5, z, str6, str7, z2, str8, l);
        }

        private Params(CashierPayRequest cashierPayRequest, boolean z, boolean z2, Long l) {
            this.cashierPayRequest = cashierPayRequest;
            this.isGpsActive = z;
            this.isReload = z2;
            this.delay = l;
        }

        /* synthetic */ Params(CashierPayRequest cashierPayRequest, boolean z, boolean z2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierPayRequest, z, z2, (i & 8) != 0 ? null : l);
        }

        @JvmName(name = "getCashierPayRequest")
        public final CashierPayRequest getCashierPayRequest() {
            return this.cashierPayRequest;
        }

        @JvmName(name = "getDelay")
        public final Long getDelay() {
            return this.delay;
        }

        @JvmName(name = "isGpsActive")
        /* renamed from: isGpsActive  reason: from getter */
        public final boolean getIsGpsActive() {
            return this.isGpsActive;
        }

        @JvmName(name = "isReload")
        /* renamed from: isReload  reason: from getter */
        public final boolean getIsReload() {
            return this.isReload;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u008b\u0001\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/cashier/domain/interactor/PayQueryCashier$Params$Companion;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "validateData", CashierKeyParams.VERIFICATION_METHOD, "inUrl", "method", "", "isGpsActive", "oneklikDeviceId", "bizOrderId", "isReload", "cashierRequestId", "", "delay", "Lid/dana/cashier/domain/interactor/PayQueryCashier$Params;", "createPayQueryRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)Lid/dana/cashier/domain/interactor/PayQueryCashier$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params createPayQueryRequest$default(Companion companion, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2, String str8, Long l, int i, Object obj) {
                return companion.createPayQueryRequest(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, z, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : l);
            }

            /* JADX WARN: Type inference failed for: r11v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @JvmStatic
            public final Params createPayQueryRequest(String r51, String validateData, String r53, String inUrl, String method, boolean isGpsActive, String oneklikDeviceId, String bizOrderId, boolean isReload, String cashierRequestId, Long delay) {
                String str = oneklikDeviceId;
                if (str == null || str.length() == 0) {
                    String str2 = method;
                    ?? r11 = 0;
                    return new Params(new CashierPayRequest(str2 == null || str2.length() == 0 ? "payQuery" : method, null, r51, null, null, null, r11, null, null, null, null, null, null, null, null, null, null, null, validateData, cashierRequestId, null, null, null, null, null, null, null, null, null, r53, null, null, null, null, inUrl, null, null, null, null, null, null, bizOrderId, -537657350, 507, null), isGpsActive, isReload, delay, r11);
                }
                String str3 = method;
                ?? r7 = 0;
                return new Params(new CashierPayRequest(str3 == null || str3.length() == 0 ? "payQuery" : method, null, r51, null, null, null, r7, null, null, null, null, null, null, null, null, null, oneklikDeviceId, null, validateData, cashierRequestId, null, null, null, null, null, null, null, null, null, r53, null, null, null, null, inUrl, null, null, null, null, null, null, bizOrderId, -537722886, 507, null), isGpsActive, isReload, delay, r7);
            }
        }
    }
}
