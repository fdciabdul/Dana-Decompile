package id.dana.domain.onboarding.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/onboarding/interactor/IsFirebaseRegisterPerformanceTrackerOn;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IsFirebaseRegisterPerformanceTrackerOn extends BaseUseCase<Boolean, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public IsFirebaseRegisterPerformanceTrackerOn(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> onErrorReturn = this.featureConfigRepository.isFirebaseRegisterPerformanceTrackerOn().onErrorReturn(new Function() { // from class: id.dana.domain.onboarding.interactor.IsFirebaseRegisterPerformanceTrackerOn$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2385buildUseCase$lambda0;
                m2385buildUseCase$lambda0 = IsFirebaseRegisterPerformanceTrackerOn.m2385buildUseCase$lambda0((Throwable) obj);
                return m2385buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Boolean m2385buildUseCase$lambda0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.FALSE;
    }
}
