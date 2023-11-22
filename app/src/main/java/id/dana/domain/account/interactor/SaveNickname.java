package id.dana.domain.account.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.account.AccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class SaveNickname extends UseCase<String, Params> {
    private final AccountRepository accountRepository;

    @Inject
    public SaveNickname(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        super(threadExecutor, postExecutionThread);
        this.accountRepository = accountRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Params params) {
        return this.accountRepository.saveNickname(params.nickname);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String nickname;

        public Params(String str) {
            this.nickname = str;
        }

        public static Params forSaveNickname(String str) {
            return new Params(str);
        }
    }
}
