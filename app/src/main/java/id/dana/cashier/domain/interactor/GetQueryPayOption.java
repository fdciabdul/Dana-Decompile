package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.QueryPayOptionInfoRequest;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryPayOption;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQueryPayOption extends BaseUseCase<CashierPay, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public GetQueryPayOption(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierPay> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.getQueryPayOption(params.getQueryPayOptionInfoRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params;", "", "Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "queryPayOptionInfoRequest", "Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "getQueryPayOptionInfoRequest$feature_cashier_productionRelease", "()Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "<init>", "(Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final QueryPayOptionInfoRequest queryPayOptionInfoRequest;

        public /* synthetic */ Params(QueryPayOptionInfoRequest queryPayOptionInfoRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(queryPayOptionInfoRequest);
        }

        @JvmStatic
        public static final Params createQueryPayOptionRequest(String str, List<String> list) {
            return INSTANCE.createQueryPayOptionRequest(str, list);
        }

        private Params(QueryPayOptionInfoRequest queryPayOptionInfoRequest) {
            this.queryPayOptionInfoRequest = queryPayOptionInfoRequest;
        }

        @JvmName(name = "getQueryPayOptionInfoRequest$feature_cashier_productionRelease")
        /* renamed from: getQueryPayOptionInfoRequest$feature_cashier_productionRelease  reason: from getter */
        public final QueryPayOptionInfoRequest getQueryPayOptionInfoRequest() {
            return this.queryPayOptionInfoRequest;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params$Companion;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "", "disablePayMethod", "Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params;", "createQueryPayOptionRequest", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/cashier/domain/interactor/GetQueryPayOption$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createQueryPayOptionRequest(String cashierOrderId, List<String> disablePayMethod) {
                Intrinsics.checkNotNullParameter(cashierOrderId, "");
                return new Params(new QueryPayOptionInfoRequest(cashierOrderId, disablePayMethod), null);
            }
        }
    }
}
