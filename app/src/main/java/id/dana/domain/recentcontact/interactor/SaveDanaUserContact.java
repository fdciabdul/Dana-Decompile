package id.dana.domain.recentcontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveDanaUserContact extends UseCase<Boolean, Params> {
    private RecentContactRepository recentContactRepository;

    @Inject
    public SaveDanaUserContact(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentContactRepository recentContactRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentContactRepository = recentContactRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.recentContactRepository.saveDanaUserContact(params.userId, params.phoneNumber);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String phoneNumber;
        private String userId;

        private Params(String str, String str2) {
            this.userId = str;
            this.phoneNumber = str2;
        }

        public static Params forSaveDanaUserContact(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
