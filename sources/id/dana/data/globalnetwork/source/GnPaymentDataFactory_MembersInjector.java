package id.dana.data.globalnetwork.source;

import dagger.MembersInjector;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GnPaymentDataFactory_MembersInjector implements MembersInjector<GnPaymentDataFactory> {
    private final Provider<RemoteGnPaymentEntityData> remoteGnPaymentEntityDataProvider;

    public GnPaymentDataFactory_MembersInjector(Provider<RemoteGnPaymentEntityData> provider) {
        this.remoteGnPaymentEntityDataProvider = provider;
    }

    public static MembersInjector<GnPaymentDataFactory> create(Provider<RemoteGnPaymentEntityData> provider) {
        return new GnPaymentDataFactory_MembersInjector(provider);
    }

    public final void injectMembers(GnPaymentDataFactory gnPaymentDataFactory) {
        injectRemoteGnPaymentEntityData(gnPaymentDataFactory, this.remoteGnPaymentEntityDataProvider.get());
    }

    public static void injectRemoteGnPaymentEntityData(GnPaymentDataFactory gnPaymentDataFactory, RemoteGnPaymentEntityData remoteGnPaymentEntityData) {
        gnPaymentDataFactory.remoteGnPaymentEntityData = remoteGnPaymentEntityData;
    }
}
