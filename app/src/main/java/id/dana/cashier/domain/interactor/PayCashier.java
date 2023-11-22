package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.paylater.PaylaterCashierPayRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/PayCashier;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/domain/interactor/PayCashier$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/PayCashier$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayCashier extends BaseUseCase<CashierPay, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public PayCashier(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierPay> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.payCashier(params.getCashierPayRequest(), params.getIsGpsActive(), params.getPaylaterCashierPayRequest());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/domain/interactor/PayCashier$Params;", "", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierPayRequest", "Lid/dana/cashier/domain/model/CashierPayRequest;", "getCashierPayRequest", "()Lid/dana/cashier/domain/model/CashierPayRequest;", "", "isGpsActive", "Z", "()Z", "Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "paylaterCashierPayRequest", "Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "getPaylaterCashierPayRequest", "()Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "<init>", "(Lid/dana/cashier/domain/model/CashierPayRequest;ZLid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CashierPayRequest cashierPayRequest;
        private final boolean isGpsActive;
        private final PaylaterCashierPayRequest paylaterCashierPayRequest;

        public /* synthetic */ Params(CashierPayRequest cashierPayRequest, boolean z, PaylaterCashierPayRequest paylaterCashierPayRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierPayRequest, z, paylaterCashierPayRequest);
        }

        @JvmStatic
        public static final Params createPayCashierRequest(CashierPayRequest cashierPayRequest, boolean z, PaylaterCashierPayRequest paylaterCashierPayRequest) {
            return INSTANCE.createPayCashierRequest(cashierPayRequest, z, paylaterCashierPayRequest);
        }

        private Params(CashierPayRequest cashierPayRequest, boolean z, PaylaterCashierPayRequest paylaterCashierPayRequest) {
            this.cashierPayRequest = cashierPayRequest;
            this.isGpsActive = z;
            this.paylaterCashierPayRequest = paylaterCashierPayRequest;
        }

        @JvmName(name = "getCashierPayRequest")
        public final CashierPayRequest getCashierPayRequest() {
            return this.cashierPayRequest;
        }

        @JvmName(name = "isGpsActive")
        /* renamed from: isGpsActive  reason: from getter */
        public final boolean getIsGpsActive() {
            return this.isGpsActive;
        }

        @JvmName(name = "getPaylaterCashierPayRequest")
        public final PaylaterCashierPayRequest getPaylaterCashierPayRequest() {
            return this.paylaterCashierPayRequest;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/PayCashier$Params$Companion;", "", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierPayRequest", "", "isGpsActive", "Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "paylaterCashierPayRequest", "Lid/dana/cashier/domain/interactor/PayCashier$Params;", "createPayCashierRequest", "(Lid/dana/cashier/domain/model/CashierPayRequest;ZLid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;)Lid/dana/cashier/domain/interactor/PayCashier$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params createPayCashierRequest$default(Companion companion, CashierPayRequest cashierPayRequest, boolean z, PaylaterCashierPayRequest paylaterCashierPayRequest, int i, Object obj) {
                if ((i & 4) != 0) {
                    paylaterCashierPayRequest = null;
                }
                return companion.createPayCashierRequest(cashierPayRequest, z, paylaterCashierPayRequest);
            }

            @JvmStatic
            public final Params createPayCashierRequest(CashierPayRequest cashierPayRequest, boolean isGpsActive, PaylaterCashierPayRequest paylaterCashierPayRequest) {
                Intrinsics.checkNotNullParameter(cashierPayRequest, "");
                return new Params(cashierPayRequest, isGpsActive, paylaterCashierPayRequest, null);
            }
        }
    }
}
