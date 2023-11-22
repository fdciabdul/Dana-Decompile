package id.dana.domain.exploredana.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class DismissAllExploreDana extends UseCase<Boolean, Params> {
    private final ExploreDanaRepository exploreDanaRepository;

    @Inject
    public DismissAllExploreDana(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ExploreDanaRepository exploreDanaRepository) {
        super(threadExecutor, postExecutionThread);
        this.exploreDanaRepository = exploreDanaRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.exploreDanaRepository.setDismissAll(params.contentIds);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private List<String> contentIds;

        private Params(List<String> list) {
            this.contentIds = list;
        }

        public static Params forDismiss(List<String> list) {
            return new Params(list);
        }
    }
}
