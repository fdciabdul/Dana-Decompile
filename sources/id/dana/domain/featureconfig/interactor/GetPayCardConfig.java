package id.dana.domain.featureconfig.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.payasset.model.PayCardConfig;
import id.dana.domain.payasset.repository.PayAssetRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/featureconfig/interactor/GetPayCardConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/payasset/model/PayCardConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/payasset/repository/PayAssetRepository;", "payAssetRepository", "Lid/dana/domain/payasset/repository/PayAssetRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/payasset/repository/PayAssetRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPayCardConfig extends BaseUseCase<PayCardConfig, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;
    private final PayAssetRepository payAssetRepository;

    @Inject
    public GetPayCardConfig(FeatureConfigRepository featureConfigRepository, PayAssetRepository payAssetRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(payAssetRepository, "");
        this.featureConfigRepository = featureConfigRepository;
        this.payAssetRepository = payAssetRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PayCardConfig> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<PayCardConfig> zip = Observable.zip(this.featureConfigRepository.isCameraCardEnable(), this.featureConfigRepository.getFeatureForcedFirstCard(), this.payAssetRepository.getEnableAddNewCard(), new Function3() { // from class: id.dana.domain.featureconfig.interactor.GetPayCardConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return new PayCardConfig(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }
}
