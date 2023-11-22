package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryModel;

/* loaded from: classes5.dex */
public final class PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory implements Factory<MerchantPhotoGalleryModel> {
    private final PhotoGalleryModule getAuthRequestContext;

    private PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory(PhotoGalleryModule photoGalleryModule) {
        this.getAuthRequestContext = photoGalleryModule;
    }

    public static PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory PlaceComponentResult(PhotoGalleryModule photoGalleryModule) {
        return new PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory(photoGalleryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantPhotoGalleryModel) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
