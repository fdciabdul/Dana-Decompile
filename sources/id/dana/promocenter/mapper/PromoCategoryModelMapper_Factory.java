package id.dana.promocenter.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PromoCategoryModelMapper_Factory implements Factory<PromoCategoryModelMapper> {
    private final Provider<PromoAdsModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoCategoryModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
