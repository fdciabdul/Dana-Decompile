package id.dana.domain.usereducation.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveShowToolTip extends UseCase<Boolean, Params> {
    private final UserEducationRepository userEducationRepository;

    @Inject
    public SaveShowToolTip(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserEducationRepository userEducationRepository) {
        super(threadExecutor, postExecutionThread);
        this.userEducationRepository = userEducationRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.userEducationRepository.saveShowToolTip(params.hasShown, params.scenario);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private boolean hasShown;
        private String scenario;

        private Params(boolean z, String str) {
            this.hasShown = z;
            this.scenario = str;
        }

        public static Params forSaveShowToolTip(boolean z, String str) {
            return new Params(z, str);
        }
    }
}
