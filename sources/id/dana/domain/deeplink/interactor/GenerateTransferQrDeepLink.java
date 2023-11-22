package id.dana.domain.deeplink.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GenerateTransferQrDeepLink extends UseCase<DeepLink, Params> {
    private final GenerateLinkRepository repository;

    @Inject
    public GenerateTransferQrDeepLink(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        super(threadExecutor, postExecutionThread);
        this.repository = generateLinkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeepLink> buildUseCaseObservable(Params params) {
        return this.repository.generateTransferQrDeepLink(params.transferQrUrl, params.deepLinkTitle, params.deepLinkDescription);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String deepLinkDescription;
        private final String deepLinkTitle;
        private final String transferQrUrl;

        private Params(String str, String str2, String str3) {
            this.transferQrUrl = str;
            this.deepLinkTitle = str2;
            this.deepLinkDescription = str3;
        }

        public static Params forParams(String str, String str2, String str3) {
            return new Params(str, str2, str3);
        }
    }
}
