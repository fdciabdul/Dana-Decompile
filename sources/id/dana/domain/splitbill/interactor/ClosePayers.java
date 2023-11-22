package id.dana.domain.splitbill.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ClosePayers extends UseCase<Boolean, Params> {
    private final SplitBillRepository splitBillRepository;

    @Inject
    public ClosePayers(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SplitBillRepository splitBillRepository) {
        super(threadExecutor, postExecutionThread);
        this.splitBillRepository = splitBillRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.splitBillRepository.closePayers(params.closePayerList, params.splitBillId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private List<String> closePayerList;
        private String splitBillId;

        private Params(List<String> list, String str) {
            this.closePayerList = list;
            this.splitBillId = str;
        }

        public static Params forClosePayers(List<String> list, String str) {
            return new Params(list, str);
        }
    }
}
