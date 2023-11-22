package id.dana.domain.deeplink.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetDeepLinkPayload extends UseCase<DeepLinkPayload, Params> {
    private final DeepLinkRepository deepLinkRepository;

    @Inject
    public GetDeepLinkPayload(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DeepLinkRepository deepLinkRepository) {
        super(threadExecutor, postExecutionThread);
        this.deepLinkRepository = deepLinkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeepLinkPayload> buildUseCaseObservable(Params params) {
        return this.deepLinkRepository.getDeepLinkPayload(params.fromRoot);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        boolean fromRoot;

        private Params(boolean z) {
            this.fromRoot = z;
        }

        public static Params fromRoot(boolean z) {
            return new Params(z);
        }
    }
}
