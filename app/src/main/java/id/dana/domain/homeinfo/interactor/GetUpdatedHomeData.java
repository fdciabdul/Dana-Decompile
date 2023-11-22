package id.dana.domain.homeinfo.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.HomeData;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetUpdatedHomeData extends UseCase<HomeData, NoParams> {
    private final HomeInfoRepository homeInfoRepository;

    @Inject
    public GetUpdatedHomeData(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HomeInfoRepository homeInfoRepository) {
        super(threadExecutor, postExecutionThread);
        this.homeInfoRepository = homeInfoRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<HomeData> buildUseCaseObservable(NoParams noParams) {
        return this.homeInfoRepository.getUpdatedHomeData();
    }
}
