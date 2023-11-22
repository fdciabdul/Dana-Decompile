package id.dana.domain.recentrecipient.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetRecentRecipient extends UseCase<List<RecentRecipient>, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public GetRecentRecipient(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentRecipientRepository = recentRecipientRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<RecentRecipient>> buildUseCaseObservable(Params params) {
        return this.recentRecipientRepository.getSecureRecentRecipient(params.maxRecentRecipient, params.contactType, params.recentContactType);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private int contactType;
        private int maxRecentRecipient;
        private int recentContactType;

        private Params(int i, int i2, int i3) {
            this.maxRecentRecipient = i;
            this.contactType = i2;
            this.recentContactType = i3;
        }

        public static Params forGetRecentRecipient(int i, int i2, int i3) {
            return new Params(i, i2, i3);
        }
    }
}
