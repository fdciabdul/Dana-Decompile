package id.dana.data.qriscrossborder.source;

import dagger.internal.Factory;
import id.dana.data.qriscrossborder.source.local.LocalQrisCrossBorderEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrisCrossBorderEntityDataFactory_Factory implements Factory<QrisCrossBorderEntityDataFactory> {
    private final Provider<LocalQrisCrossBorderEntityData> getAuthRequestContext;

    private QrisCrossBorderEntityDataFactory_Factory(Provider<LocalQrisCrossBorderEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static QrisCrossBorderEntityDataFactory_Factory getAuthRequestContext(Provider<LocalQrisCrossBorderEntityData> provider) {
        return new QrisCrossBorderEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QrisCrossBorderEntityDataFactory(this.getAuthRequestContext.get());
    }
}
