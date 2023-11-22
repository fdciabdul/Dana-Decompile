package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetPromoCenterConfig extends UseCase<PromoCenterConfig, Params> {
    private FeatureConfigRepository featureConfigRepository;

    /* loaded from: classes4.dex */
    public static class Params {
    }

    @Inject
    public GetPromoCenterConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<PromoCenterConfig> buildUseCaseObservable(Params params) {
        return Observable.zip(this.featureConfigRepository.getPromoCenterConfig(), this.featureConfigRepository.getPromoBannerSliderItemNewSizeEnabled(), new BiFunction() { // from class: id.dana.domain.featureconfig.interactor.GetPromoCenterConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GetPromoCenterConfig.lambda$buildUseCaseObservable$0((PromoCenterConfig) obj, (Boolean) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PromoCenterConfig lambda$buildUseCaseObservable$0(PromoCenterConfig promoCenterConfig, Boolean bool) throws Exception {
        promoCenterConfig.isBigSliderItemModeEnabled = bool.booleanValue();
        return promoCenterConfig;
    }
}
