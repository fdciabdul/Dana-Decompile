package id.dana.domain.qriscrossborder.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/qriscrossborder/interactor/GetQrisCrossBorderCountries;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQrisCrossBorderCountries extends BaseUseCase<List<? extends String>, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public GetQrisCrossBorderCountries(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<String>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<String>> qrisCrossBorderSupportedCountries = this.featureConfigRepository.getQrisCrossBorderSupportedCountries();
        Intrinsics.checkNotNullExpressionValue(qrisCrossBorderSupportedCountries, "");
        return qrisCrossBorderSupportedCountries;
    }
}
