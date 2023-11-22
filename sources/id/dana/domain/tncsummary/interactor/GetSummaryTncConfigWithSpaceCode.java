package id.dana.domain.tncsummary.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tncsummary.model.TermsConditionsResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSummaryTncConfigWithSpaceCode extends UseCase<TermsConditionsResponse, Void> {
    private final TncSummaryRepository tncSummaryRepository;

    @Inject
    public GetSummaryTncConfigWithSpaceCode(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TncSummaryRepository tncSummaryRepository) {
        super(threadExecutor, postExecutionThread);
        this.tncSummaryRepository = tncSummaryRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<TermsConditionsResponse> buildUseCaseObservable(Void r1) {
        return this.tncSummaryRepository.getTncSummaryConfigWithSpaceCode();
    }
}
