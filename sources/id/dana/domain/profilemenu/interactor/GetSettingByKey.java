package id.dana.domain.profilemenu.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSettingByKey extends UseCase<SettingModel, Params> {
    private final SettingRepository settingRepository;

    @Inject
    public GetSettingByKey(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SettingRepository settingRepository) {
        super(threadExecutor, postExecutionThread);
        this.settingRepository = settingRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SettingModel> buildUseCaseObservable(Params params) {
        return this.settingRepository.getSettingByKey(params.key);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String key;

        private Params(String str) {
            this.key = str;
        }

        public static Params forSettingKey(String str) {
            return new Params(str);
        }
    }
}
