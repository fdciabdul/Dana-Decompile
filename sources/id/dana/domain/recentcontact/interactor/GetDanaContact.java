package id.dana.domain.recentcontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetDanaContact extends UseCase<List<String>, Void> {
    private final RecentContactRepository recentContactRepository;

    @Inject
    public GetDanaContact(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentContactRepository recentContactRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentContactRepository = recentContactRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<String>> buildUseCaseObservable(Void r1) {
        return this.recentContactRepository.getDanaUserContact();
    }
}
