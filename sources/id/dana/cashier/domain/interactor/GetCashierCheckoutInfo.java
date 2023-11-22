package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "Lid/dana/domain/investment/InvestmentRepository;", "investmentRepository", "Lid/dana/domain/investment/InvestmentRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;Lid/dana/domain/investment/InvestmentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCashierCheckoutInfo extends BaseUseCase<CashierPay, Params> {
    private final CashierRepository cashierRepository;
    private final InvestmentRepository investmentRepository;

    @Inject
    public GetCashierCheckoutInfo(CashierRepository cashierRepository, InvestmentRepository investmentRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        Intrinsics.checkNotNullParameter(investmentRepository, "");
        this.cashierRepository = cashierRepository;
        this.investmentRepository = investmentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierPay> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<CashierPay> zip = Observable.zip(CashierRepository.CC.payCashier$default(this.cashierRepository, params.getCashierPayRequest(), params.getIsGpsActive(), null, 4, null), this.investmentRepository.getDanaPlusMethodConfig(), new BiFunction() { // from class: id.dana.cashier.domain.interactor.GetCashierCheckoutInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CashierPay m574buildUseCase$lambda0;
                m574buildUseCase$lambda0 = GetCashierCheckoutInfo.m574buildUseCase$lambda0((CashierPay) obj, (DanaPlusMethodConfig) obj2);
                return m574buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final CashierPay m574buildUseCase$lambda0(CashierPay cashierPay, DanaPlusMethodConfig danaPlusMethodConfig) {
        Intrinsics.checkNotNullParameter(cashierPay, "");
        Intrinsics.checkNotNullParameter(danaPlusMethodConfig, "");
        cashierPay.setDanaPlusMethodConfig(danaPlusMethodConfig);
        return cashierPay;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;", "", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierPayRequest", "Lid/dana/cashier/domain/model/CashierPayRequest;", "getCashierPayRequest$feature_cashier_productionRelease", "()Lid/dana/cashier/domain/model/CashierPayRequest;", "", "isGpsActive", "Z", "()Z", "setGpsActive", "(Z)V", "<init>", "(Lid/dana/cashier/domain/model/CashierPayRequest;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CashierPayRequest cashierPayRequest;
        private boolean isGpsActive;

        public /* synthetic */ Params(CashierPayRequest cashierPayRequest, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierPayRequest, z);
        }

        @JvmStatic
        public static final Params createCashierMainRequest(CashierPayRequest cashierPayRequest, boolean z) {
            return INSTANCE.createCashierMainRequest(cashierPayRequest, z);
        }

        private Params(CashierPayRequest cashierPayRequest, boolean z) {
            this.cashierPayRequest = cashierPayRequest;
            this.isGpsActive = z;
        }

        @JvmName(name = "getCashierPayRequest$feature_cashier_productionRelease")
        /* renamed from: getCashierPayRequest$feature_cashier_productionRelease  reason: from getter */
        public final CashierPayRequest getCashierPayRequest() {
            return this.cashierPayRequest;
        }

        @JvmName(name = "isGpsActive")
        /* renamed from: isGpsActive  reason: from getter */
        public final boolean getIsGpsActive() {
            return this.isGpsActive;
        }

        @JvmName(name = "setGpsActive")
        public final void setGpsActive(boolean z) {
            this.isGpsActive = z;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params$Companion;", "", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierRequestModel", "", "isGpsActive", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;", "createCashierMainRequest", "(Lid/dana/cashier/domain/model/CashierPayRequest;Z)Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createCashierMainRequest(CashierPayRequest cashierRequestModel, boolean isGpsActive) {
                Intrinsics.checkNotNullParameter(cashierRequestModel, "");
                return new Params(cashierRequestModel, isGpsActive, null);
            }
        }
    }
}
