package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.DexguardIntegrityCheckConfig;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class CheckDexguardIntegrityCheckFeature extends UseCase<DexguardIntegrityCheckConfig, Void> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckDexguardIntegrityCheckFeature(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<DexguardIntegrityCheckConfig> buildUseCaseObservable(Void r4) {
        return Observable.zip(this.featureConfigRepository.checkDexguardRootCheckFeature(), this.featureConfigRepository.checkDexguardHookCheckFeature(), this.featureConfigRepository.checkDexguardTamperCheckFeature(), new Function3() { // from class: id.dana.domain.featureconfig.interactor.CheckDexguardIntegrityCheckFeature$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                DexguardIntegrityCheckConfig zipDexguardConfig;
                zipDexguardConfig = CheckDexguardIntegrityCheckFeature.this.zipDexguardConfig(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
                return zipDexguardConfig;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DexguardIntegrityCheckConfig zipDexguardConfig(boolean z, boolean z2, boolean z3) {
        return new DexguardIntegrityCheckConfig(z, z2, z3);
    }
}
