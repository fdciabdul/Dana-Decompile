package id.dana;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AppLifeCycleObserver_Factory implements Factory<AppLifeCycleObserver> {
    private final Provider<PreferenceAccountEntityData> PlaceComponentResult;
    private final Provider<LocationPermissionSubject> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AppLifeCycleObserver(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), this.getAuthRequestContext.get());
    }
}
