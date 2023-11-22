package id.dana.domain.recentbank.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentbank.model.RecentBank;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetRecentBank extends UseCase<List<RecentBank>, Void> {
    private final RecentRecipientRepository repository;

    @Inject
    public GetRecentBank(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        this.repository = recentRecipientRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<RecentBank>> buildUseCaseObservable(Void r2) {
        return this.repository.getRecentBank("");
    }
}
