package id.dana.danah5.easteregg;

import dagger.MembersInjector;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.config.DeviceInformationProvider;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class EasterEggsEventHandler_MembersInjector implements MembersInjector<EasterEggsEventHandler> {
    private final Provider<BasePersistenceDao> databaseProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;

    public EasterEggsEventHandler_MembersInjector(Provider<DeviceInformationProvider> provider, Provider<BasePersistenceDao> provider2) {
        this.deviceInformationProvider = provider;
        this.databaseProvider = provider2;
    }

    public static MembersInjector<EasterEggsEventHandler> create(Provider<DeviceInformationProvider> provider, Provider<BasePersistenceDao> provider2) {
        return new EasterEggsEventHandler_MembersInjector(provider, provider2);
    }

    public final void injectMembers(EasterEggsEventHandler easterEggsEventHandler) {
        injectDeviceInformationProvider(easterEggsEventHandler, this.deviceInformationProvider.get());
        injectDatabase(easterEggsEventHandler, this.databaseProvider.get());
    }

    public static void injectDeviceInformationProvider(EasterEggsEventHandler easterEggsEventHandler, DeviceInformationProvider deviceInformationProvider) {
        easterEggsEventHandler.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectDatabase(EasterEggsEventHandler easterEggsEventHandler, BasePersistenceDao basePersistenceDao) {
        easterEggsEventHandler.database = basePersistenceDao;
    }
}
