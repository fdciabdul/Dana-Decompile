package id.dana.data.permission;

import id.dana.data.storage.GeneralPreferencesData;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.domain.permission.PermissionRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PermissionEntityRepository implements PermissionRepository {
    private final GeneralPreferencesDataFactory generalPreferencesDataFactory;

    @Inject
    public PermissionEntityRepository(GeneralPreferencesDataFactory generalPreferencesDataFactory) {
        this.generalPreferencesDataFactory = generalPreferencesDataFactory;
    }

    private GeneralPreferencesData createData() {
        return this.generalPreferencesDataFactory.createData2("local");
    }

    @Override // id.dana.domain.permission.PermissionRepository
    public Observable<Boolean> setDeniedLocationPermission(Boolean bool) {
        return createData().setLocationPermissionDenied(bool.booleanValue());
    }

    @Override // id.dana.domain.permission.PermissionRepository
    public Observable<Boolean> checkDeniedLocationPermission() {
        return createData().isLocationPermissionDenied();
    }
}
