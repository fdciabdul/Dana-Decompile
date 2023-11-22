package id.dana.domain.account.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.account.AccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.io.File;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class UploadAvatar extends UseCase<String, Params> {
    private final AccountRepository accountRepository;

    @Inject
    public UploadAvatar(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        super(threadExecutor, postExecutionThread);
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Params params) {
        return this.accountRepository.uploadAvatar(params.avatarFile);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private File avatarFile;

        private Params(File file) {
            this.avatarFile = file;
        }

        public static Params forUploadAvatar(File file) {
            return new Params(file);
        }
    }
}
