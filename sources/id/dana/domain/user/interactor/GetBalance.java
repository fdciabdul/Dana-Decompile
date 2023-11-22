package id.dana.domain.user.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetBalance extends UseCase<CurrencyAmount, Void> {
    private final UserRepository userRepository;

    @Inject
    public GetBalance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<CurrencyAmount> buildUseCaseObservable(Void r1) {
        return this.userRepository.getBalance();
    }
}
