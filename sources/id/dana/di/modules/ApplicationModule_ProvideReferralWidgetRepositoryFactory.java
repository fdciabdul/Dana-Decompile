package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.referralwidget.ReferralWidgetEntityRepository;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideReferralWidgetRepositoryFactory implements Factory<ReferralWidgetRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ReferralWidgetEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideReferralWidgetRepositoryFactory(ApplicationModule applicationModule, Provider<ReferralWidgetEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideReferralWidgetRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<ReferralWidgetEntityRepository> provider) {
        return new ApplicationModule_ProvideReferralWidgetRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralWidgetRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
