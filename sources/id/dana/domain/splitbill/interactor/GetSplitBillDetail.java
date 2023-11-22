package id.dana.domain.splitbill.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSplitBillDetail extends UseCase<SplitBillHistory, Params> {
    private final SplitBillRepository splitBillRepository;

    @Inject
    public GetSplitBillDetail(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SplitBillRepository splitBillRepository) {
        super(threadExecutor, postExecutionThread);
        this.splitBillRepository = splitBillRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SplitBillHistory> buildUseCaseObservable(Params params) {
        return this.splitBillRepository.getSplitBillDetail(params.splitBillId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String splitBillId;

        private Params(String str) {
            this.splitBillId = str;
        }

        public static Params forSplitBillId(String str) {
            return new Params(str);
        }
    }
}
