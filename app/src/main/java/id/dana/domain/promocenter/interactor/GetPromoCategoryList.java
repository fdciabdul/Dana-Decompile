package id.dana.domain.promocenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promocenter.model.PromoCategoryInfo;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetPromoCategoryList extends UseCase<PromoCategoryInfo, Params> {
    private final PromoCenterRepository promoCenterRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public GetPromoCategoryList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoCenterRepository promoCenterRepository) {
        super(threadExecutor, postExecutionThread);
        this.promoCenterRepository = promoCenterRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<PromoCategoryInfo> buildUseCaseObservable(Params params) {
        return this.promoCenterRepository.getCategories(params.pageSize, params.pageNumber, params.loadMore);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final boolean loadMore;
        private final int pageNumber;
        private final int pageSize;

        private Params(int i, int i2, boolean z) {
            this.pageSize = i;
            this.pageNumber = i2;
            this.loadMore = z;
        }

        public static Params forGetCategory(int i, int i2, boolean z) {
            return new Params(i, i2, z);
        }
    }
}
