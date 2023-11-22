package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class CheckVisibilityFeatureSwitch extends UseCase<Boolean, Params> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckVisibilityFeatureSwitch(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.featureConfigRepository.checkVisibilityFeature(params.name);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String name;

        private Params(String str) {
            this.name = str;
        }

        public static Params forCheckVisibilityFeatureSwitch(String str) {
            return new Params(str);
        }
    }
}
