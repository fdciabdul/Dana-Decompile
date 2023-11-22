package id.dana.domain.featureconfig.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "danaProtectionInfoRepository", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetDanaProtectionWidgetConfig extends BaseUseCase<DanaProtectionWidgetConfig, NoParams> {
    private final DanaProtectionInfoRepository danaProtectionInfoRepository;
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public GetDanaProtectionWidgetConfig(FeatureConfigRepository featureConfigRepository, DanaProtectionInfoRepository danaProtectionInfoRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(danaProtectionInfoRepository, "");
        this.featureConfigRepository = featureConfigRepository;
        this.danaProtectionInfoRepository = danaProtectionInfoRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<DanaProtectionWidgetConfig> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<DanaProtectionWidgetConfig> doOnError = Observable.concat(this.danaProtectionInfoRepository.getDanaProtectionWidgetConfigInCache(), this.featureConfigRepository.getDanaProtectionWidgetConfig()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).doOnError(new Consumer() { // from class: id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetDanaProtectionWidgetConfig.m2333buildUseCase$lambda0(GetDanaProtectionWidgetConfig.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnError, "");
        return doOnError;
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final void m2333buildUseCase$lambda0(GetDanaProtectionWidgetConfig getDanaProtectionWidgetConfig, Throwable th) {
        Intrinsics.checkNotNullParameter(getDanaProtectionWidgetConfig, "");
        getDanaProtectionWidgetConfig.danaProtectionInfoRepository.trackError(th);
    }
}
