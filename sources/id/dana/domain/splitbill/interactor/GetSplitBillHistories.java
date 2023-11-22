package id.dana.domain.splitbill.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSplitBillHistories extends UseCase<List<SplitBillHistory>, Params> {
    private final SplitBillRepository splitBillRepository;

    @Inject
    public GetSplitBillHistories(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SplitBillRepository splitBillRepository) {
        super(threadExecutor, postExecutionThread);
        this.splitBillRepository = splitBillRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<SplitBillHistory>> buildUseCaseObservable(Params params) {
        return this.splitBillRepository.getSplitBillHistories(params.pageNum);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private int pageNum;

        private Params(int i) {
            this.pageNum = i;
        }

        public static Params forPageNum(int i) {
            return new Params(i);
        }
    }
}
