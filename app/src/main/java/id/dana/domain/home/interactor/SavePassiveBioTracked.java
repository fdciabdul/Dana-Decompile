package id.dana.domain.home.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.home.HomePassiveBioRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/home/interactor/SavePassiveBioTracked;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(J)Lio/reactivex/Observable;", "Lid/dana/domain/home/HomePassiveBioRepository;", "repository", "Lid/dana/domain/home/HomePassiveBioRepository;", "<init>", "(Lid/dana/domain/home/HomePassiveBioRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavePassiveBioTracked extends BaseUseCase<Unit, Long> {
    private final HomePassiveBioRepository repository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Unit> buildUseCase(Long l) {
        return buildUseCase(l.longValue());
    }

    @Inject
    public SavePassiveBioTracked(HomePassiveBioRepository homePassiveBioRepository) {
        Intrinsics.checkNotNullParameter(homePassiveBioRepository, "");
        this.repository = homePassiveBioRepository;
    }

    public final Observable<Unit> buildUseCase(long params) {
        return this.repository.saveLastTrackTimeStamp(params);
    }
}
