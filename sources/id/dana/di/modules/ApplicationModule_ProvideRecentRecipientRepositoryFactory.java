package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRecentRecipientRepositoryFactory implements Factory<RecentRecipientRepository> {
    private final Provider<RecentRecipientEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideRecentRecipientRepositoryFactory(ApplicationModule applicationModule, Provider<RecentRecipientEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideRecentRecipientRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<RecentRecipientEntityRepository> provider) {
        return new ApplicationModule_ProvideRecentRecipientRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecentRecipientRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
