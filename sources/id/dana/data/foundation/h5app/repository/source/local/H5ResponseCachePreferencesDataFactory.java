package id.dana.data.foundation.h5app.repository.source.local;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes8.dex */
public class H5ResponseCachePreferencesDataFactory extends AbstractEntityDataFactory<H5ResponseCachePreferencesData> {
    public final LocalH5ResponseCachePreferencesData MyBillsEntityDataFactory;

    @Inject
    public H5ResponseCachePreferencesDataFactory(LocalH5ResponseCachePreferencesData localH5ResponseCachePreferencesData) {
        this.MyBillsEntityDataFactory = localH5ResponseCachePreferencesData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public /* bridge */ /* synthetic */ H5ResponseCachePreferencesData createData(String str) {
        return this.MyBillsEntityDataFactory;
    }
}
