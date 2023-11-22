package id.dana.nearbyme.merchantdetail.mediaviewer;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PhotoGalleryPresenter_Factory implements Factory<PhotoGalleryPresenter> {
    private final Provider<PhotoGalleryContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMerchantImage> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantPhotoGalleryModel> getAuthRequestContext;

    private PhotoGalleryPresenter_Factory(Provider<MerchantPhotoGalleryModel> provider, Provider<PhotoGalleryContract.View> provider2, Provider<GetMerchantImage> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static PhotoGalleryPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<MerchantPhotoGalleryModel> provider, Provider<PhotoGalleryContract.View> provider2, Provider<GetMerchantImage> provider3) {
        return new PhotoGalleryPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PhotoGalleryPresenter(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
