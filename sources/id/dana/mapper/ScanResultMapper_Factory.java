package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.base.BaseResponseMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ScanResultMapper_Factory implements Factory<ScanResultMapper> {
    private final Provider<BaseResponseMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private ScanResultMapper_Factory(Provider<BaseResponseMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ScanResultMapper_Factory MyBillsEntityDataFactory(Provider<BaseResponseMapper> provider) {
        return new ScanResultMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScanResultMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
