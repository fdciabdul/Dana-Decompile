package id.dana.domain.account.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetUserId extends UseCase<String, Void> {
    private final LiteAccountRepository accountRepository;

    @Inject
    public GetUserId(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LiteAccountRepository liteAccountRepository) {
        super(threadExecutor, postExecutionThread);
        this.accountRepository = liteAccountRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Void r1) {
        return this.accountRepository.getUserId();
    }
}
