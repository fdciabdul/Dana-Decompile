package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.announcement.repository.AnnouncementEntityRepository;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideAnnouncementRepositoryFactory implements Factory<AnnouncementRepository> {
    private final Provider<AnnouncementEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideAnnouncementRepositoryFactory(ApplicationModule applicationModule, Provider<AnnouncementEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideAnnouncementRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<AnnouncementEntityRepository> provider) {
        return new ApplicationModule_ProvideAnnouncementRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AnnouncementRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
