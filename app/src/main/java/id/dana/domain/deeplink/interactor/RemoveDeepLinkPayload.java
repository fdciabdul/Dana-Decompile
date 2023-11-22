package id.dana.domain.deeplink.interactor;

import id.dana.domain.SynchronizedUseCase;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/deeplink/interactor/RemoveDeepLinkPayload;", "Lid/dana/domain/SynchronizedUseCase;", "", "", "params", "buildUseCaseObservable", "(Lkotlin/Unit;)Ljava/lang/Boolean;", "Lid/dana/domain/deeplink/repository/DeepLinkRepository;", "deepLinkRepository", "Lid/dana/domain/deeplink/repository/DeepLinkRepository;", "<init>", "(Lid/dana/domain/deeplink/repository/DeepLinkRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RemoveDeepLinkPayload extends SynchronizedUseCase<Boolean, Unit> {
    private final DeepLinkRepository deepLinkRepository;

    @Inject
    public RemoveDeepLinkPayload(DeepLinkRepository deepLinkRepository) {
        Intrinsics.checkNotNullParameter(deepLinkRepository, "");
        this.deepLinkRepository = deepLinkRepository;
    }

    @Override // id.dana.domain.SynchronizedUseCase
    public final Boolean buildUseCaseObservable(Unit params) {
        return Boolean.valueOf(this.deepLinkRepository.removeDeeplinkPayload());
    }
}
