package id.dana.domain.resetpin.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.ResetPinRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/resetpin/interactor/IsDanaVizEnrollmentSkippable;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/resetpin/ResetPinRepository;", "resetPinRepository", "Lid/dana/domain/resetpin/ResetPinRepository;", "<init>", "(Lid/dana/domain/resetpin/ResetPinRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class IsDanaVizEnrollmentSkippable extends BaseUseCase<Boolean, NoParams> {
    private final ResetPinRepository resetPinRepository;

    @Inject
    public IsDanaVizEnrollmentSkippable(ResetPinRepository resetPinRepository) {
        Intrinsics.checkNotNullParameter(resetPinRepository, "");
        this.resetPinRepository = resetPinRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.resetPinRepository.isDanaVizEnrollmentSkippable();
    }
}
