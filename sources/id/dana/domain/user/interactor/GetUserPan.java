package id.dana.domain.user.interactor;

import id.dana.domain.CompletableUseCase;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Completable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetUserPan extends CompletableUseCase<Void> {
    private final UserRepository userRepository;

    @Inject
    public GetUserPan(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.CompletableUseCase
    public Completable buildCompletableUseCase(Void r1) {
        return this.userRepository.getUserInfoWithUserPan().ignoreElements();
    }
}
