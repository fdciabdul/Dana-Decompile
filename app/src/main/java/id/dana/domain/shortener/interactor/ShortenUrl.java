package id.dana.domain.shortener.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.shortener.repository.ShortenerRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class ShortenUrl extends UseCase<String, Params> {
    private final ShortenerRepository shortenerRepository;

    @Inject
    public ShortenUrl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ShortenerRepository shortenerRepository) {
        super(threadExecutor, postExecutionThread);
        this.shortenerRepository = shortenerRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Params params) {
        return this.shortenerRepository.shorten(params.bizType, params.originalUrl);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String bizType;
        private String originalUrl;

        private Params(String str, String str2) {
            this.bizType = str;
            this.originalUrl = str2;
        }

        public static Params forShortenUrl(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
