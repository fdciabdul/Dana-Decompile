package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CheckX2PAndX2XVoucherFeature extends UseCase<Boolean, Void> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckX2PAndX2XVoucherFeature(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r3) {
        return this.featureConfigRepository.isX2XVoucherEnable().zipWith(this.featureConfigRepository.isX2PEnable(), new BiFunction() { // from class: id.dana.domain.sendmoney.interactor.CheckX2PAndX2XVoucherFeature$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        });
    }
}
