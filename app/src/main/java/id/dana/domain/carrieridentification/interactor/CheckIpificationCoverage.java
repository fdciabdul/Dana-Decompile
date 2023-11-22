package id.dana.domain.carrieridentification.interactor;

import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.model.CheckCoverageResponse;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/carrieridentification/interactor/CheckIpificationCoverage;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/carrieridentification/model/CheckCoverageResponse;", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "carrierIdentificationRepository", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "<init>", "(Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckIpificationCoverage extends BaseUseCase<CheckCoverageResponse, String> {
    private final CarrierIdentificationRepository carrierIdentificationRepository;

    @Inject
    public CheckIpificationCoverage(CarrierIdentificationRepository carrierIdentificationRepository) {
        Intrinsics.checkNotNullParameter(carrierIdentificationRepository, "");
        this.carrierIdentificationRepository = carrierIdentificationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CheckCoverageResponse> buildUseCase(String params) {
        Observable<CheckCoverageResponse> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(params, "");
        Single<CheckCoverageResponse> checkIPificationCoverage = this.carrierIdentificationRepository.checkIPificationCoverage(params);
        if (checkIPificationCoverage instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) checkIPificationCoverage).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(checkIPificationCoverage));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }
}
