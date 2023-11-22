package id.dana.domain.expresspurchase.interaction;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.OrderQueryResult;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;", "Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DealsExpressOrderQueryByCondition extends BaseUseCase<OrderQueryResult, Param> {
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public DealsExpressOrderQueryByCondition(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition$Param;", "", "", "acquirementId", "Ljava/lang/String;", "getAcquirementId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final String acquirementId;

        public Param(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.acquirementId = str;
        }

        @JvmName(name = "getAcquirementId")
        public final String getAcquirementId() {
            return this.acquirementId;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<OrderQueryResult> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.expressPurchaseRepository.orderQueryByCondition(params.getAcquirementId(), CollectionsKt.listOf((Object[]) new String[]{"ORDER_BASE_INFO", "ORDER_EXT_INFO", "ORDER_PAY_INFO", "ORDER_AMOUNT_INFO"}));
    }
}
