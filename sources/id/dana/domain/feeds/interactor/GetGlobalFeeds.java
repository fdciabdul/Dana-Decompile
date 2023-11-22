package id.dana.domain.feeds.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.interactor.BaseGetFeeds;
import id.dana.domain.feeds.model.Feeds;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetGlobalFeeds extends BaseGetFeeds {
    private final FeedsRepository feedsRepository;

    @Inject
    public GetGlobalFeeds(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        super(threadExecutor, postExecutionThread);
        this.feedsRepository = feedsRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Feeds> buildUseCaseObservable(BaseGetFeeds.Params params) {
        return this.feedsRepository.getGlobalFeeds(params.pageSize, params.maxId);
    }
}
