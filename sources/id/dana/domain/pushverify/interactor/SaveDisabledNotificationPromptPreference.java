package id.dana.domain.pushverify.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/pushverify/interactor/SaveDisabledNotificationPromptPreference;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Completable;", "Lid/dana/domain/pushverify/repository/PushVerifyRepository;", "pushVerifyRepository", "Lid/dana/domain/pushverify/repository/PushVerifyRepository;", "<init>", "(Lid/dana/domain/pushverify/repository/PushVerifyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveDisabledNotificationPromptPreference extends CompletableUseCase<NoParams> {
    private final PushVerifyRepository pushVerifyRepository;

    @Inject
    public SaveDisabledNotificationPromptPreference(PushVerifyRepository pushVerifyRepository) {
        Intrinsics.checkNotNullParameter(pushVerifyRepository, "");
        this.pushVerifyRepository = pushVerifyRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.pushVerifyRepository.saveNotificationPromptPreference(false);
    }
}
