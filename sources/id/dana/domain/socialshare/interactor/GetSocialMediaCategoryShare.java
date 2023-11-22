package id.dana.domain.socialshare.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSocialMediaCategoryShare extends UseCase<List<String>, Void> {
    FeatureConfigRepository featureConfigRepository;

    @Inject
    public GetSocialMediaCategoryShare(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<String>> buildUseCaseObservable(Void r1) {
        return this.featureConfigRepository.getSocialMediaCategoryShare();
    }
}
