package id.dana.domain.services.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/services/interactor/GetService;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/services/ServicesRepository;", "repository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/services/ServicesRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetService extends BaseUseCase<ThirdPartyServiceResponse, String> {
    private final ServicesRepository repository;

    @Inject
    public GetService(ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.repository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ThirdPartyServiceResponse> buildUseCase(String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<ThirdPartyServiceResponse> serviceByKey = this.repository.getServiceByKey(params);
        Intrinsics.checkNotNullExpressionValue(serviceByKey, "");
        return serviceByKey;
    }
}
