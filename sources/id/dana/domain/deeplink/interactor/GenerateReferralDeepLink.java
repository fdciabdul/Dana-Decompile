package id.dana.domain.deeplink.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GenerateReferralDeepLink extends UseCase<DeepLink, Params> {
    private final GenerateLinkRepository repository;

    @Inject
    public GenerateReferralDeepLink(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        super(threadExecutor, postExecutionThread);
        this.repository = generateLinkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeepLink> buildUseCaseObservable(Params params) {
        return this.repository.generateReferralDeepLink(params.referralCode);
    }

    /* loaded from: classes4.dex */
    public static final class Params {
        private final String referralCode;

        private Params(String str) {
            this.referralCode = str;
        }

        public static Params forParams(String str) {
            return new Params(str);
        }
    }
}
