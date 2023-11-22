package id.dana.domain.homeinfo.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetHomeInfo extends UseCase<HomeInfoResponse, Params> {
    private HomeInfoRepository homeInfoRepository;

    @Inject
    public GetHomeInfo(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HomeInfoRepository homeInfoRepository) {
        super(threadExecutor, postExecutionThread);
        this.homeInfoRepository = homeInfoRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<HomeInfoResponse> buildUseCaseObservable(Params params) {
        if (params == null) {
            return this.homeInfoRepository.getHomeInfo(null);
        }
        return this.homeInfoRepository.getHomeInfo(params.filter);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private List<String> filter;

        private Params(List<String> list) {
            this.filter = list;
        }

        public static Params forGetHomeInfo(List<String> list) {
            return new Params(list);
        }
    }
}
