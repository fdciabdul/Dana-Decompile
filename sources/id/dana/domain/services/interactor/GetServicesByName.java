package id.dana.domain.services.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetServicesByName extends UseCase<List<ThirdPartyCategoryService>, Params> {
    private final ServicesRepository servicesRepository;

    @Inject
    public GetServicesByName(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        super(threadExecutor, postExecutionThread);
        this.servicesRepository = servicesRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<ThirdPartyCategoryService>> buildUseCaseObservable(Params params) {
        return this.servicesRepository.getServicesByName(params.names);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private List<String> names;

        private Params(List<String> list) {
            this.names = list;
        }

        public static Params forGetServicesByName(List<String> list) {
            return new Params(list);
        }
    }
}
