package id.dana.domain.tncsummary.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetFeatureTncSummary extends UseCase<Boolean, Void> {
    private final TncSummaryRepository tncSummaryRepository;

    @Inject
    public GetFeatureTncSummary(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TncSummaryRepository tncSummaryRepository) {
        super(threadExecutor, postExecutionThread);
        this.tncSummaryRepository = tncSummaryRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.tncSummaryRepository.getFeatureTncSummary();
    }
}
