package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.notification.FeedsNotificationEntityRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideFeedsNotificationRepositoryFactory implements Factory<FeedsNotificationRepository> {
    private final SocialCommonModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsNotificationEntityRepository> PlaceComponentResult;

    private SocialCommonModule_ProvideFeedsNotificationRepositoryFactory(SocialCommonModule socialCommonModule, Provider<FeedsNotificationEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = socialCommonModule;
        this.PlaceComponentResult = provider;
    }

    public static SocialCommonModule_ProvideFeedsNotificationRepositoryFactory PlaceComponentResult(SocialCommonModule socialCommonModule, Provider<FeedsNotificationEntityRepository> provider) {
        return new SocialCommonModule_ProvideFeedsNotificationRepositoryFactory(socialCommonModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsNotificationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
