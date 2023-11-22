package id.dana.data.foundation.h5app.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class LocalH5ResponseCachePreferencesData_Factory implements Factory<LocalH5ResponseCachePreferencesData> {
    private final Provider<H5ResponseCachePreferences> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalH5ResponseCachePreferencesData(this.MyBillsEntityDataFactory.get());
    }
}
