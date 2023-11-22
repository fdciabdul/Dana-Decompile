package id.dana.domain.exploredana.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.domain.promotion.Space;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetExploreDana extends UseCase<Space, Void> {
    private final ExploreDanaRepository exploreDanaRepository;

    @Inject
    public GetExploreDana(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ExploreDanaRepository exploreDanaRepository) {
        super(threadExecutor, postExecutionThread);
        this.exploreDanaRepository = exploreDanaRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Space> buildUseCaseObservable(Void r1) {
        return this.exploreDanaRepository.getExploreDana();
    }
}
