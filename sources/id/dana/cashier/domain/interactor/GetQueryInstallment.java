package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.MixPayMethod;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.cashier.domain.model.paylater.QueryInstallmentRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryInstallment;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "getPaylaterAgreementConfig", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "", "consultAgreementThrowable", "Ljava/lang/Throwable;", "Lid/dana/domain/paylater/PaylaterRepository;", "paylaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;Lid/dana/domain/useragreement/UserConsentRepository;Lid/dana/domain/paylater/PaylaterRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQueryInstallment extends BaseUseCase<QueryInstallment, Params> {
    private final CashierRepository cashierRepository;
    private Throwable consultAgreementThrowable;
    private final PaylaterRepository paylaterRepository;
    private final UserConsentRepository userConsentRepository;

    @Inject
    public GetQueryInstallment(CashierRepository cashierRepository, UserConsentRepository userConsentRepository, PaylaterRepository paylaterRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        this.cashierRepository = cashierRepository;
        this.userConsentRepository = userConsentRepository;
        this.paylaterRepository = paylaterRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QueryInstallment> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = getPaylaterAgreementConfig(params).flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.GetQueryInstallment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m583buildUseCase$lambda3;
                m583buildUseCase$lambda3 = GetQueryInstallment.m583buildUseCase$lambda3(GetQueryInstallment.this, params, (PaylaterAgreementConfig) obj);
                return m583buildUseCase$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: buildUseCase$lambda-3 */
    public static final ObservableSource m583buildUseCase$lambda3(final GetQueryInstallment getQueryInstallment, Params params, final PaylaterAgreementConfig paylaterAgreementConfig) {
        Intrinsics.checkNotNullParameter(getQueryInstallment, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(paylaterAgreementConfig, "");
        return Observable.zip(getQueryInstallment.cashierRepository.getQueryInstallment(params.getQueryInstallmentRequest()), getQueryInstallment.userConsentRepository.consultAgreement(paylaterAgreementConfig.getSpaceCodes(), Boolean.TRUE).onErrorReturn(new Function() { // from class: id.dana.cashier.domain.interactor.GetQueryInstallment$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultAgreementResponse m584buildUseCase$lambda3$lambda0;
                m584buildUseCase$lambda3$lambda0 = GetQueryInstallment.m584buildUseCase$lambda3$lambda0(GetQueryInstallment.this, (Throwable) obj);
                return m584buildUseCase$lambda3$lambda0;
            }
        }), new BiFunction() { // from class: id.dana.cashier.domain.interactor.GetQueryInstallment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                QueryInstallment m585buildUseCase$lambda3$lambda2;
                m585buildUseCase$lambda3$lambda2 = GetQueryInstallment.m585buildUseCase$lambda3$lambda2(PaylaterAgreementConfig.this, getQueryInstallment, (QueryInstallment) obj, (ConsultAgreementResponse) obj2);
                return m585buildUseCase$lambda3$lambda2;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* renamed from: buildUseCase$lambda-3$lambda-0 */
    public static final ConsultAgreementResponse m584buildUseCase$lambda3$lambda0(GetQueryInstallment getQueryInstallment, Throwable th) {
        Intrinsics.checkNotNullParameter(getQueryInstallment, "");
        Intrinsics.checkNotNullParameter(th, "");
        getQueryInstallment.consultAgreementThrowable = th;
        ?? r3 = 0;
        return new ConsultAgreementResponse(false, r3, 2, r3);
    }

    /* renamed from: buildUseCase$lambda-3$lambda-2 */
    public static final QueryInstallment m585buildUseCase$lambda3$lambda2(PaylaterAgreementConfig paylaterAgreementConfig, GetQueryInstallment getQueryInstallment, QueryInstallment queryInstallment, ConsultAgreementResponse consultAgreementResponse) {
        Intrinsics.checkNotNullParameter(paylaterAgreementConfig, "");
        Intrinsics.checkNotNullParameter(getQueryInstallment, "");
        Intrinsics.checkNotNullParameter(queryInstallment, "");
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        queryInstallment.setPaylaterAgreementEnable(Boolean.valueOf(paylaterAgreementConfig.getEnable()));
        queryInstallment.setConsultAgreement(consultAgreementResponse);
        queryInstallment.setConsultAgreementError(getQueryInstallment.consultAgreementThrowable);
        return queryInstallment;
    }

    private final Observable<PaylaterAgreementConfig> getPaylaterAgreementConfig(Params params) {
        if (!Intrinsics.areEqual(params.getQueryInstallmentRequest().getPayMethod(), PayMethod.LOAN_CREDIT)) {
            MixPayMethod mixPayMethod = params.getQueryInstallmentRequest().getMixPayMethod();
            if (!Intrinsics.areEqual(mixPayMethod != null ? mixPayMethod.getPayMethod() : null, PayMethod.LOAN_CREDIT)) {
                return this.cashierRepository.getPaylaterAgreementConfig();
            }
        }
        Observable flatMap = this.paylaterRepository.getPaylaterCicilConfig().flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.GetQueryInstallment$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m586getPaylaterAgreementConfig$lambda4;
                m586getPaylaterAgreementConfig$lambda4 = GetQueryInstallment.m586getPaylaterAgreementConfig$lambda4((PaylaterCicilMethodConfig) obj);
                return m586getPaylaterAgreementConfig$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getPaylaterAgreementConfig$lambda-4 */
    public static final ObservableSource m586getPaylaterAgreementConfig$lambda4(PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        return Observable.just(new PaylaterAgreementConfig(true, paylaterCicilMethodConfig.getTncSpaceCode()));
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "", "Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "queryInstallmentRequest", "Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "getQueryInstallmentRequest", "()Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "<init>", "(Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final QueryInstallmentRequest queryInstallmentRequest;

        public /* synthetic */ Params(QueryInstallmentRequest queryInstallmentRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(queryInstallmentRequest);
        }

        @JvmStatic
        public static final Params createQueryInstallmentRequest(QueryInstallmentRequest queryInstallmentRequest) {
            return INSTANCE.createQueryInstallmentRequest(queryInstallmentRequest);
        }

        private Params(QueryInstallmentRequest queryInstallmentRequest) {
            this.queryInstallmentRequest = queryInstallmentRequest;
        }

        @JvmName(name = "getQueryInstallmentRequest")
        public final QueryInstallmentRequest getQueryInstallmentRequest() {
            return this.queryInstallmentRequest;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params$Companion;", "", "Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "queryInstallmentRequest", "Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "createQueryInstallmentRequest", "(Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;)Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createQueryInstallmentRequest(QueryInstallmentRequest queryInstallmentRequest) {
                Intrinsics.checkNotNullParameter(queryInstallmentRequest, "");
                return new Params(queryInstallmentRequest, null);
            }
        }
    }
}
