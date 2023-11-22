package id.dana.domain.h5onlineconfig;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.Set;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class GetH5OnlineConfig extends UseCase<String, Params> {
    private final H5OnlineConfigRepository h5OnlineConfigRepository;

    @Inject
    public GetH5OnlineConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, H5OnlineConfigRepository h5OnlineConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.h5OnlineConfigRepository = h5OnlineConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<String> buildUseCaseObservable(Params params) {
        return this.h5OnlineConfigRepository.getH5OnlineConfig(params.section, params.names);
    }

    /* loaded from: classes2.dex */
    public static class Params {
        private final Set<String> names;
        private final String section;

        public Params(String str, Set<String> set) {
            this.section = str;
            this.names = set;
        }

        public static Params forGetOnlineConfig(String str, Set<String> set) {
            return new Params(str, set);
        }
    }
}
