package id.dana.domain.services.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.services.ServicesRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveFavoriteServices extends UseCase<Boolean, Params> {
    private final ServicesRepository servicesRepository;

    @Inject
    public SaveFavoriteServices(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        super(threadExecutor, postExecutionThread);
        this.servicesRepository = servicesRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.servicesRepository.saveFavoriteServices(params.services);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private List<String> services;

        private Params(List<String> list) {
            this.services = list;
        }

        public static Params forFavoriteServices(List<String> list) {
            return new Params(list);
        }

        public List<String> getServices() {
            return this.services;
        }
    }
}
