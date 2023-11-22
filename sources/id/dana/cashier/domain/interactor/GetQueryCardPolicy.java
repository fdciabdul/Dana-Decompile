package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.QueryCardPolicy;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryCardPolicy;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQueryCardPolicy extends BaseUseCase<QueryCardPolicyInfo, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public GetQueryCardPolicy(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QueryCardPolicyInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.getQueryCardPolicyByCardNo(params.getQueryCardPolicy());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params;", "", "Lid/dana/cashier/domain/model/QueryCardPolicy;", "queryCardPolicy", "Lid/dana/cashier/domain/model/QueryCardPolicy;", "getQueryCardPolicy$feature_cashier_productionRelease", "()Lid/dana/cashier/domain/model/QueryCardPolicy;", "<init>", "(Lid/dana/cashier/domain/model/QueryCardPolicy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String PAYMENT_ACTION = "PAYMENT";
        private final QueryCardPolicy queryCardPolicy;

        public /* synthetic */ Params(QueryCardPolicy queryCardPolicy, DefaultConstructorMarker defaultConstructorMarker) {
            this(queryCardPolicy);
        }

        @JvmStatic
        public static final Params createQueryCardPolicy(String str, String str2, String str3) {
            return INSTANCE.createQueryCardPolicy(str, str2, str3);
        }

        private Params(QueryCardPolicy queryCardPolicy) {
            this.queryCardPolicy = queryCardPolicy;
        }

        @JvmName(name = "getQueryCardPolicy$feature_cashier_productionRelease")
        /* renamed from: getQueryCardPolicy$feature_cashier_productionRelease  reason: from getter */
        public final QueryCardPolicy getQueryCardPolicy() {
            return this.queryCardPolicy;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params$Companion;", "", "", "action", CashierKeyParams.CASHIER_ORDER_ID, "prefixCardNo", "Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params;", "createQueryCardPolicy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/interactor/GetQueryCardPolicy$Params;", "PAYMENT_ACTION", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params createQueryCardPolicy$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = "PAYMENT";
                }
                return companion.createQueryCardPolicy(str, str2, str3);
            }

            @JvmStatic
            public final Params createQueryCardPolicy(String action, String cashierOrderId, String prefixCardNo) {
                return new Params(new QueryCardPolicy(action, cashierOrderId, prefixCardNo), null);
            }
        }
    }
}
