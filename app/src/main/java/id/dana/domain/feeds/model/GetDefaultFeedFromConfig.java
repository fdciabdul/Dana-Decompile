package id.dana.domain.feeds.model;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetDefaultFeedFromConfig extends UseCase<Feeds, NoParams> {
    private FeedsRepository feedsRepository;

    @Inject
    public GetDefaultFeedFromConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        super(threadExecutor, postExecutionThread);
        this.feedsRepository = feedsRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Feeds> buildUseCaseObservable(NoParams noParams) {
        return this.feedsRepository.getDefaultFeedFromConfig();
    }
}
