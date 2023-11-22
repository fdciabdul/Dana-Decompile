package id.dana.domain.lazada.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetLazadaRegistrationUrl extends UseCase<LazadaRegistrationUrl, Params> {
    private LazadaRepository lazadaRepository;

    @Inject
    public GetLazadaRegistrationUrl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LazadaRepository lazadaRepository) {
        super(threadExecutor, postExecutionThread);
        this.lazadaRepository = lazadaRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<LazadaRegistrationUrl> buildUseCaseObservable(Params params) {
        return this.lazadaRepository.getLazadaRegistrationUrl(params.deviceId, params.bizType);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String bizType;
        private String deviceId;

        private Params(String str, String str2) {
            this.deviceId = str;
            this.bizType = str2;
        }

        public static Params forGetURL(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
