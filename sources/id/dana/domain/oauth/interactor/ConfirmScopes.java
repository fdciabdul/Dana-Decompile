package id.dana.domain.oauth.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.oauth.model.OauthConfirmation;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ConfirmScopes extends UseCase<OauthConfirmation, Params> {
    private final OauthRepository oauthRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ConfirmScopes(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        super(threadExecutor, postExecutionThread);
        this.oauthRepository = oauthRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<OauthConfirmation> buildUseCaseObservable(Params params) {
        return this.oauthRepository.confirmOauthScope(params.codeChallenge, params.clientId, params.scopes, params.redirectUrl, params.needMobileToken);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String clientId;
        private String codeChallenge;
        private boolean needMobileToken;
        private String redirectUrl;
        private List<String> scopes;

        private Params(String str, String str2, List<String> list, String str3, boolean z) {
            this.codeChallenge = str;
            this.clientId = str2;
            this.scopes = list;
            this.redirectUrl = str3;
            this.needMobileToken = z;
        }

        public static Params forConfirmScopes(String str, String str2, List<String> list, String str3, boolean z) {
            return new Params(str, str2, list, str3, z);
        }
    }
}
