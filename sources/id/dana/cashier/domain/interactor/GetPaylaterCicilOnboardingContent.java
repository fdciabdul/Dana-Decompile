package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.model.paylater.PaylaterOnboardingContent;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/domain/interactor/GetPaylaterCicilOnboardingContent;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/paylater/PaylaterOnboardingContent;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "", "consultAgreementError", "Ljava/lang/Throwable;", "Lid/dana/domain/paylater/PaylaterRepository;", "paylaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;Lid/dana/domain/paylater/PaylaterRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPaylaterCicilOnboardingContent extends BaseUseCase<PaylaterOnboardingContent, NoParams> {
    private Throwable consultAgreementError;
    private final PaylaterRepository paylaterRepository;
    private final UserConsentRepository userConsentRepository;

    @Inject
    public GetPaylaterCicilOnboardingContent(UserConsentRepository userConsentRepository, PaylaterRepository paylaterRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        this.userConsentRepository = userConsentRepository;
        this.paylaterRepository = paylaterRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PaylaterOnboardingContent> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.paylaterRepository.getPaylaterCicilConfig().flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m578buildUseCase$lambda2;
                m578buildUseCase$lambda2 = GetPaylaterCicilOnboardingContent.m578buildUseCase$lambda2(GetPaylaterCicilOnboardingContent.this, (PaylaterCicilMethodConfig) obj);
                return m578buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m578buildUseCase$lambda2(final GetPaylaterCicilOnboardingContent getPaylaterCicilOnboardingContent, final PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Intrinsics.checkNotNullParameter(getPaylaterCicilOnboardingContent, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        return getPaylaterCicilOnboardingContent.userConsentRepository.consultAgreement(paylaterCicilMethodConfig.getTncSpaceCode(), Boolean.TRUE).onErrorReturn(new Function() { // from class: id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultAgreementResponse m579buildUseCase$lambda2$lambda0;
                m579buildUseCase$lambda2$lambda0 = GetPaylaterCicilOnboardingContent.m579buildUseCase$lambda2$lambda0(GetPaylaterCicilOnboardingContent.this, (Throwable) obj);
                return m579buildUseCase$lambda2$lambda0;
            }
        }).map(new Function() { // from class: id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PaylaterOnboardingContent m580buildUseCase$lambda2$lambda1;
                m580buildUseCase$lambda2$lambda1 = GetPaylaterCicilOnboardingContent.m580buildUseCase$lambda2$lambda1(GetPaylaterCicilOnboardingContent.this, paylaterCicilMethodConfig, (ConsultAgreementResponse) obj);
                return m580buildUseCase$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* renamed from: buildUseCase$lambda-2$lambda-0  reason: not valid java name */
    public static final ConsultAgreementResponse m579buildUseCase$lambda2$lambda0(GetPaylaterCicilOnboardingContent getPaylaterCicilOnboardingContent, Throwable th) {
        Intrinsics.checkNotNullParameter(getPaylaterCicilOnboardingContent, "");
        Intrinsics.checkNotNullParameter(th, "");
        getPaylaterCicilOnboardingContent.consultAgreementError = th;
        ?? r3 = 0;
        return new ConsultAgreementResponse(false, r3, 2, r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final PaylaterOnboardingContent m580buildUseCase$lambda2$lambda1(GetPaylaterCicilOnboardingContent getPaylaterCicilOnboardingContent, PaylaterCicilMethodConfig paylaterCicilMethodConfig, ConsultAgreementResponse consultAgreementResponse) {
        Intrinsics.checkNotNullParameter(getPaylaterCicilOnboardingContent, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        return new PaylaterOnboardingContent(consultAgreementResponse, getPaylaterCicilOnboardingContent.consultAgreementError, paylaterCicilMethodConfig.getOnBoardingImageUrl());
    }
}
