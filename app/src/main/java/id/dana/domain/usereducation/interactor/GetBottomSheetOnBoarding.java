package id.dana.domain.usereducation.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetBottomSheetOnBoarding extends UseCase<Boolean, Params> {
    private final UserEducationRepository userEducationRepository;

    @Inject
    public GetBottomSheetOnBoarding(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserEducationRepository userEducationRepository) {
        super(threadExecutor, postExecutionThread);
        this.userEducationRepository = userEducationRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.userEducationRepository.isNeedToShowBottomSheetOnBoarding(params.scenario);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String scenario;

        private Params(String str) {
            this.scenario = str;
        }

        public static Params forBottomSheetOnBoarding(String str) {
            return new Params(str);
        }
    }
}
