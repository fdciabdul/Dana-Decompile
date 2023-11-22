package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.reactive.ReactiveFlowKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/CreateCashierAgreementFlow;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "param", "Lkotlinx/coroutines/flow/Flow;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement;", "createCashierAgreement", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement;", "<init>", "(Lid/dana/cashier/domain/interactor/CreateCashierAgreement;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateCashierAgreementFlow extends BaseFlowUseCase<CreateCashierAgreement.Params, CashierAgreementResponse> {
    private final CreateCashierAgreement createCashierAgreement;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CreateCashierAgreementFlow(id.dana.cashier.domain.interactor.CreateCashierAgreement r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.createCashierAgreement = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.domain.interactor.CreateCashierAgreementFlow.<init>(id.dana.cashier.domain.interactor.CreateCashierAgreement):void");
    }

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final Flow<CashierAgreementResponse> buildUseCase(CreateCashierAgreement.Params param) {
        Intrinsics.checkNotNullParameter(param, "");
        Flowable<CashierAgreementResponse> flowable = this.createCashierAgreement.buildUseCase(param).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "");
        return ReactiveFlowKt.asFlow(flowable);
    }
}
