package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFaceAuthPopUpConsultationRepositoryFactory implements Factory<FaceAuthPopUpConsultationRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<FaceAuthPopUpConsultationEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideFaceAuthPopUpConsultationRepositoryFactory(ApplicationModule applicationModule, Provider<FaceAuthPopUpConsultationEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideFaceAuthPopUpConsultationRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<FaceAuthPopUpConsultationEntityRepository> provider) {
        return new ApplicationModule_ProvideFaceAuthPopUpConsultationRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthPopUpConsultationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
