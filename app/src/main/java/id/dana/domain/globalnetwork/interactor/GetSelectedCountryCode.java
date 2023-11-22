package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.common.ObservableUseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSelectedCountryCode extends ObservableUseCase<String, Void> {
    private final GlobalNetworkRepository globalNetworkRepository;

    @Inject
    public GetSelectedCountryCode(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository) {
        super(threadExecutor, postExecutionThread);
        this.globalNetworkRepository = globalNetworkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.common.ObservableUseCase
    public Observable<String> buildUseCaseObservable(Void r1) {
        return this.globalNetworkRepository.getSelectedCountryCode();
    }
}
