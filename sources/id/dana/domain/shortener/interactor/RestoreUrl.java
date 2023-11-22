package id.dana.domain.shortener.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.shortener.repository.ShortenerRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RestoreUrl extends UseCase<String, Params> {
    private final ShortenerRepository shortenerRepository;

    @Inject
    public RestoreUrl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ShortenerRepository shortenerRepository) {
        super(threadExecutor, postExecutionThread);
        this.shortenerRepository = shortenerRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Params params) {
        return this.shortenerRepository.restore(params.shortCode);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String shortCode;

        private Params(String str) {
            this.shortCode = str;
        }

        public static Params forRestoreUrl(String str) {
            return new Params(str);
        }
    }
}
