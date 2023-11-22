package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.referral.ReferralEngagementEntityRepository;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideReferralEngagementDialogRepositoryFactory implements Factory<ReferralEngagementDialogRepository> {
    private final Provider<ReferralEngagementEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideReferralEngagementDialogRepositoryFactory(ApplicationModule applicationModule, Provider<ReferralEngagementEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideReferralEngagementDialogRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<ReferralEngagementEntityRepository> provider) {
        return new ApplicationModule_ProvideReferralEngagementDialogRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralEngagementDialogRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
