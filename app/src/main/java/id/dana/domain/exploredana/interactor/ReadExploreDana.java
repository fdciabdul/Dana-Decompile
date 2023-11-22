package id.dana.domain.exploredana.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class ReadExploreDana extends UseCase<Boolean, Params> {
    private final ExploreDanaRepository exploreDanaRepository;

    @Inject
    public ReadExploreDana(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ExploreDanaRepository exploreDanaRepository) {
        super(threadExecutor, postExecutionThread);
        this.exploreDanaRepository = exploreDanaRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.exploreDanaRepository.setReadExploreDanaItem(params.key);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        String key;

        private Params(String str) {
            this.key = str;
        }

        public static Params forRead(String str) {
            return new Params(str);
        }
    }
}
