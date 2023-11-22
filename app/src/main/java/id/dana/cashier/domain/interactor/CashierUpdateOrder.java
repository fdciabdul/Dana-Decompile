package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierUpdateOrderRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/CashierUpdateOrder;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/utils/rpc/response/DefaultResponse;", "Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierUpdateOrder extends BaseUseCase<DefaultResponse, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public CashierUpdateOrder(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<DefaultResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.updateOrder(params.getUpdateOrderRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;", "", "Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "updateOrderRequest", "Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "getUpdateOrderRequest", "()Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "<init>", "(Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CashierUpdateOrderRequest updateOrderRequest;

        public /* synthetic */ Params(CashierUpdateOrderRequest cashierUpdateOrderRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierUpdateOrderRequest);
        }

        @JvmStatic
        public static final Params createUpdateOrderRequest(CashierUpdateOrderRequest cashierUpdateOrderRequest) {
            return INSTANCE.createUpdateOrderRequest(cashierUpdateOrderRequest);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params$Companion;", "", "Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "updateOrderRequest", "Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;", "createUpdateOrderRequest", "(Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;)Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createUpdateOrderRequest(CashierUpdateOrderRequest updateOrderRequest) {
                Intrinsics.checkNotNullParameter(updateOrderRequest, "");
                return new Params(updateOrderRequest, null);
            }
        }

        private Params(CashierUpdateOrderRequest cashierUpdateOrderRequest) {
            this.updateOrderRequest = cashierUpdateOrderRequest;
        }

        @JvmName(name = "getUpdateOrderRequest")
        public final CashierUpdateOrderRequest getUpdateOrderRequest() {
            return this.updateOrderRequest;
        }
    }
}
