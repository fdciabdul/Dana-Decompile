package id.dana.domain.nearbyme.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.model.NearbyWidgetConfig;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyWidgetVisibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNearbyWidgetVisibility extends BaseUseCase<Pair<? extends Boolean, ? extends Boolean>, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public GetNearbyWidgetVisibility(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Pair<Boolean, Boolean>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Pair<Boolean, Boolean>> zip = Observable.zip(this.featureConfigRepository.isNearbyMeEnable(), this.featureConfigRepository.getNearbyWidgetConfig(), new BiFunction() { // from class: id.dana.domain.nearbyme.interactor.GetNearbyWidgetVisibility$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair m2378buildUseCase$lambda0;
                m2378buildUseCase$lambda0 = GetNearbyWidgetVisibility.m2378buildUseCase$lambda0((Boolean) obj, (NearbyWidgetConfig) obj2);
                return m2378buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Pair m2378buildUseCase$lambda0(Boolean bool, NearbyWidgetConfig nearbyWidgetConfig) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(nearbyWidgetConfig, "");
        return new Pair(Boolean.valueOf(bool.booleanValue() && nearbyWidgetConfig.getEnable()), Boolean.valueOf(nearbyWidgetConfig.getKybKaFilter()));
    }
}
