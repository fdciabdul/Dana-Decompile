package id.dana.domain.cancelsurvey.interactor;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "repository", "Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "<init>", "(Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitCancelSurveyReason extends BaseUseCase<Boolean, Params> {
    private final CancelSurveyRepository repository;

    @Inject
    public SubmitCancelSurveyReason(CancelSurveyRepository cancelSurveyRepository) {
        Intrinsics.checkNotNullParameter(cancelSurveyRepository, "");
        this.repository = cancelSurveyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.repository.submitCancelReason(params.getCashierOrderId(), params.getScenario(), params.getGoodsId());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId$domain_productionRelease", "()Ljava/lang/String;", "goodsId", "getGoodsId$domain_productionRelease", "scenario", "getScenario$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cashierOrderId;
        private final String goodsId;
        private final String scenario;

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.cashierOrderId = str;
            this.scenario = str2;
            this.goodsId = str3;
        }

        @JvmName(name = "getCashierOrderId$domain_productionRelease")
        /* renamed from: getCashierOrderId$domain_productionRelease  reason: from getter */
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        @JvmName(name = "getScenario$domain_productionRelease")
        /* renamed from: getScenario$domain_productionRelease  reason: from getter */
        public final String getScenario() {
            return this.scenario;
        }

        @JvmName(name = "getGoodsId$domain_productionRelease")
        /* renamed from: getGoodsId$domain_productionRelease  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params$Companion;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "goodsId", "Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params;", "createParamsFromExpressPurchase", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params createParamsFromExpressPurchase(String cashierOrderId, String goodsId) {
                Intrinsics.checkNotNullParameter(cashierOrderId, "");
                Intrinsics.checkNotNullParameter(goodsId, "");
                return new Params(cashierOrderId, "express_purchase", goodsId);
            }
        }
    }
}
