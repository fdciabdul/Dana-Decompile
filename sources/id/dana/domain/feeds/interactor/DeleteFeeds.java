package id.dana.domain.feeds.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.model.DeleteFeed;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class DeleteFeeds extends UseCase<DeleteFeed, Params> {
    private FeedsRepository feedsRepository;

    @Inject
    public DeleteFeeds(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        super(threadExecutor, postExecutionThread);
        this.feedsRepository = feedsRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeleteFeed> buildUseCaseObservable(Params params) {
        return this.feedsRepository.deleteFeeds(params.activityId);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String activityId;

        private Params(String str) {
            this.activityId = str;
        }

        public static Params forDeleteFeeds(String str) {
            return new Params(str);
        }
    }
}
