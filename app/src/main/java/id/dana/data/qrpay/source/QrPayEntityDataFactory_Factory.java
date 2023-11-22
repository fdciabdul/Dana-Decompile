package id.dana.data.qrpay.source;

import dagger.internal.Factory;
import id.dana.data.qrpay.source.remote.RemoteQrPayEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrPayEntityDataFactory_Factory implements Factory<QrPayEntityDataFactory> {
    private final Provider<RemoteQrPayEntityData> remoteQrPayEntityDataProvider;

    public QrPayEntityDataFactory_Factory(Provider<RemoteQrPayEntityData> provider) {
        this.remoteQrPayEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final QrPayEntityDataFactory get() {
        return newInstance(this.remoteQrPayEntityDataProvider.get());
    }

    public static QrPayEntityDataFactory_Factory create(Provider<RemoteQrPayEntityData> provider) {
        return new QrPayEntityDataFactory_Factory(provider);
    }

    public static QrPayEntityDataFactory newInstance(RemoteQrPayEntityData remoteQrPayEntityData) {
        return new QrPayEntityDataFactory(remoteQrPayEntityData);
    }
}
