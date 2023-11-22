package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory implements Factory<SaveReferralEngagementDialogCache> {
    private final Provider<ReferralRepository> BuiltInFictitiousFunctionClassFactory;
    private final GContainerModule getAuthRequestContext;

    private GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory(GContainerModule gContainerModule, Provider<ReferralRepository> provider) {
        this.getAuthRequestContext = gContainerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory BuiltInFictitiousFunctionClassFactory(GContainerModule gContainerModule, Provider<ReferralRepository> provider) {
        return new GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory(gContainerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SaveReferralEngagementDialogCache) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
