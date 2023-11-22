package id.dana.domain.deeplink.interactor;

import android.app.Activity;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class InitSessionDeepLink extends UseCase<DeepLinkPayload, Params> {
    private final DeepLinkRepository deepLinkRepository;

    @Inject
    public InitSessionDeepLink(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DeepLinkRepository deepLinkRepository) {
        super(threadExecutor, postExecutionThread);
        this.deepLinkRepository = deepLinkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeepLinkPayload> buildUseCaseObservable(Params params) {
        return this.deepLinkRepository.initSession(params.activity);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private Activity activity;

        private Params(Activity activity) {
            this.activity = activity;
        }

        public static Params forInitSession(Activity activity) {
            return new Params(activity);
        }
    }
}
