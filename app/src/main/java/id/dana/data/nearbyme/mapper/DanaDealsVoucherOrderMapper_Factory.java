package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;
import id.dana.data.nearbyme.util.SystemUtils;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaDealsVoucherOrderMapper_Factory implements Factory<DanaDealsVoucherOrderMapper> {
    private final Provider<SystemUtils> systemUtilsProvider;

    public DanaDealsVoucherOrderMapper_Factory(Provider<SystemUtils> provider) {
        this.systemUtilsProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DanaDealsVoucherOrderMapper get() {
        return newInstance(this.systemUtilsProvider.get());
    }

    public static DanaDealsVoucherOrderMapper_Factory create(Provider<SystemUtils> provider) {
        return new DanaDealsVoucherOrderMapper_Factory(provider);
    }

    public static DanaDealsVoucherOrderMapper newInstance(SystemUtils systemUtils) {
        return new DanaDealsVoucherOrderMapper(systemUtils);
    }
}
