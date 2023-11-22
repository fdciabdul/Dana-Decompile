package id.dana.domain.services.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetCategory extends UseCase<List<CategoryServicesModel>, Void> {
    private final ServicesRepository servicesRepository;

    @Inject
    public GetCategory(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        super(threadExecutor, postExecutionThread);
        this.servicesRepository = servicesRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<CategoryServicesModel>> buildUseCaseObservable(Void r1) {
        return this.servicesRepository.getAllCategories();
    }
}
