package id.dana.domain.h5event.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetCheckoutH5Event extends UseCase<Boolean, Void> {
    private final H5EventRepository h5EventRepository;

    @Inject
    public GetCheckoutH5Event(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, H5EventRepository h5EventRepository) {
        super(threadExecutor, postExecutionThread);
        this.h5EventRepository = h5EventRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.h5EventRepository.getCheckoutH5Event();
    }
}
