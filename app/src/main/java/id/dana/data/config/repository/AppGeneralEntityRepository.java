package id.dana.data.config.repository;

import id.dana.data.storage.GeneralPreferencesData;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.domain.featureconfig.AppGeneralRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AppGeneralEntityRepository implements AppGeneralRepository {
    private final GeneralPreferencesDataFactory generalPreferencesDataFactory;

    @Inject
    public AppGeneralEntityRepository(GeneralPreferencesDataFactory generalPreferencesDataFactory) {
        this.generalPreferencesDataFactory = generalPreferencesDataFactory;
    }

    @Override // id.dana.domain.featureconfig.AppGeneralRepository
    public Observable<Boolean> isAppFirstLaunch() {
        return createGeneralPreferences().isAppFirstLaunch();
    }

    private GeneralPreferencesData createGeneralPreferences() {
        return this.generalPreferencesDataFactory.createData2("local");
    }
}
