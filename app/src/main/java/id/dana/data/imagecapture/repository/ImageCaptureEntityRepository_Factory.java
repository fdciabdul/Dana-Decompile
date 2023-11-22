package id.dana.data.imagecapture.repository;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ImageCaptureEntityRepository_Factory implements Factory<ImageCaptureEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ContentDeliveryEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SpaceResultMapper> getAuthRequestContext;

    private ImageCaptureEntityRepository_Factory(Provider<ContentDeliveryEntityDataFactory> provider, Provider<SpaceResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static ImageCaptureEntityRepository_Factory PlaceComponentResult(Provider<ContentDeliveryEntityDataFactory> provider, Provider<SpaceResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new ImageCaptureEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ImageCaptureEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
