package id.dana.domain.profilemenu.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetSettingCollection extends UseCase<List<SettingModel>, Params> {
    private final SettingRepository settingRepository;

    @Inject
    public GetSettingCollection(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SettingRepository settingRepository) {
        super(threadExecutor, postExecutionThread);
        this.settingRepository = settingRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<SettingModel>> buildUseCaseObservable(Params params) {
        return this.settingRepository.getSettings(params.configurations, params.collectionName, params.settingJsonMapper);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String collectionName;
        public final List<SettingConfigurationRunner> configurations;
        private final RawSettingJsonMapper settingJsonMapper;

        public Params(String str, List<SettingConfigurationRunner> list, RawSettingJsonMapper rawSettingJsonMapper) {
            this.collectionName = str;
            this.configurations = list;
            this.settingJsonMapper = rawSettingJsonMapper;
        }

        public static Params forGetSettingCollection(String str, List<SettingConfigurationRunner> list, RawSettingJsonMapper rawSettingJsonMapper) {
            return new Params(str, list, rawSettingJsonMapper);
        }
    }
}
