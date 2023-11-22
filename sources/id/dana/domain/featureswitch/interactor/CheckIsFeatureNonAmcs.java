package id.dana.domain.featureswitch.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureswitch.FeatureNonAmcsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class CheckIsFeatureNonAmcs extends UseCase<Boolean, Params> {
    private final FeatureNonAmcsRepository featureNonAmcsRepository;

    @Inject
    public CheckIsFeatureNonAmcs(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureNonAmcsRepository featureNonAmcsRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureNonAmcsRepository = featureNonAmcsRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.featureNonAmcsRepository.isFeatureNonAMCS(params.action);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String action;

        private Params(String str) {
            this.action = str;
        }

        public static Params forCheckFeature(String str) {
            return new Params(str);
        }
    }
}
