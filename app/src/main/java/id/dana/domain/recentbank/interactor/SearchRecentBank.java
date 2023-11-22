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
public class SearchRecentBank extends UseCase<List<RecentBank>, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public SearchRecentBank(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentRecipientRepository = recentRecipientRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<RecentBank>> buildUseCaseObservable(Params params) {
        return this.recentRecipientRepository.getRecentBank(params.filter);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String filter;

        public Params(String str) {
            this.filter = str;
        }

        public static Params forSaveRecentBank(String str) {
            return new Params(str);
        }
    }
}
