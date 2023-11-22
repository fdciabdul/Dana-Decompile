package id.dana.domain.cancelsurvey.interactor;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.cancelsurvey.model.CancelReason;
import id.dana.domain.cancelsurvey.model.CancellationSurveyConfig;
import id.dana.domain.cancelsurvey.model.CancellationSurveyReason;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "config", "consultCancelReasons", "(Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;)Lio/reactivex/Observable;", "", "Lid/dana/domain/cancelsurvey/model/CancelReason;", "reasons", "createCancellationSurveyReason", "(Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;Ljava/util/List;)Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "noSurvey", "()Lio/reactivex/Observable;", "Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "repository", "Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "<init>", "(Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultCancelSurveyReason extends BaseUseCase<CancellationSurveyReason, Params> {
    private final CancelSurveyRepository repository;

    @Inject
    public ConsultCancelSurveyReason(CancelSurveyRepository cancelSurveyRepository) {
        Intrinsics.checkNotNullParameter(cancelSurveyRepository, "");
        this.repository = cancelSurveyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CancellationSurveyReason> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.repository.fetchCancelSurveyReasonConfig(params.getScenario()).flatMap(new Function() { // from class: id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2250buildUseCase$lambda0;
                m2250buildUseCase$lambda0 = ConsultCancelSurveyReason.m2250buildUseCase$lambda0(ConsultCancelSurveyReason.this, params, (CancellationSurveyConfig) obj);
                return m2250buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2250buildUseCase$lambda0(ConsultCancelSurveyReason consultCancelSurveyReason, Params params, CancellationSurveyConfig cancellationSurveyConfig) {
        Observable<CancellationSurveyReason> noSurvey;
        Intrinsics.checkNotNullParameter(consultCancelSurveyReason, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(cancellationSurveyConfig, "");
        if (cancellationSurveyConfig.getEnable()) {
            noSurvey = consultCancelSurveyReason.consultCancelReasons(params, cancellationSurveyConfig);
        } else {
            noSurvey = consultCancelSurveyReason.noSurvey();
        }
        return noSurvey;
    }

    private final Observable<CancellationSurveyReason> consultCancelReasons(Params params, final CancellationSurveyConfig config) {
        Observable map = this.repository.consultCancelSurveyReason(params.getCashierOrderId(), params.getScenario(), params.getGoodsId()).map(new Function() { // from class: id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CancellationSurveyReason m2251consultCancelReasons$lambda1;
                m2251consultCancelReasons$lambda1 = ConsultCancelSurveyReason.m2251consultCancelReasons$lambda1(ConsultCancelSurveyReason.this, config, (List) obj);
                return m2251consultCancelReasons$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultCancelReasons$lambda-1  reason: not valid java name */
    public static final CancellationSurveyReason m2251consultCancelReasons$lambda1(ConsultCancelSurveyReason consultCancelSurveyReason, CancellationSurveyConfig cancellationSurveyConfig, List list) {
        Intrinsics.checkNotNullParameter(consultCancelSurveyReason, "");
        Intrinsics.checkNotNullParameter(cancellationSurveyConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            return CancellationSurveyReason.INSTANCE.noSurvey();
        }
        return consultCancelSurveyReason.createCancellationSurveyReason(cancellationSurveyConfig, list);
    }

    private final CancellationSurveyReason createCancellationSurveyReason(CancellationSurveyConfig config, List<CancelReason> reasons) {
        return new CancellationSurveyReason(true, config.getHeaderLabel(), reasons, config.getCtaLabel());
    }

    private final Observable<CancellationSurveyReason> noSurvey() {
        Observable<CancellationSurveyReason> just = Observable.just(CancellationSurveyReason.INSTANCE.noSurvey());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId$domain_productionRelease", "()Ljava/lang/String;", "goodsId", "getGoodsId$domain_productionRelease", "scenario", "getScenario$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params$Companion;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "goodsId", "Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;", "createParamsFromExpressPurchase", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
