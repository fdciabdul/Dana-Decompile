package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.DeepLinkFeatureSwitchModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CheckDeepLinkActionVisibility extends UseCase<DeepLinkFeatureSwitchModel, Params> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckDeepLinkActionVisibility(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DeepLinkFeatureSwitchModel> buildUseCaseObservable(Params params) {
        return this.featureConfigRepository.checkDeepLinkFeatureVisibility(params.name);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String name;

        private Params(String str) {
            this.name = str;
        }

        public static Params forAction(String str) {
            return new Params(str);
        }
    }
}
