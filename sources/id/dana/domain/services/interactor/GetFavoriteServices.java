package id.dana.domain.services.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetFavoriteServices extends UseCase<ThirdPartyCategoryService, Void> {
    private final ServicesRepository servicesRepository;

    @Inject
    public GetFavoriteServices(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        super(threadExecutor, postExecutionThread);
        this.servicesRepository = servicesRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ThirdPartyCategoryService> buildUseCaseObservable(Void r1) {
        return this.servicesRepository.getFavoriteServices();
    }
}
