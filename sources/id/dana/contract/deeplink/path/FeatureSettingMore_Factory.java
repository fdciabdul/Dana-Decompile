package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.lib.bio.productpage.ProductPageManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureSettingMore_Factory implements Factory<FeatureSettingMore> {
    private final Provider<ProductPageManager> MyBillsEntityDataFactory;
    private final Provider<GetSettingByKey> PlaceComponentResult;

    private FeatureSettingMore_Factory(Provider<GetSettingByKey> provider, Provider<ProductPageManager> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static FeatureSettingMore_Factory PlaceComponentResult(Provider<GetSettingByKey> provider, Provider<ProductPageManager> provider2) {
        return new FeatureSettingMore_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureSettingMore(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
