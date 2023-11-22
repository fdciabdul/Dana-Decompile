package id.dana.domain.usersecurityquestions.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSecurityQuestionState extends UseCase<SecuritySettingData, Params> {
    private final UserSecurityQuestionStateRepository userSecurityQuestionStateRepository;

    @Inject
    public GetSecurityQuestionState(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository) {
        super(threadExecutor, postExecutionThread);
        this.userSecurityQuestionStateRepository = userSecurityQuestionStateRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SecuritySettingData> buildUseCaseObservable(Params params) {
        return this.userSecurityQuestionStateRepository.getSecurityQuestionState(params.kbaVersion).map(new Function() { // from class: id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetSecurityQuestionState.lambda$buildUseCaseObservable$0((UserSecurityQuestionInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SecuritySettingData lambda$buildUseCaseObservable$0(UserSecurityQuestionInfo userSecurityQuestionInfo) throws Exception {
        if (userSecurityQuestionInfo != null) {
            return userSecurityQuestionInfo.getData();
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String kbaVersion;

        private Params(String str) {
            this.kbaVersion = str;
        }

        public static Params forSecurityQuestionState(String str) {
            return new Params(str);
        }
    }
}
