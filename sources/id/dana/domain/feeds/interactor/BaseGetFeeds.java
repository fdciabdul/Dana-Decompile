package id.dana.domain.feeds.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.feeds.model.Feeds;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public abstract class BaseGetFeeds extends UseCase<Feeds, Params> {
    public BaseGetFeeds(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        String maxId;
        int pageSize;

        private Params(int i, String str) {
            this.pageSize = i;
            this.maxId = str;
        }

        public static Params forGetFeeds(int i, String str) {
            return new Params(i, str);
        }
    }
}
