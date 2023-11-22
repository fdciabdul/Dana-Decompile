package id.dana.feeds.data.config;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.feeds.data.config.source.FeedsConfigDataFactory;
import id.dana.feeds.data.config.source.mapper.ReportReasonsConfigMapper;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsConfigEntityRepository_Factory implements Factory<FeedsConfigEntityRepository> {
    private final Provider<SocialPreferencesDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsConfigDataFactory> MyBillsEntityDataFactory;
    private final Provider<HomeWidgetEntityData> PlaceComponentResult;
    private final Provider<ReportReasonsConfigMapper> getAuthRequestContext;

    private FeedsConfigEntityRepository_Factory(Provider<FeedsConfigDataFactory> provider, Provider<ReportReasonsConfigMapper> provider2, Provider<SocialPreferencesDataFactory> provider3, Provider<HomeWidgetEntityData> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static FeedsConfigEntityRepository_Factory getAuthRequestContext(Provider<FeedsConfigDataFactory> provider, Provider<ReportReasonsConfigMapper> provider2, Provider<SocialPreferencesDataFactory> provider3, Provider<HomeWidgetEntityData> provider4) {
        return new FeedsConfigEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsConfigEntityRepository(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
